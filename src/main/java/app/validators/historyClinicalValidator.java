package app.validators;


public class historyClinicalValidator extends InputsValidator{
    
    public long idValidator(String id) throws Exception {
		return super.longValidator(id, "Cédula de propietario");
	}
    
    public long cedulaValidator(String cedula) throws Exception {
            return super.longValidator(cedula, "cédula del veterinario que atendio");
	}
    
    
    public void procedureValidator(String procedure) throws Exception {
            super.stringValidator(procedure, "procedure");
	}
    
    
    public void medicinesValidator(String medicines) throws Exception {
            super.stringValidator(medicines, "medicines");
	}
    
    
    public void vaccinesValidator(String vaccines) throws Exception {
            super.stringValidator(vaccines, "vaccines");
	}
    
    public void allergyValidator(String allergy) throws Exception {
            super.stringValidator(allergy, "allergy");
	}
    
    
    public void motivedValidator(String motive) throws Exception {
            super.stringValidator(motive, "motive");
	}
    
    public void symptomatologyValidator(String symptomatology) throws Exception {
		super.stringValidator(symptomatology, "symptomatology");
	}
    
   public void detailProcedureValidator(String detailProcedure) throws Exception {
		super.stringValidator(detailProcedure, "detailProcedure");
	}
   
    public void diagnosisValidator(String diagnosis) throws Exception {
		super.stringValidator(diagnosis, "diagnosis");
	}  
    
    
    public void medicationDosageValidator(String medicationDosage) throws Exception {
		super.stringValidator(medicationDosage, "medicationDosage");
	} 
    
    
    
   
}
