package com.app.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;

import com.app.util.EmailUtil;
@Component
public class ConsoleRunner implements CommandLineRunner {
	@Autowired
	private EmailUtil util;
@Override
public void run(String... args) throws Exception {
	
	FileSystemResource file=new FileSystemResource("C:\\Users\\dell\\Desktop\\rsm\\New folder\\ajit.pdf");
	
boolean status=	util.send("ajitsase@gmail.com", "hii", "how are you", file);
if(status)
{
	System.out.println("success");
}
else
{
	System.out.println("check problems");
}
}
}
