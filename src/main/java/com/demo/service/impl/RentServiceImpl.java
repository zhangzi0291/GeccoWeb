package com.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.demo.dao.RentDao;
import com.demo.entity.RentEntity;
import com.demo.gecco.htmlBean.ChuZhuBean;
import com.demo.service.RentService;

@Service("rentService")
public class RentServiceImpl implements  RentService{

//	@Resource
//	RentDao rentDao;

	@Override
	public Integer insert(ChuZhuBean bean) {
		RentEntity.setList(bean);
		return 1;
	}

	@Override
	public List<ChuZhuBean> findAll() {
		return RentEntity.rentList;
	}

//	@Override
//	public List<ChuZhuBean> findByExample(ChuZhuBean bean) {
//		return rentDao.findByExample(bean);
//	}

	@Override
	public List<String> findAllDetailId() {
		List<String> list=new ArrayList<>();
		for(ChuZhuBean bean:RentEntity.rentList){
			list.add(bean.getDetailId());
		}
		return list;
	}
}
