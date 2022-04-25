package top.xkk.adminbookapi.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import top.xkk.adminbookapi.domain.dto.GetInfoDTO;
import top.xkk.adminbookapi.domain.dto.LoginDTO;
import top.xkk.adminbookapi.result.RestResult;
import top.xkk.adminbookapi.service.LoginService;
import top.xkk.adminbookapi.util.Md5TokenGenerator;

import javax.annotation.Resource;

@RestController
public class LoginController {

    @Resource
    LoginService loginService;

    @PostMapping("/login")
    public RestResult login(@RequestBody LoginDTO loginDTO) {

        return loginService.login(loginDTO);
    }

    @PostMapping("/user/info")
    public RestResult getInfo(@RequestBody GetInfoDTO getInfoDTO) {
        return loginService.getInfo(getInfoDTO);
    }
}
