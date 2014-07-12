package com.home.directory.domain;

import com.home.directory.domain.Person;

public class PartyContact {

    private Person person; // required
    private String mobilePhone; // required
    private String homePhone; // optional
    private PostalAdress postalAdress; // optional
    private String eMail; // optional

    private PartyContact(PartyContactBuilder builder) {
        this.person = new Person();
        this.person.setFirstName(builder.firstName);
        this.person.setSecondName(builder.secondName);
        this.person.setLastName(builder.lastName);
        this.mobilePhone = builder.mobilePhone;
        this.homePhone = builder.homePhone;
        this.postalAdress = new PostalAdress(builder.postalAdress);
        this.eMail = builder.eMail;
    }

    public Person getPerson() {
        return person;
    }
    
    public String getFirstName() {
    	return person.getFirstName();
    }
    
    public String getLastName() {
    	return person.getLastName();
    }
    
    public String getSecondName() {
    	return person.getSecondName();
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public PostalAdress getPostalAdress() {
        return postalAdress;
    }
    
    public String getAddress(){
    	return postalAdress.getPostalAdress();
    }

    public String geteMail() {
        return eMail;
    }

    private void setPerson(Person person) {
        this.person = person;
    }

    private void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    private void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    private void setPostalAdress(PostalAdress postalAdress) {
        this.postalAdress = postalAdress;
    }

    private void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public static class PartyContactBuilder {

        private String firstName;
        private String secondName;
        private String lastName;


        private String mobilePhone;
        private String homePhone;
        private String postalAdress;
        private String eMail;

        public PartyContactBuilder() {
        }

        public PartyContactBuilder withMobilePhone(String phone){
            this.mobilePhone = phone;
            return this;
        }

        public PartyContactBuilder withHomePhone(String phone){
            this.homePhone = mobilePhone;
            return this;
        }

        public PartyContactBuilder withEMail(String eMail){
            this.eMail = eMail;
            return this;
        }

        public PartyContactBuilder withFirstName(String firstName){
            this.firstName = firstName;
            return this;
        }

        public PartyContactBuilder withSecondName(String secondName){
            this.secondName = secondName;
            return this;
        }

        public PartyContactBuilder withLastName(String lastName){
            this.lastName = lastName;
            return this;
        }

        public PartyContactBuilder withPostalAdress(String postalAdress){
            this.postalAdress = postalAdress;
            return this;
        }

        public PartyContact build() {
            if(isEmpty(this.firstName)){
                throw new IllegalStateException("First Name required");
            }

            if(isEmpty(this.secondName)){
                throw new IllegalStateException("Second Name required");
            }

            if(isEmpty(this.firstName)){
                throw new IllegalStateException("Third Name required");
            }

            if(isEmpty(this.mobilePhone)){
                throw new IllegalStateException("Mobile Phone required");
            }

            return new PartyContact(this);
        }

        private static final boolean isEmpty(String value) {
            return value == null || value.trim().length() == 0;
        }

    }
}
