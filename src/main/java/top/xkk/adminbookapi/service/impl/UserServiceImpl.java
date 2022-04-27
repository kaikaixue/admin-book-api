package top.xkk.adminbookapi.service.impl;

import org.springframework.stereotype.Service;
import top.xkk.adminbookapi.domain.DO.UserDO;
import top.xkk.adminbookapi.domain.dto.QueryUserDTO;
import top.xkk.adminbookapi.domain.entity.User;
import top.xkk.adminbookapi.domain.vo.UserListVo;
import top.xkk.adminbookapi.mapper.UserMapper;
import top.xkk.adminbookapi.result.RestResult;
import top.xkk.adminbookapi.result.RestResultBuilder;
import top.xkk.adminbookapi.service.UserService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;

    @Override
    public RestResult findAll(QueryUserDTO queryUserDTO) {
        QueryUserDTO queryUserDTO1 = QueryUserDTO.builder()
                .key(queryUserDTO.getKey())
                .index((queryUserDTO.getIndex() - 1) * queryUserDTO.getSize())
                .size(queryUserDTO.getSize())
                .build();

        List<UserDO> list = userMapper.findAll(queryUserDTO1);
        Integer total = userMapper.count();
        if (list != null) {
            UserListVo userListVo = UserListVo.builder()
                    .list(list)
                    .total(total)
                    .build();
            return new RestResultBuilder<>().success(userListVo);
        } else {
            return new RestResultBuilder<>().error("查找失败");
        }
    }

    @Override
    public RestResult addUser(User user) {
        Integer result = userMapper.addUser(user);
        if (result > 0) {
            return new RestResultBuilder<>().success(result);
        } else {
            return new RestResultBuilder<>().error("添加失败");
        }
    }

    @Override
    public RestResult updateUser(User user) {
        Integer result = userMapper.updateUser(user);
        if (result > 0) {
            return new RestResultBuilder<>().success(result);
        } else {
            return new RestResultBuilder<>().error("添加失败");
        }
    }

    @Override
    public RestResult delUser(Integer id) {
        Integer result = userMapper.delUser(id);
        if (result > 0) {
            return new RestResultBuilder<>().success(result);
        } else {
            return new RestResultBuilder<>().error("添加失败");
        }
    }

    @Override
    public RestResult count() {
        Integer result = userMapper.count();
        if (result >=0) {
            return new RestResultBuilder<>().success(result);
        } else {
            return new RestResultBuilder<>().error("统计失败");
        }
    }
}
