package top.xkk.adminbookapi.service;

import top.xkk.adminbookapi.domain.dto.QueryBorrowDTO;
import top.xkk.adminbookapi.result.RestResult;

public interface BorrowService {
    RestResult findAll(QueryBorrowDTO queryBorrowDTO);
}
