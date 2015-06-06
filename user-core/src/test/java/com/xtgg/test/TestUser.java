package com.xtgg.test;

import org.hibernate.Session;
import org.junit.Assert;
import org.junit.Test;

import com.xtgg.hibernate.util.HibernateUtil;
import com.xtgg.vo.User;

public class TestUser {

	@Test
	public void testAdd() {
		Session session = HibernateUtil.openSession();
		session.beginTransaction();

		User u = new User();
		u.setEmail("opqrst@163.com");
		u.setUsername("admin");
		u.setPassword("123456");
		u.setNickname("monkey");

		session.save(u);

		session.getTransaction().commit();
	}

	@Test
	public void testLoad() {
		Session session = HibernateUtil.openSession();
		session.beginTransaction();

		User u = (User) session.load(User.class, 1);

		Assert.assertEquals(1, u.getId());

		session.getTransaction().commit();
	}
}
