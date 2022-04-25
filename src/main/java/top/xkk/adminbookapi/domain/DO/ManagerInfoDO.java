package top.xkk.adminbookapi.domain.DO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ManagerInfoDO {
    private Integer roles;
    private String name;
    private String avatar;
    private String introduction;
}
