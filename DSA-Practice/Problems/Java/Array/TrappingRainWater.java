public class TrappingRainWater {

    public int trap(int[] height) {
        int ans = 0;
        int length = height.length;

        
        int[] maxInLeft = new int[length];
        maxInLeft[0] = height[0];
        for (int i = 1; i < length; i++) {
            maxInLeft[i] = Math.max(maxInLeft[i - 1],height[i]);
        }

        int[] maxInRight = new int[length];
        maxInRight[length - 1] = height[length - 1];
        for (int i = length - 2; i >= 0; i--) {
            maxInRight[i] = Math.max(maxInRight[i + 1],height[i]);
        }

        for (int i = 0; i < length; i++) {

            int min = Math.min(maxInRight[i], maxInLeft[i]);

            ans = ans + (min - height[i]);
        }

        return ans;
        
    }
    
}
