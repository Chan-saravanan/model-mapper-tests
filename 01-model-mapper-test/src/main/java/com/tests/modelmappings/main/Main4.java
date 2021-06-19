package com.tests.modelmappings.main;

import java.util.Objects;
import java.util.logging.Logger;

import org.modelmapper.Condition;
import org.modelmapper.Conditions;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.Provider;
import org.modelmapper.TypeMap;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MappingContext;

import com.tests.modelmappings.models.Destination1;
import com.tests.modelmappings.models.Role;
import com.tests.modelmappings.models.Source;

public class Main4 {
	
	private static final Logger logger = Logger.getLogger(Main4.class.getName());
	
	public static void main(String[] args) {
		Source source = new Source("111","Test-fName","Test-lName","Normal");
		Destination1 destination = new Destination1();
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		Condition<String, Integer> idCondtion = conditionContext-> Objects.nonNull(conditionContext.getSource()) &&  conditionContext.getSource().matches("\\d+");
		Converter<String, Integer> idConverter = converter-> Integer.parseInt(converter.getSource());
		
		Converter<String, Role> roleConverter = converter->new Role(converter.getSource());
		
		TypeMap<Source, Destination1> typeMap = modelMapper.createTypeMap(Source.class, Destination1.class).addMappings(mapper->{
			mapper.when(idCondtion).using(idConverter).<Integer>map((src)-> src.getId(), (dest, data)-> dest.setDestId(data));
			mapper.using(roleConverter).<Role>map(src-> src.getRole(), (dest, role)-> dest.setRole(role));
		});
		
		typeMap.map(source, destination);
		logger.info("destination :"+destination);
	}
}
