import java.util.ArrayList;
public class Init
{
    public static int totalNodes=3;
    public static int nodeCount=0;
    public static int TIMEOUT=10000; 
    public static int FAULTS=2;
    public static Proposal NACK=new Proposal(-1,null,-1);
    public static Proposal ACK=new Proposal(-2,null,-2);
    public static Proposal initProp=new Proposal(-1,null,-1);
    
    public static ArrayList<Node> initNodes;
    
    Init()
    {
        createInitialNodes();
    }
    
    public void createInitialNodes()
    {
        for(int i=0;i<totalNodes;i++)       //create initial nodes
        {
            Node p = new Node(i);
            initNodes.add(p);
        }
    }
    public static ArrayList<Node> getNodesList()
    {
        return initNodes;
    }
    public boolean isMajority(int n)
    {
        if(n>=((double)totalNodes/2 +1))
        {
            return true;
        }
        else return false;
    }
    
}
