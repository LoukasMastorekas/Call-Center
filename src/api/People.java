package api;

import java.io.Serializable;

public class People implements Serializable {
    private String name=new String();
    private String surname=new String();
    private Long number;
    public People(String name,String surname,Long number){
        this.name=name;
        this.surname=surname;
        this.number=number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }
    public  String textPeople(){return (name+surname).toLowerCase();}
}
