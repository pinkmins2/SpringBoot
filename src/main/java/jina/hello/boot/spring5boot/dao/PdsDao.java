package jina.hello.boot.spring5boot.dao;

import jina.hello.boot.spring5boot.model.Pds;
import jina.hello.boot.spring5boot.model.PdsAttach;
import jina.hello.boot.spring5boot.model.PdsComment;

import java.util.List;

public interface PdsDao {
    int insertPds(Pds p);
    int insertPdsAttach(PdsAttach pa);
    List<Pds> selectPds(int stnum);
    int selectCountPds();
    Pds selectOnePds(String pno);
    PdsAttach selectOnePdsAttach(String pno);
    int insertPdsComment(PdsComment pc);
    List<PdsComment> selectPdsComment(String pno);
    int insertPdsReply(PdsComment pc);
}
