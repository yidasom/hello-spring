package hello.hellospring.websocket.server;

import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

@Log4j2
public class ServerWebSocket {
    static ServerSocket serverSocket;

    public static void main(String[] args) throws IOException {
        serverSocket = new ServerSocket(8080);
        log.info("서버 연결");
        while (true) {
            new ClientHandler(serverSocket.accept()).start();
        }
    }

    private static class ClientHandler extends Thread {
        private Socket clientSocket;

        public ClientHandler(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            try {
                log.info("client 연결");
                // 클라이언트에서 메지시 받음
            } catch (Exception e) {
                log.info("client 끊김");
                e.printStackTrace();
            }
        }
    }
}
