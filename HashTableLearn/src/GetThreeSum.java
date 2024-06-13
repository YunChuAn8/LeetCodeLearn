/*题目：
给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，
同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。注意：答案中不可以包含重复的三元组。
示例 1：
输入：nums = [-1,0,1,2,-1,-4]
输出：[[-1,-1,2],[-1,0,1]]
解释：
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。注意，输出的顺序和三元组的顺序并不重要。
示例 2：
输入：nums = [0,1,1]
输出：[]
示例 3：
输入：nums = [0,0,0]
输出：[[0,0,0]]
*/
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
public class GetThreeSum
{
    //双指针法
    public List<List<Integer>> threeSum(int[] nums)
    {
        List<List<Integer>> result=new ArrayList<>();
        Arrays.sort(nums);
        // 找出a + b + c = 0   a = nums[i], b = nums[left], c = nums[right]
        for (int i=0;i<nums.length;i++)
        {
            // 排序之后如果第一个元素已经大于零，那么无论如何组合都不可能凑成三元组，直接返回结果就可以了
            if (nums[i] > 0)
            {
                return result;
            }
            //去重a
            if (i>0&&nums[i]==nums[i-1])
            {
                continue;
            }

            int left=i+1;
            int right=nums.length-1;
            while (right>left)
            {
                int sum=nums[i]+nums[left]+nums[right];
                //此时三数之和大了，因为数组是排序后了，所以right下标就应该向左移动，这样才能让三数之和小一些
                if (sum>0)
                {
                    right--;
                }
                //此时 三数之和小了，left 就向右移动，才能让三数之和大一些，直到left与right相遇为止
                else if (sum<0)
                {
                    left++;
                }
                else
                {
                    result.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    // 去重逻辑应该放在找到一个三元组之后，对b 和 c去重
                    while (right>left&&nums[right]==nums[right-1])right--;
                    while (right>left&&nums[left]==nums[left+1])left++;

                    right--;
                    left++;
                }
            }
        }
        return result;
    }
}

/*笔记：
1、去重需要考虑三个数的去重。在a的去重中，若去重条件为：nums[i] == nums[i + 1]，则会将三元组中出现重复元素的情况直接pass掉。
例如{-1, -1 ,2}，当遍历到第一个-1 的时候，判断下一个也是-1，那这组数据就pass了，但显然这样会漏掉情况。
所以条件应设置为：i > 0 && nums[i] == nums[i - 1]
2、之前的题目“两数之和”不可以使用双指针法，因为两数之和要求返回索引下标，双指针法一定要排序，一旦排序之后原数组的索引就被改变了。
如果两数之和要求返回的是数值的话，就可以使用双指针法了。
* */
