public class AcceptorNodeHandler
{
  public void run(Node n)
  {
    AcceptorNode p = new AcceptorNode(n); //node takes on proposal role
    //--------------------------------------------------------------------//
    p.receivePrepare();                           //receive prepares
    p.generateHighestPrepareReceived();           //identify prepare with highest propNum
    p.sendPromise();                              //send promise to the nodes with propNum higher than previous
    p.receiveAcceptRequest();                     //get all accept requests
    p.sendAccept();                               //send accept to the proposal > highest accept request
  }
}
