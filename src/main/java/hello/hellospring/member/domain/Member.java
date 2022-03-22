package hello.hellospring.member.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.annotation.SessionScope;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(name="y_member")
@Table(name="y_member")
@Getter
@Setter
//@ToString
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    /** 닉네임 */
    private String name;
    /** 이메일 */
    @SerializedName("email")
    private String email;
    /** 비밀번호 */
    @SerializedName("passwrd")
    private String passwrd;
    /** 이메일 기억 */
    @SerializedName("remEmail")
    private String remEmail;

    private LocalDateTime regdt;

    private LocalDateTime updt;

    /** 고객 금액 정보 */
    @JsonIgnore
    @OneToOne(mappedBy = "member")
    private MemberCharge memberCharge;

}
