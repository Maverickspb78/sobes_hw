package HW1.task1;

public class PersonBuilder {
//   String firstName, String lastName, String middleName, String country, String address, String phone, int age, String gender.

    private Person person = new Person();

    public PersonBuilder setFirstName(String firstName){
        this.person.setFirstName(firstName);
        return this;
    }

    public PersonBuilder setLastName(String lastName){
        this.person.setLastName(lastName);
        return this;
    }

    public PersonBuilder setMiddleName(String middleName){
        this.person.setMiddleName(middleName);
        return this;
    }

    public PersonBuilder setCountry(String country){
        this.person.setCountry(country);
        return this;
    }

    public PersonBuilder setAddress(String address){
        this.person.setAddress(address);
        return this;
    }

    public PersonBuilder setPhone(String phone){
        this.person.setPhone(phone);
        return this;
    }

    public PersonBuilder setAge(int age){
        this.person.setAge(age);
        return this;
    }

    public PersonBuilder setGender(String gender){
        this.person.setGender(gender);
        return this;
    }

    public Person build(){
        return person;
    }
}
