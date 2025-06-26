public class PremiumMember extends GymMember// A subclass of GymMember
{
    // using private attribute to specify the PremiumMember
    private final double PREMIUM_CHARGE = 50000;// fixed premium charge
    private String personalTrainer;
    private boolean isFullPayment;// shows whether full payment has been made
    private double paidAmount;// amount paid
    private double discountAmount;// discount amount
    
    //Constructor method
    public PremiumMember(int id, String name, String location, String phone, String email, String gender, String DOB, String membershipStartDate, String personalTrainer)
    {
        //Calling to superclass constructor
        super(id, name, location, phone, email, gender, DOB, membershipStartDate);
        
        this.personalTrainer = personalTrainer;// set personal trainer
        this.isFullPayment = false;//setting full payment to 'false'
        this.paidAmount = 0;//setting paid amount to zero
        this.discountAmount = 0;//setting discount amount to zero
    }
    
    //using accessor method for each attribute (also known as getter method)
    public double getPremiumCharge()
    {
        return PREMIUM_CHARGE;
    }
    
    public String getPersonalTrainer()
    {
        return personalTrainer;
    }
    
    public boolean getIsFullPayment()
    {
        return isFullPayment;
    }
    
    public double getPaidAmount()
    {
        return paidAmount;
    }
    
    public double getDiscountAmount()
    {
        return discountAmount;
    }
    
    @Override
    //Implementation of abstract method from GymMember class
    public void markAttendance()
    {
        this.attendance++;//increase attendance by 1
        this.loyaltyPoints += 10;//increase loyalty points by 10
    }
    
    public String payDueAmount(double amount)
    {
        if (this.isFullPayment)// to return message if payment is full
        {
            return "Payment is already full.";
        }
        
        if (this.paidAmount + amount>PREMIUM_CHARGE)// if the total paid amount is more than premium charge
        {
            return "The total paid amount is more than premium charge so cannot process the payment.";
        }
        
        this.paidAmount += amount;//adding the paid amount to the current amount
        if (this.paidAmount == PREMIUM_CHARGE)// to check the payment if it is full
        {
            this.isFullPayment = true;// full payment is already paid
        }
        
        double remainingAmount = PREMIUM_CHARGE - this.paidAmount;
        if (this.isFullPayment) // return message
        {
            return"The full payment is made successfully. Remaning amount: " + remainingAmount;
        }
        else
        {
            return"The payment is made successfully. Remaining amount to be paid: " + remainingAmount;
        }
    }
    
    //A method to calculate the discount amount
    public void calculateDiscount()
    {
        if (this.isFullPayment)
        {
            this.discountAmount = 0.1 * PREMIUM_CHARGE;//if payment is full then premium member will get 10% discount 
            System.out.println("Calculated discount: " + this.discountAmount);
        }
        else
        {
            System.out.println("The payment is not full. Discount is not available.");
        }
    }
    
    //A method to revert premiumMember details
    public void revertPremiumMember()
    {
        super.resetMember();//calling it from super class
        
        //resetting the attributes of PremiumMember
        this.personalTrainer = "";//setting personalTrainer as empty
        this.isFullPayment = false;//setting full payment to false
        this.paidAmount = 0;//resetting paid amount to zero
        this.discountAmount = 0;//resetting discount amount to zero
    }
    
    @Override
    //A method to display the details of the PremiumMember
    public void display()
    {
        super.display();//calling the method from superclass to display all the attributes of superclass
        
        //displaying the value of personalTrainer, paidAmount, and isFullPayment
        System.out.println("Personal Trainer: " + this.personalTrainer);
        System.out.println("Paid Amount: " + this.paidAmount);
        System.out.println("Full Payment: " + (this.isFullPayment ? "Yes" : "No"));
        
        double remainingAmount = PREMIUM_CHARGE - this.paidAmount;//calculating the remaining amount
        System.out.println("Remaining amount: " + remainingAmount);
        
        if (this.isFullPayment)// dispalying discount if payment is fully paid
        {
            System.out.println("Discount Amount: " + this.discountAmount);
        }
    }
}