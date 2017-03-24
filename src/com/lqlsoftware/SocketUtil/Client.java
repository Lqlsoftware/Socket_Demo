package com.lqlsoftware.SocketUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
/*
 *  用户端封装类
 */
public class Client {
    private Socket socket;
    /*
     * 构造函数
     * 向目标端口发送socket连接请求
     */
    public Client(InetAddress ip, int port) {
        try {
            socket = new Socket(ip, port);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    /*
     *  方法：向服务器发送数据
     */
    public void println(String message) {
        PrintWriter writer;
        try {
            writer = new PrintWriter(new OutputStreamWriter(
                                     socket.getOutputStream()), true);
            writer.println(message);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    /*
     *  方法：接收服务器数据
     */
    public String readLine() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new InputStreamReader(
                                        socket.getInputStream()));
            return reader.readLine();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "";
        }
    }
    
    /*
     * Ready for use.
     */
    public void close() {
        try {
            if (socket != null && !socket.isClosed())
                socket.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}