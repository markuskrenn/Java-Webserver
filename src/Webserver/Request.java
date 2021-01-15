package Webserver;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Request {
    private String path;
    private Map<String, String> headers;
    private StringBuffer content;
    private Boolean hasContent;

    public Request(InputStream inputStream) {
        headers = new HashMap<>();
        hasContent = false;
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            int state = 0;
            while ( (line = in.readLine()) != null && !line.isEmpty() ) {
                switch (state) {
                    case 0: {
                        String[] splitted = line.split(" ");
                        headers.put("method", splitted[0].toUpperCase());  // 1. line, 1. value is method
                        if (splitted.length == 3) {
                            headers.put("url", splitted[1]);               // 1. line, 2. value is url
                            headers.put("type", splitted[2]);              // 1. line, 3. value is http type

                            // set path:
                            path = headers.get("url").equals("/") ? "/index.html" : headers.get("url");
                        }
                        state++;
                        break;
                    }
                    case 1: {   // headers.
                        String[] splitted = line.split(": ");
                        if (splitted.length == 2) {     // save all key value pairs in headers.
                            headers.put(splitted[0].toLowerCase(), splitted[1]);
                        }
                        break;
                    }
                }
            }
            // read content if content-length > 0 in headers!
            if( headers.containsKey("content-length") ) {
                int length = Integer.parseInt(headers.get("content-length"));
                if (length > 0) {
                    char[] readText = new char[length];
                    int readLength = in.read(readText, 0, length);
                    if (readLength == length) {
                        hasContent = true;
                        content = new StringBuffer();
                        content.append(readText);
                    } else System.err.println("error reading request content!");
                }
            }
        } catch (IOException ex) {
            System.err.printf("Error at Request constructor!\nerror: %s\n", ex);
        }
    }

    public String getPath() {
        return path;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        for(String key : headers.keySet()) {
            sb.append(String.format("%s: %s\n", key, headers.get(key)));
        }
        if (hasContent) {
            sb.append(String.format("\n%s\n", content.toString()));
        }
        return sb.toString();
    }
}
