public class Proposal
{
  private int propNum;
  private Object message;
  
  Proposal(int propNum, Object message)
  {
    this.propNum=propNum;
    this.message=message;
  }
  public int getPropNum()
  {
    return propNum;
  }
  public Object getMessage()
  {
    return message;
  }
}
