public class Proposal
{
  private int propNum;
  private Object message;
  private int senderId;
  private int tag;
  
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
  public int getSenderId()
  {
    return senderId;
  }
  public int getTag()
  {
    return tag;
  }
  public void setTag(int n)
  {
    tag =n;
  }
}
