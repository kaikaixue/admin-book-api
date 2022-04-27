package top.xkk.adminbookapi.domain.DO;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class UserDO {
    private Integer userId;
    private String account;
    private String avatar;
    private String cardId;
    private String name;
    private Integer cardState;
    private String phone;
    private LocalDateTime createTime;
}
