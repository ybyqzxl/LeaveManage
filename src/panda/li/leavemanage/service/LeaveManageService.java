package panda.li.leavemanage.service;

import org.iti.rdbms.base.BaseService;

import panda.li.leavemanage.json.LeaveInfoJson;

public interface LeaveManageService extends BaseService {

	// �����ҵ������Ϣ
	public LeaveInfoJson loadLeaveInfoJson(String userCode, Long time);

	// �����������������Ϣ
	public LeaveInfoJson LoadApprovalLeaveInfoJson(int approval, Long time);

}
