package study.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.spring.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
