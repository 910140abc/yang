package tw.com.liwei.register.dao;

import tw.com.liwei.register.model.MemberBean;

public interface MemberDao {
	MemberBean queryMember(String accountId);
	boolean isExist(String accountId);
	void addMember(MemberBean bean);
	void updateMember(MemberBean bean);
	MemberBean checkPassword(String accountId,String password);
}
