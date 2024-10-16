package example.User_Service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.data.annotation.Id;

@Entity
@Table
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class User {
    private String name;
    @Id
    private String email;
    private long number;
    private String gender;
    private String password;

    public void setNumber(long number) {
    }
}
