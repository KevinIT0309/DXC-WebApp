package com.techzone.springmvc.util;

import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class UUIDUtil {
	
	public String generatorUUID() {
		
		UUID uuid = UUID.randomUUID();
        String randomUUIDString = uuid.toString();
        System.out.println("[ Random UUID String for file : " + randomUUIDString + " ]");
        return randomUUIDString;
	}

}
