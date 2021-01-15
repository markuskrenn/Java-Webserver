package Webserver;

import java.io.IOException;
import java.net.Socket;

public class ServerWorker extends Thread {
    private final Socket socket;

    public ServerWorker(Socket s) {
        socket = s;
    }

    @Override
    public void run() {
        try {

            System.err.printf("Client connected from port %d\n", socket.getPort());

            Request  request = new Request(socket.getInputStream());
            Response response = new Response();
            response.sendTextfile(socket.getOutputStream(), request.getPath());

            socket.close();
            System.out.printf("Closed port %d\n", socket.getPort());

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
