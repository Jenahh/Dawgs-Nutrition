
public class ActivityLog 
{
    private int calories_burned;
    private int total_cals_burned;
    private int rating;
    private int intensity;
    private String note;

    public ActivityLog(){
        calories_burned = 0;
        rating = 0;
        intensity = 0;
        note = "";
    }

    public int getCaloriesBurned(){
        return calories_burned; 
    }
    
    public int getRating(){
        return rating; 
    }
    
    public int getIntensity(){
        return intensity; 
    }

    public String getNote(){
        return note; 
    }

    public void setCaloriesBurned(int calsBurned){
        this.calories_burned = calsBurned;
    }
    
    public void setRating(int ratingOfExc){
        this.rating = ratingOfExc; 
    }
    
    public void setIntensity(int intensityOfExc){
        this.intensity = intensityOfExc;
    }

    public void setNote(String noteOnExc){
        this.note = noteOnExc;
    }

    public int addToTotalCalsBurned(int calsBurned){
        total_cals_burned += calsBurned;
        return total_cals_burned;
    }

}


