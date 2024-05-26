/*
题目：有序数组的平方
给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
示例 1：
    输入：nums = [-4,-1,0,3,10]
    输出：[0,1,9,16,100]
    解释：平方后，数组变为 [16,1,0,9,100]，排序后，数组变为 [0,1,9,16,100]
示例 2：
    输入：nums = [-7,-3,2,3,11]
    输出：[4,9,9,49,121]
 */

public class SquaresOfSortedArray {
    public int[] sortedSquares(int[] nums)
    {
        for(int i=0;i<nums.length;i++)
        {
            for(int j=0;j<nums.length;j++)
            {
                if(i==0)
                {
                    int sq_j=nums[j]*nums[j];
                    nums[j]=sq_j;
                    if(nums[i]<nums[j])
                    {
                        int temp=nums[i];
                        nums[i]=nums[j];
                        nums[j]=temp;
                    }
                }
                else
                {
                    if(nums[i]<nums[j])
                    {
                        int temp=nums[i];
                        nums[i]=nums[j];
                        nums[j]=temp;
                    }
                }
            }
        }
        return nums;
    }

    //解析的解法：双指针法
    /*数组其实是有序的， 只不过负数平方之后可能成为最大数了。那么数组平方的最大值就在数组的两端，不是最左边就是最右边，不可能是中间。
    此时可以考虑双指针法了，i指向起始位置，j指向终止位置。
    定义一个新数组result，和A数组一样的大小，让k指向result数组终止位置。
    如果A[i] * A[i] < A[j] * A[j] 那么result[k--] = A[j] * A[j]; 。
    如果A[i] * A[i] >= A[j] * A[j] 那么result[k--] = A[i] * A[i]; 。*/
    public int[] sortedSquares_dp(int[] nums)
    {
        int right=nums.length-1;
        int left=0;
        int[] result=new int[nums.length];
        int index=result.length-1;
        while (left<=right)
        {
            if(nums[left]*nums[left]>nums[right]*nums[right])
            {
                // 正数的相对位置是不变的， 需要调整的是负数平方后的相对位置
                result[index]=nums[left]*nums[left];
                //result[index--] = nums[left] * nums[left];
                left++;//++left;
            }
            else
            {
                result[index]=nums[right]*nums[right];
                //result[index--] = nums[right] * nums[right];
                right--;//--right;
            }
            index--;//上面减了这里就不用减了
        }
        return result;

    }

    public static void main(String[] args)
    {
        int[] arr1={-4,-1,0,3,10};
        int[] arr2={-7,-3,2,3,11};

        SquaresOfSortedArray sq=new SquaresOfSortedArray();
//        int[] sq_arr1=sq.sortedSquares(arr1);
//        int[] sq_arr2=sq.sortedSquares(arr2);

        int[] sq_arr1=sq.sortedSquares_dp(arr1);
        int[] sq_arr2=sq.sortedSquares_dp(arr2);

        System.out.print("arr1的平方:");
        for(int i=0;i<sq_arr1.length;i++)
        {
            System.out.print(sq_arr1[i]+" ");
        }
        System.out.println();
        System.out.print("arr2的平方:");
        for(int i=0;i<sq_arr2.length;i++)
        {
            System.out.print(sq_arr2[i]+" ");
        }

    }
}

/*笔记：
自己写的方法时间复杂度比解析的写法大得多。当时有考虑用双指针但是没想出来头绪。
这题的关键点一个是“数组有序”，进而可以提取关键：要调整的是负数的位置
* */
