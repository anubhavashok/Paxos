public class FailureDetector
{

  private ArrayList correctNodes=Init.getNodesList();

  public bool isAlive(Node p)
  {
    //ping and check for timeout
  }


  public  ArrayList getCorrectNodes(ArrayList correctNodes)
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
