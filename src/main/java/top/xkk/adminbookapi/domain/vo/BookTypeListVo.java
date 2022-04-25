package top.xkk.adminbookapi.domain.vo;

import lombok.Builder;
import lombok.Data;
import top.xkk.adminbookapi.domain.DO.BookDO;
import top.xkk.adminbookapi.domain.DO.BookTypeDO;

import java.util.List;

@Builder
@Data
public class BookTypeListVo {
    private Integer total;
    private List<BookTypeDO> list;
}
