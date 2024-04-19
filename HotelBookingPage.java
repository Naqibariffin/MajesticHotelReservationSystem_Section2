//Muhammad Salman Faris bin Mohd Faishal's Page

//PROGRAM DESCRIPTION: TO CREATE A HOTEL ROOM SELECTION SYSTEM FOR MAJESTIC HOTEL RESERVATION SYSTEM

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HotelBookingPage extends JFrame {
    //Declares private member variables to hold various GUI components like panels, labels, text fields, combo boxes, and buttons.
    private JPanel bookingPanel;
    private JLabel checkInLabel, checkOutLabel, roomTypeLabel, adultLabel, infantLabel, dayLabel, OccupancyLabel;
    private JTextField checkInField, checkOutField, infantField;
    private JComboBox<String> roomTypeComboBox, dayComboBox, OccupancyComboBox, adultComboBox, infantComboBox;
    private JButton bookButton;

    public HotelBookingPage() {
        setTitle("Majestic Hotel Booking Page");
        setSize(900, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(1, 2));
        
        //Creates a JPanel for booking details with an 8x6 grid layout.
        bookingPanel = new JPanel();
        bookingPanel.setLayout(new GridLayout(8, 6));
        
        //Creates labels and text fields for check-in and check-out dates.
        checkInLabel = new JLabel("Check-In Date (DD/MM/YY):");
        checkInField = new JTextField(15);
        checkOutLabel = new JLabel("Check-Out Date (DD/MM/YY):");
        checkOutField = new JTextField(15);
        
        //creates a label and a combo box for selecting the number of days for the stay.
        dayLabel = new JLabel ("How Many Days:");
        String[] days = {"1", "2", "3"};
        dayComboBox = new JComboBox<>(days);

        //Creates a label and a combo box for selecting the room type.
        roomTypeLabel = new JLabel("Room Type:");
        String[] roomTypes = {"Standard (RM100)", "Deluxe (RM350)", "Suite (RM500)"};
        roomTypeComboBox = new JComboBox<>(roomTypes);
        
        //Creates a label and a combo box for selecting the occupancy type.
        OccupancyLabel = new JLabel("Occupancy:");
        String[] Occupancys = {"Single", "Double"};
        OccupancyComboBox = new JComboBox<>(Occupancys);
        
        //Creates a label and a combo box for selecting the number of adult guests.
        adultLabel = new JLabel("Adult:");
        String[] adults = {"1", "2", "3"};
        adultComboBox = new JComboBox<>(adults);
        
        //Creates a label and a combo box for selecting the number of infant guests.
        infantLabel = new JLabel("Infant:");
        String[] infants = {"1", "2", "3"};
        infantComboBox = new JComboBox<>(infants);

        bookButton = new JButton("Book");
        bookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String checkInDate = checkInField.getText();
                String checkOutDate = checkOutField.getText();
                int day = Integer.parseInt((String) dayComboBox.getSelectedItem());
                String roomType = (String) roomTypeComboBox.getSelectedItem();
                String Occupancy = (String) OccupancyComboBox.getSelectedItem();
                String adult = (String) adultComboBox.getSelectedItem();
                String infant = (String) infantComboBox.getSelectedItem();
                double roomTypePrice, totalprice = 0.0;
                if (roomType == "Standard (RM100)"){
                    roomTypePrice = 100;
                }else if (roomType == "Deluxe (RM350)"){
                    roomTypePrice = 350;
                }else if (roomType == "Suite (500)"){
                    roomTypePrice = 500;
                }else
                roomTypePrice = 0.0;
                
                totalprice = roomTypePrice * day;
                
                
                // Perform booking process here
                // For simplicity, let's just display the booking details
                String bookingDetails = "Booking Details:"+
                                        "\n\nCheck-In Date: " + checkInDate + 
                                        "\nCheck-Out Date: " + checkOutDate +
                                        "\nHow Many Days:" + day  + 
                                        "\n\nRoom Type: " + roomType + 
                                        "\nOccupancy:" + Occupancy +
                                        "\n\nTotal Person In Room"+
                                        "\nAdult: " + adult + 
                                        "\nInfant: " + infant + 
                                        "\n\nTotal Price:" + totalprice;
                JOptionPane.showMessageDialog(null, bookingDetails);
                dispose();
                new GuestInfo(bookingDetails,totalprice);

            }
        });

        //Adds the labels, text fields, combo boxes, and the book button to the booking panel.
        bookingPanel.add(checkInLabel);
        bookingPanel.add(checkInField);
        bookingPanel.add(checkOutLabel);
        bookingPanel.add(checkOutField);
        bookingPanel.add(dayLabel);
        bookingPanel.add(dayComboBox);
        bookingPanel.add(roomTypeLabel);
        bookingPanel.add(roomTypeComboBox);
        bookingPanel.add(OccupancyLabel);
        bookingPanel.add(OccupancyComboBox);
        bookingPanel.add(adultLabel);
        bookingPanel.add(adultComboBox);
        bookingPanel.add(infantLabel);
        bookingPanel.add(infantComboBox);
        bookingPanel.add(new JLabel()); // Empty space
        bookingPanel.add(bookButton);
        
        //Adds the booking panel to the main frame and sets its visibility to true, making it visible to the user.
        add(bookingPanel);
        setVisible(true);
    }
    
}