package top.xkk.adminbookapi.service;

import top.xkk.adminbookapi.domain.DO.ManagerDO;
import top.xkk.adminbookapi.domain.dto.GetInfoDTO;
import top.xkk.adminbookapi.domain.dto.LoginDTO;
import top.xkk.adminbookapi.result.RestResult;

public interface LoginService {
    RestResult login(LoginDTO loginDTO);
    RestResult getInfo(GetInfoDTO getInfoDTO);
}
