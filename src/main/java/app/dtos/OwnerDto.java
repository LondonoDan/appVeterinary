package app.dtos;

import appModels.Owner;

public class OwnerDto {
    
    private long id;
    private String fullName;
    private int age;
    
    
    public OwnerDto() {
    }
    
    public OwnerDto(long id) {
        this.id = id;
    }

    public OwnerDto(long id, String fullName, int age) {
        this.id = id;
        this.fullName = fullName;
        this.age = age;
        
    }
    
    
     public OwnerDto(Owner owner) {
        this.id = id;
        this.fullName = fullName;
        this.age = age;
        
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

   
    
    
     
    
    
}
