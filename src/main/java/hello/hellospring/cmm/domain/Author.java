package hello.hellospring.cmm.domain;

import com.google.gson.annotations.SerializedName;
import hello.hellospring.member.domain.Member;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * hello.hellospring.cmm.domain
 *
 * @author : idasom
 * @data : 2022/03/01
 */
@Entity(name="y_author")
@Table(name="y_author")
@Getter
@Setter
@ToString
public class Author {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="auth_id")
    private Long auth_id;

    @Column(name="author")
    private String author;

    private LocalDateTime regdt;

    private LocalDateTime updt;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "id")
    private Member member;

}
