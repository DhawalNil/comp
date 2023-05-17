package com.infy.reducer.dataconverter;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.infy.reducer.entity.Person;

@Service
public class DataConverterImpl implements DataConverter<Person>  {
	public static final ObjectMapper objectMapper = new ObjectMapper() ;
	
	public Person jsonToJavaObject(String jsonData) throws Exception{	
		return objectMapper.readValue(jsonData, Person.class) ;	
	}
	public String javaObjectToJson(Person person) throws Exception{
		System.out.println(person) ;
		return objectMapper.writeValueAsString(person) ;
	}
}
