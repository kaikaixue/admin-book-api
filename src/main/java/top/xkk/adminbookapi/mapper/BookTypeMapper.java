package top.xkk.adminbookapi.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.xkk.adminbookapi.domain.DO.BookTypeDO;
import top.xkk.adminbookapi.domain.dto.QueryBookTypeDTO;
import top.xkk.adminbookapi.domain.entity.Booktype;

import java.util.List;

@Mapper
public interface BookTypeMapper {
    List<BookTypeDO> findAllType(QueryBookTypeDTO queryBookTypeDTO);
    Integer count();
    Integer addType(Booktype booktype);
    Integer updateType(Booktype booktype);
    Integer delType(Integer id);
}
