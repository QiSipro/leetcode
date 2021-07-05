package javaio.biochatroom.client;

import java.io.*;
import java.net.Socket;

/**
 * 项目名：    leetcode
 * 包名：      javaio.biochatroot.client
 * 文件名：    ChatClient
 * 创建时间:   2020-04-19-12:16
 *
 * @author zhangsiqi
 * 描述：
 */

public class ChatClient {

    private final String QUIT = "quit";
    private final String DEFAULT_SERVER_HOST = "127.0.0.1";
    private final int DEFAULT_SERVER_PORT = 8888;

    private Socket socket;
    private BufferedReader reader = null;
    private BufferedWriter writer = null;

    // 发送消息给服务器
    public void send(String msg) throws IOException {
        if (!socket.isOutputShutdown()) {
            writer.write(msg + "\n");
            writer.flush();
        }
    }

    // 从服务器接收消息
    public String receive() throws IOException {
        String msg = null;
        if (!socket.isInputShutdown()) {
            msg = reader.readLine();
        }
        return msg;
    }

    // 检查用户是否准备退出
    public boolean quit(String msg) {
        return QUIT.equals(msg);
    }

    public void close() {
        try {
            if (writer != null) {
                writer.close();
                System.out.println("关闭Socket");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        try {
            // 创建socket对象
            socket = new Socket(DEFAULT_SERVER_HOST, DEFAULT_SERVER_PORT);
            //创建IO流
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            // 创建线程处理用户的输入
            new Thread(new UserInputHandler(this)).start();
            // 读取服务器转发的消息
            String msg = null;
            // 如果在输入线程中发送quit, 将会传输到服务端,调用write.close()
            // msg == null 退出,掉用close() 关闭客户端
            while ((msg = receive()) != null) {
                System.out.println(msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    public static void main(String[] args) {
        ChatClient chatClient = new ChatClient();
        chatClient.start();
    }
}
