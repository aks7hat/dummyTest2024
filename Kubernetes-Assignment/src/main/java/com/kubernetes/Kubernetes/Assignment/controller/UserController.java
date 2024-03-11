package com.kubernetes.Kubernetes.Assignment.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kubernetes.Kubernetes.Assignment.entity.User;

import org.springframework.ui.Model;


@Controller
@RequestMapping("/home")
public class UserController {
	
	@Value("${application.password}")
	private String applicationPassword;
	
	@Value("${application.name}")
	private String applicationName;
	
	@Value("${application.connectionstring}")
	private String connectionString;
	
	@Value("${application.environment}")
	private String applicationEnvironment;
	
	@GetMapping("/form")
	public String inputForm() {
		return "form";
	}
	
    @PostMapping("/submit")
    public String submitForm(User userForm, Model model) {
        String resultText = String.format(
                "Submitted Information:\nFirst Name: %s\n, Last Name: %s\n, Email: %s\n, Age: %d",
                userForm.getFirstName(), userForm.getLastName(), userForm.getEmail(), userForm.getAge()
        );
        model.addAttribute("resultText", resultText);
        return "result";
    }
    
    @GetMapping("/getEnv")
    @ResponseBody
    public Map<String, String> getEnvVariables() {
        Map<String, String> configMap = new HashMap<>();
        configMap.put("Application_Password", applicationPassword);
        configMap.put("Application_Environment", applicationEnvironment);
        configMap.put("Application_Name", applicationName);
        configMap.put("Application_ConnectionString", connectionString);
        return configMap;
    }

}
