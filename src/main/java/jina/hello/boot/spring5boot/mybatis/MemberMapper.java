package jina.hello.boot.spring5boot.mybatis;

import jina.hello.boot.spring5boot.model.Zipcode;
import jina.hello.boot.spring5boot.model.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {
    int insertMember(Member m);
    List<Member> selectMember();
    List<Zipcode> findZipcode(String dong);
    int selectOneUserid(String uid);
    Member selectOneMember(Member m);
}
