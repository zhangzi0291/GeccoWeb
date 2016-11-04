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
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		List<String> detailList = rentService.findAllDetailId();
		if(detailList.contains(bean.getDetailId())){
			return;
		}
		if((bean.getArea3()==null||bean.getArea2()==null)&&bean.getAddress()==null){
			return;
		}
		rentService.insert(bean);
	}



}
