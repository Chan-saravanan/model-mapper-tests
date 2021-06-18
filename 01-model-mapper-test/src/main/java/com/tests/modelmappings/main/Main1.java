package com.tests.modelmappings.main;

import java.util.logging.Logger;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.modelmapper.convention.MatchingStrategies;

import com.tests.modelmappings.models.Destination;
import com.tests.modelmappings.models.Destination1;
import com.tests.modelmappings.models.Source;

public class Main1 {
	private static final Logger logger = Logger.getLogger(Main1.class.getName());
	public static void main(String[] args) {
		Source source = new Source("001", "Test-fName","Test-lName","MANAGER");
		Destination destination = null;
		ModelMapper modelMapper = null;
		
		modelMapper = new ModelMapper();
		destination = modelMapper.map(source, Destination.class);
		logger.info("destination1 : ".concat(destination.toString()));
		
		modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		destination = modelMapper.map(source, Destination.class);
		logger.info("destination2 : ".concat(destination.toString()));
		
		modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		destination = modelMapper.map(source, Destination.class);
		logger.info("destination3 : ".concat(destination.toString()));
		
		Destination1 destination1 = new Destination1();
		modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		destination1 = modelMapper.map(source, Destination1.class);
		logger.info("destination4 : ".concat(destination1.toString()));
		
		logger.info("************************************************");
		modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		TypeMap<Source,Destination> typeMap1 = modelMapper.createTypeMap(Source.class, Destination.class);
		typeMap1.addMappings(mapper->{
			mapper.<String>map(Source::getId, Destination::setDestId);
		});
		logger.info("Type Map1 : "+typeMap1.getMappings());
		destination = modelMapper.map(source, Destination.class);
		logger.info("destination5 : ".concat(destination.toString()));
	}
}
