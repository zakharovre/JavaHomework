package homework14;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {

        try (ServerSocket server = new ServerSocket(5555)) {
            System.out.println("Waiting for connection...");
            Socket serverSocket = server.accept();
            System.out.println("Client has been connected. Type '/end' to stop connection.");
            DataInputStream in = new DataInputStream(serverSocket.getInputStream());
            DataOutputStream out = new DataOutputStream(serverSocket.getOutputStream());
            Thread thread1 = new Thread(() -> {
                while (true){
                    try {
                        System.out.println("Client: " + in.readUTF());
                    } catch (IOException e) {
                        System.exit(0);
                    }
                }
            });
            thread1.setDaemon(true);
            thread1.start();
            while (true){
                Scanner scanner = new Scanner(System.in);
                String message = scanner.nextLine();
                if(message.equals("/end"))
                    break;
                out.writeUTF(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

