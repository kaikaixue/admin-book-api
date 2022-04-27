package top.xkk.adminbookapi.domain.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class QueryUserDTO {
    private String key;
    private Integer size;
    private Integer index;
}
