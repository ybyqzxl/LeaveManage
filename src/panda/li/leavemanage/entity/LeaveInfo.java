package panda.li.leavemanage.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.iti.common.util.GlobeKeyBuilder;
import org.iti.entity.db.rdbms.interfaces.IRdbmsEntity;

@Entity
@Table(name = "LeaveInfo")
public class LeaveInfo implements IRdbmsEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	/**
	 * ʱ���
	 */
	@Column
	private Long timeStamp;
	/**
	 * ʵ��״̬ 0������1������֮��ľ����ݣ�2ɾ��
	 */
	@Column
	private Integer state;
	/**
	 * ��ʷid
	 */
	@Column
	private Long historyId;

	@Column
	private String userCode;
	@Column
	private String userName;
	@Column
	private String userDepart;
	@Column
	private String leaveWhy;
	@Column
	private String startTime;
	@Column
	private String endTime;
	@Column
	private String leaveInfo;
	@Column
	private int approval;// 0δ���� 1�������� 2�쵼����  3���
	@Column
	private int isSucceed; // ������

	@Override
	public String getGlobeId() {
		return GlobeKeyBuilder.keyBuilder(getClass(), id);
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public Long getTimeStamp() {
		return timeStamp;
	}

	@Override
	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}

	@Override
	public Integer getState() {
		return state;
	}

	@Override
	public void setState(Integer state) {
		this.state = state;
	}

	@Override
	public Long getHistoryId() {
		return historyId;
	}

	@Override
	public void setHistoryId(Long historyId) {
		this.historyId = historyId;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserDepart() {
		return userDepart;
	}

	public void setUserDepart(String userDepart) {
		this.userDepart = userDepart;
	}

	public String getLeaveWhy() {
		return leaveWhy;
	}

	public void setLeaveWhy(String leaveWhy) {
		this.leaveWhy = leaveWhy;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getLeaveInfo() {
		return leaveInfo;
	}

	public void setLeaveInfo(String leaveInfo) {
		this.leaveInfo = leaveInfo;
	}

	public int getApproval() {
		return approval;
	}

	public void setApproval(int approval) {
		this.approval = approval;
	}

	public int getIsSucceed() {
		return isSucceed;
	}

	public void setIsSucceed(int isSucceed) {
		this.isSucceed = isSucceed;
	}

}
