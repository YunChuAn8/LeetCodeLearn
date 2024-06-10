/*题目：
给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
如果可以，返回 true ；否则返回 false 。magazine 中的每个字符只能在 ransomNote 中使用一次。
示例 1：
输入：ransomNote = "a", magazine = "b"
输出：false
示例 2：
输入：ransomNote = "aa", magazine = "ab"
输出：false
示例 3：
输入：ransomNote = "aa", magazine = "aab"
输出：true
提示：
1 <= ransomNote.length, magazine.length <= 105
ransomNote 和 magazine 由小写英文字母组成
* */

public class CanConstruct
{
    public boolean canConstruct(String ransomNote, String magazine)
    {
        //首先定义数组
        int[] result=new int[26];
        //分别遍历两个字符串，计数
        for (int i=0;i<magazine.length();i++)
        {
            result[magazine.charAt(i)-'a']++;
        }
        for (int i=0;i<ransomNote.length();i++)
        {
            result[ransomNote.charAt(i)-'a']--;
        }

        //接着看是否有小于0的，有则无法构成
        for (int i=0;i<result.length;i++)
        {
            if (result[i]<0)
            {
                return false;
            }
        }
        return true;
    }
}

/*笔记：
该题和前面的有效的字母异位词是类似的思路。
在本题的情况下，使用map的空间消耗要比数组大一些的，因为map要维护红黑树或者哈希表，而且还要做哈希函数，耗时更长！
数据量大的话就能体现出来差别了。 所以数组更加简单直接有效
* */