package top.xkk.adminbookapi.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import top.xkk.adminbookapi.domain.DO.UserDO;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserListVo {
    private Integer total;
    private List<UserDO> list;
}
