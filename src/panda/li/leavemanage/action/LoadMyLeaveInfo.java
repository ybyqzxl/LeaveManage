package panda.li.leavemanage.action;

import javax.annotation.Resource;

import org.iti.common.util.JsonUtil;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

import panda.li.leavemanage.action.abstracthttp.LeaveManageHttpInterfaceAction;
import panda.li.leavemanage.action.util.Const;
import panda.li.leavemanage.json.LeaveInfoJson;
import panda.li.leavemanage.service.LeaveManageService;

@Controller("LoadMyLeaveInfo")
@Scope("prototype")
public class LoadMyLeaveInfo extends LeaveManageHttpInterfaceAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String userCode;
	private long time;
	@Resource(name = "leaveManageService")
	private LeaveManageService leaveManageService;

	@Override
	public String execute() throws Exception {
		if (isEmpity(userCode)) {
			return Const.REQ_PARAMS_ERR;
		} else {
			LeaveInfoJson leaveInfoJson = leaveManageService.loadLeaveInfoJson(userCode, time);
			// responResult = leaveInfoJson;//JsonUtil.toJson(leaveInfoJson);
			responResult = JsonUtil.toJson(leaveInfoJson);
			// System.out.println(responResult);

		}
		return ActionSupport.SUCCESS;
	}

	@Override
	public String getResponState() {
		return responState;
	}

	@Override
	public String getResponResult() {
		return responResult;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	// @Override
	// public Object getResponResult() {
	// // TODO Auto-generated method stub
	// return responResult;
	// }

}
