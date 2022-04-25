package top.xkk.adminbookapi.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.xkk.adminbookapi.domain.DO.ManagerDO;
import top.xkk.adminbookapi.domain.DO.ManagerInfoDO;
import top.xkk.adminbookapi.domain.dto.LoginDTO;

@Mapper
public interface LoginMapper {
    ManagerDO login(LoginDTO loginDTO);
    ManagerInfoDO getInfo(Integer userId);
}
