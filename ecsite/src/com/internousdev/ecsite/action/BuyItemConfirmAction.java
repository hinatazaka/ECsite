package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemConfirmAction extends ActionSupport implements SessionAware{
	public Map<String,Object>session;
	private BuyItemCompleteDAO buyItemCompleteDAO=new BuyItemCompleteDAO();
	public String execute()throws SQLException{
		int count=buyItemCompleteDAO.buyItemInfo(
				session.get("id").toString(),
				session.get("login_user_id").toString(),
				session.get("total_price").toString(),
				session.get("count").toString(),
				session.get("pay").toString(),
				session.get("itemName").toString());
		if(count>0) {
			buyItemCompleteDAO.UpdateItemStock(Integer.parseInt(session.get("count").toString()),session.get("id").toString());
		}
		String result=SUCCESS;
		return result;
	}
	public BuyItemCompleteDAO getBuyItemCompleteDAO() {
		return buyItemCompleteDAO;
	}
	public void setBuyItemCompleteDAO(BuyItemCompleteDAO buyItemCompleteDAO) {
		this.buyItemCompleteDAO = buyItemCompleteDAO;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	@Override
	public void setSession(Map<String,Object>session){
		this.session=session;
	}
}
