package jina.hello.boot.spring5boot.controller;

import jina.hello.boot.spring5boot.model.Gallery;
import jina.hello.boot.spring5boot.model.Pds;
import jina.hello.boot.spring5boot.service.GalleryService;
import jina.hello.boot.spring5boot.service.PdsService;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/gallery")
@RequiredArgsConstructor
public class GalleryController {
    final GalleryService gsrv;

    Logger logger = LogManager.getLogger(GalleryController.class);

    @GetMapping("list/{cpg}")
    public String list(Model m, @PathVariable Integer cpg) {
        logger.info("gallery/list 호출!!");
        m.addAttribute("gals", gsrv.readGallery(cpg));
        m.addAttribute("cpg", cpg);
        m.addAttribute("cntpg", gsrv.countGallery());
        m.addAttribute("stpg", ((cpg - 1) / 10) * 10 + 1);
//        if (cpg > (int) m.getAttribute("cntpg")) {
//            return "redirect:/gallery/list/1";
//        }
        return "gallery/list";
    }

    @GetMapping("/write")
    public String write() {
        logger.info("gallery/write 호출!!");
        return "gallery/write";
    }

    @PostMapping("/write")
    public String writeok(Gallery g , List<MultipartFile> attachs) {
        logger.info("gallery/writeok 호출!!");
        String returnPage = "redirect:/gallery/fail";
        // 작성한 게시글을 먼저 디비에 저장하고 글번호를 알아냄
        int gno = gsrv.newGallery(g);
        // 알아낸 글 번호를 이용해서 첨부파일 처리(DB 저장, 업로드)
        if(!attachs.isEmpty()) {  // 첨부파일이 존재한다면
            gsrv.newGalAttach(attachs, gno);
            returnPage = "redirect:/gallery/list/1";
        }
        return returnPage;
    }

}