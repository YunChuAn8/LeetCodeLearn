/*题目：
给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回 0。
示例：
输入：s = 7, nums = [2,3,1,2,4,3]
输出：2
解释：子数组 [4,3] 是该条件下的长度最小的子数组。
*/
public class MinSubArrayLength {
    public int minSubArrayLen(int target, int[] nums)
    {
        //滑动窗口
        int left=0;
        int total=0;
        int subLength=0;//滑动窗口的长度
        int result=Integer.MAX_VALUE;//记录最小的子窗口，即结果
        for(int right=0;right<nums.length;right++)
        {
            total+=nums[right];
            while (total>=target)
            {
                subLength=(right-left+1);
                //如果有更小的符合条件的窗口，更新结果
                if(result>subLength)
                {
                    result=subLength;
                }
                //滑动窗口的精髓：不断变更子序列起始位置
                total-=nums[left++];
            }
        }
        //如果result没有被赋值，说明没有符合条件的子序列
        if(result==Integer.MAX_VALUE)
        {
            return 0;
        }
        else
        {
            return result;
        }
    }
    public static void main(String[] args)
    {
        int[] arr={2,3,1,2,4,3};
        int s=7;
        MinSubArrayLength solution=new MinSubArrayLength();
        int minLength=solution.minSubArrayLen(s,arr);
        System.out.println("长度最小的子数组的长度为："+minLength);

    }
}


/*笔记：
滑动窗口，就是不断的调节子序列的起始位置和终止位置，从而得出我们要想的结果。
本题的窗口就是 满足其和 ≥ s 的长度最小的连续子数组
窗口滑动规则：
1、窗口的起始位置：如果当前窗口的总和值>=s了，窗口向前移动。
2、窗口的结束位置：窗口的结束位置就是遍历数组的指针，也就是for循环里的索引。
**/