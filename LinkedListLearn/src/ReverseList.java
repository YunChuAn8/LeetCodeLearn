/*题目：
给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
示例 1：
输入：head = [1,2,3,4,5]
输出：[5,4,3,2,1]
示例 2：
输入：head = [1,2]
输出：[2,1]
示例 3：
输入：head = []
输出：[]
进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？
*/
public class ReverseList
{
    //迭代法
    public ListNode reverseListRecursion(ListNode head)
    {
        if(head==null)
        {
            return null;
        }
        ListNode pre=null;
        ListNode cur=head;
        ListNode temp;
        while (cur!=null)
        {
            temp=cur.next;
            cur.next=pre;
            pre=cur;
            cur=temp;
        }
        return pre;
    }

    //递归法
    public ListNode reverseListIteration(ListNode head)
    {
        return reverse(null,head);
    }
    private ListNode reverse(ListNode pre,ListNode cur)
    {
        if (cur==null)
        {
            return pre;
        }
        ListNode temp=null;
        temp=cur.next;//先保存下一个节点
        cur.next=pre;//反转
        return reverse(cur,temp);
    }

}
