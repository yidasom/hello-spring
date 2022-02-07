package hello.hellospring.websocket.service;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * cpu 정보
 */
@Setter
@Getter
@ToString
public class CpuInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	private Double usageCpu;
	private Double totalCpu;
	private Double freeCpu;

}
