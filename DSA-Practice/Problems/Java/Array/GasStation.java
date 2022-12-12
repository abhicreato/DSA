public class GasStation {
    
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        int diff[] = new int[gas.length];
        int total = 0;
        int sumGas = 0;
        int sumCost = 0;
        int ans =0;
        
        for(int i=0;i<gas.length;i++){
            sumGas += gas[i];
            sumCost += cost[i];
        }
        
        if(sumCost>sumGas) return -1;
        
        for(int i = 0;i < gas.length; i++){
            diff[i] = gas[i] - cost[i];
        }
        
        for(int i=0;i<gas.length;i++){
            total += diff[i];
            if(total < 0){
                total = 0;
                ans = i + 1;
            } 
        }
        
        return ans;
        
    }
}
