package panda.li.leavemanage.service;

import org.iti.rdbms.base.BaseService;

import panda.li.leavemanage.json.LeaveInfoJson;

public interface LeaveManageService extends BaseService {

	// 下载我的请假信息
	public LeaveInfoJson loadLeaveInfoJson(String userCode, Long time);

	// 下载需审批的请假信息
	public LeaveInfoJson LoadApprovalLeaveInfoJson(int approval, Long time);

}
