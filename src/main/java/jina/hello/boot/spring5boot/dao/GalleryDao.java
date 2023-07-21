package jina.hello.boot.spring5boot.dao;

import jina.hello.boot.spring5boot.model.GalAttach;
import jina.hello.boot.spring5boot.model.Gallery;

import java.util.List;

public interface GalleryDao {
    List<Gallery> selectGallery(int stnum);

    int insertGallery(Gallery g);

    int insertGalAttach(GalAttach ga);


    int readOneGallery(String gno);

    Gallery selectOneGallery(String gno);
}
