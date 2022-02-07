package hello.hellospring.websocket.service;

import org.hyperic.sigar.Sigar;

/**
 * SigarInfo
 * @date 2022-02-07
 * @author miz-yi
 *
 * 방법
 * sigar.jar 파일 추가
 * run > Edit Configurations ... > program Argument
 * -Djava.library.path="sigar 폴더 위치 lib 까지"
 */
public class SigarInfo {
    public static void main(String[] args) {
        Sigar sigar = new Sigar();

    }
}
