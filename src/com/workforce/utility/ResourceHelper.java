package com.workforce.utility;

import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.workforce.models.CompanyModel;

public class ResourceHelper {

	public static String getPropertyValue(String propertyFileName, String propertyKeyName){

		Properties properties = new Properties();
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		String propertyValue = "";

		try {
			properties.load(classLoader.getResourceAsStream("/" + propertyFileName + ".properties"));
			propertyValue = properties.getProperty(propertyKeyName);
		} catch (Exception e) {
			// TODO: handle exception
			propertyValue = e.getMessage();
			e.printStackTrace();
			System.out.println("Cannot get property file.");
		}
		return propertyValue;
	}

	public static List<?> getJsonList(String jsonFileName){

		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		
		ObjectMapper objectMapper = new ObjectMapper();
		List<?> list = null;
		
		try (InputStream is = classLoader.getResourceAsStream("/" + jsonFileName + ".json");) {
			
			if(jsonFileName.equals("companies")){
				list = objectMapper.readValue(is, new TypeReference<List<CompanyModel>>(){});
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("Cannot get json file.");
		}
		return list;
	}
	
	public static InputStream getFileAsInputStream(String filename){
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		
		InputStream inputStream = classLoader.getResourceAsStream("/" + filename);
		return inputStream;
	}

}
