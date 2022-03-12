package hello.hellospring;

import hello.hellospring.member.domain.MemberInfo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@SpringBootApplication
public class HelloSpringApplication {

	@Resource
	private MemberInfo info;

	public static void main(String[] args) {
		SpringApplication.run(HelloSpringApplication.class, args);
	}

}
