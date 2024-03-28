package app.validators;

public class PetInputsValidator extends InputsValidator {
    
    public void nameValidator(String name) throws Exception {
		super.stringValidator(name, "nombre de mascota");
	}
    
    public long idValidator(String cedula) throws Exception {
		return super.longValidator(cedula, "Cédula de propietario");
	}
    
    public int ageValidator(String age) throws Exception{
		return super.integerValidator(age, "Ingrese la edad de la mascota");
	}
    
    
    
    public void speciesValidator(String specie) throws Exception {
		super.stringValidator(specie, "Especie de mascota");
	}
    
    
    public void breedValidator(String breed) throws Exception {
		super.stringValidator(breed, "Raza de mascota");
	}
    
    
    public void characteristicsValidator(String characteristics) throws Exception {
		super.stringValidator(characteristics, "Caracteristicas de mascota");
	}
    
    public double weightValidator(String weight) throws Exception {
	return super.doubleValidator(weight, "Peso de la mascota");
	}
}
