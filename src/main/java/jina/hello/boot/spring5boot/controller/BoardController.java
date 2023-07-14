package jina.hello.boot.spring5boot.controller;

import jina.hello.boot.spring5boot.model.Board;
import jina.hello.boot.spring5boot.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    final BoardService bsrv;
    Logger logger = LogManager.getLogger(BoardController.class);

    @GetMapping("/list/{cpg}")
    public String list(Model m, @PathVariable Integer cpg) {
        logger.info("board/list 호출!!");
        m.addAttribute("bds",bsrv.readBoard(cpg));
        m.addAttribute("cpg",cpg);
        m.addAttribute("cntpg",bsrv.countBoard());
        m.addAttribute("stpg",((cpg-1)/10)*10+1);
        //만일, 현재페이지(cpg)가 총 페이지 수(cntpg)보다 크면 cpg를 1페이지로 강제 이동
       if(cpg > (int)m.getAttribute("cntpg")) {
            return "redirect:/board/list/1";
        }
        return "board/list";
    }

    @GetMapping("/view/{bno}")
    public String view(Model m, @PathVariable String bno) {
        logger.info("board/view 호출!!");
        m.addAttribute("bd",bsrv.readOneBoard(bno));
        return "board/view";
    }

    @GetMapping("/write")
    public String write() {
        logger.info("board/write 호출!!");
        return "board/write";
    }

    @PostMapping("/write")
    public String writeok(Board b) {
        logger.info("board/writeok 호출!!");
        String returnPage = "redirect:/board/fail";
        if(bsrv.saveBoard(b))
            returnPage = "redirect:/board/list/1";
        return returnPage;
    }

    @GetMapping("/find/{findtype}/{findkey}/{cpg}")
    public String find(Model m, @PathVariable Integer cpg, @PathVariable String findtype, @PathVariable String findkey ){
        logger.info("board/find 호출!!");
        m.addAttribute("bds",bsrv.readFindBoard(cpg, findtype, findkey));
        m.addAttribute("cpg",cpg);
        m.addAttribute("cntpg",bsrv.countFindBoard(findtype,findkey));
        m.addAttribute("stpg",((cpg-1)/10)*10+1);
        m.addAttribute("ftype", findtype);
        m.addAttribute("fkey", findkey);
        //만일, 현재페이지(cpg)가 총 페이지 수(cntpg)보다 크면 cpg를 1페이지로 강제 이동
        if(cpg > (int)m.getAttribute("cntpg")) {
            return "redirect:/board/list/1";
        }
        return "board/list";
    }
}
