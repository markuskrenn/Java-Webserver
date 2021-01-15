package Webserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Webserver {
    public static void main(String[] args) {
        ArrayList<ServerWorker> clients = new ArrayList<>();

        try ( ServerSocket serverSocket = new ServerSocket(1111); ) {
            System.err.printf("Server started at port %d\n", serverSocket.getLocalPort());

            while (true) {
                Socket clientSocket = serverSocket.accept();        // 1. wait for connection
                ServerWorker sw = new ServerWorker(clientSocket);   // 2. create new worker thread
                sw.start();                                         // 3. start worker thread
                clients.add(sw);                                    // 4. remember worker thread
            }
        } catch(IOException ioException) {
            ioException.printStackTrace();
        } finally {
            for (ServerWorker sw : clients) {
                try {
                    sw.join();
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }
        }
    }
}
