package study.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import study.spring.domain.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

}
