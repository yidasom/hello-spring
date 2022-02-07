package hello.hellospring.websocket.service;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 램 메모리
 */
@Setter
@Getter
@ToString
public class RamMemory implements Serializable {

	private static final long serialVersionUID = 1L;

	private Double totalRam;
	private Double freeRam;

}
