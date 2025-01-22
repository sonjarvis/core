package hello.core.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MemoryMemberRepository implements MemberRepository {

    private final Map<Long, Member> store = new HashMap<>(); //*HashMap 은 동시성 이슈가 발생할 수 있음. 그래서 현업에서는 ConcurrentHashMap 주로 사용.

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
