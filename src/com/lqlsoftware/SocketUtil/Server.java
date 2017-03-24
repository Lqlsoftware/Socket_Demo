package com.lqlsoftware.SocketUtil;

import java.io.IOException;
import java.net.ServerSocket;
/*
 *  �������˷�װ��
 */
public class Server {
	    private ServerSocket serverSocket;
	    private ListeningThread listeningThread;
	    private MessageHandler messageHandler;
	    /*
	     *  ���캯��
	     *  ����socket����
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
	     *  �������ر�����
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
