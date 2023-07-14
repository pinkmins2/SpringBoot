package jina.hello.boot.spring5boot.dao;

import jina.hello.boot.spring5boot.model.Pds;
import jina.hello.boot.spring5boot.model.PdsAttach;

public interface PdsDao {
    int insertPds(Pds p);

    int insertPdsAttach(PdsAttach pa);
}
