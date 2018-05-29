package webstore.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import webstore.domain.Product;

import java.math.BigDecimal;

@Component
public class UnitsInStockValidator implements Validator {
	@Override
	public boolean supports(Class<?> clazz) {
		return Product.class.isAssignableFrom(clazz);
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		Product product =  (Product) target;
		if (product.getUnitPrice() != null && new BigDecimal(1000).compareTo(product.getUnitPrice()) <= 0 &&
				product.getUnitsInStock() > 99) {
			errors.rejectValue("unitsInStock", "webstore.validator.UnitsInStockValidator.message");
		}
	}
}
