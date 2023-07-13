package jina.hello.boot.spring5boot.service;

import jina.hello.boot.spring5boot.dao.BoardDao;
import jina.hello.boot.spring5boot.model.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("bsrv")
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{
    final BoardDao bdao;
    @Override
    public boolean saveBoard(Board b) {
        boolean isSaved = false;
        if(bdao.insertBoard(b) > 0) isSaved = true;
        return isSaved;
    }

    @Override
    public List<Board> readBoard(Integer cpg) {
        int stnum = (cpg - 1) * 25;
        return bdao.selectBoard(stnum);
    }

    @Override
    public Board readOneBoard(String bno) {
        return bdao.selectOneBoard(bno);
    }

    @Override
    public int countBoard() {
        return bdao.selectCountBoard();
    }
}
