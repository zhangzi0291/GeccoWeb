package com.demo.gecco.htmlBean;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.demo.service.RentService;
import com.geccocrawler.gecco.pipeline.Pipeline;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.scheduler.DeriveSchedulerContext;

@Service("nextPagePipeline")
public class NextPagePipeline implements Pipeline<ChuZhuPageBean>{

	@Resource(name="rentService")
	private RentService rentService;
	
	@Override
	public void process(ChuZhuPageBean bean) {
		try {
			List<ChuZhuBean> list = bean.getChuzhu();
			System.out.println(list.size());
//			for(int i=0;i<list.size();i++){
//				List<ChuZhuBean> rentList = rentService.findByExample(list.get(i));
//				if(rentList!=null && rentList.size()>0){
//					continue;
//				}else{
//					rentService.insert(list.get(i));
//				}
//			}
			HttpRequest currRequest=bean.getRequest();
			
			Integer currPage = bean.getCurrPage();
			Integer nextPage = currPage + 1;
			Integer totalPage = 2;
			
			if(nextPage <= totalPage) {
			    String nextUrl = "";
			    String currUrl = currRequest.getUrl();
			    if(currUrl.indexOf("pn") != -1) {
			        nextUrl = StringUtils.replaceOnce(currUrl, "pn" + currPage, "pn" + nextPage);
			    } else {
			        nextUrl = currUrl + "/pn" + nextPage;
			    }
			    System.out.println("当前URL："+currUrl);
			    System.out.println("下一页URL："+nextUrl);
			    DeriveSchedulerContext.into(currRequest.subRequest(nextUrl));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
