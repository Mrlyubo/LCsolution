import java.util.*;

class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int l = 0, r = n - 1;
        int ans = 0;
        while(l < r &&  height[l] <= height[l+1]) l++;
        while(l < r &&  height[r] <= height[r-1]) r--;

        while (l < r){
            int left = l;
            int right = r;

            if(height[left] <= height[right]){
                // add water to ans from left until higher than left.
                while (l < r && height[++l] <= height[left] )
                    ans += height[left] - height[l];

            }
            else{
                // add water to ans from right until higher than right.
                while (l < r && height[--r] <= height[right])
                    ans += height[right] - height[r];
            }
        }
        return ans;

    }
    public static void main(String[] args) {
        Solution Launcher = new Solution();
        Launcher.start();
    }

    public void start() {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }
}

