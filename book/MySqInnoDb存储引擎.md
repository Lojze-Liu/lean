### 1、innoDB 中的内存缓冲池
1. **如何维护**
> 采用LRU算法管理mysql内存中的缓冲池，缓冲池中页的大小默认为16kb
---
2. **特殊的地方**
> InnoDB存储引擎对LRU进行了优化，加入了midPoint，新读取到的页，不是直接放在LRU的首部，而是放入了midpoint的位置，这个算法在innoDB储存引擎下被称为 midpoint insertion stategy*
> 在默认配置下，在LRU列表的 5/8 处， 
> 使用 `SHOW VARIABLES like 'innodb_old_blocks_pct'\G ` 
> 查看使用 

> 为什么不采用朴素的LRU呢？ 
>   1. TODO 


### 2、数据库宕机

1. **如何避免数据丢失 - 关于重做日志（redo log）**

>通过重做日志（redo log）来恢复数据
>
>普遍事务型数据库采用了 Write Ahead Log 策略，即当事务提交时，先写重做日志，再修改页，如果在刷新磁盘的时候发生了宕机，通过重做日志来恢复数据
>
>关于重做日志
>> InnoDb内存区会含有重做日志的缓冲，每一秒会将重做日志缓冲刷新到日志文件中，一般来说，重做日志的缓冲8M足够，下列三种情况会将重做日志刷新到磁盘上：
>> 1. *Master Thread 每秒刷新到磁盘上*
>> 2. **事务提交**
>> 3. *重做日志缓存容量小于 1/2 时*

"只通过重做日志保证数据恢复可行吗"
> 缓冲池缓冲全部数据
> 重做日志无限大，恢复时间长
>     不可行

--- 
2. **如何避免数据丢失 - 关于`check point` 技术**
> 解决的问题
>> 1. 缩短数据库恢复时间
>> 2. 缓冲池不够用的时候，将脏业刷新到磁盘
>> 3. 重做日志不可用时，刷新脏页




### 3、
1. ** 为解决的问题 **





# 问题

1. **mysql的master thread使用的是AIO，提高了性能，探索一下Aio与Bio是什么？**
> mysql
2. **数据库中的页**
> mysql

3. **mysql 脏页**？
>mysql
4. **redo log 与 undo log 的区别总结**？
>mysql