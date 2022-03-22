package hello.hellospring.member.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * hello.hellospring.member.domain
 *
 * @author : idasom
 * @data : 2022/03/08
 */
@Entity(name="y_membercharge")
@Table(name="y_membercharge")
@Setter
@Getter
@ToString(exclude = "member")
public class MemberCharge {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="chg_id")
    private Long chg_id;

    /** 닉네임 */
    private String nick;

    /** 전화번호 */
    private String phone;

    /** 입실시간 */
    private LocalDateTime checkInTime;

    /** 사용시간 */
    private LocalDateTime useTime;

    /** 충전금액 */
    private Integer charge;

    /** 좌석 */
    private String seat;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "id")
    private Member member;
}
