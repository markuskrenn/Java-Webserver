package Webserver;

import java.io.InputStream;

public class Request {
    private String path;

    public Request(InputStream inputStream) {}

    public String getPath() {
        return path;
    }
}
