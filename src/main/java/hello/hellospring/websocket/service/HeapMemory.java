package hello.hellospring.websocket.service;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 자바 힙 메모리
 */
@Setter
@Getter
@ToString
public class HeapMemory implements Serializable {

	private static final long serialVersionUID = 1L;

	private Double heap;
	private Double nonHeap;

}
