package top.xkk.adminbookapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.xkk.adminbookapi.domain.DO.ManagerDO;
import top.xkk.adminbookapi.domain.DO.ManagerInfoDO;
import top.xkk.adminbookapi.domain.dto.GetInfoDTO;
import top.xkk.adminbookapi.domain.dto.LoginDTO;
import top.xkk.adminbookapi.domain.vo.LoginVo;
import top.xkk.adminbookapi.domain.vo.ManagerInfoVo;
import top.xkk.adminbookapi.mapper.LoginMapper;
import top.xkk.adminbookapi.result.RestResult;
import top.xkk.adminbookapi.result.RestResultBuilder;
import top.xkk.adminbookapi.service.LoginService;
import top.xkk.adminbookapi.util.ConstantKit;
import top.xkk.adminbookapi.util.Md5TokenGenerator;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService {
    @Resource
    LoginMapper loginMapper;

    @Autowired
    Md5TokenGenerator tokenGenerator;

    @Override
    public RestResult login(LoginDTO loginDTO) {
        ManagerDO managerDO = loginMapper.login(loginDTO);
        if (managerDO == null) {
            return new RestResultBuilder<>().error("账号或密码不对");
        } else {
            String account = loginDTO.getUserName();
            Jedis jedis = new Jedis("127.0.0.1", 6379);
            String token = tokenGenerator.generate(account, loginDTO.getPassword());
            jedis.set(account, token);
            // 设置key生存时间，当key过期时，会被自动删除，单位是秒
            jedis.expire(account, ConstantKit.TOKEN_EXPIRE_TIME);
            jedis.set(token, account);
            jedis.expire(token, ConstantKit.TOKEN_EXPIRE_TIME);
            Long currentTime = System.currentTimeMillis();
            jedis.set(token + account, currentTime.toString());
            // 关闭
            jedis.close();
            LoginVo loginVo = LoginVo.builder()
                    .userId(managerDO.getUserId())
                    .token(token)
                    .build();
            return new RestResultBuilder<>().success(loginVo);
        }
    }

    @Override
    public RestResult getInfo(GetInfoDTO getInfoDTO) {
        ManagerInfoDO managerInfoDO = loginMapper.getInfo(getInfoDTO.getUserId());
        if (managerInfoDO == null) {
            return new RestResultBuilder<>().error("用户不存在");
        } else {
            String role = "";
            if (managerInfoDO.getRoles() == 0) {
                role = "admin";
            } else {
                role = "图书管理员";
            }
            List<String> list = new ArrayList<String>();
            list.add(role);
            ManagerInfoVo managerInfoVo = ManagerInfoVo.builder()
                    .roles(list)
                    .avatar(managerInfoDO.getAvatar())
                    .name(managerInfoDO.getName())
                    .introduction(managerInfoDO.getIntroduction())
                    .build();
            return new RestResultBuilder<>().success(managerInfoVo);
        }
    }
}
