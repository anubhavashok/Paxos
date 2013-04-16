import java.util.ArrayList;
public class Node
{
	
	protected int id;				//Node ID
	private FailureDetector fd = new FailureDetector();

	
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
}
