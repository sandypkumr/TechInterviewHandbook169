package arrays;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalDef = 0, curDef = 0, curStart = 0;
        for (int i = 0; i < cost.length; i++) {
            totalDef += gas[i] - cost[i];
            curDef += gas[i] - cost[i];
            if (curDef < 0) {
                curDef = 0;
                curStart = i + 1;
            }
        }
        return (totalDef >= 0)?curStart:-1;
    }
}
