package jina.hello.boot.spring5boot.pds;

import jina.hello.boot.spring5boot.dao.PdsDao;
import jina.hello.boot.spring5boot.dao.PdsDaoImpl;
import jina.hello.boot.spring5boot.model.Pds;
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
@Import(PdsDaoImpl.class)
public class PdsDaoUnitTest {
    @Autowired
    private PdsDao pdao;

    @Test
    @DisplayName("BoardDao select Test")
    void selectBoard() {
        int cpg = 1;
        int stnum = (cpg -1) * 25;
        List<Pds> results = pdao.selectPds(stnum);
        //System.out.println(results);
        assertNotNull(results);
    }

    @Test
    @DisplayName("PdsDao selectOnePds Test")
    void selectOnePds() throws Exception {
        String pno = "5";
        Pds result = pdao.selectOnePds(pno);
        //System.out.println(results);
        assertNotNull(result);
    }
}