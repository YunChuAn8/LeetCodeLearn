/*题目：给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出和为目标值 target 的那两个整数，并返回它们的数组下标。
你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
你可以按任意顺序返回答案。
示例 1：
输入：nums = [2,7,11,15], target = 9
输出：[0,1]
解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
示例 2：
输入：nums = [3,2,4], target = 6
输出：[1,2]
示例 3：
输入：nums = [3,3], target = 6
输出：[0,1]
进阶：你可以想出一个时间复杂度小于 O(n^2) 的算法吗？
*/
import java.util.Map;
import java.util.HashMap;
public class GetTwoSum
{
    public int[] twoSum(int[] nums, int target)
    {
        int[] res=new int[2];
        if (nums==null||nums.length==0)
        {
            return res;
        }
        Map<Integer,Integer> map=new HashMap<>();
        for (int i=0;i< nums.length;i++)
        {
            //遍历当前的元素，并在map中寻找是否有匹配的key
            int temp=target-nums[i];
            if (map.containsKey(temp))
            {
                res[0]=i;
                res[1]=map.get(temp);
                break;
            }
            //如果没找到匹配对，就把访问过的元素和下标加入到map中
            map.put(nums[i],i);
        }
        return res;
    }
}

/*笔记：
1、为什么会想到用哈希表
本题需要到一个集合来存放遍历过的元素，然后在遍历数组时去询问这个集合，某元素是否遍历过，也就是是否出现在这个集合。
2、哈希表为什么用map
本题需要知道元素有无遍历过，也要知道元素对应下标->一一对应关系，并且本题并不需要key有序
3、本题map是用来存什么的
用来存放我们访问过的元素，因为遍历数组的时候，需要记录我们之前遍历过哪些元素和对应的下标，这样才能找到与当前元素相匹配的（也就是相加等于target）
4、map中的key和value用来存什么的
 {key：数据元素，value：数组元素对应的下标}
* */