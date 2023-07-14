package jina.hello.boot.spring5boot.utils;

import jina.hello.boot.spring5boot.model.PdsAttach;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

@Component()
public class PdsUtils {
    Logger logger = LogManager.getLogger(PdsUtils.class);

    // 첨부 파일 저장 위치
    @Value("${saveDir}")
    private String saveDir;
    public PdsAttach processUpload(MultipartFile attach) {
        PdsAttach pa = new PdsAttach();

        // 업로드 할 파일 정보 알아내기 - 첨부 파일명
        pa.setFname(makeUUID() + attach.getOriginalFilename());

        // 업로드 할 파일 정보 알아내기 - 확장자 추출
        // 파일명: abc123.zip          -> 확장자 zip 추출
        // 파일명: abc123.zip          -> 파일명.split(".")[1]
        // 파일명: abc123.987xyz.zip   -> 파일명.substring(lastIndexOf".")+1
        int pos = pa.getFname().lastIndexOf(".")+1;
        pa.setFtype(pa.getFname().substring(pos));

        // 업로드할 파일 정보 알아내기 - 파일 크기
        pa.setFsize(attach.getSize()/1024 + "");

        // 첨부파일을 지정한 위치에 저장
        String savepath = saveDir + pa.getFname();
        try {
            attach.transferTo(new File(savepath));
        } catch (IOException e) {
            logger.error("첨부파일 처리 중 오류 발생");
            e.printStackTrace();
        }

        return pa;
    }

    private String makeUUID() {
        String uuid = LocalDate.now() + "" + LocalTime.now();
       uuid = uuid.replace("-","")
                   .replace(":","")
                   .replace(".","");
        return uuid;
    }
}
