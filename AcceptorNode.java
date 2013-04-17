import java.util.ArrayList;
public class AcceptorNode extends Node
{
  private ArrayList<Proposal> receivedPrepares;
  private ArrayList<Proposal> acceptedProposals;
  private Proposal highestPrepareReceived;
  private Proposal highestAcceptRequestReceived;
  private ArrayList<Proposal> receivedAcceptRequests;
  
  AcceptorNode(Node n)
  {
    super(n.getId());
  }
  
  public void receivePrepare()
  {
    Proposal p = null;              // receive proposal
    receivedPrepares.add(p);
  }
  public void generateHighestPrepareReceived()
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
  public void generateHighestAcceptRequestReceived()
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
  public void sendPromise()
  {
    generateHighestPrepareReceived();
    highestPrepareReceived.setTag(Init.promiseTag);
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
    Proposal p = null;              // receive proposal
    receivedAcceptRequests.add(p);
  }
  public void sendAccept()
  {
    generateHighestAcceptRequestReceived();
    highestAcceptRequestReceived.setTag(Init.acceptTag);
    for(Proposal p: receivedAcceptRequests)
    {
      if(p.getPropNum()<highestAcceptRequestReceived.getPropNum())
      {
        sendProposal(Init.NACK, p.getSenderId());
      }
      else 
      {
        acceptedProposals.add(p);
        sendProposal(Init.ACK, p.getSenderId());
      }
    }
  }
}
