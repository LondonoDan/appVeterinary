package app.dtos;

import appModels.Person;

public class PersonDto {
    
        private long id;
	private String fullName;
	private String rol;
        private int age;
	private String userName;
	private String password;

  
        
     
	
	public PersonDto(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

    public PersonDto(long id, String fullName, String rol, int age, String userName, String password) {
        this.id = id;
        this.fullName = fullName;
        this.rol = rol;
        this.age = age;
        this.userName = userName;
        this.password = password;
    }

	

	public PersonDto(Person person) {
		this.id = person.getId();
		this.fullName = person.getFullName();
		this.rol = person.getRol();
                this.age = person.getAge();
		this.userName = person.getUserName();
		this.password = person.getPassword();
	}
        
        

	public PersonDto() {
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

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
        
        
        

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
