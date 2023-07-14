package jina.hello.boot.spring5boot.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PdsAttach {
    private String pano;
    private String pno;
    private String fname;
    private String ftype;
    private String fsize;
    private String fdown;
}
