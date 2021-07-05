package javaio.socket1;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * 项目名：    leetcode
 * 包名：      javaio.socket1
 * 文件名：    client
 * 创建时间:   2020-04-18-16:25
 *
 * @author zhangsiqi
 * 描述：
 */

public class client {

    public static void main(String[] args) {
        final String QUIT = "quit";
        final String DEFAULT_SERVER_HOST = "127.0.0.1";
        final int DEFAULT_SERVER_PORT = 8888;
        Socket socket = null;
        BufferedWriter writer = null;

        try {
            // 创建socket
            socket = new Socket(DEFAULT_SERVER_HOST, DEFAULT_SERVER_PORT);
            //创建IO流
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            // 等待用户输入信息
            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Say something:");
            String input = null;
            while ((input = consoleReader.readLine()) != null) {
                // 发送消息到服务器
                writer.write(input + "\n");
                writer.flush();
                String msg = reader.readLine();
                System.out.println(msg);
                if (QUIT.equals(input)) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                    System.out.println("关闭客户端Socket");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
