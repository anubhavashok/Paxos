public class AcceptorNode extends Node
{
  private ArrayList<Proposal> receivedPrepares;
  private ArrayList<Proposal> acceptedProposals;
  private Proposal highestPrepareReceived;
  private Proposal highestAcceptRequestReceived;
  private ArrayList<Proposal> receivedAcceptRequests;
  
  Acceptor(Node n)
  {
    this.id = n.getId();
  }
  
  public void receivePrepare()
  {
    Proposal p = ;              // receive proposal
    receivedPrepares.add(p);
  }
  public generateHighestPrepareReceived()
  {
    Proposal currentHighest=Init.initProp;
    for(Proposal p: receivedPrepares)
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
    Proposal currentHighest=Init.initProp;
    for(Proposal p: receivedAcceptRequests)
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
    for(Proposal p : receivedPrepares)
    {
      if(p.getPropNum()>= highestPrepareReceived.getPropNum())
      {
        sendProposal(highestPrepareReceived,p.getSenderId());
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
    receivedAcceptRequests.add(p);
  }
  public void sendAccept()
  {
    generateHighestAcceptRequestReceived();
    for(Proposal p: receivedAcceptRequests)
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
