package com.lqlsoftware.SocketDemo;

import java.io.IOException;
import java.net.InetAddress;

import com.lqlsoftware.SocketUtil.Client;
import com.lqlsoftware.SocketUtil.Server;

public class client {
    public static void main(String[] args) throws IOException {
        // �ͻ������������������
        Client client = new Client(InetAddress.getLocalHost(), 5556);
        // ������Ϣ
        client.println("123456");
        client.println("fuck");
        // ������Ϣ
        System.out.println(client.readLine());
        
        // �ر�����
        client.close();
    }
}
