package hello.hellospring.websocket.server;

import com.sun.management.OperatingSystemMXBean;
import hello.hellospring.websocket.service.CpuInfo;
import hello.hellospring.websocket.service.DiskInfo;
import hello.hellospring.websocket.service.HeapMemory;
import hello.hellospring.websocket.service.RamMemory;

import java.io.File;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.util.ArrayList;
import java.util.List;

/**
 * ServerWebSocketInfo
 * @date 2022-02-07
 * @author miz-yi
 *
 * lib를 사용하지 않고 java에서 가지고 올 수 있는 시스템 정보
 */
public class ServerWebSocketInfo {

    static double kb = 1024.0;
    static double mb = 1024.0 * 1024.0;
    static double gb = 1024.0 * 1024.0 * 1024;

    /**
     * 자바 힙 메모리
     */
    public HeapMemory memoryInfo(){
        HeapMemory memory = new HeapMemory();

        MemoryMXBean membean = ManagementFactory.getMemoryMXBean();
        memory.setHeap(membean.getHeapMemoryUsage().getUsed()/gb);
        memory.setNonHeap(membean.getNonHeapMemoryUsage().getUsed()/gb);
        return memory;
    }

    /**
     * 램 메모리
     */
    public RamMemory ramInfo() {
        RamMemory memory = new RamMemory();

        OperatingSystemMXBean osbean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        memory.setTotalRam(osbean.getTotalSwapSpaceSize()/gb);
        memory.setFreeRam(osbean.getFreeSwapSpaceSize()/gb);
        return memory;
    }

    /**
     * 디스크 정보
     */
    public List<DiskInfo> diskInfo() {
        List<DiskInfo> list = new ArrayList<>();
        String drive;
        double totalSize, freeSize, useSize;
        File[] roots = File.listRoots();
        DiskInfo info = new DiskInfo();

        for (File root : roots) {
            info = new DiskInfo();
            drive = root.getAbsolutePath();
            totalSize = root.getTotalSpace()/gb;
            useSize = root.getUsableSpace()/gb;
            freeSize = totalSize - useSize;

            info.setDiskName(drive);
            info.setTotalSize(totalSize);
            info.setFreeSize(freeSize);
            list.add(info);
        }
        return list;
    }

    /**
     * cpu 사용량
     */
    public CpuInfo cpuInfo() {
        CpuInfo info = new CpuInfo();
        OperatingSystemMXBean osBean = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);

        info.setUsageCpu(osBean.getSystemLoadAverage());
        info.setTotalCpu((double) osBean.getTotalSwapSpaceSize()/gb);
        info.setFreeCpu((double) osBean.getFreeSwapSpaceSize()/gb);
//        info.setUsageCpu(osBean.getSystemCpuLoad() * 100);
//        info.setTotalCpu((double) osBean.getTotalPhysicalMemorySize()/1024/1024/1024);
//        info.setFreeCpu((double) osBean.getFreePhysicalMemorySize()/1024/1024/1024);
        return info;
    }
}
