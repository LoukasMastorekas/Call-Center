package gui;

import api.ListOfPeople;
import api.People;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddNumberPage implements ActionListener {
    JFrame frame=new JFrame("Add Number");
    JButton backButton=new JButton("Back");
    JButton saveButton=new JButton("Add Phone");
    JLabel nameLabel=new JLabel("Name");
    JLabel surnameLabel=new JLabel("Surname");
    JLabel phoneLabel=new JLabel("Phone");
    JLabel warningLabel=new JLabel();
    JTextField name=new JTextField();
    JTextField surname=new JTextField();
    JTextField phone=new JTextField();

    ListOfPeople listOfPeople;
    public AddNumberPage(ListOfPeople listOfPeople)
    {
        this.listOfPeople=listOfPeople;
        nameLabel.setBounds(100,50,70,30);
        surnameLabel.setBounds(100,135,70,30);
        phoneLabel.setBounds(100,220,70,30);
        warningLabel.setBounds(145,335,200,40);

        name.setBounds(100,90,200,35);
        surname.setBounds(100,175,200,35);
        phone.setBounds(100,260,200,35);

        backButton.setBounds(0,0,75,40);
        saveButton.setBounds(135,305,120,40);

        saveButton.addActionListener(this);
        backButton.addActionListener(this);
        frame.add(warningLabel);
        frame.add(nameLabel);
        frame.add(surnameLabel);
        frame.add(phoneLabel);
        frame.add(name);
        frame.add(surname);
        frame.add(phone);
        frame.add(saveButton);

        frame.add(backButton);

        frame.getContentPane().setLayout(null);
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
        if(e.getSource()==backButton)
        {
          WelcomePageCall welcomePageCall=new WelcomePageCall(listOfPeople);
            frame.setVisible(false);
            frame.dispose();
        }
        if(e.getSource()==saveButton)
        {if((name.getText().isEmpty()&surname.getText().isEmpty()&phone.getText().matches(".*[a-zA-Z]+.*")|| phone.getText().isEmpty()||phone.getText().length()!=10)||(name.getText().isEmpty()&surname.getText().isEmpty())||(name.getText().isEmpty()&phone.getText().matches(".*[a-zA-Z]+.*")|| phone.getText().isEmpty()||phone.getText().length()!=10)||(surname.getText().isEmpty()&phone.getText().matches(".*[a-zA-Z]+.*")|| phone.getText().isEmpty()||phone.getText().length()!=10)){
                warningLabel.setText("Give Information");
           }
           else if(name.getText().isEmpty())
           {
               warningLabel.setText("Give a name");
           }
           else if(surname.getText().isEmpty())
           {
               warningLabel.setText("Give a surname");
           }
           else if(phone.getText().matches(".*[a-zA-Z]+.*")|| phone.getText().isEmpty()||phone.getText().length()!=10)
           {
               warningLabel.setText("Give number");
           }else{
               String namep=name.getText();
               String surnamep=surname.getText();
               long phonep=Long.parseLong(phone.getText());
               People people=new People(namep,surnamep,phonep);
               listOfPeople.addPeople(people);
               warningLabel.setText("Saved");
           }
        }
    }
}
