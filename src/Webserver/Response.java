package Webserver;

import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import Raspberry.Raspberry;

public class Response {
    private Raspberry rb = new Raspberry();

    public void sendTextfile(OutputStream outputStream, String path) {
        switch (path) {
            case "/up": {
                rb.forward();
                sendSuccess(outputStream);
                break;
            }
            case "/left": {
                rb.left();
                sendSuccess(outputStream);
                break;
            }
            case "/down": {
                rb.back();
                sendSuccess(outputStream);
                break;
            }
            case "/right": {
                rb.right();
                sendSuccess(outputStream);
                break;
            }
            case "/stop": {
                rb.stop();
                sendSuccess(outputStream);
                break;
            }
            default: {
                try {
                    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));
                    String fileContent = Files.readString(Path.of(String.format("res%s", path)));
                    bw.write("HTTP/1.0 200 OK\n");
                    bw.write("Content-Type: text/html\n");
                    bw.write(String.format("Content-Length: %d\n", fileContent.length()));
                    bw.write("\n");
                    bw.write(fileContent);
                    bw.flush();
                    bw.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        }
    }

    private void sendSuccess(OutputStream outputStream) {
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));
            bw.write("HTTP/1.0 200 OK\n");
            bw.write("Content-Type: text/html\n");
            bw.write("Content-Length: 0\n");
            bw.write("\n");
            bw.flush();
            bw.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
