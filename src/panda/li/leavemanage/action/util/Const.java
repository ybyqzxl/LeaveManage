package panda.li.leavemanage.action.util;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicBoolean;

import org.iti.common.cache.CommonCache;
import org.iti.common.util.GlobeKeyBuilder;
import org.iti.common.util.PropertiesLoader;
import org.iti.common.util.StringConvert;
import org.iti.security.vo.AuthUserInfo;

public class Const implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6701723075449783248L;

	public static AtomicBoolean DEBUG = new AtomicBoolean(false);

	public static final String REQ_SUCCESS = "REQ_SUCCESS";
	public static final String REQ_ERROR = "REQ_ERROR";
	public static final String REQ_VERIFY_SUCCESS = "REQ_VERIFY_SUCCESS";
	public static final String REQ_VERIFY_ERR = "REQ_VERIFY_ERR";
	public static final String REQ_USERPWD_ERR = "REQ_USERPWD_ERR";
	public static final String REQ_USERNAME_ERR = "REQ_USERNAME_ERR";
	public static final String REQ_TIMEOUT = "REQ_TIMEOUT";
	public static final String REQ_PARAMS_ERR = "REQ_PARAMS_ERR";
	public static final String REQ_UNKNOWN_ERR = "REQ_UNKNOWN_ERR";
	public static final String REGISTER_NO_USER = "REGISTER_NO_USER";
	public static final String REGISTER_DEPT_ERROR = "REGISTER_DEPT_ERROR";
	public static final String REGISTER_IDCARD_ERROR = "REGISTER_IDCARD_ERROR";
	public static final String REGISTER_EXISTENCE = "REGISTER_EXISTENCE";
	public static final String REGISTER_SUCCESS = "REGISTER_SUCCESS";
	public static final String NO_REGISTER = "NO_REGISTER";
	public static final String NO_PERMISSION = "NO_PERMISSION";
	public static final String USER_INEFFECTIVE = "USER_INEFFECTIVE";
	public static final String STATIC_PARAMS = "StaticParams";
	public static final String REQ_TIMEOUT_LIMIT_KEY = "REQ_TIMEOUT_LIMIT";
	public static final long REQ_TIMEOUT_LIMIT = Long.parseLong(
			PropertiesLoader.getPropertiesValue(REQ_TIMEOUT_LIMIT_KEY, STATIC_PARAMS)) * StringConvert.SECOND;

	public static final boolean checkTimeout(Long timeStamp) {
		return timeStamp == null ? false : ((System.currentTimeMillis() - timeStamp - Const.REQ_TIMEOUT_LIMIT) > 0);
	}

	public static final AuthUserInfo getAuthUserInfo(String userName) {
		String key = GlobeKeyBuilder.keyBuilder(AuthUserInfo.class, userName);
		AuthUserInfo userInfo = (AuthUserInfo) CommonCache.getCacheClient().get(key);
		return userInfo;
	}
}
