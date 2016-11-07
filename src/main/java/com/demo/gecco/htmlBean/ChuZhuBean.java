package com.demo.gecco.htmlBean;

import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.Href;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Image;
import com.geccocrawler.gecco.annotation.Request;
import com.geccocrawler.gecco.annotation.RequestParameter;
import com.geccocrawler.gecco.annotation.Text;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.HtmlBean;


@Gecco(matchUrl = {"http://nj.58.com/zufang/{detailId}.shtml?version={version}&psid={psid}&entinfo={entinfo}","http://nj.58.com/hezu/{detailId}.shtml?version={version}&psid={psid}&entinfo={entinfo}"},pipelines="saveHousePipeline")
public class ChuZhuBean implements HtmlBean{
	
	private static final long serialVersionUID = 3117365397519039492L;
	
	@RequestParameter
	private String detailId;
	
	@RequestParameter
	private String version;
	
	@RequestParameter
	private String psid;
	
	@RequestParameter
	private String entinfo;
	
	
	@Request
	private HttpRequest request;
	
	@Text
	@HtmlField(cssPath = "h1.main-title.font-heiti")
	private String mainTitle;
	
	@Text
	@HtmlField(cssPath = "div > i > em")
	private String housePrice;
	
	@Text
	@HtmlField(cssPath = "div.house-primary-content-wrap.fr > ul > li:nth-child(2) > div")
	private String houseType;

	@Text
	@HtmlField(cssPath = "div.xiaoqu>a:nth-child(1) ")
	private String area1;
	
	@Text
	@HtmlField(cssPath = "div.xiaoqu>a:nth-child(2) ")
	private String area2;
	
	@Text
	@HtmlField(cssPath = "div.xiaoqu>a:nth-child(3) ")
	private String area3;
	
	@Image
	@HtmlField(cssPath = "#xtu_1 > img ")
	private String img1;
	
	@Image
	@HtmlField(cssPath = "#xtu_2 > img ")
	private String img2;
	
	@Image
	@HtmlField(cssPath = "#xtu_3 > img ")
	private String img3;
	
	@Image
	@HtmlField(cssPath = "#xtu_4 > img ")
	private String img4;

	@Text
	@HtmlField(cssPath = "div.house-primary-content-wrap.fr > ul > li:nth-child(4) > div")
	private String address;

	@Text
	@HtmlField(cssPath = "li.house-primary-content-li.house-primary-content-fir.clearfix > div > span")
	private String payMethod;
	
	private String equipment;
	
	private String longitude;
	
	private String latitude;
	
	private String url;

	public String getDetailId() {
		return detailId;
	}

	public void setDetailId(String detailId) {
		this.detailId = detailId;
	}

	public String getMainTitle() {
		return mainTitle;
	}

	public void setMainTitle(String mainTitle) {
		this.mainTitle = mainTitle;
	}

	public String getHousePrice() {
		return housePrice;
	}

	public void setHousePrice(String housePrice) {
		this.housePrice = housePrice;
	}

	public String getHouseType() {
		return houseType;
	}

	public void setHouseType(String houseType) {
		this.houseType = houseType;
	}

	public String getArea1() {
		return area1;
	}

	public void setArea1(String area1) {
		this.area1 = area1;
	}

	public String getArea2() {
		return area2;
	}

	public void setArea2(String area2) {
		this.area2 = area2;
	}

	public String getArea3() {
		return area3;
	}

	public void setArea3(String area3) {
		this.area3 = area3;
	}

	public String getImg1() {
		return img1;
	}

	public void setImg1(String img1) {
		this.img1 = img1;
	}

	public String getImg2() {
		return img2;
	}

	public void setImg2(String img2) {
		this.img2 = img2;
	}

	public String getImg3() {
		return img3;
	}

	public void setImg3(String img3) {
		this.img3 = img3;
	}

	public String getImg4() {
		return img4;
	}

	public void setImg4(String img4) {
		this.img4 = img4;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEquipment() {
		return equipment;
	}

	public void setEquipment(String equipment) {
		this.equipment = equipment;
	}

	public HttpRequest getRequest() {
		return request;
	}

	public void setRequest(HttpRequest request) {
		this.request = request;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getPsid() {
		return psid;
	}

	public void setPsid(String psid) {
		this.psid = psid;
	}

	public String getEntinfo() {
		return entinfo;
	}

	public void setEntinfo(String entinfo) {
		this.entinfo = entinfo;
	}

	public String getPayMethod() {
		return payMethod;
	}

	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "ChuZhuBean [detailId=" + detailId + ", version=" + version + ", psid=" + psid + ", entinfo=" + entinfo
				+ ", request=" + request + ", mainTitle=" + mainTitle + ", housePrice=" + housePrice + ", houseType="
				+ houseType + ", area1=" + area1 + ", area2=" + area2 + ", area3=" + area3 + ", img1=" + img1
				+ ", img2=" + img2 + ", img3=" + img3 + ", img4=" + img4 + ", address=" + address + ", payMethod="
				+ payMethod + ", equipment=" + equipment + ", longitude=" + longitude + ", latitude=" + latitude
				+ ", url=" + url + "]";
	}

	


	
	
}
