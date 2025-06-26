import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.*;
import java.util.List;
import java.io.*;

public class GymGUI
{
    private List<GymMember> members = new ArrayList<>();// It uses ArrayList which holds both RegularMember and PremiumMember
    //GUI components
    private JFrame frame;
    private JPanel panel;
    private JLabel title, Name, ID, Location, Phone, DOB, Gender, Trainername, Email, Paidamount, Referralsource, Removalreason, Membershipstartdate, Plan, Regularprice, Premiumcharge, Discount;
    private JTextField name, id, location, phone, trainername, email, paidamount, referralsource, regularplanprice, premiumplancharge, discountamount;
    private JTextArea removalreason;
    private JRadioButton Male ,Female, Others;
    private JComboBox<String> DOByear, DOBmonth, DOBday, memberyear,membermonth, memberday, plancombo;
    private JButton regularMember, premiumMember, mark, active, deactive, revertRegular, revertPremium, display, clear, upgradePlan, calculateDiscount, payDue, saveToFile, readFromFile;
    
    //Constructor
    public GymGUI()
    {
        //Initializing and position the main frame
        frame = new JFrame("GymGUI");
        frame.setSize(1280,720);// setting frame size
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//close application on frame close
        frame.setLayout(null); //setting layout to null 
        
        //Initializing and position panel
        panel = new JPanel();
        panel.setBounds(25, 50, 1215, 580);//x,y,width,height
        panel.setBackground(new Color(240, 200, 160));//setting background color
        panel.setLayout(null);//setting panel to null
        frame.add(panel);//adding panel to frame
        
        //Initializing and position title label 
        title = new JLabel("GYM");
        title.setBounds(590, 0, 200, 60);//x,y,width,height
        title.setFont(new Font("Arial",Font.BOLD,40));//set the font size and style
        frame.add(title);//adding title to frame
        
        //initallizing and position name label and text
        Name = new JLabel("Name:");
        Name.setBounds(50, 30, 100, 25);//x,y,width,height
        name = new JTextField();
        name.setBounds(150, 30, 300, 25);//x,y,width,height
        panel.add(Name);//adding Name to panel
        panel.add(name);//adding name to panel
        
        // initializing and position ID label and text field
        ID = new JLabel("ID:");
        ID.setBounds(50, 70, 100, 25);//x,y,width,height
        id = new JTextField();
        id.setBounds(150, 70, 300, 25);//x,y,width,height
        panel.add(ID);//adding ID to panel
        panel.add(id);//adding id to panel
        
        //initalizing and position Loaction label and text field
        Location = new JLabel("Location:");
        Location.setBounds(50, 110, 100, 25);//x,y,width,height
        location = new JTextField();
        location.setBounds(150, 110, 300, 25);//x,y,width,height
        panel.add(Location);//adding Location to panel
        panel.add(location);//adding location to panel
        
        //initalizing and position phone label and text field
        Phone = new JLabel("Phone:");
        Phone.setBounds(50, 150, 100, 25);//x,y,width,height
        phone = new JTextField();
        phone.setBounds(150, 150, 300, 25);//x,y,width,height
        panel.add(Phone);//adding Phone to panel
        panel.add(phone);//adding phone to panel
        
        // initalizing and position DOB label and combo box
        DOB = new JLabel("DOB:");
        DOB.setBounds(50, 190, 160, 25);//x,y,width,height
        String[] years = {"1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999","2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008","2009"};
        String[] months = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
        String[] days = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
        DOByear = new JComboBox<>(years);
        DOByear.setBounds(150, 190, 80, 25);//x,y,width,height
        DOBmonth = new JComboBox<>(months);
        DOBmonth.setBounds(240, 190, 100, 25);//x,y,width,height
        DOBday = new JComboBox<>(days);
        DOBday.setBounds(350, 190, 80, 25);//x,y,width,height
        panel.add(DOB);//adding DOB to panel
        panel.add(DOByear);//adding DOByear to panel
        panel.add(DOBmonth);//adding DOBmonth to panel
        panel.add(DOBday);//adding DOBday to panel
        
        //initalizing and position gender label and radio buttons
        Gender = new JLabel("Gender:");
        Gender.setBounds(50, 230, 120, 25);//x,y,width,height
        Male = new JRadioButton("Male");
        Male.setBounds(180, 230, 80, 25); //x,y,width,height
        Male.setBackground(new Color(240, 200, 160));
        Female = new JRadioButton("Female");
        Female.setBounds(270, 230, 100, 25);//x,y,width,height
        Female.setBackground(new Color(240, 200, 160));
        Others = new JRadioButton("Other");
        Others.setBounds(380, 230, 100, 25);//x,y,width,height
        Others.setBackground(new Color(240, 200, 160));
        //group radio buttons to allow only one selection
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(Male);
        genderGroup.add(Female);
        genderGroup.add(Others);
        panel.add(Gender);//adding Gender to panel
        panel.add(Male);//adding Male to panel
        panel.add(Female);//adding Female to panel
        panel.add(Others);//adding Others to panel
        
        //initalizing and position email label and text field
        Email = new JLabel("Email:");
        Email.setBounds(700, 30, 100, 25);//x,y,width,height
        email = new JTextField();
        email.setBounds(800, 30, 300, 25);//x,y,width,height
        panel.add(Email);//adding Email to panel
        panel.add(email);//adding email to panel
        
        //initalizing and position tranier name label and text field
        Trainername = new JLabel("Trainer name:");
        Trainername.setBounds(700, 70, 100, 25);//x,y,width,height
        trainername = new JTextField();
        trainername.setBounds(800, 70, 300, 25);//x,y,width,height
        panel.add(Trainername);//adding Trainername to panel
        panel.add(trainername);//adding trainername to panel
        
        //initalizing and position referral source label and text field
        Referralsource = new JLabel("Referral source:");
        Referralsource.setBounds(700, 110, 100, 25);//x,y,width,height
        referralsource = new JTextField();
        referralsource.setBounds(800, 110, 300, 25);//x,y,width,height
        panel.add(Referralsource);//adding Referralsource to panel
        panel.add(referralsource);//adding referralsource to panel
        
        //initializing and position membership start date label and combo boxes
        Membershipstartdate = new JLabel("Membership Start Date:");
        Membershipstartdate.setBounds(700, 150, 160, 25);//x,y,width,height
        String[] year = {"2019","2020","2021","2022","2023","2024","2025"};
        String[] month = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
        String[] day = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
        memberyear = new JComboBox<>(year);
        memberyear.setBounds(870, 150, 80, 25);//x,y,width,height
        membermonth = new JComboBox<>(month);
        membermonth.setBounds(960, 150, 80, 25); //x,y,width,height
        memberday = new JComboBox<>(day);
        memberday.setBounds(1050, 150, 80, 25);//x,y,width,height
        panel.add(Membershipstartdate);//adding Membershipstartdateto panel
        panel.add(memberyear);//adding memberyear to panel
        panel.add(membermonth);//adding membermonth to panel
        panel.add(memberday);//adding memberday to panel
        
        //initalizing and position button to add regular member
        regularMember = new JButton("Add Regular member");
        regularMember.setBounds(680, 190, 200, 35);//x,y,width,height
        panel.add(regularMember);//adding regularMember to panel
        
        //Add ActionListener 
        regularMember.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try 
                {
                    int memberId;
                try 
                {
                    memberId = Integer.parseInt(id.getText());
                } 
                catch (NumberFormatException ex) 
                {
                    JOptionPane.showMessageDialog(frame, "ID must be a number.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                //check for duplicate ID
                for (GymMember gym : members) 
                {
                    if (gym.getId() == memberId) 
                    {
                        JOptionPane.showMessageDialog(frame, "Duplicate ID.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                } 
                
                //validate name
                if (name.getText().length() == 0) 
                {
                        JOptionPane.showMessageDialog(frame, "Name cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                }
                
                //validate phone
                if (phone.getText().length() == 0) 
                {
                        JOptionPane.showMessageDialog(frame, "Phone number cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
                        return; 
                }
                
                //validate email
                if (email.getText().length() == 0) 
                {
                        JOptionPane.showMessageDialog(frame, "Email cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                }

                // Getting other input values
                String memberName = name.getText();
                String memberPhone = phone.getText();
                String memberEmail = email.getText();
                String memberLocation = location.getText();
                String dob = DOByear.getSelectedItem() + "-" + DOBmonth.getSelectedItem() + "-" + DOBday.getSelectedItem();
                String membershipstartDate = memberyear.getSelectedItem() + "-" + membermonth.getSelectedItem() + "-" + memberday.getSelectedItem();
                String referral = referralsource.getText();
                
                //determine selected gender
                String gender;
                if (Male.isSelected()) 
                {
                    gender = "Male";
                } 
                else if (Female.isSelected()) 
                {
                    gender = "Female";
                } 
                else if (Others.isSelected()) 
                {
                    gender = "Other";
                } 
                else 
                {
                    JOptionPane.showMessageDialog(frame, "Please select a gender.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Creating RegularMember object and adding it to the list
                RegularMember regular = new RegularMember(memberId, memberName, memberLocation, memberPhone, memberEmail, gender, dob, membershipstartDate, referral);
                members.add(regular);

                // Showing success message
                JOptionPane.showMessageDialog(frame, "Regular Member sucessfully Added!", "Success", JOptionPane.INFORMATION_MESSAGE);
                } 
                catch (NumberFormatException ex) 
                {
                    JOptionPane.showMessageDialog(frame, "Invalid paid amount.");
                } 
                catch (Exception ex) 
                {
                    JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        //initialize and position button to add premium member
        premiumMember = new JButton("Add Premium member");
        premiumMember.setBounds(930, 190, 200, 35);//x,y,width,height
        panel.add(premiumMember);//adding premiumMember to panel
        
        //Adding ActionListener
        premiumMember.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                try 
                {
                    int memberId;
                    try 
                    {
                        memberId = Integer.parseInt(id.getText());
                    }  
                    catch (NumberFormatException ex) 
                    {
                        JOptionPane.showMessageDialog(frame, "ID must be a number.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    // Checking for duplicate Member ID
                    for (GymMember gym : members) 
                    {
                        if (gym.getId() == memberId) 
                        {
                            JOptionPane.showMessageDialog(frame, "Duplicate ID.", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                    }
                    
                    //validate name
                    if (name.getText().length() == 0) 
                    {
                        JOptionPane.showMessageDialog(frame, "Name cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    
                    //validate phone
                    if (phone.getText().length() == 0) 
                    {
                        JOptionPane.showMessageDialog(frame, "Phone number cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    
                    //validate email
                    if (email.getText().length() == 0) 
                    {
                        JOptionPane.showMessageDialog(frame, "Email cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    
                    // Getting other input values
                    String memberName = name.getText();
                    String memberPhone = phone.getText();
                    String memberEmail = email.getText();
                    String memberLocation = location.getText();
                    String dob = DOByear.getSelectedItem() + "-" + DOBmonth.getSelectedItem() + "-" + DOBday.getSelectedItem();
                    String startDate = memberyear.getSelectedItem() + "-" + membermonth.getSelectedItem() + "-" + memberday.getSelectedItem();
                    String referral = referralsource.getText();
                    String trainerName = trainername.getText(); // for premium member
                    
                    //determine selected gender
                    String gender;
                    if (Male.isSelected()) 
                    {
                        gender = "Male";
                    } 
                    else if (Female.isSelected()) 
                    {
                        gender = "Female";
                    } 
                    else if (Others.isSelected()) 
                    {
                        gender = "Other";
                    }
                    else 
                    {
                        JOptionPane.showMessageDialog(frame, "Please select a gender.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }              
                    
                    //validate paid amount
                    double paidAmount;
                    try 
                    {
                        if (paidamount.getText().length() == 0) 
                        {
                            paidAmount = 0.0;
                        } 
                        else 
                        {
                            paidAmount = Double.parseDouble(paidamount.getText());
                        }
                    } 
                    catch (NumberFormatException ex) 
                    {
                        JOptionPane.showMessageDialog(frame, "Paid amount must be a number.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    
                    // Creating PremiumMember object and adding it to the list
                    PremiumMember premium = new PremiumMember(memberId, memberName, memberLocation, memberPhone, memberEmail, gender, dob, startDate, trainerName);
                    String paymentResult = "";
                    if (paidAmount > 0) 
                    {
                        paymentResult = premium.payDueAmount(paidAmount);
                    }
                    members.add(premium);

                    // Showing success message
                    JOptionPane.showMessageDialog(frame, "Premium Member Added!"+ paymentResult, "Success", JOptionPane.INFORMATION_MESSAGE);
                } 
                catch (NumberFormatException ex) 
                {
                    JOptionPane.showMessageDialog(frame, "Invalid paid amount.");
                }  
                catch (Exception ex) 
                {
                    JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        //initializing  and position plan label and combo box
        Plan = new JLabel("Plan:");
        Plan.setBounds(700, 250, 80, 25);//x,y,width,height
        String[] plan = {"Basic", "Standard" , "Deluxe"};
        plancombo = new JComboBox<>(plan);
        plancombo.setBounds(750, 250, 90, 25);//x,y,width,height
        panel.add(Plan);//adding Plan to panel
        panel.add(plancombo);//adding plancombo to panel
        
        //iniliaizing and position regular plan price label and text field
        Regularprice = new JLabel("Regular Plan Price:");
        Regularprice.setBounds(860, 250, 130, 25);//x,y,width,height
        regularplanprice = new JTextField("6500"); 
        regularplanprice.setBounds(998, 250, 100, 25);//x,y,width,height
        regularplanprice.setEditable(false);//making it non editable text
        panel.add(Regularprice);//adding Regularprice to panel
        panel.add(regularplanprice);//adding regularplanprice to panel
        
        //initializing and position premium plan charge label and textfield
        Premiumcharge = new JLabel("Premium Plan Charge:");
        Premiumcharge.setBounds(860, 285, 140, 25);//x,y,width,height
        premiumplancharge = new JTextField("50000");
        premiumplancharge.setBounds(998, 285, 100, 25);//x,y,width,height
        premiumplancharge.setEditable(false);//making it non editable text
        panel.add(Premiumcharge);//adding Premiumcharge to panel
        panel.add(premiumplancharge);//adding premiumplancharge to panel
        
        //initializing and position discount amount label and text field
        Discount = new JLabel("Discount Amount:");
        Discount.setBounds(860, 320, 140, 25);//x,y,width,height
        discountamount = new JTextField("5000"); 
        discountamount.setBounds(998, 320, 100, 25);//x,y,width,height
        discountamount.setEditable(false);//making it non editable text
        panel.add(Discount);//adding Discount to panel
        panel.add(discountamount);//adding discountamount to panel
        
        //initializing and position paid amount label and text field
        Paidamount = new JLabel("Paid amount:");
        Paidamount.setBounds(700, 355, 100, 25);//x,y,width,height
        paidamount = new JTextField();
        paidamount.setBounds(800, 355, 290, 25);//x,y,width,height
        panel.add(Paidamount);//adding Paidamount to panel
        panel.add(paidamount);//adding paidamount to panel
        
        //initializing and position mark attendance button
        mark = new JButton("Mark Attendance");
        mark.setBounds(50, 270, 200, 35);//x,y,width,height
        panel.add(mark);//adding mark to panel
        
        //adding ActionListener
        mark.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                try 
                {
                    int memberId;
                    try 
                    {
                         memberId = Integer.parseInt(id.getText());
                    }  
                    catch (NumberFormatException ex) 
                    {
                        JOptionPane.showMessageDialog(frame, "ID must be a number.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    
                    //find member by ID
                    GymMember memberToMark = null;
                    for (GymMember gym : members) 
                    {
                        if (gym.getId() == memberId) 
                        {
                            memberToMark = gym;
                            break;
                        }
                    }
                    
                    // mark attendance if member is found and active
                    if (memberToMark != null) 
                    {
                        if (memberToMark.getActiveStatus()) 
                        {
                            memberToMark.markAttendance();
                            JOptionPane.showMessageDialog(frame, "Attendance Marked!", "Success", JOptionPane.INFORMATION_MESSAGE);
                        } 
                        else 
                        {
                            JOptionPane.showMessageDialog(frame, "Member is not active.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } else 
                    {
                        JOptionPane.showMessageDialog(frame, "Member ID not found.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        //initializing and position activate membership button
        active = new JButton("Activate Membership");
        active.setBounds(380, 270, 200, 35);//x,y,width,height
        panel.add(active);//adding active to panel
        
        //Add ActionListener
        active.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                try 
                {
                    //valid ID input
                   String memberIdText = id.getText();
                   if (memberIdText.length() == 0) 
                   {
                        JOptionPane.showMessageDialog(frame, "ID is required.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                   }

                   // Converting ID to integer
                   int memberId;
                   try 
                   {
                        memberId = Integer.parseInt(memberIdText);
                   } 
                   catch (NumberFormatException ex) 
                   {
                        JOptionPane.showMessageDialog(frame, "ID must be a number.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                   }

                    // Searching for the member
                   GymMember memberToActivate = null;
                   for (GymMember gym : members) 
                   {
                        if (gym.getId() == memberId)  // Correct int comparison
                        {
                            memberToActivate = gym;    // Use correct variable name
                            break;
                        }
                   }

                   //activate membership if found
                   if (memberToActivate != null) 
                   {
                        memberToActivate.activateMembership(); // Assuming activateMembership() is defined in GymMember class
                        JOptionPane.showMessageDialog(frame, "Membership Activated!", "Success", JOptionPane.INFORMATION_MESSAGE);
                   } 
                   else 
                   {
                        JOptionPane.showMessageDialog(frame, "Member ID not found.", "Error", JOptionPane.ERROR_MESSAGE);
                   }
                }  
                catch (Exception ex) 
                {
                    JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        //initalizing and position deactivate membership button
        deactive = new JButton("Deactivate Membership");
        deactive.setBounds(50, 315, 200, 35);//x,y,width,height
        panel.add(deactive);//adding deactive to panel
        
        //adding ActionListener
        deactive.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) 
            {
                try 
                {
                    //Finding ID input
                    String memberIdText = id.getText();
                    if (memberIdText.isEmpty()) 
                    {
                        JOptionPane.showMessageDialog(frame, "ID is required.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }       
                    
                    //converting memberID to integer
                    int memberId;
                    try 
                    {
                        memberId = Integer.parseInt(memberIdText);
                    } 
                    catch (NumberFormatException ex) 
                    {
                        JOptionPane.showMessageDialog(frame, "ID must be a number.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    // find member by ID
                    GymMember memberToDeactivate = null;
                    for (GymMember gym : members) 
                    {
                        if (gym.getId() == memberId) 
                        {
                            memberToDeactivate = gym;
                            break;
                        }
                    }
                    
                    //deactivate membership if found
                    if (memberToDeactivate != null) 
                    {
                        memberToDeactivate.deactivateMembership(); // Assuming deactivateMembership() is defined in GymMember class
                        JOptionPane.showMessageDialog(frame, "Membership Deactivated!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    } 
                    else 
                    {
                        JOptionPane.showMessageDialog(frame, "Member ID not found.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } 
                catch (Exception ex) 
                {
                    JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        //initializing and position revert regular member button
        revertRegular = new JButton("Revert Regular Member");
        revertRegular.setBounds(50, 360, 200, 35);//x,y,width,height260, 270, 200, 35
        panel.add(revertRegular);//adding revert to panel
        
        //adding ActionListener
        revertRegular.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                try
                {
                    //validate ID input
                    String memberIdText = id.getText();
                    if (memberIdText.length() == 0) 
                    {
                        JOptionPane.showMessageDialog(frame, "ID is required.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    
                    //converting memberID to integer
                    int memberId;
                    try 
                    {
                        memberId = Integer.parseInt(memberIdText);
                    } 
                    catch (NumberFormatException ex) 
                    {
                        JOptionPane.showMessageDialog(frame, "ID must be a number.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    
                    //find member by ID
                    GymMember memberToRevert = null;
                    for (GymMember gym : members) 
                    {
                        if (gym.getId() == memberId) 
                        {
                            memberToRevert = gym;
                            break;
                        }
                    }
                    
                    //revert regular member if found and is RegularMember
                    if (memberToRevert != null && memberToRevert instanceof RegularMember) 
                    {
                        String reason = removalreason.getText();
                        if (reason.length() == 0) 
                        {
                            JOptionPane.showMessageDialog(frame, "Removal reason is required.", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        ((RegularMember) memberToRevert).revertRegularMember(reason);
                        JOptionPane.showMessageDialog(frame, "Regular Member reverted.", "Success", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else 
                    {
                        JOptionPane.showMessageDialog(frame, "Member is not a Regular Member or ID not found.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        //initializing and position revert premium member button 
        revertPremium = new JButton("Revert Premium Member");
        revertPremium.setBounds(380, 360, 200, 35);//260, 310, 200, 35
        panel.add(revertPremium);

        //adding actionlistener
        revertPremium.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                try 
                {
                    //validate ID input
                    String memberIdText = id.getText();
                    if (memberIdText.length() == 0) 
                    {
                        JOptionPane.showMessageDialog(frame, "ID is required.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    //converting memberID to integer
                    int memberId;
                    try 
                    {
                        memberId = Integer.parseInt(memberIdText);
                    } 
                    catch (NumberFormatException ex) 
                    {
                        JOptionPane.showMessageDialog(frame, "ID must be a number.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    //find member by ID
                    GymMember memberToRevert = null;
                    for (GymMember gym : members) 
                    {
                        if (gym.getId() == memberId) 
                        {
                            memberToRevert = gym;
                            break;
                        }
                    }

                    //revert premium member if found and is PremiumMember
                    if (memberToRevert != null && memberToRevert instanceof PremiumMember) 
                    {
                        ((PremiumMember) memberToRevert).revertPremiumMember();
                        JOptionPane.showMessageDialog(frame, "Premium Member reverted.", "Success", JOptionPane.INFORMATION_MESSAGE);
                    } 
                    else 
                    {
                        JOptionPane.showMessageDialog(frame, "Member is not a Premium Member or ID not found.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        //initalizing and position upgrade plan button
        upgradePlan = new JButton("Upgrade Plan");
        upgradePlan.setBounds(380, 315, 200, 35);//260, 350, 200, 35
        panel.add(upgradePlan);

        //adding action listner
        upgradePlan.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) {
                try 
                {
                    int memberId;
                    try 
                    {
                        memberId = Integer.parseInt(id.getText());
                    } 
                    catch (NumberFormatException ex) 
                    {
                        JOptionPane.showMessageDialog(frame, "ID must be a number.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    //find member by ID
                    GymMember member = null;
                    for (GymMember gym : members) 
                    {
                        if (gym.getId() == memberId) 
                        {
                            member = gym;
                            break;
                        }
                    }
                    //upgrade plan if member is found, is RegularMember, and active 
                    if (member != null && member instanceof RegularMember) 
                    {
                        if (member.getActiveStatus()) 
                        {
                            String newPlan = (String) plancombo.getSelectedItem();
                            String result = ((RegularMember) member).upgradePlan(newPlan.toLowerCase());
                            JOptionPane.showMessageDialog(frame, result, "Success", JOptionPane.INFORMATION_MESSAGE);
                        } 
                        else 
                        {
                            JOptionPane.showMessageDialog(frame, "Member is not active.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } 
                    else 
                    {
                        JOptionPane.showMessageDialog(frame, "Member is not a Regular Member or ID not found.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        //initializing and position calculate discount button
        calculateDiscount = new JButton("Calculate Discount");
        calculateDiscount.setBounds(900, 400, 200, 35);
        panel.add(calculateDiscount);

        //adding action listner
        calculateDiscount.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                try 
                {
                    int memberId;
                    try 
                    {
                        memberId = Integer.parseInt(id.getText());
                    } 
                    catch (NumberFormatException ex) 
                    {
                        JOptionPane.showMessageDialog(frame, "ID must be a number.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    //find member by ID 
                    GymMember member = null;
                    for (GymMember gym : members) 
                    {
                        if (gym.getId() == memberId) 
                        {
                            member = gym;
                            break;
                        }
                    }

                    //calculate discount if member is found and is PremiumMember
                    if (member != null && member instanceof PremiumMember) 
                    {
                        ((PremiumMember) member).calculateDiscount();
                        JOptionPane.showMessageDialog(frame, "Discount calculated.", "Success", JOptionPane.INFORMATION_MESSAGE);
                    } 
                    else 
                    {
                        JOptionPane.showMessageDialog(frame, "Member is not a Premium Member or ID not found.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        //initializing and position pay due amount button
        payDue = new JButton("Pay Due Amount");
        payDue.setBounds(610, 400, 200, 35);//470, 310, 200, 35
        panel.add(payDue);

        //adding acion listner
        payDue.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                try 
                {
                    int memberId;
                    try 
                    {
                        memberId = Integer.parseInt(id.getText());
                    } 
                    catch (NumberFormatException ex) 
                    {
                        JOptionPane.showMessageDialog(frame, "ID must be a number.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    double amount;
                    try 
                    {
                        if (paidamount.getText().length() == 0) 
                        {
                            JOptionPane.showMessageDialog(frame, "Paid amount is required.", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        amount = Double.parseDouble(paidamount.getText());
                    } 
                    catch (NumberFormatException ex) 
                    {
                        JOptionPane.showMessageDialog(frame, "Paid amount must be a number.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    //find member by ID
                    GymMember member = null;
                    for (GymMember gym : members) 
                    {
                        if (gym.getId() == memberId) 
                        {
                            member = gym;
                            break;
                        }
                    }

                    //process paymemnt if member is found and is PremiumMember
                    if (member != null && member instanceof PremiumMember) 
                    {
                        String result = ((PremiumMember) member).payDueAmount(amount);
                        JOptionPane.showMessageDialog(frame, result, "Success", JOptionPane.INFORMATION_MESSAGE);
                    } 
                    else 
                    {
                        JOptionPane.showMessageDialog(frame, "Member is not a Premium Member or ID not found.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        //initializing and position display button
        display = new JButton("Display");
        display.setBounds(270, 530, 200, 35);//x,y,width,height
        panel.add(display);//adding display to panel
        
        //adding ActionListener
        display.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                //create new frame to display member details
                JFrame displayFrame = new JFrame("All Members");
                displayFrame.setSize(800, 600);
                displayFrame.setLayout(new BorderLayout());

                //create text area to show member details
                JTextArea displayArea = new JTextArea();
                displayArea.setEditable(false);
                StringBuilder details = new StringBuilder();
                for (GymMember gym : members) 
                {
                    details.append(formatMemberDetails(gym));
                    details.append("\n");
                }
                displayArea.setText(details.toString());

                //add sroll pane for text area
                JScrollPane scrollPane = new JScrollPane(displayArea);
                displayFrame.add(scrollPane, BorderLayout.CENTER);
                displayFrame.setVisible(true);
            }
        });
        
        //initializing and position clear button
        clear = new JButton("Clear");
        clear.setBounds(760, 530, 200, 35);//x,y,width,height
        panel.add(clear);//adding clear to panel
        
        //adding ActionListener
        clear.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                // Clear text fields
                name.setText("");
                id.setText("");
                location.setText("");
                phone.setText("");
                email.setText("");
                trainername.setText("");
                referralsource.setText("");
                paidamount.setText("");
                removalreason.setText("");

                // Clear radio buttons (assuming a ButtonGroup is used)
                genderGroup.clearSelection();

                // Resetting combo boxes (if present)
                DOByear.setSelectedIndex(0);
                DOBmonth.setSelectedIndex(0);
                DOBday.setSelectedIndex(0);
                memberyear.setSelectedIndex(0);
                membermonth.setSelectedIndex(0);
                memberday.setSelectedIndex(0);
                plancombo.setSelectedIndex(0);
            }
        });
        
        //initializing and position save to file button
        saveToFile = new JButton("Save to File");
        saveToFile.setBounds(900, 450, 200, 35);
        panel.add(saveToFile);

        //adding action listener
        saveToFile.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                try 
                {
                    //write number details to file
                    FileWriter writer = new FileWriter("MemberDetails.txt");
                    //write header
                    writer.write(String.format("%-5s %-15s %-15s %-15s %-25s %-20s %-10s %-10s %-10s %-15s %-10s %-15s %-15s %-15s\n",
                            "ID", "Name", "Location", "Phone", "Email", "Membership Start Date", "Plan", "Price", "Attendance", "Loyalty Points", "Active Status", "Full Payment", "Discount Amount", "Net Amount Paid"));
                    
                    //write each member's details      
                    for (GymMember gym : members) 
                    {
                        String plan = gym instanceof RegularMember ? ((RegularMember) gym).getPlan() : "-";
                        String price = gym instanceof RegularMember ? String.valueOf(((RegularMember) gym).getPrice()) : "-";
                        String fullPayment = gym instanceof PremiumMember ? (((PremiumMember) gym).getIsFullPayment() ? "Yes" : "No") : "-";
                        String discount = gym instanceof PremiumMember ? String.valueOf(((PremiumMember) gym).getDiscountAmount()) : "-";
                        String paid = gym instanceof PremiumMember ? String.valueOf(((PremiumMember) gym).getPaidAmount()) : "-";
                        writer.write(String.format( "%-5s %-15s %-15s %-15s %-25s %-20s %-10s %-10s %-10s %15s %-10s %-15s %-15s %-15s\n",
                                gym.getId(), gym.getName(), gym.getLocation(), gym.getPhone(), gym.getEmail(), gym.getMembershipStartDate(),
                                plan, price, gym.getAttendance(), gym.getLoyaltyPoints(), gym.getActiveStatus() ? "Active" : "Inactive",
                                fullPayment, discount, paid));
                    }
                    writer.close();
                    JOptionPane.showMessageDialog(frame, "Member details saved to MemberDetails.txt", "Success", JOptionPane.INFORMATION_MESSAGE);
                } 
                catch (IOException ex) 
                {
                    JOptionPane.showMessageDialog(frame, "Error saving to file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        //initializing and position read from file button
        readFromFile = new JButton("Read from File");
        readFromFile.setBounds(610, 450, 200, 35);
        panel.add(readFromFile);

        //adding action listner
        readFromFile.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) 
            {
                try 
                {
                    //create new frame to display file contents
                    JFrame readFrame = new JFrame("Member Details from File");
                    readFrame.setSize(800, 600);
                    readFrame.setLayout(new BorderLayout());

                    //create text area to show file contents
                    JTextArea readArea = new JTextArea();
                    readArea.setEditable(false);
                    BufferedReader reader = new BufferedReader(new FileReader("MemberDetails.txt"));
                    String line;
                    StringBuilder content = new StringBuilder();
                    //read file line by line
                    while ((line = reader.readLine()) != null) 
                    {
                        content.append(line).append("\n");
                    }
                    reader.close();
                    readArea.setText(content.toString());

                    //add scroll pane for text area
                    JScrollPane scrollPane = new JScrollPane(readArea);
                    readFrame.add(scrollPane, BorderLayout.CENTER);
                    readFrame.setVisible(true);
                } 
                catch (IOException ex) 
                {
                    JOptionPane.showMessageDialog(frame, "Error reading from file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // initializing and position removal reason label and text area
        Removalreason = new JLabel("Removal reason:");
        Removalreason.setBounds(50, 415, 120, 20);//x,y,width,height
        removalreason = new JTextArea();
        removalreason.setBounds(180, 415, 265, 110);//x,y,width,height
        panel.add(Removalreason);//adding Removalreason to panel
        panel.add(removalreason);//adding removalreason to panel
        
        //make frame visible 
        frame.setVisible(true);
    }
    
    //method to format member details for display
    private String formatMemberDetails(GymMember gym) 
    {
        StringBuilder details = new StringBuilder();
        //append common member details
        details.append("ID: ").append(gym.getId()).append("\n");
        details.append("Name: ").append(gym.getName()).append("\n");
        details.append("Location: ").append(gym.getLocation()).append("\n");
        details.append("Phone: ").append(gym.getPhone()).append("\n");
        details.append("Email: ").append(gym.getEmail()).append("\n");
        details.append("Gender: ").append(gym.getGender()).append("\n");
        details.append("DOB: ").append(gym.getDOB()).append("\n");
        details.append("Membership Start Date: ").append(gym.getMembershipStartDate()).append("\n");
        details.append("Attendance: ").append(gym.getAttendance()).append("\n");
        details.append("Loyalty Points: ").append(gym.getLoyaltyPoints()).append("\n");
        details.append("Active Status: ").append(gym.getActiveStatus() ? "Active" : "Inactive").append("\n");

        // append RegularMember specific details
        if (gym instanceof RegularMember) 
        {
            RegularMember regular = (RegularMember) gym;
            details.append("Plan: ").append(regular.getPlan()).append("\n");
            details.append("Price: ").append(regular.getPrice()).append("\n");
            
            if (regular.getRemovalReason().length() > 0) 
            {
                details.append("Removal Reason: ").append(regular.getRemovalReason()).append("\n");
            }
        }
        //append PremiumMember specific details
        else if (gym instanceof PremiumMember) 
        {
            PremiumMember premium = (PremiumMember) gym;
            details.append("Personal Trainer: ").append(premium.getPersonalTrainer()).append("\n");
            details.append("Paid Amount: ").append(premium.getPaidAmount()).append("\n");
            details.append("Full Payment: ").append(premium.getIsFullPayment() ? "Yes" : "No").append("\n");
            details.append("Remaining amount: ").append(premium.getPremiumCharge() - premium.getPaidAmount()).append("\n");
            
            if (premium.getIsFullPayment())
            {
                details.append("Discount Amount: ").append(premium.getDiscountAmount()).append("\n");
            }
        }
        return details.toString();
    }
    
    //main method to launch the application
    public static void main(String[] args)
    {
        new GymGUI();
    }
}