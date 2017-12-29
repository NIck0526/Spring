package ibatis.services.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import ibatis.services.domain.Item;
import ibatis.services.item.Shop;

//index.html�� ��û�� ������....IndexController�� ������ ���̴�.
public class IndexController implements Controller{

	private Shop shop;
	
	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List<Item> itemList = shop.findItemList();
		return new ModelAndView("WEB-INF/jsp/index.jsp","itemList",itemList);
	}

}





















