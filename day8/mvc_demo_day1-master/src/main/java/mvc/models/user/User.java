package mvc.models.user;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    private String name;
    private String lastname;
    private String password;
    private String detail;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

    private Gender gender=Gender.Male;
    private String country;
    private boolean nonSmoking;
}
