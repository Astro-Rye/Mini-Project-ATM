public class Persons {
    // ATM simulator
    public String firstName;
    public String lastName;

    public Persons(String firstName){
        this.firstName = firstName;
        this.lastName = "";
    }

    public Persons(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() { return firstName;}
    public String getLastName() { return lastName;}

    public void setFirstName(String firstName) {this.firstName = firstName;}
    public void setLastName(String lastName) {this.lastName = lastName; }
}
