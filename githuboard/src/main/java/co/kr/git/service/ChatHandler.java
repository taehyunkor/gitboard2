package co.kr.git.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;


@Component
public class ChatHandler extends TextWebSocketHandler {
   private static List<WebSocketSession> users = new ArrayList<WebSocketSession>();
   
   @Override
	public void afterConnectionEstablished(WebSocketSession session) 
			throws Exception {
	   users.add(session);
		System.out.printf("%s 연결 됨\n", session.getId());
	}
   @Override
	protected void handleTextMessage(
			WebSocketSession session, TextMessage message) throws Exception {
		for(WebSocketSession s :users) {
			s.sendMessage(new TextMessage(message.getPayload()));
		}
	   
	   System.out.printf("%s로부터 [%s] 받음\n", 
				session.getId(), message.getPayload());
		
	}

	@Override
	public void afterConnectionClosed(
			WebSocketSession session, CloseStatus status) throws Exception {
		users.remove(session);
		
		System.out.printf("%s 연결 끊김\n", session.getId());
	}

	
}
