package hello.hellospring.member.domain;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.annotation.SessionScope;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Entity(name="y_member")
@Table(name="y_member")
@Getter
@Setter
@ToString
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @SerializedName("email")
    private String email;

    @SerializedName("passwrd")
    private String passwrd;

    @SerializedName("remEmail")
    private String remEmail;

    private LocalDateTime regdt;

    private LocalDateTime updt;
}
