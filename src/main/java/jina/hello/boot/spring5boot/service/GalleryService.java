package jina.hello.boot.spring5boot.service;

import jina.hello.boot.spring5boot.model.Gallery;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public interface GalleryService {
    List<Gallery> readGallery(Integer cpg);
    int countGallery();

    int newGallery(Gallery g);

    boolean newGalAttach(List<MultipartFile> attachs, int gno);
}
