package com.aladdin.io.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 *
 * @author lgc
 */
public class DirectBufferAction {
    public static void main(String[] args) throws Exception {
        String inFile="/Users/lgc/Desktop/plc.txt";
        FileInputStream fin = new FileInputStream(inFile);
        FileChannel finChannel = fin.getChannel();

        String outFile="/Users/lgc/Desktop/out.txt";
        FileOutputStream out = new FileOutputStream(outFile);
        FileChannel outChannel = out.getChannel();

        ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
        while (true){
            buffer.clear();
            int read = finChannel.read(buffer);
            if (read==-1){
                break;
            }
            buffer.flip();
            outChannel.write(buffer);
        }
    }
}
