package top.xkk.adminbookapi.domain.DO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ManagerDO {
    private Integer userId;
    private String account;
    private Integer flag;
    private String name;
    private Integer isDelete;
    private String createTime;
}
