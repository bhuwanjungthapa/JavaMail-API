package ClientSide;
import java.net.*;
import java.io.*;

public class client {
    private Socket socket=null;
    private DataInputStream input=null;
    private DataOutputStream out=null;
    public client(String address, int port){
        try{
            socket=new Socket(address,port);
            System.out.println("Connected");
            input=new DataInputStream(System.in);
            out=new DataOutputStream(socket.getOutputStream());
        } catch (UnknownHostException e) {
            System.out.println(e);
        } catch (IOException i) {
            System.out.println(i);
        }
        String line="";
        while(!line.equals("Over")){
            try {
                line = input.readLine();
                out.writeUTF(line);
            } catch (IOException e) {
                System.out.println(e);
            }

        }
        try{
            input.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args){
        client client = new client("127.0.0.1",5010);
    }
}

