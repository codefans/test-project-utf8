package org.apache.rocketmq.client.remoting;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;

/**
 * @author: ShengzhiCai
 * @date: 2018-10-04 10:13
 */
public class ChannelWrapper {

    private final ChannelFuture channelFuture;

    public ChannelWrapper(ChannelFuture channelFuture) {
        this.channelFuture = channelFuture;
    }

    public boolean isOK() {
        return this.channelFuture.channel() != null && this.channelFuture.channel().isActive();
    }

    public boolean isWritable() {
        return this.channelFuture.channel().isWritable();
    }

    public Channel getChannel() {
        return this.channelFuture.channel();
    }

    public ChannelFuture getChannelFuture() {
        return channelFuture;
    }


}