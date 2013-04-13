public class Proposer extends Node
{
    private int propNum;
    private int numberOfTimesProposed=0;
    public void generateNewPropNum()
    {
        propNum=getId()+numberOfTimesProposed*Init.totalNodes;
        numberOfTimesProposed++ 
    }
    public int getPropNum()
    {
        return propNum;
    }
}
