/*题目：
给定一个链表的头节点head ，返回链表开始入环的第一个节点。如果链表无环，则返回 null。如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。
注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
不允许修改链表。

示例 1：
输入：head = [3,2,0,-4], pos = 1
输出：返回索引为 1 的链表节点
解释：链表中有一个环，其尾部连接到第二个节点。
示例 2：
输入：head = [1,2], pos = 0
输出：返回索引为 0 的链表节点
解释：链表中有一个环，其尾部连接到第一个节点。
示例 3：
输入：head = [1], pos = -1
输出：返回 null

进阶：你是否可以使用 O(1) 空间解决此题？
 */

public class DetectCycle
{
    //快慢指针法找环
    public ListNode detectCycle(ListNode head)
    {
        ListNode fast=head;
        ListNode slow=head;
        while (fast!=null&&fast.next!=null)
        {
            fast=fast.next.next;
            slow=slow.next;
            if (fast==slow)
            {
                //有环，找到环入口;找到的方法经过推导可以得到：从头结点和相遇节点各出发一个指针，同样速度为1，相遇的节点则为环入口
                ListNode index1=fast;
                ListNode index2=head;
                while (index1!=index2)
                {
                    index1=index1.next;
                    index2=index2.next;
                }
                return index2;//返回环入口
            }
        }
        return null;//没有环
    }
}

/*笔记：
判断是否有环->快慢指针法。循环判断条件开始时设置遗漏，应该设置为“fast!=null&&fast.next!=null”
另外找环入口开始时也想不到。找环入口的方法为：从头结点和相遇节点各出发一个指针，同样速度为1，相遇的节点则为环入口
推导：
假设从头结点到环形入口节点 的节点数为x。fast一次走2节点，slow走1节点，环形入口节点到 fast指针与slow指针相遇节点 节点数为y。 从相遇节点 再到环形入口节点节点数为 z。
相遇时两指针走过节点数：slow: x + y， fast：x + y + n (y + z)，n为fast指针在环内走了n圈才遇到slow指针，（y+z）为 一圈内节点的个数A。
有如下关系：(x + y) * 2 = x + y + n (y + z)，为求x，推导得x = (n - 1) (y + z) + z；n=1时，x=z
即：从头结点出发一个指针，从相遇节点 也出发一个指针，这两个指针每次只走一个节点， 那么当这两个指针相遇的时候就是 环形入口的节点。
*/