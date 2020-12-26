package hello.core.beanFind;

import hello.core.AppConfig;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


class ApplicationContextBeanBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void 빈_이름으로_조회(){
        MemberService memberService = ac.getBean("memberService", MemberService.class);

        // getBean으로 찾아온 MemberService와 실제 객체가 연결된 구현체(MemberServiceImpl)과 동일한지
        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("이름없이 타입으로만 조회")
    void 이름없이_타입으로만_조회(){
        MemberService memberService = ac.getBean(MemberService.class);

        // getBean으로 찾아온 MemberService와 실제 객체가 연결된 구현체(MemberServiceImpl)과 동일한지
        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("구현체 타입으로 조회")
    void 구현체_타입으로_조회(){
        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);

        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }
    
    @Test
    @DisplayName("빈 이름으로 조회(예외)")
    void 빈_이름으로_조회_예외(){
        // ac.getBean 실행 시 예외가 터져야 테스트 정상 완료
        org.junit.jupiter.api.Assertions.assertThrows(NoSuchBeanDefinitionException.class
                , () -> ac.getBean("xxxx" ,MemberService.class));
    }
}

