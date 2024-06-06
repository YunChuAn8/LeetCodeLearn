/*题目：
给定两个数组 nums1 和 nums2 ，返回它们的交集。输出结果中的每个元素一定是唯一的。我们可以不考虑输出结果的顺序 。
示例 1：
输入：nums1 = [1,2,2,1], nums2 = [2,2]
输出：[2]
示例 2：
输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
输出：[9,4]
解释：[4,9] 也是可通过的
*/
//使用HashSet结构和Set结构
import java.util.HashSet;
import java.util.Set;
public class GetIntersection
{
    public int[] intersection(int[] nums1, int[] nums2)
    {
        if (nums1==null||nums2==null||nums1.length==0||nums2.length==0)
        {
            return null;
        }
        //Set<Integer>: 这是一个接口Set的引用，HashSet是Set接口的一个具体实现，它允许存储不重复的元素，并且元素的存储顺序是不确定的（即无序的）
        Set<Integer> set1=new HashSet<>();
        Set<Integer> resultSet=new HashSet<>();
        //遍历数组1
        for (int i:nums1)
        {
            set1.add(i);
        }
        //遍历数组2，并且判哈希表中是否存在该元素
        for (int i:nums2)
        {
            if (set1.contains(i))
            {
                resultSet.add(i);
            }
        }
        //将结果转成int数组的形式返回，解析提供了两种方法
        //第一种方法
        int[] result=resultSet.stream()// 使用Java 8的Stream API
                .mapToInt(Integer::intValue)// 将Integer对象转换为int
                .toArray();// 收集到一个int数组中
        return result;

        //或者：return resSet.stream().mapToInt(x -> x).toArray();

        //方法二：另外申请一个数组存放setRes中的元素,最后返回数组
        //        int[] arr = new int[resSet.size()];
        //        int j = 0;
        //        for(int i : resSet){
        //            arr[j++] = i;
        //        }
        //
        //        return arr;

    }
}

/*笔记：
1、使用数组来做哈希的题目，是因为题目都限制了数值的大小。而该没有限制数值的大小，就无法使用数组来做哈希表了。
而且如果哈希值比较少、特别分散、跨度非常大，使用数组就造成空间的极大浪费。
2、在C++中可以使用set，std::set和std::multiset底层实现都是红黑树，std::unordered_set的底层实现是哈希表，
使用unordered_set读写效率是最高的，并不需要对数据进行排序，而且还不要让数据重复，所以选择unordered_set。
在Java中，使用java.util.HashSet，java.util.Set，其中，创建两个Set集合对象，具体是HashSet类型的实例
Set<Integer>: 这是一个接口Set的引用，具体实例为HashSet对象。
使用Set接口的代码。这提高了代码的灵活性和可维护性
3、上面转换的写法是java8的Stream API
* */
