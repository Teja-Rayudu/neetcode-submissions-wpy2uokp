class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        int currTank = 0;
        int n = gas.length;
        int startingStation = 0;
        
        for(int i = 0; i < n; i++){
            totalGas += gas[i];
            totalCost += cost[i];
            currTank += gas[i] - cost[i];

            if(currTank < 0){
                startingStation = i + 1;
                currTank = 0;
            }
        }

        if(totalGas < totalCost) return -1;

        return startingStation;
    }
}
