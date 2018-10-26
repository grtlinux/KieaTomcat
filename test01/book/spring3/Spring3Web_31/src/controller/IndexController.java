package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import logic.Item;
import logic.Shop;

public final class IndexController implements Controller {

	private Shop shopService;
	
	public void setShopService(Shop shopService) {
		this.shopService = shopService;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Item> itemList = this.shopService.getItemList();
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("itemList", itemList);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/WEB-INF/jsp/index.jsp");
		modelAndView.addAllObjects(model);
		
		return modelAndView;
	}
}
