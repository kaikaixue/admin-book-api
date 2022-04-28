package top.xkk.adminbookapi.service;

import top.xkk.adminbookapi.domain.dto.QueryBookTypeDTO;
import top.xkk.adminbookapi.domain.entity.Book;
import top.xkk.adminbookapi.domain.entity.Booktype;
import top.xkk.adminbookapi.result.RestResult;

public interface BookTypeService {
    RestResult findAllType(QueryBookTypeDTO queryBookTypeDTO);

    RestResult addType(Booktype booktype);

    RestResult updateType(Booktype booktype);

    RestResult delType(Integer id);

    RestResult count();
}
