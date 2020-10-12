package homework14;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try (Socket clientSocket = new Socket("127.0.0.1", 5555)) {
            System.out.println("Connection success. Type '/end' to stop connection.");
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
            DataInputStream in = new DataInputStream(clientSocket.getInputStream());
            Thread thread1 = new Thread(() -> {
                while (true) {
                    try {
                        System.out.println("Server: " + in.readUTF());
                    } catch (IOException e) {
                        System.exit(0);
                    }
                }
            });
            thread1.setDaemon(true);
            thread1.start();
            while(true){
                Scanner scanner = new Scanner(System.in);
                String message = scanner.nextLine();
                if(message.equals("/end"))
                    break;
                out.writeUTF(message);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

