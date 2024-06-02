/*给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
示例 1：
输入：head = [1,2,3,4,5], n = 2
输出：[1,2,3,5]
示例 2：
输入：head = [1], n = 1
输出：[]
示例 3：
输入：head = [1,2], n = 1
输出：[1]
进阶：你能尝试使用一趟扫描实现吗？
*/
public class RemoveNthFromEnd
{
    public ListNode removeNthFromEnd(ListNode head, int n)
    {
        //添加虚拟节点
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        //target为tail的前n位置
        ListNode tail=head;
        ListNode target=head;
        ListNode pre=dummy;

        //tail开始先出发n-1
        for (int i=n-1;i>0;i--)
        {
            if (tail.next==null)
            {
                return null;//n不合法
            }
            tail=tail.next;
        }
        //接着三指针一起往后走，直到tail到最后面一个元素
        while (tail.next!=null)
        {
            tail=tail.next;
            target=target.next;
            pre=pre.next;
        }
        //删除节点
        pre.next=target.next;

        return dummy.next;
    }
    //解析的方法思路也是一样，不过有的处理不一样、
    public ListNode removeNthFromEnd2(ListNode head, int n)
    {
        //新建一个虚拟头节点指向head
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        //快慢指针指向虚拟头节点
        ListNode fastIndex = dummyNode;
        ListNode slowIndex = dummyNode;

        // 只要快慢指针相差 n 个结点即可
        for (int i = 0; i <= n; i++) {
            fastIndex = fastIndex.next;
        }

        while (fastIndex != null) {
            fastIndex = fastIndex.next;
            slowIndex = slowIndex.next;
        }

        // 此时 slowIndex 的位置就是待删除元素的前一个位置。
        // 检查 slowIndex.next 是否为 null，以避免空指针异常
        if (slowIndex.next != null) {
            slowIndex.next = slowIndex.next.next;
        }
        return dummyNode.next;
    }

}

/*笔记：
双指针的经典应用，如果要删除倒数第n个节点，让fast移动n步，然后让fast和slow同时移动，直到fast指向链表末尾。删掉slow所指向的节点就可以了。*/
