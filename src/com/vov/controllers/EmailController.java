package com.vov.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vov.pojos.Billing;

@RestController
@RequestMapping("/email")
@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")
public class EmailController {
	
	@Autowired
	private JavaMailSender sender;
	@RequestMapping(method=RequestMethod.POST)
	public String processForm(@RequestBody Billing b)
	{
		System.out.println(b.getCemail()+"  "+b.getMsg());
		SimpleMailMessage mesg=new SimpleMailMessage();
		mesg.setTo(b.getCemail());
		mesg.setSubject("Regarding Booking Service");
		mesg.setText(b.getMsg());
		sender.send(mesg);
		return "sent-mail";
	}
}
