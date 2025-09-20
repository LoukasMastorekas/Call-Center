package gui;

import api.ListOfPeople;
import api.People;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShowPeoplePage implements ActionListener {
    JFrame frame=new JFrame("Show Details");

   JButton back=new JButton("Back");
   JButton changeButton=new JButton("Change");
   JButton deleteButton=new JButton("Delete number");
   JLabel nameL=new JLabel("Name:");
   JLabel surnameL=new JLabel("Surname:");
   JLabel phoneL=new JLabel("Phone:");
   JLabel name=new JLabel();
   JLabel surname=new JLabel();
   JLabel phone=new JLabel();

   ListOfPeople listOfPeople;
   People people;

    public ShowPeoplePage(People people,ListOfPeople listOfPeople){
        this.listOfPeople=listOfPeople;
        this.people=people;
        frame.getContentPane().setLayout(null);

        nameL.setBounds(100,50,70,30);
        surnameL.setBounds(100,135,70,30);
        phoneL.setBounds(100,220,70,30);

        name.setText(people.getName());
        surname.setText(people.getSurname());
        phone.setText(String.valueOf(people.getNumber()));
        name.setBounds(100,90,200,35);
        surname.setBounds(100,175,200,35);
        phone.setBounds(100,260,200,35);

        changeButton.setBounds(100,305,100,40);
        back.setBounds(0,0,75,40);
        deleteButton.setBounds(205,305,150,40);

        back.addActionListener(this);
        changeButton.addActionListener(this);
        deleteButton.addActionListener(this);

        frame.add(back);
        frame.add(changeButton);
        frame.add(nameL);
        frame.add(surnameL);
        frame.add(phoneL);
        frame.add(name);
        frame.add(surname);
        frame.add(phone);
        frame.add(deleteButton);


        frame.setSize(420, 420);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==back)
        {
            WelcomePageCall welcomePageCall=new WelcomePageCall(listOfPeople);
            frame.setVisible(false);
            frame.dispose();
        }
        if(e.getSource()==changeButton){
            ChangePeoplePage changePeoplePage=new ChangePeoplePage(people,listOfPeople);
            frame.setVisible(false);
            frame.dispose();
        }
        if(e.getSource()==deleteButton)
        {
            listOfPeople.deletePeople(people);
            WelcomePageCall welcomePageCall=new WelcomePageCall(listOfPeople);
            frame.setVisible(false);
            frame.dispose();
        }
    }
}
