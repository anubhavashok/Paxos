public class AcceptorNode extends Node
{
  private ArrayList<Proposal> receivedProposals;
  private Proposal highestProposalAccepted;
  
  
  public void receivePrepare()
  {
    Proposal p = ;              // receive proposal
    receivedProposals.add(p);
  }
  public generateHighestProposalAccepted()
  {
    Proposal currentHighest;
    for(Proposal p: receivedProposals)
    {
      if(p.getPropNum()>currentHighest.getPropNum())
      {
        currentHighest=p;
      }
    }
    highestProposalAccepted= currentHighest;
  }
}
