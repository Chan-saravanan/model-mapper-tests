package com.tests.modelmappings.main;

import java.util.logging.Logger;

import org.modelmapper.Conditions;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MappingContext;

import com.tests.modelmappings.models.Destination1;
import com.tests.modelmappings.models.Role;
import com.tests.modelmappings.models.Source;

public class Main3 {
	private static final Logger logger = Logger.getLogger(Main3.class.getName());
	
	public static void main(String[] args) {
		Source source = new Source("001", "Test-fName","Test-lName","MANAGER");
		Source source2 = new Source("Test-fName","Test-lName",null);
		Destination1 destination = new Destination1();
		
		ModelMapper modelMapper = new ModelMapper();
		
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		Converter<String, Integer> stringToIntegerModelMappingConverter = new Converter<String, Integer>(){
			@Override
			public Integer convert(MappingContext<String, Integer> context) {
				return Integer.parseInt(context.getSource());
			}
		};
		
		Converter<String, Role> stringToRoleMappingConverter = new Converter<String, Role>(){
			@Override
			public Role convert(MappingContext<String, Role> context) {
				return new Role(context.getSource());
			}
		};
		
		TypeMap<Source, Destination1> typeMap = modelMapper.createTypeMap(Source.class, Destination1.class);
		
		typeMap.addMappings(mapper->{
			mapper
			.when(Conditions.isNotNull())
			.using(stringToIntegerModelMappingConverter)
			.map(Source::getId, Destination1::setDestId);
			
			mapper
			.when(Conditions.isNotNull())
			.using(stringToRoleMappingConverter)
			.map(Source::getRole, Destination1::setRole);
		});
		
		typeMap.getMappings().stream().forEach(mapping->logger.info(mapping.toString()));
		destination = modelMapper.map(source, Destination1.class);
		logger.info("destination1 : "+destination);
		
		destination = modelMapper.map(source2, Destination1.class);
		logger.info("destination2 : "+destination);
	}

}
