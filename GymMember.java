public abstract class GymMember  //parent class "GymMember" as a abstract class
{
    // All the attributes are set with protected access modifier which can be accessed by subclasses
    protected int id;//It is a unique ID
    protected String name;
    protected String location;
    protected String phone;
    protected String email;
    protected String gender;
    protected String DOB;
    protected String membershipStartDate;
    protected int attendance;
    protected double loyaltyPoints;
    protected boolean activeStatus;
    
    //Constructor only accepting id,name,location,phone,email,gender,DOB,membershipStartDate as a parameters
    public GymMember(int id, String name, String location, String phone, String email, String gender, String DOB, String membershipStartDate)
    {
        //'this' refers to current object or the instance of the class. It helps to assign parameter from constructor to instance variable
        this.id = id;//assign unique id from the parameter
        this.name = name;//assign name from the parameter
        this.location = location;//assign location from the parameter
        this.phone = phone;//assign phone from the parameter
        this.email = email;//assign email from the parameter
        this.gender = gender;
        this.DOB = DOB;
        this.membershipStartDate = membershipStartDate;//assign membershipStartDate from parameter
        this.attendance = 0; //Initialized attendance to 0
        this.loyaltyPoints = 0.0; //Initialized loyaltyPoints to 0
        this.activeStatus = false; //The membership is inactive by default 
    }
    
    //Applying accessor methods on each attribute (also known as getter method)
    public int getId()
    {
        return id;//return the unique id of members
    }
    
    public String getName()
    {
        return name;//return the name of members
    }
    
    public String getLocation()
    {
        return location;//return location of the members
    }
    
    public String getPhone()
    {
        return phone;//return of the members phone number
    }
    
    public String getEmail()
    {
        return email;//return email of the members
    }
    
    public String getGender()
    {
        return gender;
    }
    
    public String getDOB()
    {
        return DOB;//return date of birth of the members
    }
    
    public String getMembershipStartDate()
    {
        return membershipStartDate;//return date of the members when they started their membership
    }
    
    public int getAttendance()
    {
        return attendance;//return of the members attendance
    }
    
    public double getLoyaltyPoints()
    {
        return loyaltyPoints;//return of the loyalty points that members have earned
    }
    
    public boolean getActiveStatus()
    {
        return activeStatus;//return of the members active status
    }
    
    //Abstract method to mark the attendance of the members
    public abstract void markAttendance();
    
    // A method to activate or renew the members membership where the activeStatus is true
    public void activateMembership()
    {
        activeStatus = true;//activeStatus is set to 'True' for the membership to be active
    }
    
    // A method to deactivate or pause the members membership where the activeStatus is false
    public void deactivateMembership()
    {
        // A method to deactivate the membership which is currently active but can only be deactivated if the membership is still active
        if (activeStatus)
        {
            activeStatus = false;//activeStatus is set to 'False' for the membership to be deactive
        }
        else
        {
            System.out.println("Membership is already deactive");
        }
    }
    
    // A method to reset the members details
    public void resetMember()
    {
        activeStatus = false;//activeStatus set as 'False' to deactivate the membership
        attendance = 0;//attendance set as zero for reset
        loyaltyPoints = 0.0;//loyaltyPoints set as zero for reset
    }
    
    // A method to display output of the attributes or details of the members
    public void display()
    {
        System.out.println("ID: " + id);//members unique id
        System.out.println("Name: " + name);
        System.out.println("Location: " + location);
        System.out.println("Phone: " + phone);
        System.out.println("Email: " + email);
        System.out.println("Gender: " + gender);
        System.out.println("DOB: " + DOB);
        System.out.println("Membership Start Date: " + membershipStartDate);//shows the date of the members when they started the membership
        System.out.println("Attendance: " + attendance);
        System.out.println("Loyalty Points: " + loyaltyPoints);//shows the loyalty points that the members earned
        System.out.println("Active Status: " + (activeStatus ? "Active" : "Inactive"));//shows if the membership is active or deactive
    }
}