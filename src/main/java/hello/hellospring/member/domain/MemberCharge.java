package hello.hellospring.member.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * hello.hellospring.member.domain
 *
 * @author : idasom
 * @data : 2022/03/08
 */
@Setter
@Getter
@ToString
public class MemberCharge {
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
}
