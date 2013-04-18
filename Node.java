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
	public ArrayList<Proposal> receiveProposals()
	{
		return s.receiveAll();
	}
	public int getId()			//Id accessor
	{
		return id;
	}

	public InetAddress getInetAddress()
	{
		return s.getInetAddress();
	}
}
