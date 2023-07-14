package jina.hello.boot.spring5boot.service;

import jina.hello.boot.spring5boot.model.Board;

import java.util.List;
import java.util.Map;

public interface BoardService {
    boolean saveBoard(Board b);
    List<Board> readBoard(Integer cpg);
    Board readOneBoard(String bno);
    int countBoard();
    List<Board> readFindBoard(Integer cpg, String ftype, String fkey);
    int countFindBoard(String ftype, String fkey);
}
