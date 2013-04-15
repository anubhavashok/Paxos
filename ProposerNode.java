public class Proposer extends Node
{
    private int propNum;                
    private int numberOfTimesProposed=0;
    private Object message;                                     //CHANGE OBJECT TYPE
    private ArrayList<Proposal> promises;
    
    Proposer(Node n)
    {
        this.id = n.getId();
        propNum= 0;
        numberOfTimesProposed=0;
    }
    
    public void generateNewPropNum()
    {
        propNum=getId()+numberOfTimesProposed*Init.totalNodes;
        numberOfTimesProposed++ 
    }
    public int getPropNum()
    {
        return propNum;
    }
    public ArrayList<Proposal> getPromises()
    {
        return promises;
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
    public void acceptRequest()
    {
        Proposal highest= promises.get(0);

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
    public void receiveAccept()
    {
        //receive p
        if(p.getPropNum()==-1)
        {
            //send new Proposal
        }
        else if(p.getPropNum()==-2)
        {
            //Proposal Accepted
        }
    }
}
