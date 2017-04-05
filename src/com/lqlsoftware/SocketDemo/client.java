package com.lqlsoftware.SocketDemo;

import java.io.IOException;
import java.net.InetAddress;

import com.lqlsoftware.SocketUtil.Client;
import com.lqlsoftware.SocketUtil.Server;

public class client {
    public static void main(String[] args) throws IOException {
        // 客户端向服务器发送请求
        Client client = new Client(InetAddress.getLocalHost(), 5556);
        // 密钥验证
        client.println("123456");
        // 发送消息
        client.println("连接成功");
        // 接收消息
        System.out.println(client.readLine());
        
        // 关闭连接
        client.close();
    }
}
