package webview;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class UrlConnection {
    public String getWebsiteContent(String urlname) {
        try {
            URL url = new URL(urlname);
            URLConnection connection = url.openConnection();
            connection.connect();
            Map<String, List<String>> headers = connection.getHeaderFields();
            for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
                String key = entry.getKey();
                for (String value : entry.getValue()) {
                    System.out.println(key + ": " + value);
                }
            }
            printHeaderContents(connection);
            return readContent(connection);


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
    public String readContent(URLConnection connection){
        String content = "";
        try(Scanner in = new Scanner(connection.getInputStream(),"UTF-8")) {
            while (in.hasNextLine()){
                content+=in.nextLine();
                content+="\n";
            }
            return content;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public void printHeaderContents(URLConnection connection){
        System.out.println("----------");
        System.out.println("getContentType: " + connection.getContentType());
        System.out.println("getContentLength: " + connection.getContentLength());
        System.out.println("getContentEncoding: " + connection.getContentEncoding());
        System.out.println("getDate: " + connection.getDate());
        System.out.println("getExpiration: " + connection.getExpiration());
        System.out.println("getLastModifed: " + connection.getLastModified());
        System.out.println("----------");
        String encoding = connection.getContentEncoding();
        if (encoding == null) encoding = "UTF-8";
    }
}
