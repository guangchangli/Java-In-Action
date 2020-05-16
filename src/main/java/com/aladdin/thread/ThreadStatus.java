package com.aladdin.thread;

/**
 * 线程状态
 * new          线程被构建 还没有start
 * RUNNABLE     运行状态
 * BLOCKING     阻塞状态
 * WAITING      等待状态 需要等待其他线程作出通知或者中断
 * TIME_WAITING 超时等待 在指定时间返回
 * TERMINATED   执行完毕 终止状态
 *
 * 1。sleep 运行 -> 阻塞 不释放资源
 * 2。yield 运行 -> 就绪 等待调度
 * 3。join join(0) 阻塞当前线程
 *
 * sleep 是静态方法 thread 等待
 * wait 是 object 方法 对象等待 没有参数的 需要被动唤醒
 * join 是实例方法
 * sleep join 都可以抛出异常 可被中断
 * @author lgc
 **/
public class ThreadStatus {
}
