package top.xkk.adminbookapi.domain.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class BookDTO {
    private String name;
    private String cover;
    private String description;
    private Integer type;
    private String author;
    private String press;
    private Double price;
    private Integer inventory;
}
