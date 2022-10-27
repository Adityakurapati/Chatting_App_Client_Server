import java.net.*;
import java.util.*;
import java.io.*;
class ClientChat {
    static int clientPort=270,serverPort=280;
    static byte buffer[]=new byte[10000],bufferR[]=new byte[5000];

    public static void main(String a[]){// throws SocketException, UnknownHostException, IOException{
     try{
        DatagramSocket con = new DatagramSocket(clientPort);
     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     InetAddress i = InetAddress.getByName("localhost");
     while(true){
        String str = br.readLine();
     buffer = str.getBytes();
     con.send(new DatagramPacket(buffer, str.length(),i,serverPort));
     DatagramPacket p = new DatagramPacket(bufferR,bufferR.length);
     con.receive(p);
     String psw=new String(p.getData(),0,p.getLength());
     if(psw.equalsIgnoreCase("bye")){
        break;
     }
     }


     }catch(Exception e){}
    }
}
