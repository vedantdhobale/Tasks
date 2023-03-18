package com;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@Controller
public class QueryController {
	
	@Autowired
	private QueryService queryService;
	
	/*
	 * @GetMapping("/query") public String showReport(@RequestParam String query,
	 * Model model) {
	 * 
	 * List<Map<String, Object>> result = employeeService.getQueryReport(query);
	 * model.addAttribute("result", result); return "report"; }
	 */
	
	

	@GetMapping("/report")
	public String showReport( Model model) {
	    
		String query="Select * from employees";
	    List<Map<String, Object>> result = queryService.getQueryReport(query);
	    
	    model.addAttribute("result", result);
	    
	    return "report";
	}

}
