package jina.hello.boot.spring5boot.dao;

import jina.hello.boot.spring5boot.model.Member;
import jina.hello.boot.spring5boot.model.Zipcode;
import jina.hello.boot.spring5boot.mybatis.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("mdao")
@RequiredArgsConstructor
public class MemberDaoImpl implements MemberDao{
    // mybatis를 사용하기 위해 필요한 객체 DI
    // 단, 생성자 주입 방식 사용!
    @Autowired
    final MemberMapper memberMapper;

//    @Autowired
//    private SqlSession sqlSession;

    @Override
    public int insertMember(Member m) {
        // sqlSession.insert("insert관련 매핑 insertMember",매개변수 m)로 사용하는 방식보다는 편리
        // return sqlSession.insert("jina.hello.boot.spring5boot.mybatis.MemberMapper.insertMember",m);
        // return sqlSession.insert("insertMember", m)
        return memberMapper.insertMember(m);
    }

    @Override
    public List<Member> selectMember() {
        return memberMapper.selectMember();
    }

    @Override
    public List<Zipcode> selectzip(String dong) {
        return memberMapper.findZipcode(dong);
    }

    @Override
    public int selectOneUserid(String uid) {
        return memberMapper.selectOneUserid(uid);
    }

    @Override
    public Member selectOneMember(Member m) {
        return memberMapper.selectOneMember(m);
    }
}