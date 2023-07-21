package jina.hello.boot.spring5boot.service;

import jina.hello.boot.spring5boot.dao.GalleryDao;
import jina.hello.boot.spring5boot.model.GalAttach;
import jina.hello.boot.spring5boot.model.Gallery;
import jina.hello.boot.spring5boot.utils.GalleryUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service("gsrv")
@RequiredArgsConstructor
public class GalleryServiceImpl implements GalleryService{
    final GalleryDao gdao;
    final GalleryUtils galUtils;
    @Override
    public List<Gallery> readGallery(Integer cpg) {
        return gdao.selectGallery(cpg - 1);
    }

    @Override
    public int countGallery() {
        return 0;
    }

    @Override
    public int newGallery(Gallery g) {
        return gdao.insertGallery(g);
    }

    @Override
    public boolean newGalAttach(List<MultipartFile> attachs, int gno) {
        // 이미지 파일 저장 후 파일 정보들 받아오기
        GalAttach ga = galUtils.processUpload(attachs);

        // 썸네일 이미지 생성
        galUtils.makeThumbnail(ga);

        // 이미지 파일 정보 저장
        ga.setGno(gno+"");
        return (gdao.insertGalAttach(ga) > 0) ? true : false;
    }

    @Override
    public Gallery readOneGallery(String gno) {
        return gdao.selectOneGallery(gno);
    }

}
