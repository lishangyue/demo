package test;

import java.io.*;
import java.net.Socket;

public class ChatClient {
    Socket socket = null;

    public ChatClient() throws IOException {
        socket = new Socket("127.0.0.1", 8080);
    }

    // send方式
    public void send(String str) throws IOException {
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        dos.writeUTF(str);
    }

    // 关闭连接
    public void disconnection() throws IOException {
        if (socket != null) {
            socket.close();
        }
    }

    //内部类（多线程方式）
    class ReceiveThread implements Runnable {
        @Override
        public void run() {
            if (socket == null) {
                return;
            }
            try {
                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                String str = dataInputStream.readUTF();
                while (str != null && str.length() != 0) {
                    System.out.println("别人说：" + str);
                    str = dataInputStream.readUTF();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
        ChatClient chatClient = new ChatClient();
        System.out.println("请输入：");
        String str = bReader.readLine();
        while (str != null && str.length() != 0) {
            chatClient.send(str);
            System.out.println("请输入：");
            str = bReader.readLine();
            System.out.println("自己说：" + str);
        }
        chatClient.disconnection();

    }
}
