package com.lqlsoftware.SocketDemo;

import java.io.IOException;
import java.net.InetAddress;

import com.lqlsoftware.SocketUtil.Client;
import com.lqlsoftware.SocketUtil.Server;

public class client {
    public static void main(String[] args) throws IOException {
        // 客户端向服务器发送请求
        Client client = new Client(InetAddress.getLocalHost(), 5556);
        // 发送消息
        client.println("123456");
        client.println("fuck");
        // 接收消息
        System.out.println(client.readLine());
        
        // 关闭连接
        client.close();
    }
}
