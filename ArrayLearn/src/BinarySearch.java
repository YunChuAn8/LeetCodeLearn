//给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
//示例 1:
//输入: nums = [-1,0,3,5,9,12], target = 9
//输出: 4
//
//示例 2:
//输入: nums = [-1,0,3,5,9,12], target = 2
//输出: -1
//
//提示：
//你可以假设 nums 中的所有元素是不重复的。
//n 将在 [1, 10000]之间。
//nums 的每个元素都将在 [-9999, 9999]之间。

public class BinarySearch
{
    public int search(int[] nums,int target)
    {
        int left=0;
        int right=nums.length-1;
        while (left<=right)
        {
            int middle=(left+right)/2;
            if(nums[middle]<target)
            {
                left=middle+1;
            }
            else if(nums[middle]>target)
            {
                right=middle-1;
            }
            else
            {
                return middle;
            }
        }
        return -1;
    }

    public static void main(String[] args)
    {
        int[] arr={-1,0,3,5,9,12};
        int target1=9;
        int target2=2;

        BinarySearch bs=new BinarySearch();

        System.out.println("示例1输出："+bs.search(arr,target1));
        System.out.println("示例2输出："+bs.search(arr,target2));
    }
}

//总结笔记：
//1、二分法前提：有序数组、无重复；
//关键：区间的定义就是不变量-> 循环不变量规则；
//区间分为两种：
//左闭右闭 [left, right]，循环用 <=；
//左闭右开 [left, right)，循环用<。
//2、计算出的中间索引时需考虑整数溢出问题，这是二分查找算法中常见的边界条件处理技巧之一。
//3、知识点需查缺补漏；无自动纠错下，语言间语法区别有待适应；