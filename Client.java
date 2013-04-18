import java.lang.*;
import java.io.*;
import java.net.*;
import java.util.*;
class Client
{
  public static void send(Proposal p, InetAddress i, int port)
  {
      try{
          Socket skt = new Socket(i,port);
          OutputStream os = skt.getOutputStream();
          ObjectOutputStream oos = new ObjectOutputStream(os);
          oos.writeObject(p);
          oos.close();
          os.close();
          skt.close();
      }
      catch(Exception e)
      {
      }
  }
}
