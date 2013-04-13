public class AcceptorNode extends Node
{
  private ArrayList<Proposal> receivedProposals;
  private ArrayList<Proposal> acceptedProposals;
  private Proposal highestProposalReceived;
  
  
  public void receivePrepare()
  {
    Proposal p = ;              // receive proposal
    receivedProposals.add(p);
  }
  public generateHighestProposalReceived()
  {
    Proposal currentHighest;
    for(Proposal p: receivedProposals)
    {
      if(p.getPropNum()>=currentHighest.getPropNum())
      {
        currentHighest=p;
      }
    }
    highestProposalReceived= currentHighest;
  }
  public sendPromise()
  {
    generateHighestProposalReceived();
    for(Proposal p : receivedProposals)
    {
      if(p.getPropNum()> highestProposalReceived.getPropNum())
      {
        sendProposal(highestProposalReceived,p.getSenderId());
      }
      else 
      {
        sendProposal(Init.NACK,p.getSenderId();
      }
    }
  }
}
