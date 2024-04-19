/**
* PROGRAM DESCRIPTION: TO CREATE A HOTEL ROOM BOOKING  FOR MAJESTIC HOTEL RESERVATION SYSTEM
*
* GROUP MEMBERS:
*1. MUHAMMAD SALMAN FARIS BIN MOHD FAISHAL(AM2307014204)
*2. MUHAMMAD NAQIB ASYRAAF BIN ARIFFIN (AM2307013890)
*3.MUHAMMAD IRHAM FIRDAUS BIN AMRAN (AM2307013904)
*4.MUHAMMAD MAZIZI BIN MAZLAN (AM2307013954)
* 
* 19 APRIL 2024
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HotelLoginSystem extends JFrame {
    //Declares private member variables to hold various GUI components like panels, labels, text fields, password fields, and buttons.
    private JPanel loginPanel, welcomePanel;
    private JLabel usernameLabel, passwordLabel, introLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton, continueButton;

    public HotelLoginSystem() {
        setTitle("Majestic Hotel Login System");
        setSize(1800, 1050);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new CardLayout());

        // Login Panel
        loginPanel = new JPanel();
        loginPanel.setLayout(new GridLayout(3, 2));
        
        //Creates labels and text fields for username and password input.
        usernameLabel = new JLabel("Username:");
        usernameField = new JTextField(15);

        passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField(15);
        
        
        loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                // Validate login credentials here, for simplicity let's assume it's successful
                // If login successful, show welcome panel
                CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
                cardLayout.show(getContentPane(), "welcome");
            }
        });

        loginPanel.add(usernameLabel);
        loginPanel.add(usernameField);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordField);
        loginPanel.add(new JLabel()); // Empty space
        loginPanel.add(loginButton);

        // Welcome Panel
        welcomePanel = new JPanel();
        welcomePanel.setLayout(new BorderLayout());
        
        //Add custom image on the welcome page
        ImageIcon introImage = new ImageIcon("IntroPage.png");
        JLabel introLabel = new JLabel(introImage);
        welcomePanel.add(introLabel);
        

        continueButton = new JButton("Continue");
        continueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add logic to proceed to the next step after login
                JOptionPane.showMessageDialog(null, "Continue to booking page!");
                dispose();
                new HotelBookingPage();
            }
        });

        welcomePanel.add(introLabel, BorderLayout.CENTER);
        welcomePanel.add(continueButton, BorderLayout.SOUTH);

        // Add panels to main frame
        add(loginPanel, "login");
        add(welcomePanel, "welcome");
        //Sets the visibility of the frame to true, making it visible to the user.
        setVisible(true);
    }
    //The main method which starts the application by creating an instance of HotelLoginSystem inside the event dispatch thread for Swing components.
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new HotelLoginSystem();
            }
        });
    }
}