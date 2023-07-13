package jina.hello.boot.spring5boot.dao;

import jina.hello.boot.spring5boot.model.Board;

import java.util.List;
import java.util.Map;

public interface BoardDao {
    int insertBoard(Board b);
    List<Board> selectBoard(int stnum);
    Board selectOneBoard(String bno);
    int selectCountBoard();
    List<Board> selectFindBoard(Map<String,Object> params);
}
