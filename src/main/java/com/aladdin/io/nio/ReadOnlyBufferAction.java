package com.aladdin.io.nio;

import java.nio.ByteBuffer;

/**
 * 只读缓冲区 throws ReadOnlyBufferException
 * @author lgc
 */
public class ReadOnlyBufferAction {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        for (int i = 0; i < buffer.capacity(); i++) {
            buffer.put((byte)i);
        }
        //创建只读缓冲区
        ByteBuffer readOnly = buffer.asReadOnlyBuffer();

        for (int i = 0; i < readOnly.capacity(); i++) {
            byte b = buffer.get(i);
            b*=10;
            buffer.put(i,b);
        }
        readOnly.position(0);
        System.out.println(readOnly.mark());
        while (readOnly.hasRemaining()){
            System.out.println(readOnly.get());
        }
    }
}
