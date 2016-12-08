package com.demo.entity;

import java.util.ArrayList;
import java.util.List;

import com.demo.gecco.htmlBean.ChuZhuBean;

public class RentEntity {
	
	private RentEntity re;
	
	private RentEntity() {
	}
	public RentEntity getInstance(){
		if(re==null){
			re=new RentEntity();
		}
		return re;
	}
	
	public static List<ChuZhuBean> rentList=new ArrayList<>();
	
	public static void setList(ChuZhuBean bean){
		rentList.add(bean);
	}
}
