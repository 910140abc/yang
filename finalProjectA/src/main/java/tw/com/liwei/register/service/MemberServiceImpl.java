package tw.com.liwei.register.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.com.liwei.register.dao.MemberDao;
import tw.com.liwei.register.model.MemberBean;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	MemberDao dao;
	
	@Override
	public boolean checkPassword(String accountId, String passwrod) {
		// TODO Auto-generated method stub
		return false;
	}

	@Transactional
	@Override
	public void addMember(MemberBean bean) {
		dao.addMember(bean);
	}

	@Override
	public void updateMember(MemberBean bean) {
		dao.updateMember(bean);
	}

	@Override
	public boolean isAccountIdExist(String accountId) {
		MemberBean bean = dao.queryMember(accountId);
		if(bean!=null) return true;
		return false;
	}

}
