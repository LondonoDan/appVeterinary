package appModels;

public class Person {
    
        private long id;
	private String fullName;
	private String rol;
        private int age;
	private String userName;
	private String password;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
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

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
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