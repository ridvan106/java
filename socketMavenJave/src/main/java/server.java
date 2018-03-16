import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by oem on 3/16/18.
 */
public class server {
    public  static  void main(String args[]) throws IOException {
        ServerSocket ss = new ServerSocket(8081);
        Socket temp =ss.accept();
        BufferedReader bfr = new BufferedReader(new InputStreamReader(temp.getInputStream()));
        System.out.println(bfr.readLine());
        PrintStream pr = new PrintStream(temp.getOutputStream());
        pr.println("gonderdimlooo");
        System.out.println("gonderdim");
        pr.close();
        bfr.close();
        temp.close();
        ss.close();
    }
}
