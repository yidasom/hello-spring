package hello.hellospring.websocket.server;

import hello.hellospring.websocket.service.DiskInfo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * (sigar에서 가져온 정보)
 */
public class ServerWebSocketInfo {

    static double kb = 1024.0;
    static double mb = 1024.0 * 1024.0;
    static double gb = 1024.0 * 1024.0 * 1024;

    /**
     * 디스크 정보 (sigar 하기 전에 sample)
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
}
