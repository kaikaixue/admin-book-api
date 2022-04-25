package top.xkk.adminbookapi.domain.vo;

import lombok.Builder;
import lombok.Data;
import top.xkk.adminbookapi.domain.DO.BookDO;

import java.util.List;

@Data
@Builder
public class BookListVo {
    private Integer total;
    private List<BookDO> list;
}
