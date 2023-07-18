package jina.hello.boot.spring5boot.pds;

import jina.hello.boot.spring5boot.model.Board;
import jina.hello.boot.spring5boot.model.Pds;
import jina.hello.boot.spring5boot.model.PdsAttach;
import jina.hello.boot.spring5boot.mybatis.PdsMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PdsMapperUnitTest {
    @Autowired
    private PdsMapper pdsMapper;

    @Test
    @DisplayName("PdsMapper lastId Test")
    @Transactional
    void lastIdPds() {
        Pds p = new Pds();
        p.setUserid("abc123");
        p.setTitle("t");
        p.setContents("c");
        p.setIpaddr("127.0.0.1");
        pdsMapper.insertPds(p);
        int result = pdsMapper.lastPdsPno();
        //System.out.println(result);
        assertNotNull(result);
    }

    @Test
    @DisplayName("PdsMapper selectOnePA Test")
    void selectOnePA() {
        String pno = "17";
        PdsAttach result = pdsMapper.selectOnePdsAttach(pno);
        //System.out.println(result);
        assertNotNull(result);
    }
}