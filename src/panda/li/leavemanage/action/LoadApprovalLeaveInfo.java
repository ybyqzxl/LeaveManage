package panda.li.leavemanage.action;

import javax.annotation.Resource;

import org.iti.common.util.JsonUtil;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import panda.li.leavemanage.action.abstracthttp.LeaveManageHttpInterfaceAction;
import panda.li.leavemanage.action.util.Const;
import panda.li.leavemanage.json.LeaveInfoJson;
import panda.li.leavemanage.service.LeaveManageService;

@Controller("LoadApprovalLeaveInfo")
@Scope("prototype")
public class LoadApprovalLeaveInfo extends LeaveManageHttpInterfaceAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int approval;
	private long time;

	@Resource(name = "leaveManageService")
	private LeaveManageService leaveManageService;

	@Override
	public String execute() throws Exception {
		if (isEmpity(Integer.toString(approval))) {
			responState = Const.REQ_ERROR;
		} else {
			LeaveInfoJson leaveInfoJson = new LeaveInfoJson();
			leaveInfoJson = leaveManageService.LoadApprovalLeaveInfoJson(approval, time);
			responResult = JsonUtil.toJson(leaveInfoJson);
		}
		return ActionSupport.SUCCESS;
	}

	public void setApproval(int approval) {
		this.approval = approval;
	}

	public void setTime(long time) {
		this.time = time;
	}

	@Override
	public String getResponState() {
		return responState;
	}

	@Override
	public String getResponResult() {
		return responResult;
	}

}
