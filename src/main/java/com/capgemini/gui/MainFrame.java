package com.capgemini.gui;

import com.capgemini.core.Rental;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    //Text
    private final static String TITLE           = "Boat rental";
    private final static String START           = "Start";
    private final static String STOP            = "Stop";
    private final static String STATUS          = "Status:";
    private final static String AVERAGE         = "Average:";
    private final static String TOUR_ID         = "TourId:";
    private final static String STATUS_START    = "Use the button to start/stop tours";

    //Text formatting
    private final static String TOUR_FORMAT     = "Tour number is %d";
    private final static String DURATION_FORMAT = "Tour duration was %d ms";
    private final static String DURATION_ERROR  = "No tour with id %d was found";
    private final static String AVERAGE_FORMAT  = "The average boat tour was %f ms";

    //Swing variables
    private JPanel      pnlMain;
    private JPanel      pnlButtonBar;
    private JLabel      lblStatus;
    private JLabel      lblAverage;
    private JLabel      lblTourId;
    private JTextField  tfStatus;
    private JTextField  tfAverage;
    private JSpinner    spnrTourId;

    private JButton     btnStart;
    private JButton     btnStop;

    //Instance variables
    private final Rental rental;

    public MainFrame() {
        super(TITLE);
        this.rental = new Rental();

        initGUI();
        initListeners();
        updateStatistics();
    }

    private void initGUI() {
        pnlMain         = new JPanel(new GridBagLayout());
        pnlButtonBar    = new JPanel(new GridBagLayout());
        lblStatus       = new JLabel();
        lblAverage      = new JLabel();
        lblTourId       = new JLabel();
        btnStart        = new JButton();
        btnStop         = new JButton();
        tfStatus        = new JTextField();
        tfAverage       = new JTextField();
        spnrTourId      = new JSpinner();

        btnStart    .setText(START);
        btnStop     .setText(STOP);
        lblStatus   .setText(STATUS);
        lblAverage  .setText(AVERAGE);
        lblTourId   .setText(TOUR_ID);
        tfStatus    .setText(STATUS_START);
        tfStatus    .setEditable(false);
        tfAverage   .setEditable(false);
        spnrTourId  .setModel(new SpinnerNumberModel(0, 0, null, 1));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx       = 0;
        gbc.gridy       = 0;
        gbc.weightx     = 0;
        gbc.weighty     = 0;
        gbc.gridwidth   = 2;
        gbc.gridheight  = 1;
        gbc.fill        = GridBagConstraints.NONE;
        gbc.anchor      = GridBagConstraints.NORTHWEST;
        gbc.insets      = new Insets(5, 5, 5, 5);
        pnlMain.add(lblStatus, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx       = 1;
        gbc.gridy       = 0;
        gbc.weightx     = 1;
        gbc.weighty     = 0;
        gbc.gridwidth   = 1;
        gbc.gridheight  = 1;
        gbc.fill        = GridBagConstraints.HORIZONTAL;
        gbc.anchor      = GridBagConstraints.NORTHWEST;
        gbc.insets      = new Insets(5, 0, 5, 5);
        pnlMain.add(tfStatus, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx       = 0;
        gbc.gridy       = 1;
        gbc.weightx     = 0;
        gbc.weighty     = 0;
        gbc.gridwidth   = 1;
        gbc.gridheight  = 1;
        gbc.fill        = GridBagConstraints.NONE;
        gbc.anchor      = GridBagConstraints.NORTHWEST;
        gbc.insets      = new Insets(0, 5, 5, 5);
        pnlMain.add(lblAverage, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx       = 1;
        gbc.gridy       = 1;
        gbc.weightx     = 1;
        gbc.weighty     = 0;
        gbc.gridwidth   = 1;
        gbc.gridheight  = 1;
        gbc.fill        = GridBagConstraints.HORIZONTAL;
        gbc.anchor      = GridBagConstraints.NORTHWEST;
        gbc.insets      = new Insets(0, 0, 5, 5);
        pnlMain.add(tfAverage, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx       = 0;
        gbc.gridy       = 2;
        gbc.weightx     = 1;
        gbc.weighty     = 1;
        gbc.gridwidth   = 1;
        gbc.gridheight  = 1;
        gbc.fill        = GridBagConstraints.NONE;
        gbc.anchor      = GridBagConstraints.NORTHWEST;
        gbc.insets      = new Insets(0, 5, 5, 5);
        pnlMain.add(lblTourId, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx       = 1;
        gbc.gridy       = 2;
        gbc.weightx     = 1;
        gbc.weighty     = 1;
        gbc.gridwidth   = 1;
        gbc.gridheight  = 1;
        gbc.fill        = GridBagConstraints.NONE;
        gbc.anchor      = GridBagConstraints.NORTHWEST;
        gbc.insets      = new Insets(0, 0, 5, 5);
        pnlMain.add(spnrTourId, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx       = 0;
        gbc.gridy       = 0;
        gbc.weightx     = 1;
        gbc.weighty     = 1;
        gbc.gridwidth   = 1;
        gbc.gridheight  = 1;
        gbc.fill        = GridBagConstraints.NONE;
        gbc.anchor      = GridBagConstraints.SOUTHEAST;
        gbc.insets      = new Insets(0, 0, 0, 0);
        pnlButtonBar.add(btnStop, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx       = 1;
        gbc.gridy       = 0;
        gbc.weightx     = 0;
        gbc.weighty     = 1;
        gbc.gridwidth   = 1;
        gbc.gridheight  = 1;
        gbc.fill        = GridBagConstraints.NONE;
        gbc.anchor      = GridBagConstraints.SOUTHEAST;
        gbc.insets      = new Insets(0, 5, 0, 0);
        pnlButtonBar.add(btnStart, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx       = 0;
        gbc.gridy       = 3;
        gbc.weightx     = 1;
        gbc.weighty     = 0;
        gbc.gridwidth   = 2;
        gbc.gridheight  = 1;
        gbc.fill        = GridBagConstraints.BOTH;
        gbc.anchor      = GridBagConstraints.NORTHWEST;
        gbc.insets      = new Insets(5, 5, 5, 5);
        pnlMain.add(pnlButtonBar, gbc);

        setContentPane(pnlMain);
    }

    private void initListeners() {
        btnStart.addActionListener(e -> startTour());
        btnStop.addActionListener(e -> stopTour());
    }

    private void startTour() {
        int tourId = rental.startTour();

        tfStatus.setText(String.format(TOUR_FORMAT, tourId));
    }

    private void stopTour() {
        int tourId = (int) spnrTourId.getValue();

        long durationMillis = rental.stopTour(tourId);

        if(durationMillis < 0) {
            tfStatus.setText(String.format(DURATION_ERROR, tourId));
            return;
        }

        tfStatus.setText(String.format(DURATION_FORMAT, durationMillis));
        updateStatistics();
    }

    private void updateStatistics() {
        tfAverage.setText(String.format(AVERAGE_FORMAT, rental.getAverageTimeInMillis()));
    }

    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        frame.setMinimumSize(new Dimension(600, 600));
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }
}