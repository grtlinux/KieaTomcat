package sample.spring.chapter10.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sample.spring.chapter10.service.FixedDepositService;

@Controller
@RequestMapping(value = "/fixedDeposit")
public class FixedDepositController {

	@Autowired
	private FixedDepositService fixedDepositService;
	
	/////////////////////////////////////////////////////////
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView listFixedDeposits() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("list", this.fixedDepositService.getFixedDetails());
		return new ModelAndView("fixedDepositList", model);
	}
}
