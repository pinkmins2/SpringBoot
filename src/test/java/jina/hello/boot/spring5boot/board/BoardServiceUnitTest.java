package jina.hello.boot.spring5boot.board;

import jina.hello.boot.spring5boot.dao.BoardDaoImpl;
import jina.hello.boot.spring5boot.model.Board;
import jina.hello.boot.spring5boot.service.BoardServiceImpl;
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
@Import({BoardServiceImpl.class, BoardDaoImpl.class})
public class BoardServiceUnitTest {
    @Autowired
    private BoardServiceImpl bsrv;

    @Test
    @DisplayName("BoardService read Test")
    void readBoard() {
        int cpg = 1;
        List<Board> results = bsrv.readBoard(cpg);
        //System.out.println(results);
        assertNotNull(results);
    }

    @Test
    @DisplayName("BoardService readOne Test")
    void readOneBoard() {
        String bno = "3009";
        Board result = bsrv.readOneBoard(bno);
        //System.out.println(result);
        assertNotNull(result);
    }

    @Test
    @DisplayName("BoardService save Test")
    @Transactional
    void saveBoard() {
        Board b = new Board();
        b.setUserid("abc123");
        // abc123a는 member2 테이블의 외래키(foreign key) 조건 때문에 db에 있는 아이디로 테스트
        b.setTitle("t");
        b.setContents("c");
        b.setIpaddr("127.0.0.1");
        boolean result = bsrv.saveBoard(b);
        //System.out.println(result);
        assertEquals(result, true);
    }

    @Test
    @DisplayName("BoardService countPage Test")
    void countPage() {
        int result = bsrv.countBoard();
        assertNotNull(result);
    }

    @Test
    @DisplayName("BoardDao findBoard Test")
    void findBoard() {
        Map<String, Object> params = new HashMap<>();
        String ftype = "title";
        String fkey = "t";
        int cpg = 1;
        List<Board> results = bsrv.readFindBoard(cpg,ftype,fkey);
        assertNotNull(results);
    }

    @Test
    @DisplayName("BoardDao countFindBoard Test")
    void countFindBoard() {
        Map<String, Object> params = new HashMap<>();
        String ftype = "userid";
        String fkey = "jina";
        int result = bsrv.countFindBoard(ftype,fkey);
        assertNotNull(result);
    }
}