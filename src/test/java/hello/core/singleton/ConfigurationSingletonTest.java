package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationSingletonTest {

    @Test
    void configurationTest(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);

        MemberRepository memberRepository1 = memberService.getMemberRepository();
        MemberRepository memberRepository2 = orderService.getMemberRepository();
        MemberRepository memberRepository3 = ac.getBean("memberRepository", MemberRepository.class);

        System.out.println("memberService -> MemberRepository = " + memberRepository1);
        System.out.println("orderService -> MemberRepository = " + memberRepository2);
        System.out.println("memberRepository = " + memberRepository3);
//        memberService -> MemberRepository = hello.core.member.MemoryMemberRepository@37091312
//        orderService -> MemberRepository = hello.core.member.MemoryMemberRepository@37091312
//        memberRepository = hello.core.member.MemoryMemberRepository@37091312

        Assertions.assertThat(memberService.getMemberRepository()).isSameAs(memberRepository3);
        Assertions.assertThat(orderService.getMemberRepository()).isSameAs(memberRepository3);
    }

    @Test
    void configurationDeep(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig bean = ac.getBean(AppConfig.class);
        System.out.println("appConfig = " + bean.getClass());
        //appConfig = class hello.core.AppConfig$$EnhancerBySpringCGLIB$$ba528fbb
        //$$EnhancerBySpringCGLIB$$ba528fbb
    }
}
