public class ProposerNodeHandler
{
  public void run(Node n)
  {
    Proposer p = new Proposer(n);                   //node takes on proposal role
    //--------------------------------------------------------------------//
    p.prepare();                                    //initiate prepare phase
    p.receivePromises();                            //listen for promises - need terminating conditions
    ArrayList<Proposal> promises = p.getPromises(); //get all received promises
    if(Init.isMajority(promises.size()))            //if received a majority of promises
    {
      p.acceptRequest();                            //send accept request to majority set of acceptors
    }
    else  //restart loop
    p.receiveAccept();                                //listen for Accept
    ArrayList<Proposal> ACKs = p.getACKs();           //get all ACKs
    if(Init.isMajority(ACKs.size()))                  //if received a majority of ACKs
    {
      //broadcast decide                               //send Message to all
    }
  }
}
