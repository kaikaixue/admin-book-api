package top.xkk.adminbookapi.domain.DO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BorrowDO {
    private Integer id;
    private String bookName;
    private String userName;
    private Integer flag;
    private Integer isReturn;
    private LocalDateTime createTime;
    private LocalDateTime endTime;
}
