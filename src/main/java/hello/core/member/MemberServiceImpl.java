package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService {
    //회원 서비스 구현체
    //private final MemberRepository memberRepository = new MemoryMemberRepository(); //의존
    private final MemberRepository memberRepository; //실행에만 집중 의존은 외부에서 처리(AppConfig)

    @Autowired //ac.getBean(MemberRepository.class)과 동일
    public MemberServiceImpl(MemberRepository memberRepository) { //생성자
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
