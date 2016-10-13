package panda.li.leavemanage.serviceimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.iti.rdbms.base.impl.BaseServiceImpl;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import panda.li.leavemanage.entity.LeaveInfo;
import panda.li.leavemanage.json.LeaveInfoJson;
import panda.li.leavemanage.service.LeaveManageService;

@Service("leaveManageService")
public class LeaveManageServiceImpl extends BaseServiceImpl implements LeaveManageService {

	private String sqlStr = null;

	@Override
	public LeaveInfoJson loadLeaveInfoJson(String userCode, Long time) {
		if (time <= 0) {
			time = System.currentTimeMillis();
		}
		sqlStr = String.format(
				"select * from LeaveInfo where userCode='%s' and state=0 and timestamp<='%s' order by timestamp desc limit 10",
				userCode, time);

		LeaveInfoJson leaveInfoJson = new LeaveInfoJson();
		List<LeaveInfo> list = this.getJdbcTemplate().query(sqlStr, new RowMapper<LeaveInfo>() {

			@Override
			public LeaveInfo mapRow(ResultSet arg0, int arg1) throws SQLException {
				return (LeaveInfo) loadEntityFromRDBMSById(LeaveInfo.class, arg0.getLong("id"));
			}

		});
		if (list != null) {
			leaveInfoJson.setLeaveInfos(list);
		} else {
			leaveInfoJson.setLeaveInfos(new ArrayList<LeaveInfo>());
		}
		return leaveInfoJson;
	}

	@Override
	public LeaveInfoJson LoadApprovalLeaveInfoJson(int approval, Long time) {
		if (time <= 0) {
			time = System.currentTimeMillis();
		}
		sqlStr = String.format(
				"select * from LeaveInfo where approval<='%s' and state=0 and timestamp<'%s' order by timestamp desc limit 10",
				approval, time);

		LeaveInfoJson leaveInfoJson = new LeaveInfoJson();
		List<LeaveInfo> list = this.getJdbcTemplate().query(sqlStr, new RowMapper<LeaveInfo>() {

			@Override
			public LeaveInfo mapRow(ResultSet arg0, int arg1) throws SQLException {
				return (LeaveInfo) loadEntityFromRDBMSById(LeaveInfo.class, arg0.getLong("id"));
			}

		});
		if (list != null) {
			leaveInfoJson.setLeaveInfos(list);
		} else {
			leaveInfoJson.setLeaveInfos(new ArrayList<LeaveInfo>());
		}
		return leaveInfoJson;
	}

}
