package com.capgemini.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import static java.lang.Thread.*;

public class SwingControl {
    private JFrame mainFrame;
    private JLabel headerLabel;
    private JLabel statusLabel;
    private JPanel controlPanel;
    private JTextField inputfield;

    public SwingControl(){
        prepareGUI();
    }
    public static void main(String[] arg){
        SwingControl swingControlDemo = new SwingControl();
        swingControlDemo.showEventDemo();
    }
    private void prepareGUI(){
        mainFrame = new JFrame("Java SWING Examples");
        mainFrame.setSize(400,400);
        mainFrame.setLayout(new GridLayout(3, 1));

        headerLabel = new JLabel("",JLabel.CENTER );
        statusLabel = new JLabel("",JLabel.CENTER);
        statusLabel.setSize(350,100);

        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }
        });
        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);
        mainFrame.add(statusLabel);
        mainFrame.setVisible(true);
    }
    private void showEventDemo(){
        headerLabel.setText("Botenverhuur");

        JButton cancelButton = new JButton("Gemiddelde tochttijd");
        JButton okButton = new JButton("Tocht aanmaken");
        JButton submitButton = new JButton("Tocht beeindigen");
        inputfield = new JTextField("13", 13);

        okButton.setActionCommand("CreateTour");
        submitButton.setActionCommand("EndTour");
        cancelButton.setActionCommand("avarageTourTime");

        okButton.addActionListener(new ButtonClickListener());
        submitButton.addActionListener(new ButtonClickListener());
        cancelButton.addActionListener(new ButtonClickListener());

        controlPanel.add(okButton);
        controlPanel.add(cancelButton);
        controlPanel.add(inputfield);
        controlPanel.add(submitButton);

        mainFrame.setVisible(true);
    }
    private class ButtonClickListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if( command.equals( "CreateTour" ))  {

                statusLabel.setText("Tochtnummet = 365.");
            } else if( command.equals( "EndTour" ) )  {
                String value = inputfield.getText();
                statusLabel.setText("Tocht " + value + " heeft 1 uur en 30 minuten geduurd.");
            } else {

                statusLabel.setText("avarageTourTime");
            }
        }
    }
}
