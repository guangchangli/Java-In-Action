package com.aladdin.io.nio;

import java.nio.IntBuffer;

/**
 * @author lgc
 */
public class IntBufferAction {
    public static void main(String[] args) {
        //分配 int 类型缓冲区，参数为缓冲区容量
        //新缓冲区的当前位置将为 0,界限为容量大小，具有一个底层实现数组，数组偏移量是 0
        IntBuffer buffer = IntBuffer.allocate(8);
        for (int i = 0; i < buffer.capacity(); i++) {
            int j=2*(i+1);
            buffer.put(j);
        }
        //重设 buffer 将限制位置设置为当前位置，然后将当前位置设置为 0
        buffer.flip();
        //查看在当前位置和限制位置之间是否有数据
        while (buffer.hasRemaining()){
            int i = buffer.get();
            System.out.print(i+" ");
        }
    }
}
