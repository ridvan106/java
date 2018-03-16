import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;
import java.util.Scanner;

/**
 * Created by oem on 3/16/18.
 */
public class socket {
    public  static  void main(String args[]) throws IOException {
        Socket client = new Socket("127.0.0.1",8081);
        PrintStream dis = new PrintStream(client.getOutputStream());

        dis.println("heelo");
        System.out.print("gonderdim\n");

        BufferedReader sc = new BufferedReader(new InputStreamReader(client.getInputStream()));
        System.out.println(sc.readLine());
        dis.close();
        client.close();


    }

}
