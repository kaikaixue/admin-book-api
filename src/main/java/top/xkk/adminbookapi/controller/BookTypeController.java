package top.xkk.adminbookapi.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.xkk.adminbookapi.annotation.AuthToken;
import top.xkk.adminbookapi.domain.dto.QueryBookTypeDTO;
import top.xkk.adminbookapi.domain.entity.Booktype;
import top.xkk.adminbookapi.result.RestResult;
import top.xkk.adminbookapi.service.BookTypeService;

import javax.annotation.Resource;

@RequestMapping("/bookType")
@RestController
public class BookTypeController {
    @Resource
    BookTypeService bookTypeService;

    @AuthToken
    @PostMapping("/findAll")
    public RestResult findAllType(@RequestBody QueryBookTypeDTO queryBookTypeDTO) {
        return bookTypeService.findAllType(queryBookTypeDTO);
    }

    @AuthToken
    @PostMapping("/add")
    public RestResult addType(@RequestBody Booktype booktype) {
        return bookTypeService.addType(booktype);
    }

    @AuthToken
    @PostMapping("/update")
    public RestResult updateType(@RequestBody Booktype booktype) {
        return bookTypeService.updateType(booktype);
    }

    @AuthToken
    @PostMapping("/delete")
    public RestResult delType(@RequestBody Integer id) {
        return  bookTypeService.delType(id);
    }
}
