package jina.hello.boot.spring5boot.board;

import jina.hello.boot.spring5boot.dao.BoardDaoImpl;
import jina.hello.boot.spring5boot.dao.MemberDaoImpl;
import jina.hello.boot.spring5boot.model.Board;
import jina.hello.boot.spring5boot.model.Member;
import jina.hello.boot.spring5boot.service.BoardService;
import jina.hello.boot.spring5boot.service.BoardServiceImpl;
import jina.hello.boot.spring5boot.service.MemberServiceImpl;
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
@Import({BoardServiceImpl.class, BoardDaoImpl.class})
public class BoardServiceUnitTest {
    @Autowired
    private BoardServiceImpl bsrv;

    @Test
    @DisplayName("BoardService read Test")
    void readMember() {
        List<Board> results = bsrv.readBoard();
        //System.out.println(results);
        assertNotNull(results);
    }

}