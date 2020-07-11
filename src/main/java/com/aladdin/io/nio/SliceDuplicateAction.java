package com.aladdin.io.nio;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;

/**
 * 缓冲区分片 go_slice
 * 注意 slice 一定要确定 position limit 区间
 *
 * @author lgc
 */
public class SliceDuplicateAction {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        System.out.println(buffer.mark());
        for (int i = 0; i < buffer.capacity(); i++) {
            buffer.put((byte) i);
        }
        for (int i = 0; i < buffer.capacity(); i++) {
            System.out.println(buffer.get(i));
        }
        System.out.println(buffer.mark());
        buffer.flip();
        //创建子缓冲区
//        buffer.position(3);
//        buffer.limit(7);
        ByteBuffer slice = buffer.slice();
        System.out.println(buffer.mark());
        System.out.println(slice.mark());
        //改变子缓冲区内容
        for (int i = 0; i < slice.capacity(); i++) {
            byte b = slice.get(i);
            b *= 10;
            slice.put(i, b);
        }
//        buffer.flip();
        slice.flip();
        System.out.println("-----");
        System.out.println(buffer.mark());
//        buffer.position(0);
//        buffer.limit(buffer.capacity());
        while (buffer.hasRemaining()) {
            System.out.println(buffer.get());
        }
        ByteBuffer allocate = ByteBuffer.allocate(10);
        ByteBuffer duplicate = allocate.duplicate();
        ByteOrder byteOrder = ByteOrder.nativeOrder();
        System.out.println(byteOrder);//LITTLE_ENDIAN
        IntBuffer allocate1 = IntBuffer.allocate(10);
        allocate1.put(1);
        allocate1.clear();
    }
}
