package top.xkk.adminbookapi.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.xkk.adminbookapi.domain.DO.BookDO;
import top.xkk.adminbookapi.domain.dto.BookDTO;
import top.xkk.adminbookapi.domain.dto.QueryBookDTO;
import top.xkk.adminbookapi.domain.entity.Book;

import java.util.List;

@Mapper
public interface BookMapper {
    Integer addBook(Book book);

    List<BookDO> findAll(QueryBookDTO queryBookDTO);

    Integer count();

    Integer updateBook(Book book);

    Integer delBook(Integer id);
}
