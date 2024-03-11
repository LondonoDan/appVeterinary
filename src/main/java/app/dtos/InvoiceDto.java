package app.dtos;

import appModels.Invoice;
import appModels.Person;
import appModels.Pet;
import java.sql.Date;

public class InvoiceDto {
    
    
    private long invoiceId;
    private Pet petId;
    private Person ownerId;
    private int orderId;
    private String productName;
    private double value;
    private int quantity;
    private Date date;
    

    public InvoiceDto(long invoiceId, Pet petId, Person ownerId, int orderId, String productName, double value, int quantity, Date date) {
        this.invoiceId = invoiceId;
        this.petId = petId;
        this.ownerId = ownerId;
        this.orderId = orderId;
        this.productName = productName;
        this.value = value;
        this.quantity = quantity;
        this.date = date;
    }
    
    
    public InvoiceDto(Invoice invoice) {
        this.invoiceId = invoiceId;
        this.petId = petId;
        this.ownerId = ownerId;
        this.orderId = orderId;
        this.productName = productName;
        this.value = value;
        this.quantity = quantity;
        this.date = date;
    }

    public long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(long invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Pet getPetId() {
        return petId;
    }

    public void setPetId(Pet petId) {
        this.petId = petId;
    }

    public Person getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Person ownerId) {
        this.ownerId = ownerId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    
    
    
}
