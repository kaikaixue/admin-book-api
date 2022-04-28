package top.xkk.adminbookapi.service.impl;

import org.springframework.stereotype.Service;
import top.xkk.adminbookapi.domain.DO.BorrowDO;
import top.xkk.adminbookapi.domain.dto.QueryBorrowDTO;
import top.xkk.adminbookapi.domain.vo.BorrowListVo;
import top.xkk.adminbookapi.mapper.BorrowMapper;
import top.xkk.adminbookapi.result.RestResult;
import top.xkk.adminbookapi.result.RestResultBuilder;
import top.xkk.adminbookapi.service.BorrowService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BorrowServiceImpl implements BorrowService {

    @Resource
    BorrowMapper borrowMapper;

    @Override
    public RestResult findAll(QueryBorrowDTO queryBorrowDTO) {
        QueryBorrowDTO queryBorrowDTO1 = QueryBorrowDTO.builder()
                .key(queryBorrowDTO.getKey())
                .index((queryBorrowDTO.getIndex() - 1) * queryBorrowDTO.getSize())
                .size(queryBorrowDTO.getSize())
                .build();
        List<BorrowDO> list = borrowMapper.findAll(queryBorrowDTO1);
        Integer total = borrowMapper.count();
        BorrowListVo borrowListVo = BorrowListVo.builder()
                .list(list)
                .total(borrowMapper.count())
                .build();
        if (list != null) {
            return new RestResultBuilder<>().success(borrowListVo);
        } else {
            return new RestResultBuilder<>().error("查找失败");
        }
    }
}
