import java.util.ArrayList;
import java.lang.*;
import java.io.*;
import java.net.*;
public class Node
{
	
	protected int id;					//Node ID
	private FailureDetector fd = new FailureDetector();	//Failure Detector
	protected Server s;
	protected Client c;
	

	
	Node(int id)					// Initialize node id and update node count
	{
		this.id= id;
		//Init.nodeCount++;		//POSSIBLE ERROR WHEN SETTING THE PROPOSER HANDLER
	}
	public ArrayList<Node> getCorrectNodes()
	{
		return fd.getCorrectNodes();
	}
	public void sendProposal(Proposal p, int destId)
	{
		ArrayList<Node> nList = getCorrectNodes();
		for(Node n : nList)
		{
			if(n.getId()==destId)
			{
				c.send(p,n.getInetAddress(),Init.port+id);	
			}
			
		}
		
	}
	public int getId()			//Id accessor
	{
		return id;
	}
	public ServerSocket getServerSocket()			//Id accessor
	{
		return sSocket;
	}
	public void startServer()
	{
		try
		{
			ss=new ServerSocket(1234+id);
			sSocket=ss.accept();
			is =sSocket.getInputStream();
			ois = new ObjectInputStream(is);
		}
		catch(Exception e)
		{
			System.out.println("server fault");
		}
	}
	public void closeServer()
	{
		is.close();
		sSocket.close();
		ss.close();
	}
	public void closeClient()
	{
		oos.close();
		os.close();
		cSocket.close();
	}
	public void startClient()
	{
		try
		{
			cSocket= new Socket("localhost",1234+id);	//TCP socket
			os=cSocket.getOutputStream();
			oos = new ObjectOutputStream(os);
		}
		catch(Exception e)
		{
			System.out.println("client fault");
		}
	}
	public InetAddress getInetAddress()
	{
		return s.getInetAddress();
	}
}
