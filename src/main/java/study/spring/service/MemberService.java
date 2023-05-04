package study.spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.spring.domain.Member;
import study.spring.repository.MemberRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public void join(Member member) {
        memberRepository.save(member);
    }
}
