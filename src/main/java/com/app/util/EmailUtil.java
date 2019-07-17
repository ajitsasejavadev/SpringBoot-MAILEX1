package com.app.util;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
@Component
public class EmailUtil {
     @Autowired
	private JavaMailSender mailSender;
     public boolean send(String to,String sub,String text,FileSystemResource file)
     {
    	 boolean  flag=false;
    	 try {
    	 
    	MimeMessage msg= mailSender.createMimeMessage();
    	MimeMessageHelper help=new MimeMessageHelper(msg, file!=null?true:false);
    	
			help.setTo(to);
			help.setSubject(sub);
			help.setText(text);
			if(file!=null)
				help.addAttachment(file.getFilename(),file);
			
			//4. send button
			mailSender.send(msg);
			
			flag=true;
		} catch (MessagingException e) {
			flag=false;
			e.printStackTrace();
		}
    	
    	 return flag;
     }
}
