package top.xkk.adminbookapi.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.xkk.adminbookapi.annotation.AuthToken;
import top.xkk.adminbookapi.domain.dto.QueryUserDTO;
import top.xkk.adminbookapi.domain.entity.User;
import top.xkk.adminbookapi.result.RestResult;
import top.xkk.adminbookapi.service.UserService;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    UserService userService;

    @AuthToken
    @PostMapping("/findAll")
    public RestResult findAll(@RequestBody QueryUserDTO queryUserDTO) {
        return userService.findAll(queryUserDTO);
    }

    @AuthToken
    @PostMapping("/add")
    public RestResult addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @AuthToken
    @PostMapping("/update")
    public RestResult updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @AuthToken
    @PostMapping("/delete")
    public RestResult delUser(@RequestBody Integer id) {
        return userService.delUser(id);
    }

    @AuthToken
    @PostMapping("/count")
    public RestResult count() {
        return userService.count();
    }
}
