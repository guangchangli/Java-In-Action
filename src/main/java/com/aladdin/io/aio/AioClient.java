package com.aladdin.io.aio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.TimeUnit;

/**
 * AIO client
 *
 * @author lgc
 */
public class AioClient {
    private final AsynchronousSocketChannel client;

    public AioClient() throws Exception {
        client = AsynchronousSocketChannel.open();
    }

    public void connect(String host, int port) throws InterruptedException {
        client.connect(new InetSocketAddress(host, port), null, new CompletionHandler<Void, Void>() {
                    @Override
                    public void completed(Void result, Void attachment) {
                        try {
                            System.out.println("client read to write");
                            client.write(ByteBuffer.wrap("测试数据".getBytes())).get();
                            System.out.println("已发送到服务器");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void failed(Throwable exc, Void attachment) {
                        exc.printStackTrace();
                    }
                }
        );
        TimeUnit.SECONDS.sleep(1);
        final ByteBuffer bb = ByteBuffer.allocate(1024);

        client.read(bb, null, new CompletionHandler<Integer, Object>() {
                    @Override
                    public void completed(Integer result, Object attachment) {
                        System.out.println("I/O 操作完成：" + result);
                        System.out.println("获取反馈结果：" + new String(bb.array()));
                    }

                    @Override
                    public void failed(Throwable exc, Object attachment) {
                        exc.printStackTrace();
                    }
                }
        );
        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
    }

    public static void main(String[] args) throws Exception {
        AioClient aioClient = new AioClient();
        aioClient.connect("localhost", 8000);
    }
}
