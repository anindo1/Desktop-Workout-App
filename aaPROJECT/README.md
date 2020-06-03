# The Anindo Lifestyle 
![Picture of Arnold!!](https://images-na.ssl-images-amazon.com/images/I/61udZyZoLEL._AC_SX425_.jpg)

## by Mr. Anindya De

### **Description** 
This is a minimalist workout app that provides beginners with all of the 
essential information they need to begin their adventure to getting jacked.

If the user trusts in the app's foolproof algorithm constructed by one of UBC's finest minds, gains are guaranteed.

### **Current Functions**
Currently, the app offers the following *intuitive* functions:
- **Accurately** calculates the user's BMI
    - Based on these calculations and more, recommends a workout schedule and diet
- Log **every** workout!
- **Track** custom-made personal body-image and lifting goals 
    - Check off these goals as you slowly conquer them! 
- **Visually** displays progress over time 

### **Why use this app?**
Unlike other workout apps, this app's interface is sleek and simple. 
It offers easy to use navigation and functionality.

Also, it is **100% FREE** and **NO ADS**!

### **About the Creator**
I decided to create a minimalist workout app because when I first started working out, most workout apps
either costed money, were filled with ads and sponsorships, or just confusing to use. They recommended complex 
workouts and did not seem to factor in any of my important personal stats, like age, gender, and BMI. 

So I want to create a good alternative workout app for beginners that is both simple and effective!

## User Stories:
As a user, I want to be able to:
- Calculate my BMI and view it
    - Be able to do so in both the imperial and metric system
- Add custom, personal body-image and lifting goals with their priority 
- View the added goals 
- See the number of goals remaining
- Delete the goals if wanted
- Accomplish goals and view them later
- Save a workout account to file
- Load a workout account 

## INSTRUCTIONS FOR GRADER:
- You can generate the first required event by:
    - First Login with a new account
    - Click the Goals button
    - Click the Add New Goals button
    - Fill in the required fields (a number for the priority, any text for the goal, and click the little calender icon
    on the right of the text field then pick a date for the Target Date)
    - After filling in the fields, press the Add Goal button
- After adding a goal, you can generate the second required event by:
    - Clicking the Pending Goals button from the Goals page
    - Select a pending goal from the list then you can press Accomplish a Goal or Delete a Goal
    - If you delete a goal, the goal will be deleted and no longer available anywhere
    - If you accomplish a goal, then you can view the accomplished goals by pressing the View Accomplished Goals button
    in the Goals Page, where you can also delete accomplished goals through the same way
- There are visual components on every scene, and an audio component whenever you initially login with a new account or 
load an account
- You can save the state of the application by clicking the Save Account button, then entering a username and pressing 
enter
- You can reload the state of the application when you run the application again from the beginning (you can press the
quit button from the main menu then just run the application again from Intellij)
    - From the login screen you can press the Login button then select load account
    - Simply enter the same username that you used to save the account, then press the enter key 

## PHASE 4: TASK 2
I choose to implement the first option for my BmiCalculator class for the methods bmiMetric() and bmiImperial(). Before 
it was required for the parameters to all be positive numbers, but now there is an exception to check if it is positive
or not. This exception is caught in the ui classes that call it, and when it is caught an error message is displayed. 

## PHASE  4: TASK 3
#### Change 1:
I fixed low cohesion issues for the BasicControls.ui Class because I started off with the class supposed to only be 
methods for switching scenes and initial images for every single FXML Controller. But it eventually 
started to have many different tasks, as it had a method for initial images that was only applied to the 
MainMenuController.ui and MainPageController.ui due to me deciding to have different images for every major function of 
the program. Also, BasicControls.ui had a method to calculate BMI status, which was only used for 
BmiController.ui, ImperialBmiController.ui, and MetricBmiController.ui. 

In other words, the BasicControls.ui was just really unfocused and broad, so I decided to change this class, now renamed
to BasicControlsUniversal.ui, so that it only has methods for switching scenes because this turned out to be the only 
universal method that all my FXML Controller classes used. I also added a new BasicControlsMainMenu.ui abstract class 
that now has the setInitialImages() method. As well, I added a BasicControlsBmi.ui abstract classes that has the 
status() method. Both of these classes extend BasicControlsUniversal.ui so that the subclasses still 
has access to the changing scenes methods. Now all 3 of these classes have high cohesion and are focused.

#### Change 2:
I fixed high coupling issues for pretty much all my classes in the ui package. The problem was that I initially thought
that I would use the same background images for all of my scenes in my GUI, but ended up having 3 different background
images: 1 for the Main Menu and Main Page, 1 for all the Goal related pages, and 1 for all the Bmi related pages. This 
led me to copy pasting the initial image setup for the groups of classes that use the same background images, so now
there is high coupling and if I decide to want to change the background image for my Goal related pages I will have to 
do this multiple times to make it consistent.

I fixed this by adding a BasicControlsGoals.ui abstract class that is extended by all of the Goal related pages.
Afterwards, I added a different setInitialImages() method to BasicControlsGoals.ui, BasicControlsBmi.ui, and 
BasicControlsMainMenu.ui that set up the background images for its intended subclasses. Now all of the 3 different 
background images can simply be called by the subclasses using the setInitialImages() method, and if I decide to ever
change a background image for 1 type of scene in my GUI, all of them will reflect the change. 
Furthermore, this change has led to low coupling between my classes. 