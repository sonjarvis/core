package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

//    MemberService memberService = new MemberServiceImpl();
    MemberService memberService;

    //테스트를 실행하기 전에 무조건 실행
    @BeforeEach
    public void BeforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join(){
        //given 주어졌을때
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when 이렇게 했을때
        memberService.join(member);
        Member finMember = memberService.findMember(1L);

        //then 이렇게 된다 (검증) org.assertj 라이브러리 사용
        Assertions.assertThat(member).isEqualTo(finMember); //가입된 회원이랑 조회된 회원이랑 똑같은지
    }
}
