package com.star.sud.web.controller;

/*
 * @Author Sudarshan
 */
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.star.sud.StarUtil;

@Controller
public class StarLoginController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String loginPage(Model model, HttpServletRequest request) {

		String clientIpAddress = StarUtil.getClientIPAddress(request);
		String currentSystemIp = StarUtil.getCurrentSystenIPAddress(request);

		if (!currentSystemIp.equals(clientIpAddress) && !clientIpAddress.contains("127.0.0")) {
			model.addAttribute("clientIPAddress", clientIpAddress);
		}

		model.addAttribute("currentIpAddress", currentSystemIp);

		return "login/login-page";
	}

}
