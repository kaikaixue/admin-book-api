package top.xkk.adminbookapi.domain.DO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BookDO {
    private Integer bookId;
    private String name;
    private String cover;
    private String description;
    private String type;
    private String author;
    private String press;
    private Integer inventory;
    private String price;
    private LocalDateTime createTime;
}
