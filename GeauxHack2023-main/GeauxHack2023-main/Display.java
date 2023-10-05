import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class Display implements ActionListener {

    private static JFrame frame = new JFrame();
    private static JPanel panel = new JPanel(new BorderLayout());
    private static JLabel user_label;
    private static JLabel pw_label;
    private static JTextField userText;
    private static JPasswordField pwText;
    private static JButton loginButton;
    private static JButton registerButton;
    private static JLabel successLogin;
    private static JLabel failLogin;
    private static JLabel acctCreated;
    private static JTextField createUserText;
    private static JTextField createPwText;
    private static JButton createAcctButton;
    private static JButton returnToLoginButton;
    private static MainFrame mainObj = new MainFrame();
    private static boolean acctExists = false;
    private static String username;
    private static String password;
    private static JButton returnToMainButton2;

    //log nutrition page variables
    private static int protInt;
    private static int carbInt;
    private static int fatInt;
    private static Integer calInt;
    private static JTextField submitProtein;
    private static JTextField submitCarbs;
    private static JTextField submitFats;

    //log activity page variables
    private static JLabel inputCaloriesBurned;
    private static JTextField caloriesBurnedText;
    private static JButton submitCalsBurnedButton;

    //Kai's added variables
    private static JButton inputGoalsButton;
    private static JButton logActivityButton;
    private static JButton logNutritionButton;
    private static JButton progressButton;

    private static JLabel inputMacrosMSG; // label to input macros goals msg
    private static JLabel protein; // protein label for protein textfield
    private static JTextField userProtein; //protein textfield
    private static JLabel carbs; // carbs label for carbs text field
    private static JTextField userCarbs; //carbs textfield
    private static JLabel fats; // fats lavel for fats text field
    private static JTextField userFats; //fats textfield

    private static int proteinInt;
    private static int carbsInt;
    private static int fatsInt;
    private static Integer calculated_calories = 0;
    private static JLabel calculated_calories_label;
    private static Integer calorie_goal = 0; // calorie goal for the user for the day
    private static Integer total_cals_burned = 0; // total calories burned for the user for the day
    private static JLabel burnedCaloriesValue;
    private static JLabel calorie_goalLabel;

    private static JButton submitMacrosButton; // button to submit macros goal
    private static JLabel confirmCorrectCalories; // label for confirm correct calories msg
    private static JButton yesSubmitMacrosButton; // button to confirm correct macros
    private static JButton noSubmitMacrosButton; // button to say incorrect macros
    private static JLabel inputCaloriesMSG; // label to input calorie goals msg
    private static JLabel caloriesGoal; // label for calories goal textfield
    private static JTextField userCalories; // calories text field
    private static JButton submitCaloriesButton; //button to submit calories goal
    private static JButton returnToMainButton; // button to initiate return to main

    private static FoodTracker ft_obj = new FoodTracker(); //creating foodTrackewr obj
    private static ActivityLog al_obj = new ActivityLog();

    private enum Page {
        LOGIN, REGISTRATION, MAIN, LOG_ACTIVITY, LOG_NUTRITION, PROGRESS, GOALS
    }

    private static Page currentPage = Page.LOGIN;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI() {
        frame.setSize(350, 220);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(panel);
        panel.setLayout(null);

        // Set up the UI based on the current page
        switch (currentPage) {
            case LOGIN:
                setupLoginPage();
                break;
            case REGISTRATION:
                setupRegistrationPage();
                break;
            case LOG_ACTIVITY:
                //setupLogActivityPage();
                break;
            case LOG_NUTRITION:
                //setupLogNutritionPage();
                break;
            case PROGRESS:
                //setupProgressPage();
                break;
            case GOALS:
                //setupGoalsPage();
                break;
        }

        frame.setVisible(true);
    }

    private static void setupLoginPage() {
        frame.setTitle("Login Page");
        panel.removeAll();

        user_label = new JLabel("Username: ");
        user_label.setBounds(10, 20, 80, 25);
        panel.add(user_label);

        pw_label = new JLabel("Password: ");
        pw_label.setBounds(10, 50, 80, 25);
        panel.add(pw_label);

        userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);

        pwText = new JPasswordField();
        pwText.setBounds(100, 50, 165, 25);
        panel.add(pwText);

        loginButton = new JButton("Login");
        loginButton.setBounds(10, 80, 80, 25);
        loginButton.addActionListener(e -> handleLoginButtonClick());
        panel.add(loginButton);

        registerButton = new JButton("Sign Up");
        registerButton.setBounds(110, 80, 80, 25);
        registerButton.addActionListener(e -> {
            currentPage = Page.REGISTRATION;
            createAndShowGUI();
        });
        panel.add(registerButton);

        successLogin = new JLabel("");
        successLogin.setBounds(10, 110, 300, 25);
        panel.add(successLogin);

        failLogin = new JLabel("");
        failLogin.setBounds(10, 110, 300, 25);
        panel.add(failLogin);

        frame.revalidate();
        frame.repaint();
    }

    private static void setupRegistrationPage() {
        frame.setTitle("Registration Page");
        panel.removeAll();

        createUsernameLabel();
        createPasswordLabel();
        createUserTextField();
        createPwTextField();
        createCreateAccountButton();
        createAccountCreatedLabel();
        if (acctExists) {
            createReturnToLoginButton();
        }

        panel.revalidate();
        panel.repaint();
    }

    private static void setupMainPage(){
        frame.setTitle("Main Page");
        panel.removeAll();

        createInputGoalsButton();
        createLogActivityButton();
        createLogNutritionButton();
        createProgressButton();

        frame.setSize(275, 525);

        frame.revalidate();
        frame.repaint();
    }

    private static void setupGoalsPage(){
        frame.setTitle("Goals Page");
        panel.removeAll();

        //displaying the input macro goals message
        inputMacrosMSG = new JLabel("Please input your macro goals: ");
        inputMacrosMSG.setBounds(10,20,200,25);
        panel.add(inputMacrosMSG);

        //displaying the macros labels
        protein = new JLabel("Protein (g): ");
        carbs = new JLabel("Carbs (g): ");
        fats = new JLabel("Fats (g): ");

        protein.setBounds(10, 50, 80, 25);
        carbs.setBounds(10, 80, 80, 25);
        fats.setBounds(10,110,80,25);

        panel.add(protein);
        panel.add(carbs);
        panel.add(fats);

        //displaying the macros text fields 
        userProtein = new JTextField(20);
        userCarbs = new JTextField(20);
        userFats = new JTextField(20);

        userProtein.setBounds(80,50,40,25);
        userCarbs.setBounds(80,80,40,25);
        userFats.setBounds(80,110,40,25);

        panel.add(userProtein);
        panel.add(userCarbs);
        panel.add(userFats);

        //displaying the submit button
        createSubmitMacrosButton();


        // setting the window size and configuring page setup
        frame.setSize(275, 300);
        frame.revalidate();
        frame.repaint();

    }

    private static void setupLogActivityPage(){
        frame.setTitle("Activity Log Page");
        panel.removeAll();

        inputCaloriesBurned = new JLabel("Calories Burned: ");
        inputCaloriesBurned.setBounds(10, 20, 120, 25);
        panel.add(inputCaloriesBurned);

        //creating the calories burned text field
        caloriesBurnedText = new JTextField(20);
        caloriesBurnedText.setBounds(150, 20, 80, 25);
        panel.add(caloriesBurnedText);

        // also make a submit button
        createSubmitCalsBurnedButton();

        frame.setSize(300, 150);
        frame.revalidate();
        frame.repaint();
    }

    private static void setupProgressPage(){
        frame.setTitle("Progress Page");
        panel.removeAll();

        // get the calorie goal and display it 

        //calorie intake
        JLabel caloricIntake = new JLabel("Calorie Intake: ");
        caloricIntake.setBounds(10, 20, 100, 25);
        panel.add(caloricIntake);

        // get the calorie intake and display it 
        JLabel calorie_int_label = new JLabel(calInt.toString());
        calorie_int_label.setBounds(120,20,80,25);
        panel.add(calorie_int_label);

        //calories burned
        JLabel burnedCalories = new JLabel("Calories Burned: ");
        burnedCalories.setBounds(10, 70, 100, 25);
        panel.add(burnedCalories);

        // get the calories burned and display it 
        JLabel burnedCaloriesValue = new JLabel(total_cals_burned.toString());
        burnedCaloriesValue.setBounds(120,70,80,25);
        panel.add(burnedCaloriesValue);

        //net calories 
        JLabel caloriesNet = new JLabel("Net Calories: ");
        caloriesNet.setBounds(10, 120, 100, 25);
        panel.add(caloriesNet);

        // get the net calories and display it
        Integer net_calories = calInt - total_cals_burned;
        JLabel netCaloriesValue = new JLabel(net_calories.toString());
        netCaloriesValue.setBounds(120,120,80,25);
        panel.add(netCaloriesValue);

        //displaying the you are at msg
        JLabel youAreAt = new JLabel("You are at");
        youAreAt.setBounds(105,180,80,25);
        panel.add(youAreAt, BorderLayout.CENTER);

        //displaying the net cals 
        JLabel calorie_net_label = new JLabel(net_calories.toString());
        calorie_net_label.setBounds(110,200,80,25);
        panel.add(calorie_net_label);
        
        //displaying a slash between intake and outtake calories
        JLabel slash = new JLabel("/" );
        slash.setBounds(130, 200, 30, 25);
        panel.add(slash, BorderLayout.CENTER);

        //displaying the outtake
        JLabel calorie_goalLabel = new JLabel(calorie_goal.toString());
        calorie_goalLabel.setBounds(150,200,80,25);
        panel.add(calorie_goalLabel);

        // calories for today msg
        JLabel caloriesForToday = new JLabel("calories for today.");
        caloriesForToday.setBounds(80,220,150,25);
        panel.add(caloriesForToday, BorderLayout.CENTER);

        createReturnToMainButton();

        frame.setSize(300, 400);
        frame.revalidate();
        frame.repaint();
    }

    private static void createUsernameLabel() {
        JLabel createUsername = new JLabel("Username: ");
        createUsername.setBounds(10, 20, 80, 25);
        panel.add(createUsername);
    }

    private static void createPasswordLabel() {
        JLabel createPassword = new JLabel("Password: ");
        createPassword.setBounds(10, 50, 80, 25);
        panel.add(createPassword);
    }

    private static void createUserTextField() {
        createUserText = new JTextField(20);
        createUserText.setBounds(100, 20, 165, 25);
        panel.add(createUserText);
    }

    private static void createPwTextField() {
        createPwText = new JPasswordField();
        createPwText.setBounds(100, 50, 165, 25);
        panel.add(createPwText);
    }

    private static void createCreateAccountButton() {
        createAcctButton = new JButton("Create Account");
        createAcctButton.setBounds(10, 80, 200, 25);
        createAcctButton.addActionListener(e -> handleCreateAccountButtonClick());
        panel.add(createAcctButton);
    }

    private static void createAccountCreatedLabel() {
        acctCreated = new JLabel("");
        acctCreated.setBounds(10, 110, 300, 25);
        panel.add(acctCreated);
    }

    private static void handleLoginButtonClick() {
        successLogin.setText("");
        failLogin.setText("");

        username = userText.getText();
        password = String.valueOf(pwText.getPassword());
        if (mainObj.checkUsername(username) && mainObj.checkPassword(password)) {
            successLogin.setText("Login successful!");
            setupMainPage();
        } else {
            failLogin.setText("Incorrect username and password combination.");
        }
    }

    private static void createReturnToLoginButton() {
        returnToLoginButton = new JButton("Return to login");
        returnToLoginButton.setBounds(10, 140, 200, 25);
        returnToLoginButton.addActionListener(e -> {
            currentPage = Page.LOGIN;
            createAndShowGUI();
        });
        panel.add(returnToLoginButton);
        returnToLoginButton.setVisible(acctExists);
    }

    private static void handleCreateAccountButtonClick() {
        String createUsername = createUserText.getText();
        String createPassword = createPwText.getText();
        mainObj.addUser(new Profiles(createUsername, createPassword));
        acctCreated.setText("Account created.");
        acctExists = true;
        createReturnToLoginButton();
        returnToLoginButton.setVisible(true);
    }

    //creating an input goals button
    private static void createInputGoalsButton(){
        inputGoalsButton = new JButton("Input Goals");
        inputGoalsButton.setBounds(30, 10, 200, 100);
        inputGoalsButton.addActionListener(e -> handleInputGoalsButtonClick());
        panel.add(inputGoalsButton);
    }

    //handling the input goals button
    private static void handleInputGoalsButtonClick(){
        setupGoalsPage();
    }
    
    //creating a log activity button
    private static void createLogActivityButton(){
        logActivityButton = new JButton("Log Activity");
        logActivityButton.setBounds(30, 130, 200, 100);
        logActivityButton.addActionListener(e -> handleLogActivityButtonClick());
        panel.add(logActivityButton);
    }

    //handling the log activity button
    private static void handleLogActivityButtonClick(){
        setupLogActivityPage();
    }

    //creating a log nutrition button
    private static void createLogNutritionButton(){
        logNutritionButton = new JButton("Log Nutrition");
        logNutritionButton.setBounds(30, 250, 200, 100);
        logNutritionButton.addActionListener(e -> handleLogNutritionButtonClick());
        panel.add(logNutritionButton);
    }

    //handling the log nutrition button
    private static void handleLogNutritionButtonClick(){
        setupLogNutritionPage();
        System.out.println("The log nutrition button was pressed.");
    }

    //creating a today's progress button
    private static void createProgressButton(){
        progressButton = new JButton("Today's Progress");
        progressButton.setBounds(30, 370, 200, 100);
        progressButton.addActionListener(e -> handleProgressButtonClick());
        panel.add(progressButton);
    }

    //handling the today's progress button
    private static void handleProgressButtonClick(){
        setupProgressPage();
        System.out.println("The progress button was pressed.");
    }

    //create submit macros button
    private static void createSubmitMacrosButton(){
        submitMacrosButton = new JButton("Submit");
        submitMacrosButton.setBounds(50,150,80,25);
        submitMacrosButton.addActionListener(e -> handleSubmitMacrosButtonClick());
        panel.add(submitMacrosButton);
    }

    //handling submit macros button
    private static void handleSubmitMacrosButtonClick(){
        System.out.print("The submit calories button was pressed.");

        // after submit is pressed, clearing the panel and displaying the confirm calories msg
        panel.removeAll();

        confirmCorrectCalories = new JLabel("Calculated Daily Calorie Goal From Macros: ");
        confirmCorrectCalories.setBounds(10,20,400,25);
        panel.add(confirmCorrectCalories);

        proteinInt = Integer.parseInt(userProtein.getText());
        carbsInt = Integer.parseInt(userCarbs.getText());
        fatsInt = Integer.parseInt(userFats.getText());

        calculated_calories = ft_obj.macrosToCalories(proteinInt, fatsInt, carbsInt);

        calculated_calories_label = new JLabel(calculated_calories.toString());
        calculated_calories_label.setBounds(10,40,80,25);
        panel.add(calculated_calories_label);

        //displaying the yes and no buttons
        createYesSubmitMacrosButton();
        createNoSubmitMacrosButton();

        frame.setSize(275, 300);
        frame.revalidate();
        frame.repaint();
    }

    //create yes submit macros button
    private static void createYesSubmitMacrosButton(){

        yesSubmitMacrosButton = new JButton("yes");
        yesSubmitMacrosButton.setBounds(50,100,70,25);
        yesSubmitMacrosButton.addActionListener(e -> handleYesSubmitMacrosButton());
        panel.add(yesSubmitMacrosButton);
    }

    //handling yes submit macros button
    private static void handleYesSubmitMacrosButton(){
        setupMainPage();
        calorie_goal += ft_obj.addToTotalCalories(calculated_calories);
    }

    //create no submit macros button
    private static void createNoSubmitMacrosButton(){
        noSubmitMacrosButton = new JButton("no");
        noSubmitMacrosButton.setBounds(140,100,70,25);
        noSubmitMacrosButton.addActionListener(e -> handleNoSubmitMacrosButton());
        panel.add(noSubmitMacrosButton);
    }

    //handling no submit macros button
    private static void handleNoSubmitMacrosButton(){
        panel.removeAll();

        inputCaloriesMSG = new JLabel("Please input your daily calorie goal: ");
        inputCaloriesMSG.setBounds(10,20,400,25);
        panel.add(inputCaloriesMSG);

        //displaying the calorie goal message
        caloriesGoal = new JLabel("Calorie Goal: ");
        caloriesGoal.setBounds(10, 80, 120, 25);
        panel.add(caloriesGoal);

        //displaying the calorie goal text field
        userCalories = new JTextField(20);
        userCalories.setBounds(150,80,80,25);
        panel.add(userCalories);

        //displaying the submit button
        createSubmitCaloriesButton();

        frame.setSize(275, 300);
        frame.revalidate();
        frame.repaint();
    }

    //creating submit calories button
    private static void createSubmitCaloriesButton(){
        submitCaloriesButton = new JButton("submit");
        submitCaloriesButton.setBounds(80,120,80,25);
        submitCaloriesButton.addActionListener(e -> handleSubmitCaloriesButton());
        panel.add(submitCaloriesButton);
    }

    //handling submit calories button
    private static void handleSubmitCaloriesButton(){
        setupMainPage();
        calorie_goal += Integer.parseInt(userCalories.getText());
    }

    private static void createSubmitCalsBurnedButton(){
        submitCalsBurnedButton = new JButton("submit");
        submitCalsBurnedButton.setBounds(80,65,80,25);
        submitCalsBurnedButton.addActionListener(e -> handleSubmitCalsBurnedButtonClick());
        panel.add(submitCalsBurnedButton);
    }

    private static void handleSubmitCalsBurnedButtonClick(){
        total_cals_burned += al_obj.addToTotalCalsBurned(Integer.parseInt(caloriesBurnedText.getText()));
        setupMainPage();
    }
 
    //creating return to main button
    private static void createReturnToMainButton(){
        returnToMainButton = new JButton("Return To Main");
        returnToMainButton.setBounds(70,250,120,25);
        returnToMainButton.addActionListener(e -> handleReturnToMainButton());
        panel.add(returnToMainButton);
    }

    //handling return to main button
    private static void handleReturnToMainButton(){
        setupMainPage();
    }

    private static void setupLogNutritionPage()
    {
        frame.setTitle("Log Nutrition");
        panel.removeAll();
        frame.setSize(1000, 1000);

        inputProteinLabel();
        inputCarbsLabel();
        inputFatsLabel();
        createProteinTextField();
        createCarbsTextField();
        createFatsTextField();

        createSubmitProteinButton();

        calculateCaloriesButton();

        createReturnToMainButton2();


        frame.revalidate();
        frame.repaint();
    }

    private static void createSubmitProteinButton() {
        createAcctButton = new JButton("Submit Answer");
        createAcctButton.setBounds(500, 50, 200, 25);
        createAcctButton.addActionListener(e -> handleSubmitProteinButtonClick());
        panel.add(createAcctButton);
    }

    private static void handleSubmitProteinButtonClick() {
        protInt = Integer.parseInt(submitProtein.getText());
        createSubmitCarbsButton();
    }

    private static void createSubmitCarbsButton() {
        createAcctButton = new JButton("Submit Answer");
        createAcctButton.setBounds(500, 100, 200, 25);
        createAcctButton.addActionListener(e -> handleSubmitCarbsButtonClick());
        panel.add(createAcctButton);
    }

     private static void handleSubmitCarbsButtonClick() {
        carbInt = Integer.parseInt(submitCarbs.getText());
        createSubmitFatsButton();
    }

     private static void createSubmitFatsButton() {
        createAcctButton = new JButton("Submit Answer");
        createAcctButton.setBounds(500, 150, 200, 25);
        createAcctButton.addActionListener(e -> handleSubmitFatsButtonClick());
        panel.add(createAcctButton);
    }

     private static void handleSubmitFatsButtonClick() {
        fatInt = Integer.parseInt(submitFats.getText());
    }

    private static void calculateCaloriesButton()
    {
        progressButton = new JButton("Calculate Calories");
        progressButton.setBounds(250, 250, 500, 75);
        progressButton.addActionListener(e -> handleCalculateCaloriesButtonClick());
        panel.add(progressButton);
    }

    private static void handleCalculateCaloriesButtonClick()
    {
        System.out.println("Entered method");
        for(int i = 0; i < mainObj.users.size(); i++)
        {
            System.out.println("Entered loop");
            if(mainObj.users.get(i).getUsername().equals(mainObj.users.get(i).getUsername()))
            {
                System.out.println("Entered if statement");
                mainObj.users.get(i).getFood().addProtein(protInt);
                mainObj.users.get(i).getFood().addCarbs(carbInt);
                mainObj.users.get(i).getFood().addFats(fatInt);
                calInt = mainObj.users.get(i).getFood().protein_to_cal() + mainObj.users.get(i).getFood().carbs_to_cal() + 
                mainObj.users.get(i).getFood().fats_to_cal();
                System.out.println(calInt);
            }
        }
        inputCaloriesLabel();
    }

    private static void inputCaloriesLabel() 
    {

        JLabel calMsg = new JLabel("You have consumed " + calInt + " calories based on the given macros.");
        calMsg.setBounds(250, 400, 500, 25);
        panel.add(calMsg);
        frame.revalidate();
        frame.repaint();  
    }

    private static void inputProteinLabel() {
        JLabel protein = new JLabel("Protein intake (g)(please enter an int): ");
        protein.setBounds(10, 50, 250, 25);
        panel.add(protein);
    }

    private static void createProteinTextField() {
        submitProtein = new JTextField(20);
        submitProtein.setBounds(300, 50, 165, 25);
        panel.add(submitProtein);
    }

    private static void inputCarbsLabel() {
        JLabel carbs = new JLabel("Carbohydrates intake (g)(please enter an int): ");
        carbs.setBounds(10, 100, 250, 25);
        panel.add(carbs);
    }

    private static void createCarbsTextField() {
        submitCarbs = new JTextField(20);
        submitCarbs.setBounds(300, 100, 165, 25);
        panel.add(submitCarbs);
    }

    private static void inputFatsLabel() {
        JLabel fats = new JLabel("Fats intake (g)(please enter an int): ");
        fats.setBounds(10, 150, 250, 25);
        panel.add(fats);
    }

    private static void createFatsTextField() {
        submitFats = new JTextField(20);
        submitFats.setBounds(300, 150, 165, 25);
        panel.add(submitFats);
    }

    private static void createReturnToMainButton2(){
        returnToMainButton2 = new JButton("Return To Main");
        returnToMainButton2.setBounds(450,450,120,80);
        returnToMainButton2.addActionListener(e -> handleReturnToMainButton2());
        panel.add(returnToMainButton2);
    }

    //handling return to main button
    private static void handleReturnToMainButton2(){
        setupMainPage();
    }

}
