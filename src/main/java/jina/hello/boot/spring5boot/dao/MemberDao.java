package jina.hello.boot.spring5boot.dao;

import jina.hello.boot.spring5boot.model.Member;
import jina.hello.boot.spring5boot.model.Zipcode;

import java.util.List;

public interface MemberDao {
    int insertMember(Member m);

    List<Member> selectMember();

    List<Zipcode> selectzip(String dong);

    int selectOneUserid(String uid);

    Member selectOneMember(Member m);
}