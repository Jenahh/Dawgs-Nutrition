import java.util.*;
import java.time.*;

public class MainFrame 
{
    List<Profiles> users;

    public MainFrame()
    {
       this.users = new ArrayList<Profiles>();
       System.out.println(users);
    }

    //Adds a profile to the list of users and sets lastLogin as the current day
    public void addUser(Profiles newUser)
    {
        users.add(newUser);
        newUser.setLastLogin(LocalDate.now());
    }

    /*public void loginUser(Profiles profile)
    {
        if(profile.daysSinceLastLogin()!=0)
        {
            profile.food = new FoodTracker();
            profile.log = new ActivityLog();
        }
        profile.setLastLogin(LocalDate.now());
    }*/

    //Returns true if list of users contains the parameter username
    public boolean checkUsername(String username)
    {
        if(!users.isEmpty())
        {
            for(int i = 0; i < users.size(); i++)
            {
                if(users.get(i).getUsername().equals(username))
                {   
                    return true;
                }
            }
        }
        return false;
    }

    //Returns true if the list of users contains the parameter password
    public boolean checkPassword(String password)
    {
        if(!users.isEmpty())
        {
            for(int i = 0; i < users.size(); i++)
            {
                if(users.get(i).getPassword().equals(password))
                {   
                    return true;
                }
            }
        }
        return false;
    }

    /*public long daysSinceLastLogin(Profiles profile)
    {
        LocalDate lastLogin = profile.getLastLogin();
        return LocalDate.now().toEpochDay() - lastLogin.toEpochDay();
    }*/
}
