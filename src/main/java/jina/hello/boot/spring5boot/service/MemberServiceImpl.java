package jina.hello.boot.spring5boot.service;

import jina.hello.boot.spring5boot.dao.MemberDao;
import jina.hello.boot.spring5boot.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("msrv")
public class MemberServiceImpl implements MemberService{
    @Autowired
    private MemberDao mdao;

    @Override
    public boolean saveMember(Member m) {
        boolean isSaved = false;
        if(mdao.insertMember(m) > 0) isSaved = true;
        return isSaved;
    }

    @Override
    public List<Member> readMember() {
        return mdao.selectMember();
    }
}
