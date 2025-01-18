package hello.core.member;

//회원 서비스 구현체
public class MemberServiceImpl implements MemberService {

    //private final MemberRepository memberRepository = new MemoryMemberRepository(); //의존
    private final MemberRepository memberRepository; //실행에만 집중 의존은 외부에서 처리(AppConfig)

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
}
