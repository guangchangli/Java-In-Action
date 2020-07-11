package com.aladdin.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * BIO 面向流 处理是一个字节一个字节的处理
 * NIO 面向缓冲区 处理单位是块
 * @author lgc
 */
public class SelectorAction {
    static private final int PORT = 8000;
    static private Selector selector;
    static private ByteBuffer buffer = ByteBuffer.allocateDirect(1024 * 1024);

    public static void main(String[] args) {

    }

    /**
     * 注册事件
     */
    static private Selector getSelector() throws IOException {
        Selector sel = Selector.open();
        //创建可选择通道，并配置为非阻塞模式
        ServerSocketChannel server = ServerSocketChannel.open();
        server.configureBlocking(false);
        //绑定通道到指定端口
        ServerSocket socket = server.socket();
        InetSocketAddress address = new InetSocketAddress(PORT);
        socket.bind(address);

        //向 Selector 注册事件
        server.register(sel, SelectionKey.OP_ACCEPT);
        return sel;
    }

    /**
     * 开始监听
     */
    static public void listen() {
        System.out.println("listen on : " + PORT);
        try {
            while (true) {
                //该调用会阻塞，知道至少一个事件发生
                selector.select();
                Set<SelectionKey> keys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = keys.iterator();
                while (iterator.hasNext()) {
                    SelectionKey next = iterator.next();
                    iterator.remove();
                    process(next);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 判断接受的请求是读数据还是写事件，分别做不同的处理
     * @param key
     * @throws IOException
     */
    private static void process(SelectionKey key) throws IOException {
        //接受请求
        if (key.isAcceptable()) {
            ServerSocketChannel server = (ServerSocketChannel) key.channel();
            SocketChannel channel = server.accept();
            channel.configureBlocking(false);
            channel.register(selector, SelectionKey.OP_READ);
        } else
            // 读数据
            if (key.isReadable()) {
                SocketChannel channel = (SocketChannel) key.channel();
                int len = channel.read(buffer);
                if (len > 0) {
                    buffer.flip();
                    String content = new String(buffer.array(), 0, len);
                    SelectionKey sKey = channel.register(selector, SelectionKey.OP_WRITE);
                    sKey.attach(content);
                } else {
                    channel.close();
                }
                buffer.clear();
            } else if (key.isWritable()) {
                SocketChannel channel = (SocketChannel) key.channel();
                String attach = (String) key.attachment();
                ByteBuffer block = ByteBuffer.wrap(("输出内容：" + attach).getBytes());
                if (block != null) {
                    channel.write(block);
                } else {
                    channel.close();
                }
            }
    }
}
