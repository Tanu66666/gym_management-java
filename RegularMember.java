public class RegularMember extends GymMember// A subclass of GymMember
{
    //Using private attributes to specify the RegularMember class
    private final int ATTENDANCE_LIMIT = 30;//attendance limit is set to 30
    private boolean isEligibleForUpgrade;//This means whether the members are eligible for upgrade
    private String removalReason;//reason for removal
    private String referralSource;
    private String plan;//plans for the gym members
    private double price;
    
    //Constructor method 
    public RegularMember (int id, String name, String location, String phone, String email, String gender, String DOB, String membershipStartDate, String referralSource)
    {
        //A call is made to superclass constructor with 8 parameter
        super(id, name, location ,phone, email, gender, DOB, membershipStartDate);
        
        //assign the parameter values
        this.referralSource = referralSource;
        this.isEligibleForUpgrade = false;//This is set as 'False' to not eligible for upgrade
        this.plan = "basic";// plan is set as 'basic'
        this.price = 6500;//price is set to '6500' 
        this.removalReason = "";//removal reason is set empty 
    }
    
    //Applying accessor methods for each attribute
    public int getAttendanceLimit()
    {
        return ATTENDANCE_LIMIT; //returns attendance limit
    }
    
    public boolean getIsEligibleForUpgrade()
    {
        return isEligibleForUpgrade;// returns if the members are eligible for upgrade
    }
    
    public String getRemovalReason()
    {
        return removalReason;//returns reason for removal
    }
    
    public String getReferralSource()
    {
        return referralSource;//returns referral source
    }
    
    public String getPlan()
    {
        return plan;//returns current plan
    }
    
    public double getPrice()
    {
        return price;//returns current price
    }
    
    //implemtation of abstract method
    @Override
    public void markAttendance()
    {
        this.attendance++;// increases the attendance value by 1 each time
        this.loyaltyPoints += 5;// increases loyalty points by 5 each 
        
        if (this.attendance >= ATTENDANCE_LIMIT)// to check the limit for the eligibility to upgrade
        {
            this.isEligibleForUpgrade = true;
        }
    }
    
    // A method to retrieve the price of the given plan
    public double getPlanPrice(String plan)
    {
        switch (plan)// using switch statement to determine the price based on plan
        {
            case "basic": 
                return 6500;// basic plan price
            case "standard": 
                return 12500;// standard plan price
            case "deluxe": 
                return 18500;// deluxe plan price
            default: 
                return -1;//Invalid plan
        }
    }
    
    // A method to upgrade plan
    public String upgradePlan(String newPlan)
    {
        double newPrice = getPlanPrice(newPlan);// To check if the plan is valid
        if (newPrice == -1)
        {
            return "The plan is invalid. ";
        }
        
        if (!isEligibleForUpgrade)// To check if the member is eligible for an upgrade
        {
            return "Not Eligible for an upgrade. ";
        }
        
        if (this.plan.equalsIgnoreCase(newPlan))// To check if the new plan is any different from the current plan
        {
            return "You are already subscribed to " + newPlan + "Plan. ";
        }
        
        // Upgrading plan and price
        this.plan = newPlan;
        this.price = newPrice;
        this.isEligibleForUpgrade = false;
        this.attendance = 0;
        
        return "Your plan has been upgraded to " + newPlan + "with a price of " + this.price + ".";
    }
    
    public void revertRegularMember(String removalReason)
    {
        super.resetMember();// calling a method from superclass to reset the members attribute
        
        //resetting the attributes
        this.isEligibleForUpgrade = false;// setting the eligibility for upgrade to 'false'.
        this.plan = "basic";// setting plan to basic
        this.price = 6500;// setting price to 6500
        this.removalReason = removalReason;// setting the reason for removal
    }
    
    @Override
    // A method to display the details of the RegularMember
    public void display()
    {
        super.display();// calling method from superclass to display all the attributes of superclass
        
        System.out.println("Plan: " + plan);// displaying plan
        System.out.println("Price: " + price);// displaying price
        if(!removalReason.isEmpty())// displaying removal reason if its value is not empty
        {
            System.out.println("Removal Reason: " + removalReason);
        }
    }
}