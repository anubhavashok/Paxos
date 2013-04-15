public class Node
{
	
	protected int id;				//Node ID
	private FailureDetector fd = new FailureDetector();

	
	Node()					// Initialize node id and update node count
	{
		this.id= Init.nodeCount;
		Init.nodeCount++;
	}
	public ArrayList<Nodes> getCorrectNodes()
	{
		return fd.getCorrectNodes();
	}
	public sendProposal(Proposal p, int destId)
	{
		// send p to node with id= destId
	}
	public int getId()			//Id accessor
	{
		return id;
	}
}
