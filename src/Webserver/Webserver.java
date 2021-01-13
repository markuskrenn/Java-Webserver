package Webserver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;

public class Webserver {
    public static void main(String[] args) {
        int port = 1111;

        try (
            ServerSocket serverSocket = new ServerSocket(port);
        ) {
            System.err.printf("Server started on port : %d\n", port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.err.printf("Client connected from port %d\n", clientSocket.getPort());

                try (
                    BufferedReader in  = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
                ) {
                    String s;
                    while ((s = in.readLine()) != null) {
                        System.out.println(s);
                        if (s.isEmpty()) {
                            break;
                        }
                    }

                    String message = Files.readString(Path.of("res/index.html"));

                    out.write("HTTP/1.0 200 OK\n");
                    out.write("Content-Type: text/html\n");
                    out.write(String.format("Content-Length: %d\n", message.length()));
                    out.write("\n");
                    out.write(message);
                }
                clientSocket.close();
                System.err.println("Connection closed!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
