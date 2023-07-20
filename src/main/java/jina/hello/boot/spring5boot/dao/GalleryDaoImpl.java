package jina.hello.boot.spring5boot.dao;

import jina.hello.boot.spring5boot.model.Gallery;
import jina.hello.boot.spring5boot.mybatis.GalleryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("gdao")
public class GalleryDaoImpl implements GalleryDao{
    @Autowired private GalleryMapper galleryMapper;

    @Override
    public List<Gallery> selectGallery(int stnum) {
        return galleryMapper.selectGallery(stnum);
    }
}
