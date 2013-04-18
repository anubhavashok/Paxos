public class Paxos
{
  Init initialize=new Init();
  initialize.createInitialNodes(); //create and initialize nodes on same machine but on different threads
  ProposerHandler p; //manage proposer actions for all nodes
  AcceptorHandler a; //manage acceptor actions for all nodes
  p.prepare(); //initiate prepare phase in proposer nodes
  startPrepareTransaction(); //proposers send Prepare and acceptors receive Prepare via TCP CONCURRENTLY
  a.promise(); //initiate promise phase
  startPromiseTransaction(); //acceptors send Promise and proposers receive Promise via TCP CONCURRENTLY
  p.acceptRequest(); //initiate accept request phase
  startAcceptRequestTransaction(); //proposers send Accept Request and acceptors receive Accept Request via TCP CONCURRENTLY
  a.accept(); //initiate accept request phase
  //learner methods and leader election to be implemented
  display(); //final message order displayed
  
}
