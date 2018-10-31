package sample.spring.chapter10.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import sample.spring.chapter10.domain.FixedDepositDetails;
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
		model.put("fdList", this.fixedDepositService.getFixedDetails());
		return new ModelAndView("fixedDepositList", model);
	}
	
	@RequestMapping(params = "fdAction=createFDForm", method = RequestMethod.POST)
	public ModelAndView showOpenFixedDepositForm() {
		FixedDepositDetails fixedDepositDetails = new FixedDepositDetails();
		fixedDepositDetails.setEmail("You must enter a valid email");
		ModelMap modelData = new ModelMap();
		modelData.addAttribute(fixedDepositDetails);
		return new ModelAndView("createFixedDepositForm", modelData);
	}
	
	@RequestMapping(params = "fdAction=create", method = RequestMethod.POST)
	public ModelAndView openFixedDeposit(@RequestParam Map<String, String> params) {
		String depositAmount = params.get("depositAmount");
		String tenure = params.get("tenure");
		String email = params.get("email");
		
		Map<String, Object> model = new HashMap<String, Object>();
		
		if (!NumberUtils.isNumber(depositAmount)) {
			model.put("error.depositAmount", "enter a valid number");
		} else if (NumberUtils.toInt(depositAmount) < 1000) {
			model.put("error.depositAmount", "must be greater than or equal to 1000");
		}
		
		if (!NumberUtils.isNumber(tenure)) {
			model.put("error.tenure", "enter a valid number");
		} else if (NumberUtils.toInt(tenure) < 12) {
			model.put("error.tenure", "must be greater than or equal to 12");
		}
		
		if (email == null || "".equals(email)) {
			model.put("error.email", "must not be blank");
		} else if (!email.contains("@")) {
			model.put("error.email", "not a well-formed email.address");
		}
		
		FixedDepositDetails fixedDepositDetails = new FixedDepositDetails();
		fixedDepositDetails.setDepositAmount(depositAmount);
		fixedDepositDetails.setTenure(tenure);
		fixedDepositDetails.setEmail(email);
		
		if (model.size() > 0) {
			// error and reform
			model.put("fixedDepositDetails", fixedDepositDetails);
			return new ModelAndView("createFixedDepositForm", model);
		} else {
			this.fixedDepositService.saveFixedDeposit(fixedDepositDetails);
			return new ModelAndView("redirect:/fixedDeposit/list");
		}
	}
	
	@RequestMapping(params = "fdAction=edit", method = RequestMethod.POST)
	public ModelAndView editFixedDeposit(@RequestParam MultiValueMap<String, String> params) {
		
		String depositAmount = params.get("depositAmount").get(0);
		String tenure = params.get("tenure").get(0);
		String email = params.get("email").get(0);
		String id = params.get("id").get(0);
		
		Map<String, Object> model = new HashMap<String, Object>();

		if (!NumberUtils.isNumber(depositAmount)) {
			model.put("error.depositAmount", "enter a valid number");
		} else if (NumberUtils.toInt(depositAmount) < 1000) {
			model.put("error.depositAmount", "must be greater than or equal to 1000");
		}
		
		if (!NumberUtils.isNumber(tenure)) {
			model.put("error.tenure", "enter a valid number");
		} else if (NumberUtils.toInt(tenure) < 12) {
			model.put("error.tenure", "must be greater than or equal to 12");
		}
		
		if (email == null || "".equals(email)) {
			model.put("error.email", "must not be blank");
		} else if (!email.contains("@")) {
			model.put("error.email", "not a well-formed email.address");
		}
		
		FixedDepositDetails fixedDepositDetails = new FixedDepositDetails();
		fixedDepositDetails.setId(Integer.parseInt(id));
		fixedDepositDetails.setDepositAmount(depositAmount);
		fixedDepositDetails.setTenure(tenure);
		fixedDepositDetails.setEmail(email);
		
		if (model.size() > 0) {
			model.put("fixedDepositDetails", fixedDepositDetails);
			return new ModelAndView("editFixedDepositForm", model);
		} else {
			this.fixedDepositService.editFixedDeposit(fixedDepositDetails);
			return new ModelAndView("redirect:/fixedDeposit/list");
		}
	}
	
	@RequestMapping(params = "fdAction=close", method = RequestMethod.GET)
	public String closeFixedDeposit(@RequestParam(value = "fixedDepositId") int fdId) {
		this.fixedDepositService.closeFixedDeposit(fdId);
		return "redirect:/fixedDeposit/list";
	}
	
	@RequestMapping(params = "fdAction=view", method = RequestMethod.GET)
	public ModelAndView viewFixedDepositDetails(HttpServletRequest request) {
		int fixedDepositId = Integer.parseInt(request.getParameter("fixedDepositId"));
		FixedDepositDetails fixedDepositDetails = this.fixedDepositService.getFixedDeposit(fixedDepositId);
		ModelMap modelMap = new ModelMap();
		modelMap.addAttribute(fixedDepositDetails);
		return new ModelAndView("editFixedDepositForm", modelMap);
	}
	
	@ExceptionHandler
	public String handleException(Exception e) {
		return "error";
	}
}
