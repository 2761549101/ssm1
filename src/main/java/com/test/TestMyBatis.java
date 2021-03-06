package com.test;

import com.mapper.AccountDao;
import com.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * @ClassName TestMyBatis
 * @Description TODO
 * @Auther Google
 * @Date 2019/4/23 9:12
 * @Version 1.0
 */
public class TestMyBatis {
    /**
     * 测试查询
     * @throws Exception
     */
    @Test
    public void run1() throws Exception {
        /*加载配置文件*/
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        /*创建SqlSessionFactory对象*/
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        /*创建SqlSession对象*/
        SqlSession session = factory.openSession();
        /*获取代理对象*/
        AccountDao dao = session.getMapper(AccountDao.class);
        /*查询所有数据*/
        List<Account> list = dao.findAll();
        for (Account account : list) {
            System.out.println(account);
        }
        /*关闭资源*/
        session.close();
        inputStream.close();
    }
    @Test
    public void run2() throws Exception {
        Account account=new Account();
        account.setName("小乔");
        account.setMoney(1582d);
        /*加载配置文件*/
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        /*创建SqlSessionFactory对象*/
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        /*创建SqlSession对象*/
        SqlSession session = factory.openSession();
        /*获取代理对象*/
        AccountDao dao = session.getMapper(AccountDao.class);
        /*保存*/
        dao.saveAccount(account);
        /*提交事务*/
        session.commit();
        /*关闭资源*/
        session.close();
        inputStream.close();
    }
}
