package top.xkk.adminbookapi.service;

import top.xkk.adminbookapi.domain.DO.BookDO;
import top.xkk.adminbookapi.domain.dto.QueryBookDTO;
import top.xkk.adminbookapi.domain.entity.Book;
import top.xkk.adminbookapi.domain.vo.BookListVo;
import top.xkk.adminbookapi.result.RestResult;

import java.util.List;

public interface BookService {
    /**
     * 添加图书
     * @param book
     * @return
     */
    Integer addBook(Book book);

    /**
     * 查询所有图书
     * @param queryBookDTO
     * @return
     */
    BookListVo findAll(QueryBookDTO queryBookDTO);

    RestResult updateBook(Book book);

    RestResult delBook(Integer id);
}
