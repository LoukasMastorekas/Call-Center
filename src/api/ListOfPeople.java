package api;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListOfPeople {
    ArrayList<People> listOfPeople;
    public ListOfPeople()
    {
        listOfPeople=new ArrayList<>();
    }

    public void addPeople(People people)
    {
        listOfPeople.add(people);
    }

    public ArrayList<People> getListOfPeople() {
        return listOfPeople;
    }

    public void setListOfPeople(ArrayList<People> listOfPeople) {
        this.listOfPeople = listOfPeople;
    }

    public void deletePeople(People people)
    {
        if(!listOfPeople.isEmpty())
        {
           listOfPeople.remove(people);
        }
    }
    public void sortByName() {
        Collections.sort(listOfPeople, Comparator.comparing(People::getName,String::compareToIgnoreCase));

    }
    public void initialization()
    {
        if(isFileEmpty("files/People.co"))
        {
            People people1 = new People("Loukas", "Mastorekas", 6949095184L);
            People people2 = new People("mitsos", "papadopoylos", 6949645234L);
            People people3 = new People("mpamphw", "kakow", 6935655184L);
            People people4 = new People("takis", "takos", 6948786954L);
            People people5 = new People("koloumpra", "toulis", 6982234514L);
            listOfPeople.add(people1);
            listOfPeople.add(people2);
            listOfPeople.add(people3);
            listOfPeople.add(people4);
            listOfPeople.add(people5);

        }


    }
    private static boolean isFileEmpty(String filePath) {
        File file = new File(filePath);

        // Check if the file exists and has a length of 0
        return file.exists() && file.length() == 0;
    }
    public void copyData() throws IOException {

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("files/People.co"))) {
            People people;
            while (true) {
                try {
                    people= (People)in.readObject();
                    listOfPeople.add(people);
                } catch (Exception e) {
                    break; }
            }
        } catch (IOException e ) {
            e.printStackTrace();
        }


    }
    public void pasteData() throws IOException{
    try(ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream("files/People.co")))
    {
        for(People p :listOfPeople)
        {
            out.writeObject(p);
        }

    }catch (IOException e)
    {
        throw new RuntimeException(e);
    }
    }
}
