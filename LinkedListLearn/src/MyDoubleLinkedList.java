//双链表
public class MyDoubleLinkedList
{   ListNode first;
    ListNode tail;
    int size;
    public MyDoubleLinkedList()
    {
        this.first= new ListNode(-1);
        this.tail=this.first;
        this.size=0;
    }

    public int get(int index)
    {
        if (index<0||index>=this.size)
        {
            return -1;
        }
        if (this.first.next!=null)
        {
            ListNode cur=this.first;
            while (index-->=0)
            {
                cur=cur.next;
            }
            return cur.val;
        }
        else
        {
            return -1;
        }
    }

    public void addAtHead(int val)
    {
        ListNode newNode=new ListNode(val);
        newNode.pre=this.first;
        this.first.next.pre=newNode;
        newNode.next=this.first.next;
        this.first.next=newNode;
        if(this.tail==this.first)
        {
            this.tail=newNode;
        }
        this.size++;
        //System.out.println("插入成功");

    }

    public void addAtTail(int val)
    {
        ListNode newNode=new ListNode(val);
        this.tail.next=newNode;
        newNode.pre=this.tail;
        this.tail=newNode;
        this.size++;
        //System.out.println("插入成功");

    }

    public void addAtIndex(int index, int val)
    {
        if (index<0||index>=this.size)
        {
            System.out.println("index非法，请重新输入");
            return;
        }

        ListNode newNode=new ListNode(val);
        ListNode pre=this.first;
        while (--index>=0)
        {
            pre=pre.next;
        }
        newNode.next=pre.next;
        pre.next.pre=newNode;
        pre.next=newNode;
        newNode.pre=pre;

        this.size++;
        //System.out.println("插入成功");

    }

    public void deleteAtIndex(int index)
    {
        if (index<0||index>=this.size)
        {
            System.out.println("index非法，请重新输入");
            return;
        }
        ListNode pre=this.first;
        while (--index>=0)
        {
            pre=pre.next;
        }
        pre.next.next.pre=pre;
        pre.next=pre.next.next;

        this.size--;
        //System.out.println("删除成功");

    }

    public static void main(String[] args)
    {
        MyLinkedList obj = new MyLinkedList();

        obj.addAtHead(1);
        obj.addAtTail(3);
        obj.addAtIndex(1,2);
        int param_1 = obj.get(1);
        System.out.println(param_1);
        obj.deleteAtIndex(1);
        int param_2 = obj.get(1);
        System.out.println(param_2);
    }

}
