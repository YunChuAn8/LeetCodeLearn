/*题目：
给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
示例 1:
输入: s = "anagram", t = "nagaram"
输出: true
示例 2:
输入: s = "rat", t = "car"
输出: false
提示:
    1 <= s.length, t.length <= 5 * 104
    s 和 t 仅包含小写字母
进阶: 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
*/
public class IsAnagram
{
    public boolean isAnagram(String s, String t)
    {
        //首先看两个字符的长度，如果不同则不是
        if(s.length()!=t.length())
        {
            return false;
        }
        int[] record=new int[26];//因为是小写，所以对应上索引是有26个英文字母，按照abcd等顺序对应
        for (int i=0;i<s.length();i++)
        {   //并不需要记住字符a的ASCII，只要求出一个相对数值就可以了
            record[s.charAt(i)-'a']++;
        }
        for (int i=0;i<t.length();i++)
        {
            record[t.charAt(i)-'a']--;
        }
        //此时遍历数组看是否全为0
        for (int i=0;i<record.length;i++)
        {
            if (record[i]!=0)
            {
                return false;
            }
        }
        return true;
    }
}

/*笔记：
数组其实就是一个简单哈希表，而且这道题目中字符串只有小写字符，那么就可以定义一个数组，来记录字符串s里字符出现的次数。
 因为字符a到字符z的ASCII也是26个连续的数值。所以对应定一个数组叫做record，大小为26
 s为+操作，t为-操作，这样后面一对比就知道了
 */