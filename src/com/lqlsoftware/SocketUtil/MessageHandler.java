package com.lqlsoftware.SocketUtil;

/*
 * 消息处理接口
 */
public interface MessageHandler {
    public void onReceive(Connection connection, String message);
}
