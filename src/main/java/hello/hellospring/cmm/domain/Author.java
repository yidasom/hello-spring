package hello.hellospring.cmm.domain;

import com.google.gson.annotations.SerializedName;
import hello.hellospring.member.domain.Member;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * hello.hellospring.cmm.domain
 *
 * @author : idasom
 * @data : 2022/03/01
 */
@Table(name="y_author")
@Getter
@Setter
@ToString
public class Author {
//    @ManyToOne
//    @JoinColumn(name = "id")
//    private Member member;
    @SerializedName("id")
    private Long id;

    @SerializedName("author")
    private String author;

    private LocalDateTime regdt;

    private LocalDateTime updt;

}
