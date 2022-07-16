package com.hiringcoders.core.validation;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.ValidationException;

import org.springframework.beans.BeanUtils;

public class PurchaseValidator implements ConstraintValidator<Purchase, Object> {

	private String purchaseIdField;
	private String purchaseValueField;
	private String purchaseDateField;
	
	@Override
	public void initialize(Purchase constraint) {
		this.purchaseIdField = constraint.purchaseIdField();
		this.purchaseValueField = constraint.purchaseValueField();
		this.purchaseDateField = constraint.purchaseDateField();
	}
	
	@Override
	public boolean isValid(Object objetoValidacao, ConstraintValidatorContext context) {
		try {
			String id = (String) BeanUtils.getPropertyDescriptor(objetoValidacao.getClass(), purchaseIdField)
					.getReadMethod().invoke(objetoValidacao);
			
			BigDecimal value = (BigDecimal) BeanUtils.getPropertyDescriptor(objetoValidacao.getClass(), purchaseValueField)
					.getReadMethod().invoke(objetoValidacao);
			
			OffsetDateTime date = (OffsetDateTime) BeanUtils.getPropertyDescriptor(objetoValidacao.getClass(), purchaseDateField)
					.getReadMethod().invoke(objetoValidacao);
			
			if ((id == null && value == null && date == null) || 
					(id != null && value != null && date != null)) {
				return true;
			} else {
				return false;
			}
			
		} catch (Exception e) {
			throw new ValidationException(e);
		}
	}

}