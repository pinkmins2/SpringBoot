package jina.hello.boot.spring5boot;

import jina.hello.boot.spring5boot.dao.MemberDao;
import jina.hello.boot.spring5boot.dao.MemberDaoImpl;
import jina.hello.boot.spring5boot.model.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import(MemberDaoImpl.class)
public class MemberDaoUnitTest {
    @Autowired
    private MemberDao mdao;

    @Test
    @DisplayName("MemberDao insert Test")
    void insertMember() {
        Member m = new Member(null, "","","","","","","","","",null);
        int result = mdao.insertMember(m);
        System.out.println(result);
        assertEquals(result, 1);
    }

    @Test
    @DisplayName("MemberDao select Test")
    void selectMember() {
        List<Member> results = mdao.selectMember();
        System.out.println(results);
        assertNotNull(results);
    }

    @Test
    @DisplayName("MemberDao checkUserid Test")
    void checkUserid() {
        String uid = "abc123";
        int result = mdao.selectOneUserid(uid);
        System.out.println(result);;
        assertEquals(result, 1);
    }

    @Test
    @DisplayName("MemberDao selectOneMember Test")
    void selectOneMember() {
        Member m = new Member();
        m.setUserid("abc123");
        m.setPasswd("987xyz");
        Member result = mdao.selectOneMember(m);
        System.out.println(result);
        assertNotNull(result);
    }
}