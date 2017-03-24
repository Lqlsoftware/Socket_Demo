package com.lqlsoftware.SocketUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;
/*
 *  socket监听进程
 */
class ListeningThread extends Thread {
    private Server Server;
    private ServerSocket serverSocket;
    private Vector<ConnectionThread> connThreads;
    private boolean isRunning;

    public ListeningThread(Server Server, ServerSocket serverSocket) {
        this.Server = Server;
        this.serverSocket = serverSocket;
        this.connThreads = new Vector<ConnectionThread>();
        isRunning = true;
    }

    @Override
    public void run() {
        while(isRunning) {
            if (serverSocket.isClosed()) {
                isRunning = false;
                break;
            }
            
            try {
                Socket socket;
                socket = serverSocket.accept();
                BufferedReader reader;
                try {
                    reader = new BufferedReader(new InputStreamReader(
                                                socket.getInputStream()));
                    String message = reader.readLine();
                    // 身份验证
                    if (!message.equals("123456"))
                        socket.close();
                    else {
                        ConnectionThread conn = new ConnectionThread(socket, Server);
                        connThreads.addElement(conn);
                        conn.start();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    
    public void stopRunning() {
        for (int i = 0; i < connThreads.size(); i++)
            connThreads.elementAt(i).stopRunning();
        isRunning = false;
    }
} 