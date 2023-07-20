package jina.hello.boot.spring5boot.dao;

import jina.hello.boot.spring5boot.model.Gallery;

import java.util.List;

public interface GalleryDao {
    List<Gallery> selectGallery(int stnum);
}
