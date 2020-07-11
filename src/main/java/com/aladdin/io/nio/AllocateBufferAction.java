package com.aladdin.io.nio;

import java.nio.ByteBuffer;

/**
 * 创建缓冲区
 * @author lgc
 */
public class AllocateBufferAction {
    public static void main(String[] args) {
        ByteBuffer allocate = ByteBuffer.allocate(10);
        ByteBuffer buffer = ByteBuffer.allocateDirect(10);
        //支持链式
        buffer.put((byte)1).put((byte)2);
        ByteBuffer wrap = ByteBuffer.wrap("123".getBytes());
        ByteBuffer wrap1 = ByteBuffer.wrap("123".getBytes(), 0, 3);
    }
}
