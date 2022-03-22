package hello.hellospring.member.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import java.time.LocalDateTime;

/**
 * hello.hellospring.member.domain
 * 유치 고객
 * @author : idasom
 * @data : 2022/03/22
 */
@Setter
@Getter
@ToString
public class AttrCust {
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

}
