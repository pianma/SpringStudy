package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

public class JdbcMemberRepository implements MemberRepository   {

    //db에 붙으려면 DataSource라는게 필요함.
    private final DataSource dataSource;

    public JdbcMemberRepository(DataSource dataSource) {
        this.dataSource = dataSource;

        //진짜 데이터베이스와 연결되는 소켓을 얻을 수 있음 여기에 sql문을 날려서 db에 전달하면 됨.
        //dataSource.getConnection();
    }

    @Override
    public Member save(Member member) {
        String sql = "insert into member(name) values(?)";


        return null;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Member> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public List<Member> findAll() {
        return null;
    }
}
