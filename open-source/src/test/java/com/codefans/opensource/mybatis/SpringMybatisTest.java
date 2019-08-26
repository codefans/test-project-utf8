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

    private long hiKeriCPCost;
    private long bonecpCost;
    private long druidCost;
    private long c3p0Cost;
    private long dbcpCost;
    private long dbcp2Cost;

    @Before
    public void before() {
        batchNum = 10 * 10000;
//        batchNum = 10000;

        userDO = new UserDO();
        userDO.setId(1L);
        userDO.setAmount(1L);

    }

    @Test
    public void userUpdateTest() {

        int updateCount = userDOMapper.addAmount(userDO);
        System.out.println("updateCount=" + updateCount);

    }

    /**
     * spring-config-dao.xml文件中SqlSessionFactoryBean的
     * dataSource设置为dataSourceHikari
     */
    @Test
    public void hiKeriCPBatchTest() {

        long beginTime = System.currentTimeMillis();
        this.update();
        long endTime = System.currentTimeMillis();
        hiKeriCPCost = (endTime - beginTime) / 1000;
        //hiKeriCP cost:[1531]，单线程更新10万次，耗时1531秒，合计25.516666666666667分钟
        //hiKeriCP cost:[154s]，单线程更新10万次，耗时154秒，合计2.57分钟
        System.out.println("hiKeriCP cost:[" + hiKeriCPCost + "s]");

    }

    /**
     * spring-config-dao.xml文件中SqlSessionFactoryBean的
     * dataSource设置为bonecpDataSource
     */
    @Test
    public void bonecpBatchTest() {

        long beginTime = System.currentTimeMillis();
        this.update();
        long endTime = System.currentTimeMillis();
        bonecpCost = (endTime - beginTime) / 1000;
        //boneCP cost:[1714]，单线程更新10万次，耗时1714秒，合计约28.566666666666667分钟
        //boneCP cost:[330s]，单线程更新1万次，耗时330秒，合计约5.5分钟
        System.out.println("boneCP cost:[" + bonecpCost + "s]");

    }

    /**
     * spring-config-dao.xml文件中SqlSessionFactoryBean的
     * dataSource设置为c3p0DataSource
     */
    @Test
    public void c3p0BatchTest() {

        long beginTime = System.currentTimeMillis();
        this.update();
        long endTime = System.currentTimeMillis();
        c3p0Cost = (endTime - beginTime) / 1000;
        //c3p0 cost:[1621s]，单线程更新10万次，耗时1621秒，合计约27.02分钟
        //c3p0 cost:[184s]，单线程更新1万次，耗时184秒，合计约3.01分钟
        System.out.println("c3p0 cost:[" + c3p0Cost + "s]");

    }

    /**
     * spring-config-dao.xml文件中SqlSessionFactoryBean的
     * dataSource设置为druidDataSource
     */
    @Test
    public void druidBatchTest() {

        long beginTime = System.currentTimeMillis();
        this.update();
        long endTime = System.currentTimeMillis();
        druidCost = (endTime - beginTime) / 1000;
        //druid cost:[1983s]，单线程更新10万次，耗时1983秒，合计约33.05分钟
        //druid cost:[194s]，单线程更新1万次，耗时194秒，合计约3.23分钟
        System.out.println("druid cost:[" + druidCost + "s]");

    }

    /**
     * spring-config-dao.xml文件中SqlSessionFactoryBean的
     * dataSource设置为dbcpDataSource
     */
    @Test
    public void dbcpBatchTest() {

        long beginTime = System.currentTimeMillis();
        this.update();
        long endTime = System.currentTimeMillis();
        dbcpCost = (endTime - beginTime) / 1000;
        //dbcp cost:[267s]，单线程更新1万次，耗时267秒，合计约4.45分钟
        System.out.println("dbcp cost:[" + dbcpCost + "s]");

    }

    /**
     * spring-config-dao.xml文件中SqlSessionFactoryBean的
     * dataSource设置为dbcp2DataSource
     */
    @Test
    public void dbcp2BatchTest() {

        long beginTime = System.currentTimeMillis();
        this.update();
        long endTime = System.currentTimeMillis();
        dbcp2Cost = (endTime - beginTime) / 1000;
        //dbcp2 cost:[397s]，单线程更新1万次，耗时397秒，合计约6.62分钟
        System.out.println("dbcp2 cost:[" + dbcp2Cost + "s]");

    }



    @Test
    public void allBatchTest() {


    }

    public void printAllCost() {

    }

    public void update() {
        for(int i = 0; i < batchNum; i ++) {
            int updateCount = userDOMapper.addAmount(userDO);
            System.out.println("updateCount=" + updateCount);
        }
    }



}
