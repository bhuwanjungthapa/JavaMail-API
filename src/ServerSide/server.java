package ServerSide;

import java.io.*;
import java.net.*;

public class server {
    private Socket socket = null;
    private ServerSocket server = null;
    private DataInputStream in = null;

    ///constructor with port
    public server(int port){
        try{
            server = new ServerSocket(port);
            System.out.println("Server started");

            System.out.println("Waiting or a client......");
            socket = server.accept();
            System.out.println("Client accepted");

            in = new DataInputStream(
                    new BufferedInputStream(socket.getInputStream()));
            String line = "";

            while (!line.equals("Over")){
                try{
                    line = in.readUTF();
                    System.out.println(line);
                }
            catch(IOException i){
                System.out.println(i);
            }
            }
        System.out.println("Closing  Connection");
        socket.close();
        in.close();

    }
    catch (IOException i){
        System.out.println(i);
        }

}
public static void main(String[] args){
    server server = new server(5010);
    }
}

