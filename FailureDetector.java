public class failureDetector
{

  private ArrayList correctNodes=initNodes;

  public bool isAlive(Node p)
  {
    //ping and check for timeout
  }


  public  ArrayList correctNodes(ArrayList correctNodes)
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
