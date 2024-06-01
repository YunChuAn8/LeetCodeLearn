/*题目：
给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
示例 1：
输入：head = [1,2,3,4]
输出：[2,1,4,3]
示例 2：
输入：head = []
输出：[]
示例 3：
输入：head = [1]
输出：[1]
*/
public class SwapPairs
{
    public ListNode swapPairs(ListNode head)
    {
        //设置虚拟头结点
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode cur=dummy;

        while (cur.next!=null&&cur.next.next!=null)
        {
            //保存节点
            ListNode temp1=cur.next;
            ListNode temp2=cur.next.next.next;

            cur.next=cur.next.next;
            cur.next.next=temp1;
            cur.next.next.next=temp2;

            cur=cur.next.next;//移动两位，准备下一轮交换

        }
        return dummy.next;
    }
    //解析给了其他解法
    //递归法
    public ListNode swapPairsRecursion(ListNode head)
    {
        if (head==null||head.next==null)
        {
            return head;
        }

        ListNode next=head.next;
        //进行递归
        ListNode newNode=swapPairsRecursion(next.next);
        //进行交换
        next.next=head;
        head.next=newNode;

        return next;
    }
    //不用设置temp节点，把步骤2、3交换顺序
    public  ListNode swapPairsNoTemp(ListNode head)
    {
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null)
        {
            ListNode node1 = cur.next;// 第 1 个节点
            ListNode node2 = cur.next.next;// 第 2 个节点
            cur.next = node2; // 步骤 1
            node1.next = node2.next;// 步骤 3
            node2.next = node1;// 步骤 2
            cur = cur.next.next;
        }
        return dummy.next;
    }
}

/*总结：
正常模拟即可。使用虚拟头结点方便操作；画图明思路。
* */