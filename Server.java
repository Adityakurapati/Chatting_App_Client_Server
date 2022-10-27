import java.net.*;
import java.io.*;

class ServerChat{
    static int clientPort=270,serverPort=280;
    static byte buffer[]=new byte[10000],bufferS[]=new byte[5000];

    public static void main(String s[])throws UnknownHostException,SocketException,IOException{
        DatagramSocket my_Conn = new DatagramSocket(serverPort);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        InetAddress i2 = InetAddress.getByName("localhost");
        while(true){
            DatagramPacket p2 = new DatagramPacket(buffer,buffer.length);
            my_Conn.receive(p2);
            String psw = new String(p2.getData(),0,p2.getLength());
            if(psw.equalsIgnoreCase("End")){
                buffer="Bye".getBytes();
                int len="Bye".length();
                my_Conn.send(new DatagramPacket(buffer,len,i2,clientPort));
            }

            //Send 
            System.out.println("Client : "+psw+"\n");
            System.out.println("Server : ");
            String msg = br.readLine();
            bufferS=msg.getBytes();
            my_Conn.send(new DatagramPacket(bufferS,bufferS.length,i2,clientPort));
        }
    }
}
