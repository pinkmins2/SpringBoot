package jina.hello.boot.spring5boot.dao;

import jina.hello.boot.spring5boot.model.Pds;
import jina.hello.boot.spring5boot.model.PdsAttach;

import java.util.List;

public interface PdsDao {
    int insertPds(Pds p);
    int insertPdsAttach(PdsAttach pa);
    List<Pds> selectPds(int stnum);
    int selectCountPds();
    Pds selectOnePds(String pno);
}
