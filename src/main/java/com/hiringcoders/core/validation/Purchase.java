package com.hiringcoders.core.validation;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ ElementType.TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = { PurchaseValidator.class })
public @interface Purchase {

	String message() default "Dados do Pedido Associado devem ser informados por completo";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
	
	String purchaseIdField();
	
	String purchaseValueField();
	
	String purchaseDateField();
	
}
