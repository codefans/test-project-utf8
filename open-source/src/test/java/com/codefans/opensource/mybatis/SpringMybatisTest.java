package com.codefans.opensource.mybatis;

import com.codefans.opensource.mybatis.dao.UserDOMapper;
import com.codefans.opensource.mybatis.domain.UserDO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author: codefans
 * @date: 2019-08-21 14:42
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:mybatis/spring-config-dao.xml"})
@TestPropertySource(properties={"env=dev"})
public class SpringMybatisTest {

    @Resource
    private UserDOMapper userDOMapper;

    private int batchNum;
    private UserDO userDO;

    @Before
    public void before() {
        batchNum = 10 * 10000;

        userDO = new UserDO();
        userDO.setId(1L);
        userDO.setAmount(1L);

    }

    @Test
    public void userUpdateTest() {

        int updateCount = userDOMapper.addAmount(userDO);
        System.out.println("updateCount=" + updateCount);

    }

    @Test
    public void hiKeriCPBatchTest() {

        long beginTime = System.currentTimeMillis();
        for(int i = 0; i < batchNum; i ++) {
            int updateCount = userDOMapper.addAmount(userDO);
            System.out.println("updateCount=" + updateCount);
        }
        long endTime = System.currentTimeMillis();
        //hiKeriCP cost:[1531]，单线程更新10万次，耗时1531秒，合计25.516666666666667分钟
        System.out.println("hiKeriCP cost:[" + (endTime - beginTime) / 1000 + "]");

    }

    @Test
    public void bonecpBatchTest() {

        long beginTime = System.currentTimeMillis();
        for(int i = 0; i < batchNum; i ++) {
            int updateCount = userDOMapper.addAmount(userDO);
            System.out.println("updateCount=" + updateCount);
        }
        long endTime = System.currentTimeMillis();
        //boneCP cost:[1714]，单线程更新10万次，耗时1714秒，合计约28.566666666666667分钟
        System.out.println("boneCP cost:[" + (endTime - beginTime) / 1000 + "]");

    }




}
