package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan( // @Component를 찾아 스프링 빈으로 등록해준다.
    // 기본 스캔 범위를 정할 수 있다.
    basePackages = "hello.core.member",

    // 기존 AppConfig.java는 등록이 되면 안되기 때문에
    // @Component 어노테이션을 찾을 때 제외할 어노테이션 (@Configuration)
    excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION
            , classes = Configuration.class)
)
public class AutoAppConfig {

}
