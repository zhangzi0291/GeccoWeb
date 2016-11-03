package com.demo.service;

import java.util.List;

import com.demo.gecco.htmlBean.ChuZhuBean;

public interface RentService {

	Integer insert(ChuZhuBean bean);
	List<ChuZhuBean> findAll();
	List<ChuZhuBean> findByExample(ChuZhuBean bean);
}
