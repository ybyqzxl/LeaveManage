package panda.li.leavemanage.action;

import javax.annotation.Resource;

import org.iti.common.util.EncodeUtil;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import panda.li.leavemanage.action.abstracthttp.LeaveManageHttpInterfaceAction;
import panda.li.leavemanage.action.util.Const;
import panda.li.leavemanage.entity.LeaveInfo;
import panda.li.leavemanage.service.LeaveManageService;

@Controller("PublishLeaveInfosAction")
@Scope("prototype")
public class PublishLeaveInfosAction extends LeaveManageHttpInterfaceAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String userCode;
	private String userName;
	private String userDepart;
	private String leaveWhy;
	private String startTime;
	private String endTime;
	private String leaveInfo;
	private int approval = 0;// 0未审批 1部门审批 2领导审批 approval = 0默认未审批状态

	private int isSucceed = 0; // 0假期中 1假期完成 默认为0

	@Resource(name = "leaveManageService")
	private LeaveManageService leaveManageService;

	@Override
	public String execute() throws Exception {
		try {
			if (isEmpity(userCode) || isEmpity(userName) || isEmpity(userDepart) || isEmpity(leaveWhy)
					|| isEmpity(startTime) || isEmpity(endTime) || isEmpity(leaveInfo)) {
				return responState = Const.REQ_PARAMS_ERR;
			} else {

				LeaveInfo info = new LeaveInfo();
				info.setUserCode(userCode);
				info.setUserName(userName);
				info.setUserDepart(userDepart);
				info.setStartTime(startTime);
				info.setEndTime(endTime);
				info.setLeaveInfo(leaveInfo);
				info.setLeaveWhy(leaveWhy);
				info.setApproval(approval);
				info.setIsSucceed(isSucceed);
				leaveManageService.saveEntityToRDBMS(info);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ActionSupport.ERROR;
		}
		return ActionSupport.SUCCESS;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public void setUserName(String userName) {
		this.userName = EncodeUtil.decodeHex2Str(userName);
	}

	public void setUserDepart(String userDepart) {
		this.userDepart = EncodeUtil.decodeHex2Str(userDepart);
	}

	public void setLeaveWhy(String leaveWhy) {
		this.leaveWhy = EncodeUtil.decodeHex2Str(leaveWhy);
	}

	public void setStartTime(String startTime) {
		this.startTime = EncodeUtil.decodeHex2Str(startTime);
	}

	public void setEndTime(String endTime) {
		this.endTime = EncodeUtil.decodeHex2Str(endTime);
	}

	public void setLeaveInfo(String leaveInfo) {
		this.leaveInfo = EncodeUtil.decodeHex2Str(leaveInfo);
	}

	@Override
	public String getResponState() {
		return responState;
	}

	// @Override
	// public Object getResponResult() {
	// return responResult;
	// }

	@Override
	public String getResponResult() {
		return responResult;
	}

}
