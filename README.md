# LeetCodeLearn
记录刷leetcode题的学习过程

**一、刷题资料：**  
指导：代码随想录（含刷题链接）：https://programmercarl.com/#%E6%9C%AC%E7%AB%99%E8%83%8C%E6%99%AF  
题库：牛客 ：leetcode hot100&剑指offer（LCR）：https://leetcode.cn/studyplan/top-100-liked/

**二、整体规划:**   
刷题类型：数组-> 链表-> 哈希表->字符串->栈与队列->树->回溯->贪心->动态规划->图论->高级数据结构，再从简单刷起，做了几个类型题目之后，再慢慢做中等题目、困难题目。  
先看代码随想录，对整个算法各个专题都有整体认知之后，再去看剑指offer（因各专题不够系统）  
任务安排：每日1-2题，形成习惯（据当日安排和题目难度）  

**三、具体实践（C++）**  
**2024.5.24：二分查找**  
笔记：  
1、二分法前提：有序数组、无重复；  
关键：区间的定义就是不变量-> 循环不变量规则；  
区间分为两种：  
左闭右闭 [left, right]，循环用 <=；  
左闭右开 [left, right)，循环用<。  
2、计算出的中间索引时需考虑整数溢出问题，这是二分查找算法中常见的边界条件处理技巧之一。  
3、知识点需查缺补漏；无自动纠错下，语言间语法区别有待适应（平时写惯python了，写其他语言总是忘东西qwq）；  

**2024.5.25: 移除数组**   
该题常见解法一个是快慢指针、一个是相向指针。本质都是一个记录数组前段非val元素的末置和寻找下一非val元素。  
（说明：代码文件按专题收录似乎会比较好，所以后面数组部分代码的更新放在“ArrayLearn”文件夹中，添加新的java代码。）  

**2024.5.26：有序数组的平方**  
自己写的方法时间复杂度比解析的写法大得多。当时有考虑用双指针但是没想出来头绪。  
这题的关键点一个是“数组有序”，进而可以提取关键：要调整的是负数的位置。  

**2024.5.27:螺旋矩阵Ⅱ**  
这道题关键坚持循环不变量原则。  
填充分四种情况讨论：  
                填充上行从左到右  
                填充右列从上到下  
                填充下行从右到左  
                填充左列从下到上  
每条边遵循左闭右开原则。  
奇数最中间元素单独处理。  

**2024.5.28：长度最小的子数组**  
滑动窗口，就是不断的调节子序列的起始位置和终止位置，从而得出我们要想的结果。  
本题的窗口就是 满足其和 ≥ s 的长度最小的连续子数组  
窗口滑动规则：  
1、窗口的起始位置：如果当前窗口的总和值>=s了，窗口向前移动。  
2、窗口的结束位置：窗口的结束位置就是遍历数组的指针，也就是for循环里的索引。  

**数组专题总结：**  
待写。。。  


**2024.5.29：删除链表元素**  
1、java无c++那样的指针，在Java中，所有非基本类型（如对象、数组等）都是通过引用来传递的。当将一个对象赋值给另一个变量时，实际上是在复制引用，
而不是对象本身。因此，两个变量将指向内存中的同一个对象。  
2、使用java ，python的话就不用手动管理内存  
3、可以设置虚拟头结点统一删除的操作  

**2024.5.30：设计链表**  
实现了双链表和单链表  

**2024.5.31：反转链表**  
实现方法有迭代法和递归法  

**2024.6.1：两两交换链表中的节点**  
正常模拟即可。使用虚拟头结点方便操作；画图明思路。  

**2024.6.2：删除链表的倒数第N个节点**  
双指针的经典应用，如果要删除倒数第n个节点，让fast移动n步，然后让fast和slow同时移动，直到fast指向链表末尾。删掉slow所指向的节点就可以了。  

**2024.6.3：链表相交**  
题目中的示例是相交后就会并在一起。  
解题要点在于：合并后就都是一条链了，那交点肯定是两链屁股并起后往前推，一定会在短的链的长度范围内，那长链在短链长度外的节点必然不可能是相交点了  

另外，版本二的解法很巧妙，可以推导出来的。    
假设链表A的长度为𝑚，链表B的长度为𝑛。两个链表在节点𝐶处相交。在链表A中，节点𝐶前有𝑎个节点。在链表B中，节点𝐶有𝑏个节点  
因此有𝑎+𝑐=𝑚和𝑏+𝑐=𝑛，其中𝑐是从𝐶到链表末尾的节点数量。  
双指针遍历过程：  
初始化指针 curA 指向链表A的头节点，curB 指向链表B的头节点。  
在每次迭代中：  
如果 curA 到达了链表A的末尾（已走过m），则将其重置为链表B的头节点。  
如果 curB 到达了链表B的末尾（已走过n），则将其重置为链表A的头节点。  
否则，两个指针分别向前移动一个节点。  
遍历到相交节点：    
第一次遍历：指针 curA 和 curB 都会分别遍历自己的链表。假设它们在第一次遍历中没有相遇。    
第二次遍历：当指针 curA 完成遍历链表A（长度𝑚），它会被重置为链表B的头节点，并开始遍历链表B。  
同样，当指针 curB 完成遍历链表B（长度𝑛），它会被重置为链表A的头节点，并开始遍历链表A。  
因为两个指针最终都会遍历𝑚+𝑛个节点，速度也相同，所以前面相同的点也都会一起走，往前推到第一次相交相遇的点，也都是一起走，即它们最终会在相交节点𝐶处相遇。  
如果两个链表不相交，则两个指针都会在最终到达各自的末尾（即都为 null），并且它们会同时结束循环。  



