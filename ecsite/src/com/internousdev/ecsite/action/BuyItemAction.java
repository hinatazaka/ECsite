package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class BuyItemAction extends ActionSupport implements SessionAware{
	private int count;
	private String pay;
	public Map<String,Object>session;
	private String ErrorMessage;

	public String execute(){
		String result=SUCCESS;
		session.put("count", count);
		int intCount=Integer.parseInt(session.get("count").toString());
		int intPrice=Integer.parseInt(session.get("buyItem_price").toString());
		int itemstock=Integer.parseInt(session.get("item_s").toString());
		session.put("total_price",intCount * intPrice);
		String payment;
		if(count>itemstock) {
			setErrorMessage("在庫が足りません。");
			result=ERROR;
		    return result;
		}else if(pay.equals("1")){
			payment="現金払い";
			session.put("pay",payment);
		}else{
			payment="クレジットカード";
			session.put("pay", payment);
		}
		return result;
	}
	public int getCount() {
		return count;
	}
	public String getPay() {
		return pay;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	public void setCount(int count){
		this.count=count;
	}
	public void setPay(String pay){
		this.pay=pay;
	}
	@Override
	public void setSession(Map<String,Object>session){
		this.session=session;
	}
	public String getErrorMessage() {
		return ErrorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		ErrorMessage = errorMessage;
	}


}
