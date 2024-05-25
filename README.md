# LeetCodeLearn
记录刷leetcode题的学习过程

一、刷题资料：  
指导：代码随想录（含刷题链接）：https://programmercarl.com/#%E6%9C%AC%E7%AB%99%E8%83%8C%E6%99%AF  
题库：牛客 ：leetcode hot100&剑指offer（LCR）：https://leetcode.cn/studyplan/top-100-liked/

二、整体规划：  
刷题类型：数组-> 链表-> 哈希表->字符串->栈与队列->树->回溯->贪心->动态规划->图论->高级数据结构，再从简单刷起，做了几个类型题目之后，再慢慢做中等题目、困难题目。  
先看代码随想录，对整个算法各个专题都有整体认知之后，再去看剑指offer（因各专题不够系统）  
任务安排：每日1-2题，形成习惯（据当日安排和题目难度）  

三、具体实践（C++）  
2024.5.24：二分查找  
笔记：  
1、二分法前提：有序数组、无重复；  
关键：区间的定义就是不变量-> 循环不变量规则；  
区间分为两种：  
左闭右闭 [left, right]，循环用 <=；  
左闭右开 [left, right)，循环用<。  
2、计算出的中间索引时需考虑整数溢出问题，这是二分查找算法中常见的边界条件处理技巧之一。  
3、知识点需查缺补漏；无自动纠错下，语言间语法区别有待适应（平时写惯python了，写其他语言总是忘东西qwq）；  

2024.5.25: 移除数组  
该题常见解法一个是快慢指针、一个是相向指针。本质都是一个记录数组前段非val元素的末置和寻找下一非val元素。  
（说明：代码文件按专题收录似乎会比较好，所以后面数组部分代码的更新放在“ArrayLearn”文件夹中，添加新的java代码。）   
