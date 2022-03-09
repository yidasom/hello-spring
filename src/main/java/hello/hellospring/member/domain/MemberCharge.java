package hello.hellospring.member.domain;

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
@Entity(name="y_memberCharge")
@Table(name="y_memberCharge")
@Setter
@Getter
@ToString
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

    /** 사용시간 */
    private Integer charge;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "id")
    private Member member;
}
