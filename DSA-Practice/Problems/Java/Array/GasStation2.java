class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int sumOfGas = 0;
        int sumOfCost = 0;
        int ans = 0;
        int gasNow = 0;

        for (int i = 0; i < gas.length; i++) {
            gasNow = gasNow + (gas[i] - cost[i]);
            sumOfGas += gas[i];
            sumOfCost += cost[i];
            if (gasNow < 0) {
                gasNow = 0;
                ans = i + 1;
            }
        }

        return (sumOfGas >= sumOfCost) ? ans : -1;
    }
}