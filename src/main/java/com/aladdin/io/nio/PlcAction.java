package com.aladdin.io.nio;

import java.io.FileInputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * position limit capacity
 * @author lgc
 */
public class PlcAction {
    public static void main(String[] args) throws Exception {
        FileInputStream fin = new FileInputStream("/Users/lgc/Desktop/plc.txt");
        FileChannel fc = fin.getChannel();

        //分配一个 10 大小的 buffer
        ByteBuffer buffer = ByteBuffer.allocate(10);
        output("初始化",buffer);
        //读
        fc.read(buffer);
        output("调用 read()",buffer);
        //准备操作之前先锁定操作范围
        buffer.flip();
        output("调用 flip()",buffer);
        //判断有没有数据可读
        while (buffer.remaining()>0){
            byte b = buffer.get();
            System.out.println((char)b);
        }
        output("调用 get()",buffer);
        buffer.clear();
        output("调用 clear()",buffer);
        //关闭管道
        fin.close();
    }
    //position - limit
    private static void output(String step, Buffer buffer){
        System.out.println(step+" : ");
        System.out.print("position： "+buffer.position()+", ");
        System.out.print("limit： "+buffer.limit()+", ");
        System.out.println("capacity： "+buffer.capacity()+", ");
    }
}
