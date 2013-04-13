public class Proposer extends Node
{
    private int propNum;                
    private int numberOfTimesProposed=0;
    private Object message;                                     //CHANGE OBJECT TYPE
    private ArrayList<Proposal> promises;
    public void generateNewPropNum()
    {
        propNum=getId()+numberOfTimesProposed*Init.totalNodes;
        numberOfTimesProposed++ 
    }
    public int getPropNum()
    {
        return propNum;
    }
    public Object getMessage()
    {
        return this.message;
    }
    public void sendToQuorum(Proposal p)
    {   ArrayList<Nodes> correctNodes = getCorrectNodes();
        for(Node n : correctNodes)
        {
            sendProposal(p,n.getId());
        }
        //get list of correct nodes
        //send proposal to all correct nodes
    }
    public void prepare()
    {
        generateNewPropNum();
        Proposal prepareProposal = new Proposal(propNum,message,getId());
        sendToQuorum(prepareProposal);
    }
    public void receivePromises()
    {
        //get all promises
        Proposal p;     //store received proposal in this
        promises.add(p);
    }
    public void generateAcceptProposal()
    {
        Proposal highest;
        if(promises.isEmpty())
        {
            highest = new Proposal(propNum,message,getId());
        }
        for(Proposal p: promises)                   //get proposal with highest propNum
        {
            if(p.getPropNum()>=highest.getPropNum())
            {
                highest=p;
            }
        }
        this.message = highest.getMessage();
        Proposal send= new Proposal(propNum,message,getId());
        sendToQuorum(send);
    }
}
