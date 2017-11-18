package lesson1_ibatis.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Sergey Zhernovoy
 * create on 14.11.2017.
 */

public class MyBatisSqlSessionFactory {
    private static SqlSessionFactory sqlSessionFactory;
    public static SqlSessionFactory getSqlSessionFactory(){
        if(sqlSessionFactory == null){
            try(InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml")) {
                sqlSessionFactory = new SqlSessionFactoryBuilder()
                        .build(inputStream);
            } catch (IOException exc){
                throw new RuntimeException(exc.getCause());
            }
        }
        return sqlSessionFactory;
    }

    public static SqlSession openSession(){
        return  getSqlSessionFactory().openSession();
    }

}

    