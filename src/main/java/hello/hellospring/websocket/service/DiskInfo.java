package hello.hellospring.websocket.service;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 디스크 정보
 */
@Setter
@Getter
@ToString
public class DiskInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String diskName;
    private Double totalSize;
    private Double freeSize;

}
