package top.xkk.adminbookapi.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.xkk.adminbookapi.annotation.AuthToken;
import top.xkk.adminbookapi.domain.dto.BookDTO;
import top.xkk.adminbookapi.domain.dto.QueryBookDTO;
import top.xkk.adminbookapi.domain.entity.Book;
import top.xkk.adminbookapi.domain.vo.BookListVo;
import top.xkk.adminbookapi.result.RestResult;
import top.xkk.adminbookapi.result.RestResultBuilder;
import top.xkk.adminbookapi.service.BookService;

import javax.annotation.Resource;

@RestController
@RequestMapping("/book")
public class BookController {
    @Resource
    BookService bookService;

    /**
     * 添加图书
     * @param book
     * @return
     */
    @AuthToken
    @PostMapping("/add")
    public RestResult add(@RequestBody Book book) {
        Integer result = bookService.addBook(book);
        if (result > 0) {
            return new RestResultBuilder<>().success();
        } else {
            return new RestResultBuilder<>().error("添加失败");
        }
    }

    @AuthToken
    @PostMapping("/findAll")
    public RestResult findAll(@RequestBody QueryBookDTO queryBookDTO) {
        BookListVo bookListVo = bookService.findAll(queryBookDTO);
        return new RestResultBuilder<>().success(bookListVo);
    }

    @AuthToken
    @PostMapping("/update")
    public RestResult updateBook(@RequestBody Book book) {
        return bookService.updateBook(book);
    }

    @AuthToken
    @PostMapping("/delete")
    public RestResult delBook(@RequestBody Integer id) {
        return bookService.delBook(id);
    }

    @AuthToken
    @PostMapping("/count")
    public RestResult count() {
        return bookService.count();
    }
}
