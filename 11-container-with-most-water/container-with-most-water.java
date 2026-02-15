class Solution {
    public int maxArea(int[] height) {                
        int i = 0;
        int j = height.length-1 ;
        int min_height=0;
        int area = 0;
        int width = 0;
        while (i<j)
        {
            min_height = Math.min(height[i],height[j]);
            width = j-i;
            area = Math.max(area, width*min_height);
            if (height[i]<=height[j])
            {
                i++;
            }
            else 
            {
                j--;
            }

         }
         return area;
        
    }
}