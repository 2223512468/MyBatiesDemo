package com.jajahome.test;

import com.jajahome.mapper.OrdersMapper;
import com.jajahome.po.OrdersCustom;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class OrderCustomTest {

    // 会话工厂
    private SqlSessionFactory sqlSessionFactory;

    // 创建工厂
    @Before
    public void init() throws IOException {

        // 配置文件（SqlMapConfig.xml）
        String resource = "SqlMapConfig.xml";
        // 加载配置文件到输入 流
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 创建会话工厂
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

    }


    @Test
    public void testFindOrderUserList() throws Exception {

        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 创建mapper代理对象
        OrdersMapper ordersMapper = sqlSession
                .getMapper(OrdersMapper.class);

        // 调用方法////
        List<OrdersCustom> list = ordersMapper.findOrderUserList();
        System.out.println(list);
    }

}
