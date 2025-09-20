package gui;

import api.ListOfPeople;
import api.People;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;

public class WelcomePageCall implements ActionListener {
    JFrame frame=new JFrame("CAll CENTER");

    JButton addPhone=new JButton("Add");
    JButton saveButton=new JButton("Save and Close");
    ListOfPeople listOfPeople;
    DefaultListModel<String> listModel=new DefaultListModel<>();
    JList<String> result=new JList<>(listModel);
    JScrollPane scrollPane=new JScrollPane(result);
    JTextField searchField=new JTextField();
    public WelcomePageCall(ListOfPeople listOfPeople){
        this.listOfPeople=listOfPeople;
        frame.getContentPane().setLayout(null);
        result.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
         listOfPeople.sortByName();
        for(People s:listOfPeople.getListOfPeople())
        {
            listModel.addElement(s.getName()+" "+s.getSurname());
        }

        searchField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateText();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                   updateText();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateText();
            }
            private void updateText() {
                listModel.clear();
                String currentText = searchField.getText();  // Παίρνεις το κείμενο από το JTextField
                for(People p:listOfPeople.getListOfPeople())
                {
                    if(p.textPeople().toLowerCase().contains(currentText))
                    {
                        listModel.addElement(p.getName()+" "+p.getSurname());
                    }
                }
            }
        });

        searchField.setBounds(85,40,215,25);
        scrollPane.setBounds(85,70,215,220);


        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        frame.getContentPane().add(scrollPane);

        saveButton.setBounds(120,300,150,40);

        frame.add(saveButton);
        frame.add(searchField);
        addPhone.setBounds(0,0,60,40);
        addPhone.addActionListener(this);
        saveButton.addActionListener(this);
        frame.add(addPhone);
        frame.setSize(420, 420);
    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
    int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        result.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(!e.getValueIsAdjusting())
                {
                    String[] value=result.getSelectedValue().split(" ");
                    for(People p:listOfPeople.getListOfPeople())
                    {
                         if(p.getName().equals(value[0])&p.getSurname().equals(value[1]))
                         {
                             ShowPeoplePage showPeoplePage=new ShowPeoplePage(p,listOfPeople);
                             frame.dispose();
                             frame.setVisible(false);
                         }
                    }



                }
            }
        });

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==addPhone)
        {
           AddNumberPage addNumberPage =new AddNumberPage(listOfPeople);
            frame.setVisible(false);
            frame.dispose();
        }
        if(e.getSource()==saveButton)
        {
            try {
                listOfPeople.pasteData();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            frame.setVisible(false);
            frame.dispose();
        }
    }
}
