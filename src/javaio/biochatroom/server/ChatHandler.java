package javaio.biochatroom.server;

import java.io.*;
import java.net.Socket;

/**
 * 项目名：    leetcode
 * 包名：      javaio.biochatroot.server
 * 文件名：    ChatHandler
 * 创建时间:   2020-04-19-12:16
 *
 * @author zhangsiqi
 * 描述：
 */

public class ChatHandler implements Runnable {

    private ChatServer server;
    private Socket socket;

    public ChatHandler(ChatServer server, Socket socket) {
        this.server = server;
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String msg = null;
            while ((msg = reader.readLine()) != null) {
                String fwdMsg = "客户端[" + socket.getPort() + "]:" + msg + "\n";
                System.out.print(fwdMsg);
                // 将收到的消息转发给聊天室中在线的其他用户
                server.forwardMessage(socket, fwdMsg);
                // 检查用户是否准备退出
                if (server.quit(msg)) {
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                server.removeClient(socket);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
