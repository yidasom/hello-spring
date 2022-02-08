package hello.hellospring.websocket.server;

import hello.hellospring.websocket.service.DiskInfo;
import lombok.extern.log4j.Log4j2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

@Log4j2
public class ServerWebSocket {
    private static ServerSocket serverSocket;
    private static final String SERVER_KEY = "ABC";

    public static void main(String[] args) throws IOException {
        serverSocket = new ServerSocket(8080);
        log.info("server connect");
        while (true) {
            new ClientHandler(serverSocket.accept()).start();
        }
    }

    private static class ClientHandler extends Thread {
        private Socket clientSocket;
        private ObjectOutputStream stream;
        private BufferedReader in;

        public ClientHandler(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            try {
                log.info("client connect");
                // 클라이언트에서 메지시 받음
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                String key = in.readLine().trim();
//                String key = "ABC";
                log.info("key : {}", key);
                stream = new ObjectOutputStream(clientSocket.getOutputStream());
                if (SERVER_KEY.equals(key)) {
                    while(true) {
                        log.info("pass : {}", "pass");
                        // 메시지 while문으로 하는 이유 (실시간으로 정보를 가져오기 위해)
//                        DiskInfo diskInfo = new DiskInfo();
                        ServerWebSocketInfo info = new ServerWebSocketInfo();
                        stream.writeObject(info.diskInfo());
                        stream.flush();
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            } catch (Exception e) {
                log.info("client 끊김");
                e.printStackTrace();
            }
        }
    }
}
