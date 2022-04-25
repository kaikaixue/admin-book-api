package top.xkk.adminbookapi.domain.DO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookTypeDO {
    private Integer id;
    private String type;
    private LocalDateTime createTime;
}
