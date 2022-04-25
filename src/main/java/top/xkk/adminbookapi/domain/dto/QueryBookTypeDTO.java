package top.xkk.adminbookapi.domain.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class QueryBookTypeDTO {
    private String key;
    private Integer index;
    private Integer size;
}
