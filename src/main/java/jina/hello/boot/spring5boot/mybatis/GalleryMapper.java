package jina.hello.boot.spring5boot.mybatis;

import jina.hello.boot.spring5boot.model.GalAttach;
import jina.hello.boot.spring5boot.model.Gallery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GalleryMapper {
    int insertGallery(Gallery g);
    int insertGalAttach(GalAttach ga);
    List<Gallery> selectGallery(int stnum);
    int selectCountGallery();
    Gallery selectOneGallery(String gno);
    GalAttach selectOneGalleryAttach(String gno);
//    int insertPdsComment(PdsComment pc);
//    List<PdsComment> selectPdsComment(String pno);
//    int insertPdsReply(PdsComment pc);
//    int updateViewPds(String pno);
//    List<Pds> selectFindPds(Map<String, Object> params);
//    int countFindPds(Map<String, Object> params);
}
