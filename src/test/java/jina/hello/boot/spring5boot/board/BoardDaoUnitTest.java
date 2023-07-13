package jina.hello.boot.spring5boot.board;

import jina.hello.boot.spring5boot.dao.BoardDao;
import jina.hello.boot.spring5boot.dao.BoardDaoImpl;
import jina.hello.boot.spring5boot.model.Board;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import(BoardDaoImpl.class)
public class BoardDaoUnitTest {
    @Autowired
    private BoardDao bdao;

    @Test
    @DisplayName("BoardDao select Test")
    void selectBoard() {
        int cpg = 1;
        int stnum = (cpg -1) * 25;
        List<Board> results = bdao.selectBoard(stnum);
        //System.out.println(results);
        assertNotNull(results);
    }

    @Test
    @DisplayName("BoardDao selectOne Test")
    void selectOneBoard() {
        String bno = "3009";
        Board result = bdao.selectOneBoard(bno);
        //System.out.println(results);
        assertNotNull(bno);
    }

    @Test
    @DisplayName("BoardDao insert Test")
    @Transactional
    void insertBoard() {
        Board b = new Board();
        b.setUserid("abc123");
        // abc123a는 member2 테이블의 외래키(foreign key) 조건 때문에 db에 있는 아이디로 테스트
        b.setTitle("t");
        b.setContents("c");
        b.setIpaddr("127.0.0.1");
        int result = bdao.insertBoard(b);
        //System.out.println(result);
        assertEquals(result, 1);
    }

    @Test
    @DisplayName("BoardDao countPage Test")
    void countPage() {
        int result = bdao.selectCountBoard();
        assertNotNull(result);
    }

    @Test
    @DisplayName("BoardDao findBoard Test")
    void findBoard() {
        Map<String, Object> params = new HashMap<>();
        params.put("findtype","titcont");
        params.put("findkey","t");
        params.put("stnum", 0);
        List<Board> results = bdao.selectFindBoard(params);
        assertNotNull(results);
    }
}