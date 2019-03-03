package analiseskillus.com.br.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.ConstraintValidatorContext.ConstraintViolationBuilder;

import org.apache.commons.beanutils.BeanUtils;

import analiseskillus.com.br.validation.AtributoConfirmacao;

public class AtributoConfirmacaoValidator implements ConstraintValidator<AtributoConfirmacao, Object>{

	private String atributo;
	private String atributoConfirmacao;
	
	@Override
	public void initialize(AtributoConfirmacao constraintAnnotation) {
		this.atributo = constraintAnnotation.atributo();
		this.atributoConfirmacao = constraintAnnotation.atributoConfirmacao();
	}

	@Override
	public boolean isValid(Object object, ConstraintValidatorContext context) {
		boolean valido = false;
		try {
			Object valorAtributo = BeanUtils.getProperty(object, this.atributo);
			Object valorAtributoConfirmacao = BeanUtils.getProperty(object, this.atributoConfirmacao);
			
			valido = valoresNulos(valorAtributo, valorAtributoConfirmacao) || valoresIguais(valorAtributo, valorAtributoConfirmacao);
		}catch(Exception e) {
			throw new RuntimeException("Erro recuperando valores dos atributos", e);
		}
		
		context.disableDefaultConstraintViolation();
		
		if(!valido) {
			String mensagem = context.getDefaultConstraintMessageTemplate();
			ConstraintViolationBuilder violationBuilder = context.buildConstraintViolationWithTemplate(mensagem);
			violationBuilder.addPropertyNode(atributoConfirmacao).addConstraintViolation();
		}
		return valido;
	}

	private boolean valoresIguais(Object valorAtributo, Object valorAtributoConfirmacao) {
		
		return valorAtributo != null && valorAtributo.equals(valorAtributoConfirmacao);
	}

	private boolean valoresNulos(Object valorAtributo, Object valorAtributoConfirmacao) {
		
		return valorAtributo == null && valorAtributoConfirmacao == null;
	}

}
