public class Init
{
    public static totalNodes=3;
    public static nodeCount=0;
    public static TIMEOUT=10000; 
    public static FAULTS=2;
    public static Proposal NACK=new Proposal(-1,null,-1);
    
    public ArrayList initNodes;
    
    Init()
    {
        createInitialNodes();
    }
    
    public ArrayList createInitialNodes()
    {
        for(i=0;i<totalNodes;i++)       //create initial nodes
        {
            Node p = new Node();
            initNodes.add(p);
        }
    }
    public ArrayList getNodesList()
    {
        return initNodes;
    }
    
}
