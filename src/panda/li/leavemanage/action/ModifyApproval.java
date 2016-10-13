package panda.li.leavemanage.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import panda.li.leavemanage.action.abstracthttp.LeaveManageHttpInterfaceAction;
import panda.li.leavemanage.action.util.Const;
import panda.li.leavemanage.entity.LeaveInfo;
import panda.li.leavemanage.service.LeaveManageService;

@Controller("ModifyApproval")
@Scope("prototype")
public class ModifyApproval extends LeaveManageHttpInterfaceAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;
	private int approval;

	@Resource(name = "leaveManageService")
	private LeaveManageService leaveManageService;

	@Override
	public String execute() throws Exception {
		if (isEmpity(Integer.toString(approval)) || isEmpity(Long.toString(id))) {
			responState = Const.REQ_ERROR;
		} else {
			LeaveInfo leaveInfo = (LeaveInfo) leaveManageService.loadEntityFromRDBMSById(LeaveInfo.class, id);
			leaveInfo.setApproval(approval);
			leaveManageService.updateEntityToRDBMS(leaveInfo);
		}
		return ActionSupport.SUCCESS;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setApproval(int approval) {
		this.approval = approval;
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
