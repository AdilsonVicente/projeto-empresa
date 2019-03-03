package analiseskillus.com.br.thymeleaf;

import java.util.HashSet;
import java.util.Set;

import org.thymeleaf.dialect.AbstractProcessorDialect;
import org.thymeleaf.processor.IProcessor;
import org.thymeleaf.standard.StandardDialect;

import analiseskillus.com.br.thymeleaf.processor.ClassForErrorAtributeTagProcessor;
import analiseskillus.com.br.thymeleaf.processor.MenuAttributeTagProcessor;
import analiseskillus.com.br.thymeleaf.processor.MessageElementTagProcessor;
import analiseskillus.com.br.thymeleaf.processor.OrderElementTagProcessor;
import analiseskillus.com.br.thymeleaf.processor.PaginatioElementTagProcessor;

public class SkillusDialect extends AbstractProcessorDialect{

	public SkillusDialect() {
		super("Analise Skillus", "skillus", StandardDialect.PROCESSOR_PRECEDENCE);
	}
	
	@Override
	public Set<IProcessor> getProcessors(String dialectPrefix) {
		final Set<IProcessor> processadores = new HashSet<>();
		processadores.add(new ClassForErrorAtributeTagProcessor(dialectPrefix));
		processadores.add(new MessageElementTagProcessor(dialectPrefix));
		processadores.add(new OrderElementTagProcessor(dialectPrefix));
		processadores.add(new PaginatioElementTagProcessor(dialectPrefix));
		processadores.add(new MenuAttributeTagProcessor(dialectPrefix));
		return processadores;
	}

}
