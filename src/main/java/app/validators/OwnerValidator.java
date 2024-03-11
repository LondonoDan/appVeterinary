package app.validators;


public class OwnerValidator extends InputsValidator{
    
    public void FullNameValidator(String fullName) throws Exception {
		super.stringValidator(fullName, "nombre de propietario");
	}
    
    public long idValidator(String number) throws Exception {
		return super.longValidator(number, "Documento de usuario");
	}
    
    public int ageValidator(String age) throws Exception{
		return super.integerValidator(age, "Ingrese la edad del propietario");
	}
    
    
}
