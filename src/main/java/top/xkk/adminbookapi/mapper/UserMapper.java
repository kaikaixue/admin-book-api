package top.xkk.adminbookapi.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.xkk.adminbookapi.domain.DO.UserDO;
import top.xkk.adminbookapi.domain.dto.QueryUserDTO;
import top.xkk.adminbookapi.domain.entity.User;

import java.util.List;

@Mapper
public interface UserMapper {
    List<UserDO> findAll(QueryUserDTO queryUserDTO);
    Integer count();
    Integer addUser(User user);
    Integer updateUser(User user);
    Integer delUser(Integer id);
}
