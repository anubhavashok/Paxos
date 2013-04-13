public class Proposer extends Node
{
    private int propNum;                
    private int numberOfTimesProposed=0;
    private Object message;                                     //CHANGE OBJECT TYPE
    public void generateNewPropNum()
    {
        propNum=getId()+numberOfTimesProposed*Init.totalNodes;
        numberOfTimesProposed++ 
    }
    public int getPropNum()
    {
        return propNum;
    }
    public void sendToQuorum(Proposal p)
    {
        //get list of correct nodes
        //send proposal to all correct nodes
    }
    public void prepare()
    {
        generateNewPropNum();
        Proposal prepareProposal = new Proposal(propNum,message);
        sendToQuorum(prepareProposal);
    }
}
