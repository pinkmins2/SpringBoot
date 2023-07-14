package jina.hello.boot.spring5boot.service;

import jina.hello.boot.spring5boot.dao.PdsDao;
import jina.hello.boot.spring5boot.model.Pds;
import jina.hello.boot.spring5boot.model.PdsAttach;
import jina.hello.boot.spring5boot.utils.PdsUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@Service("psrv")
@RequiredArgsConstructor
public class PdsServiceImpl implements PdsService{
    final PdsDao pdao;
    final PdsUtils pdsUtils;

    @Override
    public int newPds(Pds p) {
        return pdao.insertPds(p);
    }

    @Override
    public boolean newPdsAttach(MultipartFile attach, int pno) {
        // 첨부한 파일을 지정한 위치에 저장 후 파일 정보 리턴
        PdsAttach pa = pdsUtils.processUpload(attach);
        //pa.setPno(String.valueOf(pno)); 아래 코드로 더 간단하게 형변환
        pa.setPno(pno + "");
        // 첨부 파일 정보를 디비에 저장
        int pacnt = pdao.insertPdsAttach(pa);
        return (pacnt > 0) ? true : false;
    }
}