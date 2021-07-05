package javaio.biochatroom.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 项目名：    leetcode
 * 包名：      javaio.biochatroot.client
 * 文件名：    UserInputHandler
 * 创建时间:   2020-04-19-12:17
 *
 * @author zhangsiqi
 * 描述：
 */

public class UserInputHandler implements Runnable {

    private ChatClient chatClient;

    public UserInputHandler(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @Override
    public void run() {
        try {
            //等待用户输入消息
            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                String input = consoleReader.readLine();
                // 向服务器发送
                chatClient.send(input);
                if (chatClient.quit(input)) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
