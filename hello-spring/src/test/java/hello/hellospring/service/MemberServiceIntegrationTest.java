package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class MemberServiceIntegrationTest {
    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;

    @Test
    @Commit
    void 회원가입 () {
    //given
        Member member = new Member();
        member. setName ("spring");

        //when
        Long saveId = memberService. join (member);

        //then
        Member findMember = memberService. findOne (saveId) .get() ;
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }
}
