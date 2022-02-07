package hello.hellospring.websocket.service;

import org.hyperic.sigar.CpuPerc;
import org.hyperic.sigar.Mem;
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
    // sigar 객체 생성
    private static Sigar sigar = new Sigar();
    private static Mem mem = null;

    // 단위 수정
    static double kb = 1024.0;
    static double mb = 1024.0 * 1024.0;
    static double gb = 1024.0 * 1024.0 * 1024;

    public static void main(String[] args) {
//        CpuPerc cpu = null;
//        CpuPerc[] cpus = null;
//
//        try {
//            cpu = sigar.getCpuPerc();
//            cpus = sigar.getCpuPercList();
//        }
//
//        catch (SigarException e) {
//            System.out.println("Error : " + e);
//        }
//
//        // cpu사용량 출력
//        System.out.println("Total cpu----");
//
//        cpu_output(cpu);
//
//        for (int i = 0; i < cpus.length; i++) {
//            System.out.println("cpu" + i + "----");
//            cpu_output(cpus[i]);
//        }
        memory();
    }

    public static void cpu_output(CpuPerc cpu) {
        System.out.println("Combined Time\t :" + CpuPerc.format(cpu.getCombined())); // 조합된 부하(User + Sys + Nice + Wait)
        System.out.println("Idle Time\t :" + CpuPerc.format(cpu.getSys())); // 총 가용 CPU의 유휴 시간(CPU 부하)
        System.out.println("Irq Time\t :" + CpuPerc.format(cpu.getIrq())); // 총 가용 CPU의 인터럽트 시간(CPU 부하)
        System.out.println("Nice Time\t :" + CpuPerc.format(cpu.getNice())); // 총 가용 CPU의 Nice 시간(CPU 부하)
        System.out.println("Softlrq Time\t :" + CpuPerc.format(cpu.getSoftIrq())); // 총 가용 CPU의 소프트 인터럽트 시간(CPU 부하)
        System.out.println("Stolen Time\t :" + CpuPerc.format(cpu.getStolen())); // 총 가용 CPU의 Stolen 시간(CPU 부하)
        System.out.println("Sys Time\t :" + CpuPerc.format(cpu.getSys())); // 총 가용 CPU의 Sys 시간(CPU 부하)
        System.out.println("User Time\t :" + CpuPerc.format(cpu.getUser())); // 총 가용 CPU의 User 시간(CPU 부하)
        System.out.println("Wait Time\t :" + CpuPerc.format(cpu.getWait())); // 총 가용 CPU의 Wait 시간(CPU 부하)
    }

    public static void memory() {
        System.out.println("================== Memory DATA ====================");
        try {
            mem = sigar.getMem();
            /* KB  > GB 변환 */
            Double actualFree = (double) mem.getActualFree()/gb;
            Double actualUsed = (double) mem.getActualUsed()/gb;
            Double freeCPU = (double) mem.getFree()/gb;
            Double freePercent = (double) mem.getFreePercent()/gb;
            Double ram = (double) mem.getRam()/gb;
            Double totalCPU = (double) mem.getTotal()/gb;
            Double usedCPU = (double) mem.getUsed()/gb;
            Double usedPercent = (double) mem.getUsedPercent()/gb;

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
