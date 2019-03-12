package tw.com.liwei.register.service;

import tw.com.liwei.register.model.MemberBean;

public interface MemberService {
	boolean checkPassword(String accountId,String passwrod);
	void addMember(MemberBean bean);
	void updateMember(MemberBean bean);
	boolean isAccountIdExist(String accountId);
}
