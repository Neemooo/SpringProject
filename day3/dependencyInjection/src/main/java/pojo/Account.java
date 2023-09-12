package pojo;

import lombok.*;

import java.sql.Date;

@Builder
@Data
public class Account {
    private long id;
    private String ownerName;
    private double balance;
    private Date accessTime;
    private boolean locked;
}
