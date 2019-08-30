package com.internousdev.ecsite.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemListDAO;
import com.internousdev.ecsite.dao.LoginDAO;
import com.internousdev.ecsite.dto.ItemInfoDTO;
import com.internousdev.ecsite.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {
	private String loginUserId;
	private String loginPassword;
	public Map<String, Object> session;
	private LoginDAO loginDAO = new LoginDAO();
	private LoginDTO loginDTO = new LoginDTO();
//	private BuyItemDAO buyItemDAO = new BuyItemDAO();
	private String itemName;

	public String execute() {

		String result = ERROR;
		loginDTO = loginDAO.getLoginUserInfo(loginUserId, loginPassword);
		session.put("loginUser", loginDTO);

		if (loginDTO.getLoginFlg()) {
			//リストの精製
			ArrayList<ItemInfoDTO> list = new ArrayList<>();
			//itemListDAOを使えるようにインスタンス化
			ItemListDAO itemListDAO = new ItemListDAO();
			list = itemListDAO.getItemListInfo();
			//変数listをsessionに入れれる
			session.put("buyItemList", list);
			session.put("itemName",itemName);
			session.put("login_user_id", loginDTO.getLoginId());
			//管理者でログインする
			if ((loginDTO.getAdminFlg() != null)&& (loginDTO.getAdminFlg().equals("1"))) {
				session.put("login_user_id", loginDTO.getLoginId());
				result = "admin";
			} else {
				result = SUCCESS;
     		}
		}
		return result;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public String getLoginUserId() {
		return loginUserId;
	}

	public void setLoginUserId(String loginUserId) {
		this.loginUserId = loginUserId;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
