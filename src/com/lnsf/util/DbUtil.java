package com.lnsf.util;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DbUtil {
	public static SqlSession getSession(){
		SqlSession session=null;
		try{
			String resource="conf.xml";
			Reader reader=Resources.getResourceAsReader(resource);
			SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(reader);			
			session=sessionFactory.openSession();
		}catch(Exception e){
			e.printStackTrace();
		}
		return session;
	}
}
