package hello.core;

import hello.core.discount.DiscountPolicy;
        import hello.core.discount.FixDiscountPolicy;
        import hello.core.discount.RateDiscountPolicy;
        import hello.core.member.MemberRepository;
        import hello.core.member.MemberService;
        import hello.core.member.MemberServiceImpl;
        import hello.core.member.MemoryMemberRepository;
        import hello.core.order.OrderService;
        import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration      // 애플리케이션의 설정 정보
public class AppConfig {

    @Bean   // 스프링 컨테이너에 등록된다.
    public MemberRepository memberRepository() {    // 객체 생성을 메소드 처리
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();        // 새로운 구현체를 주입 하고 싶다면 new 객체를 수정하면 된다.
    }

    @Bean
    public DiscountPolicy discountPolicy(){         // 객체 생성을 메소드 처리
        //return new FixDiscountPolicy();             // 새로운 구현체를 주입 하고 싶다면 new 객체를 수정하면 된다.
        return new RateDiscountPolicy();
    }

    @Bean
    public MemberService memberService(){
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService(){
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
}
