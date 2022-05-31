package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryMemberRepository implements  MemberRepository {

    //메모리라서 저장을 하기 위해 Map을 씀
    private  static Map<Long, Member> store = new HashMap<>();


    //시퀀스는 0,1,2 이렇게 키 값을 생성해 주는 놈
    private  static long sequence = 0L;


    @Override
    public Member save(Member member) {
        //id셋팅
        member.setId(++sequence);
        //스토어에 저장-map에 저장됨
        store.put(member.getId(), member);
        return  member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        //그냥 store.get(id)를 한다면 id가 없을경우 null이 된다. 옛날에는 이렇게 썻음
        //하지만 요새는 Optional로 감싸서 반환한다.
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        //getName이 파라메터 name과 같은지 확인
        //같은 경우에만 필터링이 된다
        //findAny()->하나라도 찾는다.
       return store.values().stream().filter(member -> member.getName().equals(name)).findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
