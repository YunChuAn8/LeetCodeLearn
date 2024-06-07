/*题目：
编写一个算法来判断一个数 n 是不是快乐数。
「快乐数」 定义为：
对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
如果这个过程 结果为 1，那么这个数就是快乐数。
如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
示例 1：
输入：n = 19
输出：true
示例 2：
输入：n = 2（最终会在25+64=89间无限循环，重复出现89）
输出：false
1 <= n <= 2^31 - 1
* */
import java.util.HashSet;
import java.util.Set;

public class IsHappyNumber
{
    public boolean isHappy(int n)
    {
        //跟踪出现过的数字，当在集合中找到了一个之前已经看到过的数字时，则知此时进入了一个循环，因此该数字不是快乐数。
        // 如果我们最终得到了1，那么该数字就是快乐数。
        Set<Integer> haveSeen=new HashSet<>();
        while (n!=1&&!haveSeen.contains(n))
        {
            haveSeen.add(n);
            //分别提取位数相加平方和
            String str=Integer.toString(n);
            int sum=0;
            for (int i = 0; i < str.length(); i++)
            {
                char c = str.charAt(i); // 使用 charAt 方法来获取字符
                int digit = c - '0';
                sum += digit * digit;
            }
            n=sum;
        }
        return n==1;
    }

    //解析采用while循环取余去获取每一个位置的数
    public boolean isHappy2(int n)
    {
        Set<Integer> record = new HashSet<>();
        while (n != 1 && !record.contains(n))
        {
            record.add(n);
            n = getNextNumber(n);
        }
        return n == 1;
    }
    private int getNextNumber(int n)
    {
        int res = 0;
        while (n > 0)
        {
            int temp = n % 10;
            res += temp * temp;
            n = n / 10;
        }
        return res;
    }
}

/*笔记：
1、核心点：题目中说了会无限循环，即在求和的过程中，sum会重复出现 -> 使用hash表判断元素是否重复出现
2、取每一个位置的数可以使用while循环取余和整除结合来获取
* */