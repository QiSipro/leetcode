package javaio.socket1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 项目名：    leetcode
 * 包名：      javaio.socket1
 * 文件名：    Server
 * 创建时间:   2020-04-18-16:09
 *
 * @author zhangsiqi
 * 描述：V1 版本服务器端
 */

public class Server {
    public static void main(String[] args) {
        final String QUIT = "quit";
        final int DEFAULT_PORT = 8888;
        ServerSocket serverSocket = null;

        try {
            // 绑定监听端口, 默认本地IP地址
            serverSocket = new ServerSocket(DEFAULT_PORT);
            System.out.println("启动服务器，鉴定端口：" + DEFAULT_PORT);
            while (true) {
                // 监听客户端连接
                Socket socket = serverSocket.accept();
                System.out.println("客户端[" + socket.getPort() + "]已连接");
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(socket.getOutputStream()));
                // 读取客户端发送的消息
                String msg = null;
                while ((msg = reader.readLine()) != null) {
                    System.out.println("客户端[" + socket.getPort() + "]:" + msg);
                    // 回复客户端发送的消息
                    writer.write("服务器: " + msg + "\n");
                    writer.flush();
                    if (QUIT.equals(msg)) {
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (serverSocket != null) {
                    serverSocket.close();
                    System.out.println("关闭服务器ServerSocket");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
