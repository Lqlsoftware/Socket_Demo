package com.lqlsoftware.SocketUtil;

/*
 * ��Ϣ������ӿ� 
 */
public interface MessageHandler {
    public void onReceive(Connection connection, String message);
}