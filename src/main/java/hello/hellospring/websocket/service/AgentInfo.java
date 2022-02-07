package hello.hellospring.websocket.service;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * AgentInfo
 * @date 2022-02-07
 * @author miz-yi
 *
 * lib를 사용하지 않고 java에서 가지고 올 수 있는 시스템 정보
 * 초기화 객체해주는 이유는 나중에 해당 객체 안의 변수를 set할 시, 해당 객체를 초기화 해주지 않으면 null로 error 발생
 */
@Setter
@Getter
@ToString
public class AgentInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    private CpuInfo cpuInfo = new CpuInfo();
    private DiskInfo diskInfo = new DiskInfo();
    private HeapMemory heapMemory = new HeapMemory();
    private RamMemory ramMemory = new RamMemory();
}
