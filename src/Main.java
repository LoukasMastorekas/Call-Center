import api.ListOfPeople;
import api.People;
import gui.WelcomePageCall;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
       ListOfPeople listOfPeople=new ListOfPeople();
        //listOfPeople.initialization();
        listOfPeople.copyData();
         WelcomePageCall welcomePageCall=new WelcomePageCall(listOfPeople);
         listOfPeople.pasteData();


    }
}