/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.groud2.web.server;



import jakarta.websocket.OnClose;
import jakarta.websocket.OnError;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;



/**
 *
 * @author anhha
 */
@ServerEndpoint(value = "/chatRoomServer/{room}")
public class ChatRoomServerEndpoint {

	static Set<Session> users = Collections.synchronizedSet(new HashSet<Session>());
         Map<String, String> ip = new HashMap<>();

	@OnOpen
	public void handleOpen(Session session) throws IOException {
		users.add(session);
                
                session.getUserProperties().put("room", getRoomId(session));
	}
	@OnMessage
	public void handleMessage(String message, Session userSession) throws IOException {
		String username = (String) userSession.getUserProperties().get("username");
                ip.put(username, message);
                System.out.println("nawm " +username);
                ip.put(username, getRoomId(userSession));
                System.out.println("url " + ip);
		if (username == null) {
			userSession.getUserProperties().put("username", message);
			
		} else {
			for (Session session : users) {
				session.getBasicRemote().sendText( message);
			}
		}
	}

	@OnClose
	public void handleClose(Session session) {
		users.remove(session);
	}

	@OnError
	public void handleError(Throwable t) {
		t.printStackTrace();
	}
        private String getRoomId(Session session) {
        
        String path = session.getRequestURI().getPath();
        return path.substring(path.lastIndexOf('/') + 1);
    
    }


}
