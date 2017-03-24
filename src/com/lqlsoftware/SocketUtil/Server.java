package com.lqlsoftware.SocketUtil;

import java.io.IOException;
import java.net.ServerSocket;
/*
 *  服务器端封装类
 */
public class Server {
	    private ServerSocket serverSocket;
	    private ListeningThread listeningThread;
	    private MessageHandler messageHandler;
	    /*
	     *  构造函数
	     *  开启socket监听
	     */
	    public Server(int port, MessageHandler handler) {
	        messageHandler = handler;
	        try {
	            serverSocket = new ServerSocket(port);
	            listeningThread = new ListeningThread(this, serverSocket);
	            listeningThread.start();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    public void setMessageHandler(MessageHandler handler) {
	        messageHandler = handler;
	    }

	    public MessageHandler getMessageHandler() {
	        return messageHandler;
	    }
	    /*
	     *  方法：关闭连接
	     */
	    @SuppressWarnings("deprecation")
		public void close() {
	        try {
	            if (serverSocket != null && !serverSocket.isClosed()) {
	                listeningThread.stopRunning();
	                listeningThread.suspend();
	                listeningThread.stop();
	                serverSocket.close();
	            }
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	    }
}
