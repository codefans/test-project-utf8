package com.codefans.opensource.netty.official.bytestreaming;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetAddress;
import java.net.InetSocketAddress;

/**
 * @Author: codefans
 * @Date: 2018-11-13 23:50
 */

public class SimpleNettyClient {

    private int port;

    public SimpleNettyClient(int port) {
        this.port = port;
    }


    public void startup() throws Exception {

        InetAddress inetAddress = InetAddress.getLocalHost();	//获得本机的InetAddress对象 ，回送IP地址
        String hostAddress = inetAddress.getHostAddress();
        System.out.println("hostAddress:" + hostAddress);

        String host = hostAddress;

        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            Bootstrap b = new Bootstrap(); // (1)
            b.group(workerGroup); // (2)
            b.channel(NioSocketChannel.class); // (3)
            b.option(ChannelOption.SO_KEEPALIVE, true); // (4)
            b.handler(new ChannelInitializer<SocketChannel>() {
                @Override
                public void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline().addLast(new SimpleClientHandler());
                }
            });

            // Start the client.
//            ChannelFuture f = b.connect(host, port).sync(); // (5)

            int msgCount = 5;
            for(int i = 0; i < msgCount; i ++) {
                ChannelFuture f = b.connect(new InetSocketAddress(host, port)); // (5)

                Channel channel = f.channel();
                if(channel.isActive()) {
                    channel.writeAndFlush("simple netty client:" + i);
                }
                f.channel().closeFuture().sync();
            }

            // Wait until the connection is closed.
//            f.channel().closeFuture().sync();
        } finally {
            workerGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws Exception {
        int port = 1688;
        if (args.length > 0) {
            port = Integer.parseInt(args[0]);
        }

        new SimpleNettyClient(port).startup();
    }

}
