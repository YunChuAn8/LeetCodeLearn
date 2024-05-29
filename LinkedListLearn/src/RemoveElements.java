/*题目：
给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
示例 1：
输入：head = [1,2,6,3,4,5,6], val = 6
输出：[1,2,3,4,5]
示例 2：
输入：head = [], val = 1
输出：[]
示例 3：
输入：head = [7,7,7,7], val = 7
输出：[]
*/

public class RemoveElements {
    public ListNode removeElements(ListNode head, int val)
    {
        //当链表头不为空节点时，删除的头结点和其他节点的操作是不一样的
        //头结点为val时，只需把head指针往下移就好
        while (head!=null&&head.val==val)
        {
            head=head.next;
        }
        //已经为null，提前退出，此时处理情况包含：[7,7,7,7],val=7的情况，上面的和这个不可以调换位置，不然这种情况会处理不到
        if(head==null)
        {
            return head;
        }

        //当头结点不为val时
        ListNode pre=head;
        ListNode cur=head.next;
        while (cur!=null)
        {
            if (cur.val==val)
            {
                pre.next=cur.next;
            }
            else
            {
                pre=cur;
            }
            cur=cur.next;
        }
        return head;
    }
    //解析也给了如下的解法
    //引入虚拟节点，统一删除头结点和其他节点的操作方法
    public ListNode removeElements_dummy(ListNode head, int val)
    {
        if(head==null)
        {
            return null;
        }

        //设置虚拟头节点
        ListNode dummy=new ListNode(-1,head);
        ListNode pre=dummy;
        ListNode cur=head;
        while (cur!=null)
        {
            if (cur.val==val)
            {
                pre.next=cur.next;
            }
            else
            {
                pre=cur;
            }
            cur=cur.next;
        }
        return dummy.next;
    }

}

/*笔记：
1、java无c++那样的指针，在Java中，所有非基本类型（如对象、数组等）都是通过引用来传递的。当将一个对象赋值给另一个变量时，实际上是在复制引用，
而不是对象本身。因此，两个变量将指向内存中的同一个对象。
2、使用java ，python的话就不用手动管理内存
3、可以设置虚拟头结点统一删除的操作
* */