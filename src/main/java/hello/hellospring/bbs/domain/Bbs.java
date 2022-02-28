package hello.hellospring.bbs.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * hello.hellospring.bbs.domain
 *
 * @data : 2022/02/25
 * @author : idasom
 */
@Table(name="y_bbs")
@Setter
@Getter
@ToString
public class Bbs implements BbsVO {
    /** 게시글 고유 id */
    private Long bbsId;

    /** 게시글 이름 */
    private String bbsNm;

    /** 게시글 내용 */
    private String bbsCn;

    /** 게시글 타입 (일반 : ORI, 이미지 : IMG) */
    private String bbsType;

    /** 작성자 */
    private Long regid;

    /** 작성일 */
    private LocalDateTime regdt;

    /** 수정자 */
    private Long upid;

    /** 수정일 */
    private LocalDateTime updt;
}
