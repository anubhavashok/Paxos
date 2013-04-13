public class Proposal
{
  private int propNum;
  private Object message;
  private int senderId;
  
  Proposal(int propNum, Object message, int senderId)
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
  public int getSender()
  {
    return senderId;
  }
}
