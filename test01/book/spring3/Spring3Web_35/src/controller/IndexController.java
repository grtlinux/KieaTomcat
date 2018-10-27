package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import logic.Item;
import logic.Shop;
import logic.User;
import utils.WebConstants;

@Controller
public class IndexController {

	@Autowired
	private Shop shopService;
	
	@RequestMapping
	public ModelAndView index(HttpSession session) {
		List<Item> itemList = this.shopService.getItemList();
		
		Map<String, Object> model = new HashMap<>();
		model.put("itemList", itemList);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addAllObjects(model);
		
		User loginUser = (User) session.getAttribute(WebConstants.USER_KEY);
		if (loginUser != null) {
			modelAndView.addObject("loginUser", loginUser);
		}
		
		return modelAndView;
	}
}
