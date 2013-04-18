import java.lang.*;
import java.io.*;
import java.net.*;
import java.util.*;
class Server
{
  public static int n=0;
  public static ArrayList<Proposal> receiveAll() throws IOException
  {
    for(int i=0;i<Init.totalNodes;i++)
    {
      Proposal p = receiveProposal();
      receivedList.add(p);
    }
    return receivedList;
  }
  public static Proposal receiveProposal() throws IOException
  {
    ServerSocket ss= new ServerSocket(1234+n);
    //System.out.println(n);
    ss.setReuseAddress(true);
    ss.setSoTimeout(2000);
    n++;
    try{
    Socket s = ss.accept();
    s.setReuseAddress(true);
    s.setSoTimeout(2000);
    System.out.println(s.getSoTimeout() );
    System.out.println(s.getReuseAddress() );
    InputStream is = s.getInputStream();
    ObjectInputStream ois = new ObjectInputStream(is);
    Proposal prop=null;
    
    prop=(Proposal)ois.readObject();
    is.close();
    s.close();
    ss.close();
    
    return prop;
    }
    
    catch(Exception e)
    {
    System.out.println(e.getLocalizedMessage());
    return null;
    }
  }
}
