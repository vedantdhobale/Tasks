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
	
	
	
	

	@GetMapping("/report/{tableName}")
	public String showReport(@PathVariable String tableName, Model model) {
	    
		String query="Select * from "+tableName;
		System.out.println("Select * from "+tableName);
	    List<Map<String, Object>> result = queryService.getQueryReport(query);
	    
	    model.addAttribute("result", result);
	    
	    return "report";
	}

}
