package javaio.biochatroom.server;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 项目名：    leetcode
 * 包名：      javaio.biochatroot.server
 * 文件名：    ChatServer
 * 创建时间:   2020-04-19-12:16
 *
 * @author zhangsiqi
 * 描述：
 */

public class ChatServer {
    private final String QUIT = "quit";
    private final int DEFAULT_PORT = 8888;
    private ServerSocket serverSocket = null;
    // key=port,value=outPutStream
    private Map<Integer, Writer> connetedClients;
    private ExecutorService service = null;

    public ChatServer() {
        // 解决并发
        connetedClients = new ConcurrentHashMap<>();
        service = Executors.newFixedThreadPool(10);
    }

    public void addClient(Socket socket) throws IOException {
        if (socket != null) {
            Integer port = socket.getPort();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            connetedClients.put(port, writer);
            System.out.println("客户端[" + port + "]已连接到服务器");
        }
    }

    public void removeClient(Socket socket) throws IOException {
        if (socket != null) {
            Integer port = socket.getPort();
            if (connetedClients.containsKey(port)) {
                // 调用writer.close
                connetedClients.get(port).close();
            }
            connetedClients.remove(port);
            System.out.println("客户端[" + port + "]与服务器断开连接");
        }
    }

    public void forwardMessage(Socket socket, String fwdMsg) throws IOException {
        for (Integer id : connetedClients.keySet()) {
            if (!id.equals(socket.getPort())) {
                Writer writer = connetedClients.get(id);
                writer.write(fwdMsg);
                writer.flush();
            }
        }
    }

    public void close() {
        if (serverSocket != null) {
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean quit(String msg) {
        return QUIT.equals(msg);
    }

    public void start() {
        try {
            // 绑定监听端口
            serverSocket = new ServerSocket(DEFAULT_PORT);
            System.out.println("启动服务器,监听端口: " + DEFAULT_PORT);

            while (true) {
                // 等待客户端连接
                Socket socket = serverSocket.accept();
                // 存储新上线用户
                addClient(socket);
                // 为每一个连接过来的client创建一个监听线程
                service.execute(new ChatHandler(this, socket));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭服务器
            close();
            System.out.println("关闭server Socket");
        }
    }

    public static void main(String[] args) {
        ChatServer chatServer = new ChatServer();
        chatServer.start();
    }
}
