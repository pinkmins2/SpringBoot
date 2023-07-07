package jina.hello.boot.spring5boot.dao;

import jina.hello.boot.spring5boot.model.Member;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("mdao")
public class MemberDaoImpl implements MemberDao{
    // mybatis를 사용하기 위해 필요한 객체 DI
    @Autowired
    private SqlSession sqlSession;

    @Override
    public int insertMember(Member m) {
        // insert(insert관련 매핑, 매개변수)
        return sqlSession.insert("member.insertMember",m);
    }

    @Override
    public List<Member> selectMember() {
        return null;
    }
}
