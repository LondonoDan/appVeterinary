package app.validators;

public class InvoiceValidator extends InputsValidator {
    
    public long invoiceIdValidator(String invoiceId) throws Exception {
		return super.longValidator(invoiceId, "ID de factura");
	}
    
    public long orderIdValidator(String orderId) throws Exception {
		return super.integerValidator(orderId, orderId);
	}
    
    public void productNameValidator(String productName) throws Exception {
		super.stringValidator(productName, "Nombre producto");
	}
    
    public void valueValidator(String value) throws Exception {
		super.doubleValidator(value, "Valor producto");
	}
    
    
    public long quantityValidator(String quantity) throws Exception {
		return super.integerValidator(quantity, "Ingrese la cantidad");
	}
   

    
}
