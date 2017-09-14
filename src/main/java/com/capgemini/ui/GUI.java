package com.capgemini.ui;

import com.capgemini.core.Tour;
import com.capgemini.core.TourException;
import com.capgemini.core.TourManager;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A simple Swing GUI for usage with the boat rental program {@link TourManager}.
 */
public class GUI extends JFrame {
    /**
     * Text variables, switch to per-language dictionaries on long term.
     */
    private final static String TITLE           = "Boat rental";
    private final static String START           = "Start";
    private final static String STOP            = "Stop";
    private final static String STATUS          = "Status:";
    private final static String AVERAGE         = "Average:";
    private final static String TOUR_ID         = "TourId:";
    private final static String STATUS_START    = "Use the button to startTime/stop tours";
    private final static String TOURS_STARTED   = "Tours started:";
    private final static String TOURS_ENDED     = "Tours ended:";

    /**
     * Text formats, switch to per-language dictionaries on long term.
     */
    private final static String TOUR_FORMAT     = "Tour number is %d";
    private final static String DURATION_FORMAT = "Tour duration was %d ms";
    private final static String DURATION_ERROR  = "No tour with id %d was found";
    private final static String AVERAGE_FORMAT  = "The average boat tour was %f ms";

    /**
     * Swing variables.
     */
    private JPanel      pnlMain;
    private JPanel      pnlButtonBar;
    private JPanel      pnlView;
    private JScrollPane spView;
    private JLabel      lblStatus;
    private JLabel      lblAverage;
    private JLabel      lblTourId;
    private JLabel      lblToursStarted;
    private JLabel      lblToursEnded;
    private JTextField  tfStatus;
    private JTextField  tfAverage;
    private JTextField  tfToursStarted;
    private JTextField  tfToursEnded;
    private JSpinner    spnrTourId;

    private JButton     btnStart;
    private JButton     btnStop;

    /**
     * Instance variables
     */
    private final TourManager   rental;
    private final Set<Tour>     tours;

    public GUI() {
        super(TITLE);
        this.rental = new TourManager();
        this.tours  = new HashSet<>();

        initGUI();
        initListeners();
        updateStatistics();
    }

    /**
     * Initialise the GUI elements.
     * Only to be called from the constructor, do not call anywhere else!
     */
    private void initGUI() {
        pnlMain         = new JPanel(new GridBagLayout());
        pnlButtonBar    = new JPanel(new GridBagLayout());
        pnlView         = new JPanel(new GridBagLayout());
        spView          = new JScrollPane(pnlView);
        lblStatus       = new JLabel();
        lblAverage      = new JLabel();
        lblTourId       = new JLabel();
        lblToursStarted = new JLabel();
        lblToursEnded   = new JLabel();
        btnStart        = new JButton();
        btnStop         = new JButton();
        tfStatus        = new JTextField();
        tfAverage       = new JTextField();
        tfToursStarted  = new JTextField();
        tfToursEnded    = new JTextField();
        spnrTourId      = new JSpinner();

        btnStart        .setText(START);
        btnStop         .setText(STOP);
        lblStatus       .setText(STATUS);
        lblAverage      .setText(AVERAGE);
        lblTourId       .setText(TOUR_ID);
        lblToursStarted .setText(TOURS_STARTED);
        lblToursEnded   .setText(TOURS_ENDED);
        tfStatus        .setText(STATUS_START);
        tfStatus        .setEditable(false);
        tfAverage       .setEditable(false);
        tfToursStarted  .setEditable(false);
        tfToursEnded    .setEditable(false);
        spnrTourId      .setModel(
                new SpinnerNumberModel(0, 0, null, 1)
        );

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
        pnlView.add(lblStatus, gbc);

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
        pnlView.add(tfStatus, gbc);

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
        pnlView.add(lblAverage, gbc);

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
        pnlView.add(tfAverage, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx       = 0;
        gbc.gridy       = 2;
        gbc.weightx     = 0;
        gbc.weighty     = 0;
        gbc.gridwidth   = 1;
        gbc.gridheight  = 1;
        gbc.fill        = GridBagConstraints.NONE;
        gbc.anchor      = GridBagConstraints.NORTHWEST;
        gbc.insets      = new Insets(0, 5, 5, 5);
        pnlView.add(lblTourId, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx       = 1;
        gbc.gridy       = 2;
        gbc.weightx     = 1;
        gbc.weighty     = 0;
        gbc.gridwidth   = 1;
        gbc.gridheight  = 1;
        gbc.fill        = GridBagConstraints.BOTH;
        gbc.anchor      = GridBagConstraints.NORTHWEST;
        gbc.insets      = new Insets(0, 0, 5, 5);
        pnlView.add(spnrTourId, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx       = 0;
        gbc.gridy       = 3;
        gbc.weightx     = 0;
        gbc.weighty     = 0;
        gbc.gridwidth   = 1;
        gbc.gridheight  = 1;
        gbc.fill        = GridBagConstraints.NONE;
        gbc.anchor      = GridBagConstraints.NORTHWEST;
        gbc.insets      = new Insets(0, 5, 5, 5);
        pnlView.add(lblToursStarted, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx       = 1;
        gbc.gridy       = 3;
        gbc.weightx     = 1;
        gbc.weighty     = 0;
        gbc.gridwidth   = 1;
        gbc.gridheight  = 1;
        gbc.fill        = GridBagConstraints.BOTH;
        gbc.anchor      = GridBagConstraints.NORTHWEST;
        gbc.insets      = new Insets(0, 0, 5, 5);
        pnlView.add(tfToursStarted, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx       = 0;
        gbc.gridy       = 4;
        gbc.weightx     = 0;
        gbc.weighty     = 1;
        gbc.gridwidth   = 1;
        gbc.gridheight  = 1;
        gbc.fill        = GridBagConstraints.NONE;
        gbc.anchor      = GridBagConstraints.NORTHWEST;
        gbc.insets      = new Insets(0, 5, 5, 5);
        pnlView.add(lblToursEnded, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx       = 1;
        gbc.gridy       = 4;
        gbc.weightx     = 1;
        gbc.weighty     = 0;
        gbc.gridwidth   = 1;
        gbc.gridheight  = 1;
        gbc.fill        = GridBagConstraints.HORIZONTAL;
        gbc.anchor      = GridBagConstraints.NORTHWEST;
        gbc.insets      = new Insets(0, 0, 5, 5);
        pnlView.add(tfToursEnded, gbc);


        //Fill the button bar
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


        //Add the button bar and the view panel to the frame
        gbc = new GridBagConstraints();
        gbc.gridx       = 0;
        gbc.gridy       = 0;
        gbc.weightx     = 1;
        gbc.weighty     = 1;
        gbc.gridwidth   = 1;
        gbc.gridheight  = 1;
        gbc.fill        = GridBagConstraints.BOTH;
        gbc.anchor      = GridBagConstraints.NORTHWEST;
        gbc.insets      = new Insets(0, 0, 0, 0);
        pnlMain.add(spView, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx       = 0;
        gbc.gridy       = 1;
        gbc.weightx     = 1;
        gbc.weighty     = 0;
        gbc.gridwidth   = 1;
        gbc.gridheight  = 1;
        gbc.fill        = GridBagConstraints.BOTH;
        gbc.anchor      = GridBagConstraints.NORTHWEST;
        gbc.insets      = new Insets(5, 5, 5, 5);
        pnlMain.add(pnlButtonBar, gbc);

        setContentPane(pnlMain);
    }

    /**
     * Initialize the listeners associated to GUI elements.
     * Only to be called from the constructor, do not call anywhere else!
     */
    private void initListeners() {
        btnStart.addActionListener(e -> startTour());
        btnStop.addActionListener(e -> stopTour());
    }

    /**
     * Start a new tour.
     */
    private void startTour() {
        try {
            Tour tour = rental.startTour();
            tfStatus.setText(String.format(TOUR_FORMAT, tour.getTourId()));
            tours.add(tour);
        } catch (TourException e) {
            tfStatus.setText(e.getMessage());
            return;
        }

        updateStatistics();
    }

    /**
     * Stop a tour. The value in the spinner {@link #spnrTourId} is used for tour ID.
     */
    private void stopTour() {
        int tourId = (int) spnrTourId.getValue();

        Tour found = null;

        for(Tour t : tours) {
            if(t.getTourId() == tourId) {
                found = t;
            }
        }

        if(found == null) {
            tfStatus.setText(String.format(DURATION_ERROR, tourId));
            return;
        }

        try {
            rental.stopTour(found);

            tfStatus.setText(String.format(DURATION_FORMAT, found.getDuration()));
        } catch (TourException e) {
            tfStatus.setText(e.getMessage());
        }

        updateStatistics();
    }

    /**
     * Update the statistics GUI elements.
     */
    private void updateStatistics() {
        tfAverage.setText(String.format(AVERAGE_FORMAT, rental.getAverageTimeInMillis()));
        tfToursStarted.setText(String.valueOf(rental.getNumberOfTours()));
        tfToursEnded.setText(String.valueOf(rental.getNumberReturned()));
    }

    public static void main(String[] args) {
        GUI frame = new GUI();
        frame.setMinimumSize(new Dimension(600, 600));
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }
}