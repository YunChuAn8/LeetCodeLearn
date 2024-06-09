/*题目：
给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足：
0 <= i, j, k, l < n
nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
示例 1：
输入：nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
输出：2
解释：
两个元组如下：
1. (0, 0, 0, 1) -> nums1[0] + nums2[0] + nums3[0] + nums4[1] = 1 + (-2) + (-1) + 2 = 0
2. (1, 1, 0, 0) -> nums1[1] + nums2[1] + nums3[0] + nums4[0] = 2 + (-1) + (-1) + 0 = 0
示例 2：
输入：nums1 = [0], nums2 = [0], nums3 = [0], nums4 = [0]
输出：1
* */
import java.util.HashMap;
import java.util.Map;
public class FourSumCount
{
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4)
    {
        int count=0;
        Map<Integer,Integer>map=new HashMap<>();
        //首先遍历nums1和nums2，计算两个数组的元素相加之和以及出现的次数
        for (int i:nums1)
        {
            for (int j:nums2)
            {
                int sum=i+j;
                //key:两数之和，value：该和出现的次数
                map.put(sum,map.getOrDefault(sum,0)+1);
                //map.put(Key, Value)：将一个键值对放入Map中。如果Map中已经存在该键，则该方法会替换该键对应的值。
                //map.getOrDefault(Key, defaultValue)：它尝试获取与给定键相关联的值。当不存在键，返回设置的default值，如果是get（），键不存在会返回null
            }
        }
        //统计剩余的两个元素的和，在map中找是否存在相加为0的情况，同时记录次数
        for (int i:nums3)
        {
            for (int j:nums4)
            {
                count+=map.getOrDefault(0-i-j,0);
            }
        }
        return count;
    }
}

/*笔记：
A+B+C+D=0,可看作（A+B）+（C+D）=0，则：
首先定义map，key放a和b两数之和，value 放a和b两数之和出现的次数。
遍历大A和大B数组，统计两个数组元素之和，和出现的次数，放到map中。
定义int变量count，用来统计 a+b+c+d = 0 出现的次数。
在遍历大C和大D数组，找到如果 0-(c+d) 在map中出现过的话，就用count把map中key对应的value也就是出现次数统计出来。
最后返回统计值 count 就可以了
* */