import java.util.ArrayList;
import java.lang.*;
import java.io.*;
import java.net.*;
public class Node
{
	
	protected int id;					//Node ID
	private FailureDetector fd = new FailureDetector();	//Failure Detector
	protected Socket cSocket;				//Client TCP socket
	protected OutputStream os;
	protected ObjectOutputStream oos;			//Client Output
	protected ServerSocket ss;
	protected Socket sSocket;
	protected InputStream is;
	protected ObjectInputStream ois;
	

	
	Node(int id)					// Initialize node id and update node count
	{
		this.id= id;
		//Init.nodeCount++;		//POSSIBLE ERROR WHEN SETTING THE PROPOSER HANDLER
		startServer();
		startClient();
	}
	~Node()
	{
		closeServer();
		closeClient();
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
			cSocket= new Socket("localhost",1234);	//TCP socket
			os=cSocket.getOutputStream();
			oos = new ObjectOutputStream(os);
		}
		catch(Exception e)
		{
			System.out.println("client fault");
		}
	}
}
