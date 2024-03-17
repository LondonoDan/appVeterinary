package appModels;

import java.sql.Date;

public class clinicHistory {
    
    private Date date;
    private Owner id;
    private Person cedula;
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
    
    
    
    
    
    

    public clinicHistory() {
        this.date=new Date(System.currentTimeMillis());
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    
    
    

    

    

    public Owner getId() {
        return id;
    }

    public void setId(Owner id) {
        this.id = id;
    }

    public Person getcedula() {
        return cedula;
    }

    public void setcedula(Person profesional) {
        this.cedula = profesional;
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
