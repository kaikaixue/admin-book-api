package top.xkk.adminbookapi.service;

import top.xkk.adminbookapi.domain.dto.QueryUserDTO;
import top.xkk.adminbookapi.domain.entity.User;
import top.xkk.adminbookapi.result.RestResult;

public interface UserService {
    RestResult findAll(QueryUserDTO queryUserDTO);
    RestResult addUser(User user);
    RestResult updateUser(User user);
    RestResult delUser(Integer id);
    RestResult count();
}
