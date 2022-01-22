package hello.hellospring.member.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.annotation.SessionScope;

/**
 * 세션 넣는 vo
 */
@Getter
@Setter
@Component
@SessionScope(proxyMode = ScopedProxyMode.TARGET_CLASS)
@ToString
public class Sesson {
    private Long id;
    private String name;
    private String email;
}
