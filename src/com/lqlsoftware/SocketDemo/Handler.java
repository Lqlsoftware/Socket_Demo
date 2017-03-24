package com.lqlsoftware.SocketDemo;

import com.lqlsoftware.SocketUtil.Connection;
import com.lqlsoftware.SocketUtil.MessageHandler;

public class Handler implements MessageHandler {
	// 实现接口的抽象方法
	/*
	 * (non-Javadoc)
	 * @see com.lqlsoftware.SocketUtil.MessageHandler#onReceive(com.lqlsoftware.SocketUtil.Connection, java.lang.String)
	 * 
	 *  方法：接收到客户端的消息
	 */
	public void onReceive(Connection connection, String message){
		System.out.println("服务器收到"+message);
		connection.println("这条消息是从服务器发回来的：" + message);
	}
}
