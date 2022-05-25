package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    //회원이 저장소에 저장
    Member save(Member member);

    //findbyid로 가져오는데 null일때 그냥 반환하지 않고 Optional로 감싸서 반환
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);

    //지금까지 저장된 모든 회원리스트를 반환
    List<Member> findAll();
}
