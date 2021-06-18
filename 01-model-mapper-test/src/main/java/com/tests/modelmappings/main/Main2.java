package com.tests.modelmappings.main;

import java.util.logging.Logger;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.modelmapper.convention.MatchingStrategies;

import com.tests.modelmappings.models.Destination1;
import com.tests.modelmappings.models.Source;

public class Main2 {

	private static final Logger logger = Logger.getLogger(Main2.class.getName());
	
	public static void main(String[] args) {
		Destination1 destination = new Destination1();
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		TypeMap<Source, Destination1> typeMap = modelMapper.createTypeMap(Source.class, Destination1.class);
		
		typeMap.getMappings().stream().forEach(mapping->logger.info(mapping.toString()));
		//logger.info("destination2 : "+destination);
	}

}
