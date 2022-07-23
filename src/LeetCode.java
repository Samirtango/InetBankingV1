class Solution {
	
		
			public int[] runningSum(int[] nums)
			{
			int res[] = new int[nums.length];
			int sum=nums[0];
			res[0] = sum;
			for (int i=1; i<nums.length ;i++)
			{
			sum += nums[i];
			res[i] = sum;
			}
			return res;
			}
		
}