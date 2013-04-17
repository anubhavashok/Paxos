import java.util.ArrayList;
import java.lang.*;
import java.io.*;
import java.net.*;
public class Node
{
	
	protected int id;					//Node ID
	private FailureDetector fd = new FailureDetector();	//Failure Detector
	protected Socket cSocket;				//Client TCP socket
	protected ObjectOutputStream oos;			//Client Output
	protected ServerSocket ss;
	protected Socket sSocket;
	protected ObjectInputStream ois;
	

	
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
		// send p to node with id= destId
	}
	public int getId()			//Id accessor
	{
		return id;
	}
	public void startServer()
	{
		try
		{
			ss=new ServerSocket(1234);
			sSocket=ss.accept();
			ois = new ObjectInputStream(s.getInputStream());
		}
		catch(Exception e)
		{
			System.out.println("server fault");
		}
	}
	public void startClient()
	{
		try
		{
			cSocket= new Socket("localhost",1234);	//TCP socket
			oos = new ObjectOutputStream(cSocket.getOutputStream());
		}
		catch(Exception e)
		{
			System.out.println("client fault");
		}
	}
}
