package pojo;

import lombok.*;

import java.sql.Date;

@Builder
//@Getter
//@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    private long id;
    private String ownerName;
    private double balance;
    private Date accessTime;
    private boolean locked;
}
