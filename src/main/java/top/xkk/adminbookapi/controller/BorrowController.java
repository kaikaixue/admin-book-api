package top.xkk.adminbookapi.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.xkk.adminbookapi.annotation.AuthToken;
import top.xkk.adminbookapi.domain.dto.QueryBorrowDTO;
import top.xkk.adminbookapi.result.RestResult;
import top.xkk.adminbookapi.service.BorrowService;

import javax.annotation.Resource;

@RestController
@RequestMapping("/borrow")
public class BorrowController {
    @Resource
    BorrowService borrowService;

    @AuthToken
    @PostMapping("/findAll")
    public RestResult findAll(@RequestBody QueryBorrowDTO queryBorrowDTO) {
        return borrowService.findAll(queryBorrowDTO);
    }
}
