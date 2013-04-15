public class AcceptorNode extends Node
{
  private ArrayList<Proposal> receivedProposals;
  private ArrayList<Proposal> acceptedProposals;
  private Proposal highestPrepareReceived;
  private Proposal highestAcceptRequestReceived;
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
  public generateHighestPrepareReceived()
  {
    Proposal currentHighest;
    for(Proposal p: receivedProposals)
    {
      if(p.getPropNum()>=currentHighest.getPropNum())
      {
        currentHighest=p;
      }
    }
    highestPrepareReceived= currentHighest;
  }
  public generateHighestAcceptRequestReceived()
  {
    Proposal currentHighest;
    for(Proposal p: acceptRequestProposals)
    {
      if(p.getPropNum()>=currentHighest.getPropNum())
      {
        currentHighest=p;
      }
    }
    highestAcceptRequestReceived= currentHighest;
  }
  public sendPromise()
  {
    generateHighestPrepareReceived();
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
    generateHighestAcceptRequestReceived();
    for(Proposal p: acceptRequestProposal)
    {
      if(p.getPropNum()<highestAcceptRequestReceived.getPropNum())
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
