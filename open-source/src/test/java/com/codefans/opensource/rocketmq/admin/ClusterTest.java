package com.codefans.opensource.rocketmq.admin;

import com.codefans.opensource.rocketmq.RocketmqBase;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.remoting.exception.RemotingConnectException;
import org.apache.rocketmq.remoting.exception.RemotingSendRequestException;
import org.apache.rocketmq.remoting.exception.RemotingTimeoutException;
import org.junit.Test;

/**
 * @author: codefans
 * @date: 2019-07-02 17:48
 */
public class ClusterTest extends RocketmqBase {

    @Test
    public void clusterListTest() {

        try {
            String namesrvAddr = NAMESRV_ADDR;
            ClusterTool clusterTool = new ClusterTool();
            clusterTool.queryClusterListBaseInfo(namesrvAddr);

//            clusterTool.queryClusterListMoreStats(namesrvAddr);


        } catch (MQClientException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (MQBrokerException e) {
            e.printStackTrace();
        } catch (RemotingTimeoutException e) {
            e.printStackTrace();
        } catch (RemotingSendRequestException e) {
            e.printStackTrace();
        } catch (RemotingConnectException e) {
            e.printStackTrace();
        }

    }

}
