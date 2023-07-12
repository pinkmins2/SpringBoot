package jina.hello.boot.spring5boot.dao;

import jina.hello.boot.spring5boot.model.Board;
import jina.hello.boot.spring5boot.mybatis.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("bdao")
@RequiredArgsConstructor
public class BoardDaoImpl implements BoardDao{
    // @Autowired 없이 DI 구현
    final BoardMapper boardMapper;

    @Override
    public int insertBoard(Board b) {
        return 0;
    }

    @Override
    public List<Board> selectBoard(int stnum) {
        return boardMapper.selectBoard(stnum);
    }

    @Override
    public Board selectOneBoard(String bno) {
        return boardMapper.selectOneBoard(bno);
    }
}
