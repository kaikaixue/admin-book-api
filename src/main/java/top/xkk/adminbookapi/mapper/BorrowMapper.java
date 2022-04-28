package top.xkk.adminbookapi.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.xkk.adminbookapi.domain.DO.BorrowDO;
import top.xkk.adminbookapi.domain.dto.QueryBorrowDTO;

import java.util.List;

@Mapper
public interface BorrowMapper {
    List<BorrowDO> findAll(QueryBorrowDTO queryBorrowDTO);
    Integer count();
}
