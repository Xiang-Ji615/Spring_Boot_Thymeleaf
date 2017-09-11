package main.java.spring.thymeleaf.processor;

import org.thymeleaf.context.ITemplateContext;
import org.thymeleaf.engine.AttributeName;
import org.thymeleaf.model.IProcessableElementTag;
import org.thymeleaf.processor.element.AbstractAttributeTagProcessor;
import org.thymeleaf.processor.element.IElementTagStructureHandler;
import org.thymeleaf.templatemode.TemplateMode;
import org.unbescape.html.HtmlEscape;

public class HelloWorldProcessor extends AbstractAttributeTagProcessor{
	
    private static final String ATTR_NAME = "sayto";
    private static final int PRECEDENCE = 10000;

	public HelloWorldProcessor(String dialectPrefix) {
		super(TemplateMode.HTML, dialectPrefix, null, false, ATTR_NAME, true, PRECEDENCE,
				true);
	}

	@Override
	protected void doProcess(ITemplateContext arg0, IProcessableElementTag arg1, AttributeName arg2, String arg3,
			IElementTagStructureHandler arg4) {
		arg4.setBody("Hello world"+HtmlEscape.escapeHtml5(arg3) + " !", false);
	}

}
