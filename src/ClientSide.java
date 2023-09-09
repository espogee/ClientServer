import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientSide {
    //initialize socket and input output stream
    private Socket socket = null;
    private DataInputStream input = null;
    private DataOutputStream out = null;

    //constructor to put ip address and port
    public ClientSide(String address, int port){
        //establish a connection
        try{
            socket = new Socket(address, port);
            System.out.println("Connected");
            //takes input from terminal
            input = new DataInputStream(System.in);
            //sends output to the terminal
            out = new DataOutputStream(socket.getOutputStream());

        }catch (UnknownHostException u){
            System.out.println(u);
        }catch (IOException i){
            System.out.println(i);
        }
        //read from input
        String line = "";
        //keep reading line till "End" is input
        while (!line.equals("End")){
            try{
                line = input.readLine();
                out.writeUTF(line);

            } catch (IOException i) {
                System.out.println(i);
            }
        }
        try{
            input.close();
            out.close();
            socket.close();
        }catch (IOException i){
            System.out.println(i);
        }
    }
    public static void main(String[] args) {
        ClientSide client = new ClientSide("127.0.0.1", 5200);
    }
}
