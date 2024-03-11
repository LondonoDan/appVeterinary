package app.validators;


public abstract class InputsValidator {
    
    //Valida si la información que ingreso el usuario es un string
    public void stringValidator(String string, String element) throws Exception {
		if (string == null || string.equals("")) {
			throw new Exception(element + " No es un valor valido");
		}
	}
    
    //Valida si es un entero 
    public int integerValidator(String number, String element) throws Exception {
		stringValidator(number, element);
		try {
			return Integer.parseInt(number);
		} catch (Exception e) {
			throw new Exception(element + " No es un número valido");
		}
	}
    
    //Valida si es un long
    
    public long longValidator(String number, String element) throws Exception {
		stringValidator(number, element);
		try {
			return Long.parseLong(number);
		} catch (Exception e) {
			throw new Exception(element + " No es un numero valido");
		}
	}
    
    //Valida si es un decimal
    public double doubleValidator(String number, String element) throws Exception {
		stringValidator(number, element);
		try {
			return Double.parseDouble(number);
		} catch (Exception e) {
			throw new Exception(element + " No es un numero valido");
		}
	}

   
    
}
