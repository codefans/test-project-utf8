package org.apache.rocketmq.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import org.apache.rocketmq.client.remoting.ChannelWrapper;
import org.apache.rocketmq.client.remoting.common.RemotingHelper;

/**
 * @author: codefans
 * @date: 2018-10-04 10:04
 */
public class RocketMQClient {

    public static void main(String[] args) {
        RocketMQClient rocketMQClient = new RocketMQClient();
        rocketMQClient.nettyClient();
    }

    public void nettyClient() {

        Bootstrap bootstrap = new Bootstrap();
        String addr = "localhost:9876";
        ChannelFuture channelFuture = bootstrap.connect(RemotingHelper.string2SocketAddress(addr));
        System.out.println("createChannel: begin to connect remote host[{}] asynchronously" + addr);
        ChannelWrapper cw = new ChannelWrapper(channelFuture);

        Channel channel = null;

        if (cw != null) {
            ChannelFuture cnlFuture = cw.getChannelFuture();
            if (cnlFuture.awaitUninterruptibly(1000*3)) {
                if (cw.isOK()) {
                    System.out.println("createChannel: connect remote host[{}] success, {}" + addr + channelFuture.toString());
                    channel = cw.getChannel();


                    if (channel != null && channel.isActive()) {

//                        RemotingCommand response = this.invokeSyncImpl(channel, request, timeoutMillis - costTime);

//                        channel.writeAndFlush(request).addListener(new ChannelFutureListener() {
//                            @Override
//                            public void operationComplete(ChannelFuture f) throws Exception {
//                                if (f.isSuccess()) {
//                                    System.out.println("send request success");
//                                    return;
//                                } else {
//                                    System.out.println("send request fail");
//                                }
//
//                            }
//                        });
                    } else {
                        RemotingHelper.closeChannel(channel);
                    }


                } else {
                    System.out.println("createChannel: connect remote host[" + addr + "] failed, " + channelFuture.toString() + channelFuture.cause());
                }
            } else {
                System.out.println("createChannel: connect remote host[{}] timeout {}ms, {}" + addr + 3*1000 + channelFuture.toString());
            }
        }


    }

}
