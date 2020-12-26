package hello.core;

import hello.core.member.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// 순수 자바 코드로 테스트
public class MemberApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

        // AppConfig에 있는 설정 정보를 스프링 컨테이너에 넣어 직접 관리해준다.
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        // applicationContext에서 AppConfig에서 bean으로 등록한 클래스를 가져온다.
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        // Ctrl + Alt + V - 반환 되는 값에 맞는 인스턴스를 자동 기입
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new Member =" + member.getName());
        System.out.println("find Member =" + findMember.getName());
    }
}
