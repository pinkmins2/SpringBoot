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

import java.util.List;

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

}