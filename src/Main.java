import java.net.InetAddress;
import java.net.UnknownHostException;

public class Main {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress address = InetAddress.getByName("docs.google.com");
        System.out.println("Inet Address of named host: "+address);
        InetAddress arr[] = InetAddress.getAllByName("www.google.com");
        System.out.println("InetAddress of all named host: ");
        for(int i=0; i< arr.length; i++){
            System.out.println(arr[i]);
        }
    }
}