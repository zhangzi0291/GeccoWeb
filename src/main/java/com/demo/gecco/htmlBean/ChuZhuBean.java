package com.demo.gecco.htmlBean;

import com.geccocrawler.gecco.annotation.Href;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Image;
import com.geccocrawler.gecco.annotation.Text;
import com.geccocrawler.gecco.spider.HtmlBean;

public class ChuZhuBean implements HtmlBean{
	
	private static final long serialVersionUID = 3117365397519039492L;

	@Image
	@HtmlField(cssPath = "td.img > div > a > img")
	private String image;
	
	@Text
	@HtmlField(cssPath = "td.t.qj-rentd > a")
	private String title;
	
	@Href
	@HtmlField(cssPath = "td.t.qj-rentd > a")
	private String href;
	
	@Text
	@HtmlField(cssPath = "td:nth-child(3) > b")
	private String price;
	
	@Text
	@HtmlField(cssPath = ".showroom")
	private String type;

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "ChuZhuBean [image=" + image + ", title=" + title + ", href=" + href + ", price=" + price + ", type="
				+ type + "]";
	}
	
	
	
	
}
