package hello.core.member;

public interface MemberRepository {

    //(회원 정보 저장)
    void save(Member member);

    //회원 id로 회원 정보 찾기
    Member findById(Long memberId);
}
