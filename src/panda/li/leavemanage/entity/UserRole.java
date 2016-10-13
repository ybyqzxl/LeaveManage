package panda.li.leavemanage.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.iti.common.util.GlobeKeyBuilder;
import org.iti.entity.db.rdbms.interfaces.IRdbmsEntity;

@Entity
@Table(name = "UserRole")
public class UserRole implements IRdbmsEntity {

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
	private int userRole; // 0��ͨ��ɫ 1����������Ա 2�쵼������Ա

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

	public int getUserRole() {
		return userRole;
	}

	public void setUserRole(int userRole) {
		this.userRole = userRole;
	}

}
