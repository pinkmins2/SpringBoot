package jina.hello.boot.spring5boot.mybatis;

import jina.hello.boot.spring5boot.model.Pds;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface PdsMapper {
    int insertPds(Pds p);

    int lastPdsPno();
//    List<Pds> selectPds(int stnum);
//    Pds selectOnePds(String pno);
//    int updateViewPds(String pno);
//    int selectCountPds();
//    List<Pds> selectFindPds(Map<String, Object> params);
//    int countFindPds(Map<String, Object> params);
}