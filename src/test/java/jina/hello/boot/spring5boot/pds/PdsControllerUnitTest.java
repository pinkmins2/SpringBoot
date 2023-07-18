package jina.hello.boot.spring5boot.pds;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileInputStream;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class PdsControllerUnitTest {
    @Autowired
    private MockMvc mvc;

    @Test
    @DisplayName("PdsController upload Test")
    void writeok() throws Exception {
        String fpath = "C:/Java/abc123.png";    //테스트용 이미지 위치 경로
        FileInputStream fis = new FileInputStream(fpath);
        // MockMultipartFile(폼이름, 파일명, MIME, 파일객체);
        MockMultipartFile attach = new MockMultipartFile(
                "attach", "abc123.png", "image/png", fis );
        mvc.perform(multipart("/pds/write").file(attach)
                        .param("title","a")
                        .param("userid","abc123")
                        .param("contents","b")
                        .param("ipaddr","127.0.0.1")
                ).andExpect(status().is3xxRedirection())
                .andDo(print());
    }

    @Test
    @DisplayName("PdsController download Test")
    void download() throws Exception {
        mvc.perform(get("/pds/down/17"))
                .andExpect(status().is(200))
                .andDo(print());
    }
}
