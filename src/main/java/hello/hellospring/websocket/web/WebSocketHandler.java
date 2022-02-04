package hello.hellospring.websocket.web;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * 웹 소켓 핸들러
 */
@Component
@Log4j2
public class WebSocketHandler extends TextWebSocketHandler {
    private static List<WebSocketSession> list = new ArrayList<>();

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();
        log.info("payload : " + payload);

        for(WebSocketSession sess: list) {
            sess.sendMessage(message);
        }
    }

//    @Override
    public void startClient(WebSocketSession session) throws Exception {
        list.add(session);
        log.info("클라이언트연결성공");
    }

//    @Override
    public void endClient(WebSocketSession session, CloseStatus status) throws Exception {
        log.info("연결 끊기");
        list.remove(session);
    }
}
