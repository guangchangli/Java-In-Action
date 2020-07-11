package com.aladdin.io.nio;

import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author lgc
 */
public class NioWriteAction {
    private static final byte MESSAGE[] = {83, 111, 109, 101, 32, 98, 121, 116,101,115,46};

    public static void main(String[] args) throws IOException {
        FileOutputStream fOut = new FileOutputStream("/Users/lgc/Desktop/plc.txt");
        FileChannel outChannel = fOut.getChannel();
        FileDescriptor fd = fOut.getFD();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        for (int i = 0; i < MESSAGE.length; i++) {
            buffer.put(MESSAGE[i]);
        }
        buffer.flip();
        outChannel.write(buffer);
        fOut.close();
    }
}
