package top.xkk.adminbookapi.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ManagerInfoVo {
    private List<String> roles;
    private String name;
    private String avatar;
    private String introduction;
}
