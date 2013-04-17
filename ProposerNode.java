import java.util.ArrayList;
public class ProposerNode extends Node
{
    private int propNum;                
    private int numberOfTimesProposed=0;
    private Object message;                                     //CHANGE OBJECT TYPE
    private ArrayList<Proposal> promises;
    private ArrayList<Proposal> ACKs;
    
    ProposerNode(Node n)
    {
    super(n.getId());
        //this.id = n.getId();
        propNum= 0;
        numberOfTimesProposed=0;
    }
    
    public void generateNewPropNum()
    {
        propNum=getId()+numberOfTimesProposed*Init.totalNodes;
        numberOfTimesProposed++ ;
    }
    public int getPropNum()
    {
        return propNum;
    }
    public ArrayList<Proposal> getPromises()
    {
        return promises;
    }
    public ArrayList<Proposal> getACKs()
    {
        return ACKs;
    }
    public Object getMessage()
    {
        return this.message;
    }
    public void sendToQuorum(Proposal p)
    {   ArrayList<Node> correctNodes = getCorrectNodes();
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
        Proposal prepareProposal = new Proposal(propNum,message,getId(),Init.prepareTag);
        sendToQuorum(prepareProposal);
    }
    public void receivePromises()
    {
        //get all promises
        Proposal p=null;     //store received proposal in this
        promises.add(p);

    }
    public void acceptRequest()
    {
        Proposal highest= Init.initProp;

        for(Proposal p: promises)                   //get proposal with highest propNum
        {
            if(p.getPropNum()>=highest.getPropNum())
            {
                highest=p;
            }
        }
        this.message = highest.getMessage();
        Proposal send= new Proposal(propNum,message,getId(),Init.acceptRequestTag);
        sendToQuorum(send);
    }
    public void receiveAccept()
    {
        //receive p
	Proposal p = null;			//CHANGE
        if(p.getPropNum()==-1)                  //NACK
        {
            //send new Proposal
        }
        else if(p.getPropNum()==-2)             //ACK
        {
            ACKs.add(p);
        }
    }
}
