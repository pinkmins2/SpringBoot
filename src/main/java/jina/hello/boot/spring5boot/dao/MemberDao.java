package jina.hello.boot.spring5boot.dao;

import jina.hello.boot.spring5boot.model.Member;

import java.util.List;

public interface MemberDao {
    int insertMember(Member m);

    List<Member> selectMember();

}
