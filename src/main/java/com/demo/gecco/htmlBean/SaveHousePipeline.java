package com.demo.gecco.htmlBean;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.demo.service.RentService;
import com.geccocrawler.gecco.pipeline.Pipeline;

@Service
public class SaveHousePipeline implements Pipeline<ChuZhuBean>{

	@Resource
	private RentService rentService;
	
	@Override
	public void process(ChuZhuBean bean) {
		System.out.println(bean);
		List<String> detailList = rentService.findAllDetailId();
		if(detailList.contains(bean.getDetailId())){
			return;
		}
		rentService.insert(bean);
	}



}
