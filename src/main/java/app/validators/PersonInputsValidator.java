package app.validators;

public class PersonInputsValidator extends InputsValidator{
    
    public void fullNameValidator(String fullName) throws Exception {
		super.stringValidator(fullName, "nombre de usuario");
	}

	public long cedulaValidator(String number) throws Exception {
		return super.longValidator(number, "Cedula de usuario");
	}
	
        public int ageValidator(String age) throws Exception{
            return super.integerValidator(age, "Ingrese la edad del usuario");
	}
        
	public void rollValidator(String roll) throws Exception {
		super.stringValidator(roll, "roll de usuario");
	}
	
	public void userNameValidator(String userName) throws Exception {
		super.stringValidator(userName, "usuario");
	}
	
	public void passwordValidator(String password) throws Exception {
		super.stringValidator(password, "constraseña de usuario");
	}
    
    
    
}
