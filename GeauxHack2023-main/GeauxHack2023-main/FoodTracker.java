

public class FoodTracker 
{
    private int calorie_intake; 
    private int protein_intake;
    private int carbs_intake;
    private int fats_intake;
    private int total_cals;
    private final int protein_conversion = 4;
    private final int carbs_conversion = 4;
    private final int fats_conversion = 9;

    public FoodTracker(){
        calorie_intake = 0; 
        protein_intake = 0;
        carbs_intake = 0;
        fats_intake = 0;
    }
    
    public int getProtein(){
        return protein_intake; 
    }
    
    public int getCarbs(){
        return carbs_intake; 
    }

    public int getFats(){
        return fats_intake; 
    }

    public int protein_to_cal(){
        return (protein_intake*protein_conversion);
    }

    public int carbs_to_cal(){
        return (carbs_intake*carbs_conversion);
    }

    public int fats_to_cal(){
        return (fats_intake*fats_conversion);
    }

    public int macrosToCalories(int x, int y, int z){
        calorie_intake = (x*protein_conversion) + (y*carbs_conversion) + (z*fats_conversion);
        return calorie_intake;
    }

    public int addToTotalCalories(int calculated_cals){
        total_cals =+ calculated_cals;
        return total_cals;
    }
   
    public void setProtein(int protein){
        this.protein_intake = protein; 
    }
    
    public void setCarbs(int carbs){
        this.carbs_intake = carbs;
    }

    public void setFats(int fats){
        this.fats_intake = fats;
    }

    public int addProtein(int x)
    {
       return this.protein_intake += x;
    }

    public int addCarbs(int x)
    {
       return this.carbs_intake += x;
    }

    public int addFats(int x)
    {
       return this.fats_intake += x;
    }
}
