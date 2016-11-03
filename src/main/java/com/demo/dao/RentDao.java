package com.demo.dao;

import java.util.List;

import com.demo.gecco.htmlBean.ChuZhuBean;

public interface RentDao {
	Integer insert(ChuZhuBean bean);
	List<ChuZhuBean> findAll();
	List<String> findAllDetailId();
	List<ChuZhuBean> findByExample(ChuZhuBean bean);
}
