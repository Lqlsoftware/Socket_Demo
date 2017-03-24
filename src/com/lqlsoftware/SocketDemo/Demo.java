package com.lqlsoftware.SocketDemo;

import java.io.IOException;
import java.net.InetAddress;

import com.lqlsoftware.SocketUtil.Client;
import com.lqlsoftware.SocketUtil.Server;

public class Demo {
    public static void main(String[] args) throws IOException {
    	//	启用socket连接 端口号和MessageHandler
    	Server server = new Server(5556, new Handler());
        System.out.println("服务器启动了");
        
        // 等待服务器启动 
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
      /*  // 客户端向服务器发送请求
        Client client = new Client(InetAddress.getLocalHost(), 5556);
        // 发送消息
        client.println("123455");
        client.println("fuck");
        // 接收消息
        System.out.println(client.readLine());
        
        // 关闭连接
        client.close();
        server.close();
        */
    }
}
