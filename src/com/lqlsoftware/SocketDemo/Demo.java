package com.lqlsoftware.SocketDemo;

import java.io.IOException;
import java.net.InetAddress;

import com.lqlsoftware.SocketUtil.Client;
import com.lqlsoftware.SocketUtil.Server;

public class Demo {
    public static void main(String[] args) throws IOException {
    	//	����socket���� �˿ںź�MessageHandler
    	Server server = new Server(5556, new Handler());
        System.out.println("������������");
        
        // �ȴ����������� 
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
      /*  // �ͻ������������������
        Client client = new Client(InetAddress.getLocalHost(), 5556);
        // ������Ϣ
        client.println("123455");
        client.println("fuck");
        // ������Ϣ
        System.out.println(client.readLine());
        
        // �ر�����
        client.close();
        server.close();
        */
    }
}
