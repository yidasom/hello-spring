package hello.hellospring.websocket.web;

import org.springframework.util.StringUtils;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * client web socket
 */
public class ClientWebSocket {

    static Socket socket;
    static String host="192.168.219.116";
    static int port=8888;
    static String key="ABC";
    static Thread sendThread;

    public static void main(String[] args) throws UnknownHostException, IOException {
        // host, port
        socket = new Socket(host, port);
        if (socket.isConnected()) {
            System.out.println("success!");
            if (StringUtils.hasText(key)) {
                sendMessage(key, socket.isConnected());
            }
        } else {
            System.out.println("fail!");
        }
    }

    /**
     * 메시지 전송
     */
    public static void sendMessage(String key, Boolean status) {
        if (status) {
            sendThread = new Thread(new Runnable() {
                @Override
                public void run() {

                }
            });
//            OutputStream outputStream = socket.getOutputStream();
//            PrintWriter writer = new PrintWriter(outputStream, true);
//
//            writer.println();

        }
    }
}
