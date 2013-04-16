import java.util.ArrayList;
public class FailureDetector
{

  protected ArrayList<Node> correctNodes= Init.getNodesList();       //List of correct nodes in system

  public boolean isAlive(Node p)                               //Checks if a particular node is correct
  {
    //ping and check for timeout
  return false;
  }


  public  ArrayList<Node> getCorrectNodes() //Get ArrayList of correct Nodes
  {
    for(Node p: correctNodes)
    {
      if(!isAlive(p))
      {
        correctNodes.remove(p);
      }
    }
    return correctNodes;
  }
}
