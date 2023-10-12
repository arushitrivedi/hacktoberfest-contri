//LEETCODE : Longest Increasing Subsequnece

/*Ques) Given an integer array nums, return the length of the longest strictly increasing 
subsequence.

Example 1:
Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.

Example 2:
Input: nums = [0,1,0,3,2,3]
Output: 4

Example 3:
Input: nums = [7,7,7,7,7,7,7]
Output: 1
*/

//Solution
class Solution
  {
    public int dfs(int[] nums,int prev,int index,int[][] dp)
    {
        if(index>=nums.length)
        {
            return 0;
        }
        if (dp[index][prev+1]!= -1) return dp[index][prev+1];
        int notTake=dfs(nums,prev,index+1,dp);
        int take=0;
        if(prev==-1||nums[prev]<nums[index])
        {
            take=1+dfs(nums,index,index+1,dp);
        }
        
        return dp[index][prev+1]=Math.max(notTake,take);
    }
    public int lengthOfLIS(int[] nums)
    {
        int [][] dp= new int[nums.length][nums.length+1];
        for(int [] row:dp) Arrays.fill(row,-1);
        return dfs(nums,-1,0,dp);
    }
}
