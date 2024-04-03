package hello.core.member;

public interface MemberService {

    void join(Member member); //회원가입

    Member findMember(Long memberId); //회원 아이디로 멤버 찾기
}
