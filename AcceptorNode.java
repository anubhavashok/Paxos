public class AcceptorNode extends Node
{
  private ArrayList<Proposal> receivedProposals;
  private ArrayList<Proposal> acceptedProposals;
  private Proposal highestProposalAccepted;
  
  
  public void receivePrepare()
  {
    Proposal p = ;              // receive proposal
    receivedProposals.add(p);
  }
  public generateHighestProposalAccepted()
  {
    Proposal currentHighest;
    for(Proposal p: acceptedProposals)
    {
      if(p.getPropNum()>=currentHighest.getPropNum())
      {
        currentHighest=p;
      }
    }
    highestProposalAccepted= currentHighest;
  }
  public sendPromise()
  {
    generateHighestProposalAccepted();
    for(Proposal p : receivedProposals)
    {
      if(p.getPropNum()> highestProposalAccepted.getPropNum())
      {
        sendProposal(highestProposalAccepted,p.getSender());
      }
    }
  }
}
