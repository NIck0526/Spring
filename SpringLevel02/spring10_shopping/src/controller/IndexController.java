package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import logic.Item;
import logic.Shop;

//index.html�� ��û�� ������....IndexController�� ������ ���̴�.
public class IndexController implements Controller{

	private Shop shop;
	
	public void setShop(Shop shop) {
		this.shop = shop;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//�����Ͻ� ������ ȣ��....���ϵ� ���� ModelAndView�� ����...��� �������� ����
		
		List<Item> itemList=shop.findAll();
		return new ModelAndView("WEB-INF/jsp/index.jsp","itemList",itemList);
	}

}





















