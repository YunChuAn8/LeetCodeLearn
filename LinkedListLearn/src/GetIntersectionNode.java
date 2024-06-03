/*题目：
给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
题目数据保证整个链式结构中不存在环。注意，函数返回结果后，链表必须保持其原始结构 。

示例 1：
输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
输出：Intersected at '8'
解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。

示例 2：
输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
输出：Intersected at '2'

示例 3：
输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
输出：null
解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。
由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。这两个链表不相交，因此返回 null 。

进阶：你能否设计一个时间复杂度 O(n) 、仅用 O(1) 内存的解决方案？
*/

public class GetIntersectionNode
{
    //最粗暴的一个方法是m*n去遍历，看看是否是同一个节点
    public ListNode getIntersectionNode(ListNode headA, ListNode headB)
    {
        ListNode curA=headA;
        ListNode curB=headB;
        while (curA!=null)
        {
            //逐个比较和b的节点
            while (curB!=null)
            {
                if (curA==curB)
                {
                    return curA;
                }
                curB=curB.next;
            }
            curB=headB;//开始时忘记重置了，出错
            curA=curA.next;
        }
        return null;

    }

    //解析的方法，版本一先行移动长链表实现同步移动
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB)
    {
        ListNode curA=headA;
        ListNode curB=headB;
        int lenA=0,lenB=0;
        //先求两个链表的长度
        while (curA!=null)
        {
            lenA++;
            curA=curA.next;
        }
        while (curB!=null)
        {
            lenB++;
            curB=curB.next;
        }
        //重置cur
        curA=headA;
        curB=headB;
        //将两条链表尾部对其后，让最长的链表的cur处于和另一条链表的表头位置，然后再一起移动寻找交点
        //这里为了减少代码量(冗余），就让lenA指定为最长的链表，如果B大于A了就让他们互换，逻辑上A始终为最长
        if (lenB>lenA)
        {
            //先交换长度
            int tmpLen=lenA;
            lenA=lenB;
            lenB=tmpLen;
            //交换cur
            ListNode tmpNode=curA;
            curA=curB;
            curB=tmpNode;
        }
        //求长度差
        int gap=lenA-lenB;
        //末尾对齐
        while (gap-->0)
        {
            curA=curA.next;
        }
        //遍历cur，相同则返回
        while (curA!=null)
        {
            if (curA==curB)
            {
                return curA;
            }
            curA= curA.next;
            curB=curB.next;
        }
        return null;
    }

    //解析的方法，版本二合并链表实现同步移动
    public ListNode getIntersectionNode3(ListNode headA, ListNode headB)
    {
        ListNode curA=headA;
        ListNode curB=headB;
        while (curA!=curB)
        {
            //curA走一步，如果走到A链表的末尾，则转到B链表
            if (curA==null)
            {
                curA=headB;
            }
            else
            {
                curA=curA.next;
            }
            //curB走一步，如果走到B末尾，转到A
            if (curB==null)
            {
                curB=headA;
            }
            else
            {
                curB=curB.next;
            }
        }
        return curA;//一定会在交点处重逢，这个是可以推导出来的
    }

}

/*总结：
题目中的示例是相交后就会并在一起。
解题要点在于：合并后就都是一条链了，那交点肯定是两链屁股并起后往前推，一定会在短的链的长度范围内，那长链在短链长度外的节点必然不可能是相交点了

另外，版本二的解法很巧妙，可以推导出来的。
* */


