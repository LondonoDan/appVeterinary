package app.dtos;

import appModels.Person;
import appModels.clinicHistory;

public class clinicalHistoryDto {
    
    private long admissionDate;
    private PersonDto id;
    private PersonDto cedula;
    private String motive;
    private String symptomatology;
    private String procedure;
    private String medicines;
    private int order;
    private String vaccines;
    private String allergy;
    private String detailProcedure;
    private String diagnosis;
    private String medicationDosage;
    private int ordercancelation;

    public clinicalHistoryDto(long admissionDate, PersonDto id, PersonDto cedula, String motive, String symptomatology, String procedure, String medicines, int order, String vaccines, String allergy, String detailProcedure, String diagnosis, String medicationDosage, int ordercancelation) {
        this.admissionDate = admissionDate;
        this.id = id;
        this.cedula = cedula;
        this.motive = motive;
        this.symptomatology = symptomatology;
        this.procedure = procedure;
        this.medicines = medicines;
        this.order = order;
        this.vaccines = vaccines;
        this.allergy = allergy;
        this.detailProcedure = detailProcedure;
        this.diagnosis = diagnosis;
        this.medicationDosage = medicationDosage;
        this.ordercancelation = ordercancelation;
    }

    
     public clinicalHistoryDto(clinicHistory clinicalHistory,Person person) {
        this.admissionDate = admissionDate;
        this.id = id;
        this.cedula = cedula;
        this.motive = motive;
        this.symptomatology = symptomatology;
        this.procedure = procedure;
        this.medicines = medicines;
        this.order = order;
        this.vaccines = vaccines;
        this.allergy = allergy;
        this.detailProcedure = detailProcedure;
        this.diagnosis = diagnosis;
        this.medicationDosage = medicationDosage;
        this.ordercancelation = ordercancelation;
    }
    
    
    
    
    public clinicalHistoryDto() {
    }
    


	public long getAdmissionDate() {
		return admissionDate;
	}

	public void setAdmissionDate(long admissionDate) {
		this.admissionDate = admissionDate;
	}
    

    public PersonDto getId() {
        return id;
    }

    public void setId(PersonDto id) {
        this.id = id;
    }

    public PersonDto getCedula() {
        return cedula;
    }

    public void setCedula(PersonDto cedula) {
        this.cedula = cedula;
    }

    public String getMotive() {
        return motive;
    }

    public void setMotive(String motive) {
        this.motive = motive;
    }

    public String getSymptomatology() {
        return symptomatology;
    }

    public void setSymptomatology(String symptomatology) {
        this.symptomatology = symptomatology;
    }

    public String getProcedure() {
        return procedure;
    }

    public void setProcedure(String procedure) {
        this.procedure = procedure;
    }

    public String getMedicines() {
        return medicines;
    }

    public void setMedicines(String medicines) {
        this.medicines = medicines;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getVaccines() {
        return vaccines;
    }

    public void setVaccines(String vaccines) {
        this.vaccines = vaccines;
    }

    public String getAllergy() {
        return allergy;
    }

    public void setAllergy(String allergy) {
        this.allergy = allergy;
    }

    public String getDetailProcedure() {
        return detailProcedure;
    }

    public void setDetailProcedure(String detailProcedure) {
        this.detailProcedure = detailProcedure;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getMedicationDosage() {
        return medicationDosage;
    }

    public void setMedicationDosage(String medicationDosage) {
        this.medicationDosage = medicationDosage;
    }

    public int getOrdercancelation() {
        return ordercancelation;
    }

    public void setOrdercancelation(int ordercancelation) {
        this.ordercancelation = ordercancelation;
    }

   
    
   
    

    
    
    
}
