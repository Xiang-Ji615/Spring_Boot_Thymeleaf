package main.java.spring.thymeleaf.dialect;

import java.util.HashSet;
import java.util.Set;

import org.thymeleaf.dialect.AbstractProcessorDialect;
import org.thymeleaf.processor.IProcessor;

import main.java.spring.thymeleaf.processor.HelloWorldProcessor;

public class HelloWorldDialect extends AbstractProcessorDialect{

	public HelloWorldDialect() {
		super("Hello World Dialect", "hello", 1000);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Set<IProcessor> getProcessors(String dialectPrefix) {
		// TODO Auto-generated method stub
		final Set<IProcessor> processors = new HashSet<IProcessor>();
        processors.add(new HelloWorldProcessor(dialectPrefix));
        return processors;
	}

}
