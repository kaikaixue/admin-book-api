package top.xkk.adminbookapi.service.impl;

import org.springframework.stereotype.Service;
import top.xkk.adminbookapi.domain.DO.BookDO;
import top.xkk.adminbookapi.domain.dto.BookDTO;
import top.xkk.adminbookapi.domain.dto.QueryBookDTO;
import top.xkk.adminbookapi.domain.entity.Book;
import top.xkk.adminbookapi.domain.vo.BookListVo;
import top.xkk.adminbookapi.mapper.BookMapper;
import top.xkk.adminbookapi.result.RestResult;
import top.xkk.adminbookapi.result.RestResultBuilder;
import top.xkk.adminbookapi.service.BookService;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Resource
    BookMapper bookMapper;

    @Override
    public Integer addBook(Book book) {
        book.setIsDelete(1);
        book.setCreateTime(LocalDateTime.now());
        book.setUpdateTime(LocalDateTime.now());
        Integer result = bookMapper.addBook(book);
        return result;
    }

    @Override
    public BookListVo findAll(QueryBookDTO queryBookDTO) {
        QueryBookDTO newQueryBookDTO = QueryBookDTO.builder()
                .key(queryBookDTO.getKey())
                .index((queryBookDTO.getIndex() - 1) * queryBookDTO.getSize())
                .size(queryBookDTO.getSize())
                .build();

        List<BookDO> list = bookMapper.findAll(newQueryBookDTO);
        BookListVo bookListVo = BookListVo.builder()
                .total(bookMapper.count())
                .list(list)
                .build();
        return bookListVo;
    }

    @Override
    public RestResult updateBook(Book book) {
        Integer result = bookMapper.updateBook(book);
        if (result > 0) {
            return new RestResultBuilder<>().success(result);
        } else {
            return new RestResultBuilder<>().error("错误");
        }
    }

    @Override
    public RestResult delBook(Integer id) {
        Integer result = bookMapper.delBook(id);
        if (result > 0) {
            return new RestResultBuilder<>().success(result);
        } else {
            return new RestResultBuilder<>().error("删除失败");
        }
    }
}
