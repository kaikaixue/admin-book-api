package top.xkk.adminbookapi.service.impl;

import org.springframework.stereotype.Service;
import top.xkk.adminbookapi.domain.DO.BookTypeDO;
import top.xkk.adminbookapi.domain.dto.QueryBookTypeDTO;
import top.xkk.adminbookapi.domain.entity.Booktype;
import top.xkk.adminbookapi.domain.vo.BookTypeListVo;
import top.xkk.adminbookapi.mapper.BookTypeMapper;
import top.xkk.adminbookapi.result.RestResult;
import top.xkk.adminbookapi.result.RestResultBuilder;
import top.xkk.adminbookapi.service.BookTypeService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BookTypeServiceImpl implements BookTypeService {
    @Resource
    BookTypeMapper bookTypeMapper;

    @Override
    public RestResult findAllType(QueryBookTypeDTO queryBookTypeDTO) {
        Integer total = bookTypeMapper.count();
        QueryBookTypeDTO queryBookTypeDTO1 = QueryBookTypeDTO.builder()
                .key(queryBookTypeDTO.getKey())
                .index((queryBookTypeDTO.getIndex() - 1) * queryBookTypeDTO.getSize())
                .size(queryBookTypeDTO.getSize())
                .build();
        List<BookTypeDO> list = bookTypeMapper.findAllType(queryBookTypeDTO1);
        if (list != null) {
            BookTypeListVo bookTypeListVo = BookTypeListVo.builder()
                    .total(total)
                    .list(list)
                    .build();
            return new RestResultBuilder<>().success(bookTypeListVo);
        } else {
            return new RestResultBuilder<>().error("无数据");
        }
    }

    @Override
    public RestResult addType(Booktype booktype) {
        Integer result =  bookTypeMapper.addType(booktype);
        if (result > 0) {
            return new RestResultBuilder<>().success(result);
        } else {
            return new RestResultBuilder<>().error("添加失败");
        }
    }

    @Override
    public RestResult updateType(Booktype booktype) {
        Integer result = bookTypeMapper.updateType(booktype);
        if (result > 0) {
            return new RestResultBuilder<>().success(result);
        } else {
            return new RestResultBuilder<>().error("修改失败");
        }
    }

    @Override
    public RestResult delType(Integer id) {
        Integer result = bookTypeMapper.delType(id);
        if (result > 0) {
            return new RestResultBuilder<>().success(result);
        } else {
            return new RestResultBuilder<>().error("删除失败");
        }
    }
}
