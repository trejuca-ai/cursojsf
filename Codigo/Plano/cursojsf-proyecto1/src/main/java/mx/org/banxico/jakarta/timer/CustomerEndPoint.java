package mx.org.banxico.jakarta.timer;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import jakarta.websocket.OnClose;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;

@ServerEndpoint("/customersocket")
public class CustomerEndPoint {

	private static final Set<Session> sessions = new CopyOnWriteArraySet<Session>();
	
	@OnOpen
	public void onOpen(Session session) {
		sessions.add(session);
		System.out.println("ID de session del cliente: " + session.getId());
	}
	
	@OnClose
	public void onClose(Session session) {
		sessions.remove(session);
	}
	
	@OnMessage
	public void onMessage(Session session, String mensaje) {
		System.out.println("mensaje enviado al cliente con id: " + session.getId());
	}
	
	public static void sendMessage(String mensaje) {
		
		for(Session session : sessions) {
			System.out.println("Hay sesiones abiertas");
			if (session.isOpen()) {
				System.out.println("se envia mensaje");
				session.getAsyncRemote().sendText(mensaje);
			}
		}
	}
}
