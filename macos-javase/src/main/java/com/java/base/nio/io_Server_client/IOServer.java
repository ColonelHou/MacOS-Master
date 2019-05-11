package com.java.base.nio.io_Server_client;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by colonelhou on 2019/4/22.
 */
public class IOServer {
    public static void main(String[] args) {
        try {
            // TODO 服务端处理客户端连接请求
            ServerSocket serverSocket = new ServerSocket(3333);

            // 接收到客户端连接请求之后为每个客户端创建一个新的线程进行链路处理
            new Thread(() -> {

                while (true) {
                    try {
                        // 阻塞方法获取新的连接
                        Socket socket = serverSocket.accept();
                        new Thread(() -> {
                            int len;
                            byte []data = new byte[1024];
                            try {
                                InputStream inputStream = socket.getInputStream();
                                while ((len = inputStream.read(data)) != -1) {
                                    System.out.println(new String(data, 0, len));
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }).start();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
