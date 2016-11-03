package com.demo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.demo.dao.RentDao;
import com.demo.gecco.htmlBean.ChuZhuBean;
import com.demo.service.RentService;

@Service("rentService")
public class RentServiceImpl implements  RentService{

	@Resource
	RentDao rentDao;

	@Override
	public Integer insert(ChuZhuBean bean) {
		return rentDao.insert(bean);
	}

	@Override
	public List<ChuZhuBean> findAll() {
		return rentDao.findAll();
	}

	@Override
	public List<ChuZhuBean> findByExample(ChuZhuBean bean) {
		return rentDao.findByExample(bean);
	}
}
