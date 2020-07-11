package com.aladdin.io.nio;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author lgc
 */
public class NioReadAction {

    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("/Users/lgc/Desktop/plc.txt");
        FileChannel channel = fis.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        channel.read(buffer);
        buffer.flip();
        while (buffer.hasRemaining()){
            System.out.print((char)buffer.get());
        }
        fis.close();
    }
}

