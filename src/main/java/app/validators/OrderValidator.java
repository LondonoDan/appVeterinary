package app.validators;

public class OrderValidator extends InputsValidator{
         
    
    public void medicationNameValidator(String medicationName) throws Exception {
		super.stringValidator(medicationName, "Nombre del medicamento");
	}
    
    public void dosageNameValidator(String dosage) throws Exception {
		super.stringValidator(dosage, "Dosis del medicamento");
	}
}
