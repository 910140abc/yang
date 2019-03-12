package tw.com.liwei.register.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tw.com.liwei.register.model.MemberBean;

@Repository
public class MemberDaoImpl implements MemberDao {
	@Autowired
	SessionFactory factory;

	public MemberDaoImpl() {
		
	}

	@Override
	public MemberBean queryMember(String accountId) {
		Session session = factory.getCurrentSession();
		String hql = "FROM MemberBean WHERE accountId =:id";
		MemberBean bean = (MemberBean) session.createQuery(hql)
											  .setParameter("id", accountId)
											  .getSingleResult();
		return bean;
	}

	@Override
	public void addMember(MemberBean bean) {
		Session session = factory.getCurrentSession();
		session.save(bean);
	}

	@Override
	public void updateMember(MemberBean bean) {
		Session session = factory.getCurrentSession();
		session.saveOrUpdate(bean);
	}

	@Override
	public boolean isExist(String accountId) {
		Session session = factory.getCurrentSession();
		String hql = "FROM MemberBean WHERE accountId =:id";
		MemberBean bean = (MemberBean) session.createQuery(hql)
											  .setParameter("id", accountId)
											  .getSingleResult();
		if(bean!=null) { return true; }
		return false;
	}

	@Override
	public MemberBean checkPassword(String accountId, String password) {
		Session session = factory.getCurrentSession();
		String hql = "FROM MemberBean WHERE accountId =:id";
		MemberBean bean = (MemberBean) session.createQuery(hql)
										 .setParameter("id", accountId)
										 .getSingleResult();
		
		return bean;
	}

}
