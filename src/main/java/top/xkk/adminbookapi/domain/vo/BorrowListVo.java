package top.xkk.adminbookapi.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import top.xkk.adminbookapi.domain.DO.BorrowDO;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BorrowListVo {
    List<BorrowDO> list;
    Integer total;
}
