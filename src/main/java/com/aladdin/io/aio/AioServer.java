package com.aladdin.io.aio;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * AIO 服务器
 *
 * @author lgc
 */
@Slf4j
public class AioServer {
    private final int port;

    public static void main(String args[]) {
        int port = 8000;
        new AioServer(port);
    }

    public AioServer(int port) {
        this.port = port;
        listen();
    }

    private synchronized void listen() {
        try {
            ExecutorService executorService = Executors.newCachedThreadPool();
            AsynchronousChannelGroup threadGroup = AsynchronousChannelGroup.withCachedThreadPool(executorService, 1);
            final AsynchronousServerSocketChannel server = AsynchronousServerSocketChannel.open(threadGroup);
            server.bind(new InetSocketAddress(port));
            System.out.println("服务已启动,监听端口：" + port);
            server.accept(null, new CompletionHandler<AsynchronousSocketChannel, Object>() {
                        final ByteBuffer buffer = ByteBuffer.allocateDirect(1024);

                        @Override
                        public void completed(AsynchronousSocketChannel result, Object attachment) {
                            System.out.println("I/O 操作成功，开始获取数据");
                            try {
                                log.info("before read {}",buffer.mark());
                                Integer integer = result.read(buffer).get();
                                log.info("computation result: "+integer);
                                log.info("before flip {}",buffer.mark());
                                buffer.flip();
                                log.info("after flip  {}",buffer.mark());
                                result.write(buffer);
                                log.info("after write {}",buffer.mark());
                                buffer.flip();
                                log.info("after flip  {}",buffer.mark());
                            } catch (Exception e) {
                                System.out.println(e);
                            } finally {
                                try {
                                    result.close();
                                    server.accept(null, this);
                                } catch (Exception e) {
                                    System.out.println(e);
                                }
                            }
                            System.out.println("操作完成");
                        }

                        @Override
                        public void failed(Throwable exc, Object attachment) {
                            System.out.println("I/O 操作失败：" + exc);
                        }
                    }
            );
            try {
                Thread.sleep(Integer.MAX_VALUE);
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
