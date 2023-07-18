package jina.hello.boot.spring5boot.dao;

import jina.hello.boot.spring5boot.model.Pds;
import jina.hello.boot.spring5boot.model.PdsAttach;
import jina.hello.boot.spring5boot.mybatis.PdsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("pdao")
public class PdsDaoImpl implements PdsDao{
    @Autowired
    private PdsMapper pdsMapper;

    @Override
    public int insertPds(Pds p) {
        int cnt = pdsMapper.insertPds(p);
        if(cnt > 0) cnt = pdsMapper.lastPdsPno();
        return cnt;
    }

    @Override
    public int insertPdsAttach(PdsAttach pa) {
        return pdsMapper.insertPdsAttach(pa);
    }

    @Override
    public List<Pds> selectPds(int stnum) {
        return pdsMapper.selectPds(stnum);
    }

    @Override
    public int selectCountPds() {
        return pdsMapper.selectCountPds();
    }

    @Override
    public Pds selectOnePds(String pno) {
        return pdsMapper.selectOnePds(pno);
    }

    @Override
    public PdsAttach selectOnePdsAttach(String pno) {
        return pdsMapper.selectOnePdsAttach(pno);
    }
}
