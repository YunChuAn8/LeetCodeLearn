//题目：
//给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
//不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并原地修改输入数组。
//元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
//示例 1: 给定 nums = [3,2,2,3], val = 3, 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。 你不需要考虑数组中超出新长度后面的元素。
//示例 2: 给定 nums = [0,1,2,2,3,0,4,2], val = 2, 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
//你不需要考虑数组中超出新长度后面的元素。

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int tail=0;
        for(int i=0;i<nums.length;++i)
        {
            if(nums[i]!=val)
            {
                nums[tail]=nums[i];
                tail++;
            }
        }
        return tail;
    }

    public static void main(String[] args) {
        int[] nums={0,1,2,2,3,0,4,2};
        int val=2;

        RemoveElement rm=new RemoveElement();
        int k=rm.removeElement(nums,val);
        System.out.println("k="+k);
        System.out.println("nums前k个元素为:");
        for(int i=0;i<k;i++)
        {
            System.out.print(nums[i]+" ");
        }
    }
}

//一题多解，我上面想的是相近于快慢指针的写法，解析中除了有快慢指针法同时也采用的是相向双指针法
/*
class Solution {
    public int removeElement(int[] nums, int val) {
        int left = 0;
        int right = nums.length - 1;
        while(right >= 0 && nums[right] == val) right--; //将right移到从右数第一个值不为val的位置
        while(left <= right) {
            if(nums[left] == val) { //left位置的元素需要移除
                //将right位置的元素移到left（覆盖），right位置移除
                nums[left] = nums[right];
                right--;
            }
            left++;
            while(right >= 0 && nums[right] == val) right--;
        }
        return left;
    }
}
*/