package panda.li.leavemanage.action.abstracthttp;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;

import panda.li.leavemanage.action.util.Const;

public abstract class LeaveManageHttpInterfaceAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	// protected Object responResult;
	protected String responResult = Const.REQ_SUCCESS;
	protected String responInfo = "";

	public abstract String getResponState();

	public abstract String getResponResult();

	protected String responState = Const.REQ_SUCCESS;

	public boolean isEmpity(String str) {
		return str == null || str.trim().length() == 0;
	}

	public static Date str2Date(String str) {
		if (str == null || str.length() == 0) {
			return null;
		}
		Date date = null;
		try {
			SimpleDateFormat sdf = format;
			date = sdf.parse(str);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}

}
