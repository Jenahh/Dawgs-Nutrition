import java.time.*;
import java.util.*;

public class Profiles 
{
    private String username;
    private String password;
    private String full_name;
    private double height;
    private double weight;
    private int calorie_goal;
    private int protein_goal;
    private int carbs_goal;
    private int fats_goal;
    private FoodTracker food;

    private ActivityLog log;
    private double miles_walked = 0;
    private LocalDate lastLogin;

    public Profiles(String username, String password)
    {
        this.username = username;
        this.password = password;
        this.food = new FoodTracker();
        this.log = new ActivityLog();
    }

    public void setUsername(String newName)
    {
        this.username = newName;
    }

    public String getUsername()
    {
        return username;
    }

    public void setPassword(String newPassword)
    {
        this.password = newPassword;
    }

    public String getPassword()
    {
        return password;
    }

    public String getName()
    {
        return full_name;
    }

    public double getWeight()
    {
        return this.weight;
    }

    public void setWeight(double newWeight)
    {
        this.weight = newWeight;
    }

    public double getHeight()
    {
        return this.height;
    }

     public int getCalorie_goal() {
        return calorie_goal;
    }

    public void setCalorie_goal(int calorie_goal) {
        this.calorie_goal = calorie_goal;
    }

    public int getProtein_goal() {
        return protein_goal;
    }

    public void setProtein_goal(int protein_goal) {
        this.protein_goal = protein_goal;
    }

    public int getCarbs_goal() {
        return carbs_goal;
    }

    public void setCarbs_goal(int carbs_goal) {
        this.carbs_goal = carbs_goal;
    }

    public int getFats_goal() {
        return fats_goal;
    }

    public void setFats_goal(int fats_goal) {
        this.fats_goal = fats_goal;
    }

    public double setMilesWalked(){
        return this.miles_walked;
    }

    
    public LocalDate getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(LocalDate lastLogin) {
        this.lastLogin = lastLogin;
    }

    public FoodTracker getFood() {
        return this.food;
    }

    public void setFood(FoodTracker food) {
        this.food = food;
    }

     public ActivityLog getLog() {
        return log;
    }

    public void setLog(ActivityLog log) {
        this.log = log;
    }
    //Calculates the calories burned by multiplying the miles_walked by a certain
    //number based on weight
    public void setCalsWalking()
    {
         if(getWeight() <= 100){
            log.setCaloriesBurned((int)(30 * miles_walked));
         }
         else if(getWeight() > 100 && getWeight() <= 120){
            log.setCaloriesBurned((int)(53 * miles_walked));
         }
         else if(getWeight() > 120 && getWeight() <= 140){
            log.setCaloriesBurned((int)(64 * miles_walked));
         }
         else if(getWeight() > 140 && getWeight() <= 160){
            log.setCaloriesBurned((int)(74 * miles_walked));
         }
         else if(getWeight() > 160 && getWeight() <= 180){
            log.setCaloriesBurned((int)(85 * miles_walked));
         }
         else if(getWeight() > 180 && getWeight() <= 200){
            log.setCaloriesBurned((int)(96 * miles_walked));
         }
         else if(getWeight() > 200 && getWeight() <= 220){
            log.setCaloriesBurned((int)(106 * miles_walked));

         }
         else if(getWeight() > 220 && getWeight() <= 240){
            log.setCaloriesBurned((int)(117 * miles_walked));

         }
         else if(getWeight() > 240 && getWeight() <= 260){
            log.setCaloriesBurned((int)(133 * miles_walked));

         }
         else if(getWeight() > 260 && getWeight() <= 280){
            log.setCaloriesBurned((int)(146 * miles_walked));

         }
         else if(getWeight() > 280 && getWeight() <=300){
            log.setCaloriesBurned((int)(160 * miles_walked));

         }
    }
}

