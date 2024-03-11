package app.dtos;


import appModels.Pet;

public class PetDto{
    
    private String name;
    protected OwnerDto id; //validar si también debe estar en el PetValidator
    private int age;
    private String species;
    private String breed;
    private String characteristics;
    private double weight;

    public PetDto(String name, OwnerDto id, int age, String species, String breed, String characteristics, double weight) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.species = species;
        this.breed = breed;
        this.characteristics = characteristics;
        this.weight = weight;
    }

    

    

    
     public PetDto(Pet pet) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.species = species;
        this.breed = breed;
        this.characteristics = characteristics;
        this.weight = weight;
    }

    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   

    public void setId(OwnerDto id) {
        this.id = id;
    }

   
    public OwnerDto getId() {
        return id;
    }

    

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(String characteristics) {
        this.characteristics = characteristics;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    
    
    
    
    
    
    
}
