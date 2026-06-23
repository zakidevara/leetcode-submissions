class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sumGas = Arrays.stream(gas).sum();
        int sumCost = Arrays.stream(cost).sum();
        if (sumGas < sumCost) return -1;

        int[] netGas = new int[gas.length];
        for (int i = 0; i < gas.length; i++) {
            netGas[i] = gas[i] - cost[i];
        }

        int start = 0;
        int tank = 0;
        for (int i = 0; i < gas.length; i++) {

            if (tank < 0) {
                start = i;
                tank = 0;
            }

            
            tank += netGas[i];
        }

        return start;
    }
}


