package com.infy.reducer.datacompressor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xerial.snappy.Snappy;

import com.infy.reducer.dataconverter.DataConverter;
import com.infy.reducer.entity.Person;

@Service
public class DataCompressorImpl implements DataCompressor<Person> {
	@Autowired
	DataConverter<Person> dataConverter ;
	
	public byte[] compress(Person person) throws Exception{	
		
		byte[] jsonData = dataConverter.javaObjectToJson(person).getBytes() ;
		return Snappy.compress(jsonData);
		
	}
	public Person decompress(byte[] compressedData) throws Exception {
		
		byte[] decompressedData = Snappy.uncompress(compressedData) ;
		String jsonData = new String(decompressedData) ;		
		return dataConverter.jsonToJavaObject(jsonData) ;
	}
}
