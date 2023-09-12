package createXML.pojo.model;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Account {
    private long id;
    private String ownerName;
    private double balance;
    private Date accessTime;
    private boolean locked;

}
