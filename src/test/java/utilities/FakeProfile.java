package utilities;



import com.github.javafaker.Faker;


public class FakeProfile {
    private String name;
    private String surname;
    private String birthPlace;
    private String email;
    private String phoneNumber;
    private String gender;
    private String dateOfBirth;
    private String socialSecurityNumber;
    private String userName;
    private String password;
    static Faker faker;
    public FakeProfile() {
        faker = new Faker();



        this.name = faker.name().firstName();
        this.surname = faker.name().lastName();
        this.birthPlace = faker.address().city().replaceAll("\\s","" ); if (this.birthPlace.length() >= 14) {this.birthPlace = this.birthPlace.substring(0,9);}
        this.dateOfBirth=""+faker.number().numberBetween(0,3)+faker.number().numberBetween(0,9)+""+faker.number().numberBetween(0,1)+faker.number().numberBetween(0,1)+""
                +1+9+faker.number().numberBetween(5,9)+faker.number().numberBetween(0,9);
        this.email = faker.internet().emailAddress();
        this.phoneNumber = ""+faker.number().numberBetween(1,9)+faker.number().numberBetween(1,9)+faker.number().numberBetween(1,9)+"-"+faker.number().numberBetween(1,9)+faker.number().numberBetween(1,9)+faker.number().numberBetween(1,9)+"-"+faker.number().numberBetween(1,9)+faker.number().numberBetween(1,9)+faker.number().numberBetween(1,9)+faker.number().numberBetween(1,9);
        int number =faker.number().numberBetween(0,2);
         if(number>=1){this.gender ="MALE";} else{this.gender ="FEMALE";}
        this.socialSecurityNumber = ""+faker.number().numberBetween(1,9)+faker.number().numberBetween(1,9)+faker.number().numberBetween(1,9)+"-"+faker.number().numberBetween(1,9)+faker.number().numberBetween(1,9)+"-"+faker.number().numberBetween(1,9)+faker.number().numberBetween(1,9)+faker.number().numberBetween(1,9)+faker.number().numberBetween(1,9);

        this.userName = faker.name().username().replaceAll("[^A-Za-z]","A"); if (this.userName.length() >= 14) {this.userName = this.userName.substring(0,9);}
        this.password = faker.internet().password();
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }


    String createDate(){
        int sayi = (int) (Math.random()*29);
        int sayi1 = (int) (Math.random()*13);
        int sayi2 = (int) (Math.random()*2000);
        return sayi+""+sayi1+""+sayi2;
    }
}
