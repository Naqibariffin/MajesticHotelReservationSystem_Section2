//Muhammad Naqib Asyraaf Bin Ariffin's Page

//PROGRAM DESCRIPTION: TO CREATE A GUEST INFORMATION FORM FOR MAJESTIC HOTEL RESERVATION SYSTEM

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

class GuestInfo extends JFrame implements ActionListener, ItemListener {
    private JLabel lblFirstName, lblLastName, lblEmail, lblAddress, lblNumPhone, lblGender, lblCard;
    private JTextField FirstName, LastName, Email, Address, NumPhone, Gender,Card;
    private JRadioButton btnMale, btnFemale,btnPayByCard,btnPayAtCounter;
    private ButtonGroup radioGroup,cardGroup;
    private JButton btnNext, btnClear;
    private JPanel pnlPersonalInfo,pnlFN, pnlLN, pnlE, pnlA, pnlNP, pnlG, pnlB,pnlPayment,pnlC;
    String bookingDetails;
    double totalprice;
    public GuestInfo(String bookingDetails,double totalprice) {
        super("Majestic Hotel Guest Information");
        this.bookingDetails = bookingDetails;
        this.totalprice = totalprice;
        Container cont = getContentPane();
        cont.setLayout(new BorderLayout());

        //Set Up Label
        //For Guest Information 
        lblFirstName = new JLabel("First Name :");
        lblLastName = new JLabel("Last Name :");
        lblGender = new JLabel("Gender :");
        lblEmail = new JLabel("Email :");
        lblAddress = new JLabel("Address :");
        lblNumPhone = new JLabel("Number Phone :");
        lblCard = new JLabel("Do You Want Pay By :");

        //Set Up Textfield
        //For Guest Information
        FirstName = new JTextField(30);
        LastName = new JTextField(30);
        Gender = new JTextField(10);
        Gender.setEditable(false);
        Email = new JTextField(30);
        Address = new JTextField(100);
        NumPhone = new JTextField(10);

        Card = new JTextField(10);
        Card.setEditable(false);

        //Set Up Radio Button
        //For Guest Information
        btnMale = new JRadioButton("Male");
        btnFemale = new JRadioButton("Female");
        radioGroup = new ButtonGroup();
        radioGroup.add(btnMale);
        radioGroup.add(btnFemale);

        btnPayByCard = new JRadioButton("Card ");
        btnPayAtCounter = new JRadioButton("Counter when Check-In");
        cardGroup = new ButtonGroup();
        cardGroup.add(btnPayByCard);
        cardGroup.add(btnPayAtCounter);

        //Set Up Button
        btnNext = new JButton("NEXT");
        btnClear = new JButton("CLEAR");

        //Set Up Jpanel
        //For Guest Information
        pnlPersonalInfo = new JPanel();
        pnlPersonalInfo.setLayout(new GridLayout(6, 2));
        pnlPersonalInfo.setBorder(new TitledBorder(new EtchedBorder(), "Guest Information"));
        pnlFN = new JPanel();
        pnlFN.setLayout(new GridLayout(1, 1));
        pnlLN = new JPanel();
        pnlLN.setLayout(new GridLayout(1, 1));
        pnlG = new JPanel();
        pnlG.setLayout(new GridLayout(1, 1));
        pnlE = new JPanel();
        pnlE.setLayout(new GridLayout(1, 1));
        pnlA = new JPanel();
        pnlA.setLayout(new GridLayout(1, 1));
        pnlNP = new JPanel();
        pnlNP.setLayout(new GridLayout(1, 1));
        pnlB = new JPanel();
        pnlB.setLayout(new GridLayout(1, 1));

        //For Confirm Reservation
        pnlPayment = new JPanel();
        pnlPayment.setLayout(new GridLayout(1, 1));
        pnlPayment.setBorder(new TitledBorder(new EtchedBorder(), "Confirm Reservation"));
        pnlC = new JPanel();
        pnlC.setLayout(new GridLayout(1, 1));

        // add to JPanel
        pnlFN.add(lblFirstName);
        pnlFN.add(FirstName);
        pnlLN.add(lblLastName);
        pnlLN.add(LastName);
        pnlG.add(lblGender);
        pnlG.add(btnMale);
        pnlG.add(btnFemale);
        pnlE.add(lblEmail);
        pnlE.add(Email);
        pnlA.add(lblAddress);
        pnlA.add(Address);
        pnlNP.add(lblNumPhone);
        pnlNP.add(NumPhone);
        pnlB.add(btnClear);
        pnlB.add(btnNext);

        //For Confirm Reservation
        pnlC.add(lblCard);
        pnlC.add(btnPayByCard);
        pnlC.add(btnPayAtCounter);

        // register itemListener
        btnMale.addItemListener(this);
        btnFemale.addItemListener(this);
        btnPayAtCounter.addItemListener(this);
        btnPayByCard.addItemListener(this);

        // register actionListener
        btnClear.addActionListener(this);
        btnNext.addActionListener(this);

        // add to Container
        pnlPersonalInfo.add(pnlFN);
        pnlPersonalInfo.add(pnlLN);
        pnlPersonalInfo.add(pnlG);
        pnlPersonalInfo.add(pnlE);
        pnlPersonalInfo.add(pnlA);
        pnlPersonalInfo.add(pnlNP);

        pnlPayment.add(pnlC);

        cont.add(pnlPersonalInfo, BorderLayout.NORTH);
        cont.add(pnlPayment, BorderLayout.CENTER);
        cont.add(pnlB, BorderLayout.SOUTH);
        setSize(500, 300);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
       if (e.getSource() == btnClear) {
            FirstName.setText("");
            LastName.setText("");
            Gender.setText("");
            Email.setText("");
            Address.setText("");
            NumPhone.setText("");
            Card.setText("");
        } else { 
            if (btnPayByCard.isSelected()) {
                new PaymentSystem(bookingDetails, FirstName.getText(), Email.getText(), NumPhone.getText(), totalprice);
            } else if (btnPayAtCounter.isSelected()) {
                new Receipt(bookingDetails, FirstName.getText(), Email.getText(),NumPhone.getText(),"Pay At Counter when Check-In","-");
            }
        }
    }

    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == btnMale || e.getSource() == btnFemale) {
            if (btnMale.isSelected()) {
                Gender.setText("Male");
            } else if (btnFemale.isSelected()) {
                Gender.setText("Female");
            }
        } else if (e.getSource() == btnPayByCard || e.getSource() == btnPayAtCounter) {
            if (btnPayByCard.isSelected()) {
                Card.setText("Card");
            } else if (btnPayAtCounter.isSelected()) {
                Card.setText("Pay At Counter");   
            }
        }
    }

}