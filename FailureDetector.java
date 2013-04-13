public class FailureDetector
{

  private ArrayList correctNodes=Init.getNodesList();       //List of correct nodes in system

  public bool isAlive(Node p)                               //Checks if a particular node is correct
  {
    //ping and check for timeout
  }


  public  ArrayList getCorrectNodes(ArrayList correctNodes) //Get ArrayList of correct Nodes
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
