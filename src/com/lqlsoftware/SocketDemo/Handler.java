package com.lqlsoftware.SocketDemo;

import com.lqlsoftware.SocketUtil.Connection;
import com.lqlsoftware.SocketUtil.MessageHandler;

public class Handler implements MessageHandler {
	// ʵ�ֽӿڵĳ��󷽷�
	/*
	 * (non-Javadoc)
	 * @see com.lqlsoftware.SocketUtil.MessageHandler#onReceive(com.lqlsoftware.SocketUtil.Connection, java.lang.String)
	 * 
	 *  ���������յ��ͻ��˵���Ϣ
	 */
	public void onReceive(Connection connection, String message){
		System.out.println("�������յ�"+message);
		connection.println("������Ϣ�Ǵӷ������������ģ�" + message);
	}
}
