public class AcceptorNode extends Node
{
  private ArrayList<Proposal> receivedProposals;
  private ArrayList<Proposal> acceptedProposals;
  private Proposal highestProposalReceived;
  private Proposal highestProposalAccepted;
  private ArrayList<Proposal> acceptRequestProposals;
  
  Acceptor(Node n)
  {
    this.id = n.getId();
  }
  
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
      if(p.getPropNum()>= highestProposalReceived.getPropNum())
      {
        sendProposal(highestProposalReceived,p.getSenderId());
      }
      else 
      {
        sendProposal(Init.NACK,p.getSenderId());
      }
    }
  }
  public void receiveAcceptRequest()
  {
    Proposal p = ;              // receive proposal
    acceptRequestProposal.add(p);
  }
  public void sendAccept()
  {
    generateHighestProposalReceived();
    for(Proposal p: acceptRequestProposal)
    {
      if(p.getPropNum()<highestProposalReceived.getPropNum())
      {
        sendProposal(Init.NACK, p.getSenderId())
      }
      else 
      {
        acceptedProposals.add(p);
        sendProposal(Init.ACK, p.getSenderId());
      }
    }
  }
}
