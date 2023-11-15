package assign2_template;

import org.w3c.dom.traversal.NodeIterator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Scanner;

public class ManageVideoGames {

    public static void main(String[] args) {
        
        //2.2.2 Application Class - ManageVideoGames
                
        //create an empty list of VideoGames
        LinkedList<VideoGame> vG =  new LinkedList<>();

      
        //1. display menu
        Scanner uI = new Scanner(System.in);
        int userChoice = 0;
        VideoGame newGame = new VideoGame(null,null,null,null);
        displayMenu();
        System.out.println("Please enter a choice");
        userChoice = uI.nextInt();
        userChoice = getUserChoice(userChoice);
        while(userChoice < 6 && userChoice > 0) {
            if(userChoice ==1 ){
               newGame = getNewGame();
            } else if(userChoice == 2){
                remove(vG);
            }else if(userChoice == 3){
                ListLinked(vG);
            }else if(userChoice ==4){
                int index = lastestRealseDate(vG);
                System.out.println("This is the latest: " + vG.get(index));
            } else if(userChoice ==5){
                vG = add(newGame,vG);
            } else if(userChoice == 6){
                break;
            }
            displayMenu();
            System.out.println("Please enter a choice");
            userChoice = uI.nextInt();
            userChoice = getUserChoice(userChoice);
        }
        //2. get user choice

        //3. take action based on user choice 
        
        //4. loop through steps 1, 2, 3 above until user quits

    }

    //define other methods for modularization, samples are listed below.
    
    //method to display menu
    public static void ListLinked(LinkedList<VideoGame> vG){
        for(int i = 0; i < vG.size(); i++){
            System.out.println("This is the game: " + vG.get(i).toString() + "\n");
        }
    }
    public static void displayMenu() {
        //add your code
        //display the menu like the one in Page 5 of Assign2.pdf
        System.out.println("1. Add a new game\n" +
                "2. Remove an existing game\n" +
                "3. Display the games in the order they were inserted\n" +
                "4. Find games with latest release\n" +
                "5. Add a new game in the titles\n" +
                "6. Exit");
          
        
    }    
    
    //method to get and return the user choice of menu items.
    public static int getUserChoice(int userChoice) {
        //add your code
        // keep reading user input until user enters correct menu choice number,
        // then return the user choice number
        Scanner uI = new Scanner(System.in);
        if(userChoice < 0 || userChoice > 6) {
            while (userChoice < 0 || userChoice > 6) {
                System.out.println("Pleas enter a correct option: ");
                userChoice = uI.nextInt();
                uI.nextLine();
            }
        }
        
        return userChoice;
    }    
    
    
    //method to get user input, create and return a video game
    public static VideoGame getNewGame() {
        //add your code here
        /*
        get new game based on user input:
        keyboard input
          game title:
             use nextLine() to avoid problems caused by newline character
          platforms: 
             get how-many: int
             then use a loop to get each platform.

          date value: 
            get 3 integers: month, day, year
            use LocaleDate.of(year, month, day) to create a date
            (see TestDate.java for details)
        */
        Scanner uI = new Scanner(System.in);
        String title = "";
        String dev = "";
        int numPlat = 0;
        int year = 0;
        int month = 0;
        int day = 0;
        System.out.println("Please enter a title: ");
        title = uI.nextLine();
        System.out.println("Please enter the lead dev: ");
        dev = uI.nextLine();
        System.out.println("Please enter the num of platforms: ");
        numPlat = uI.nextInt();
        uI.nextLine();
        String [] plats = new String [numPlat];
        for(int i = 0; i < numPlat; i++){
            System.out.println("Please enter the platform");
            plats[i] = uI.nextLine();
        }
        System.out.println("Please enter the Relese Date year(yyyy): ");
        year = uI.nextInt();
        uI.nextLine();
        System.out.println("Please enter the Relese Date month(1-12): ");
        month = uI.nextInt();
        if (month < 0 || month > 12){
            while (month < 0 || month > 12) {
                System.out.println("Pleas enter a correct option: ");
                month = uI.nextInt();
                uI.nextLine();
            }
        }
        System.out.println("Please enter the Relese Date day(1-31): ");
        day = uI.nextInt();
        uI.nextLine();
        if (day < 1 || day > 31){
            while (day < 0 || day > 32) {
                System.out.println("Pleas enter a correct option: ");
                day = uI.nextInt();
                uI.nextLine();
            }
        }
        LocalDate localDate = LocalDate.of(year,month,day);
        VideoGame vG= new VideoGame(title,dev,plats,localDate);
        System.out.println("Made new object");
        return vG;
    }     
    
    //method to add a video game without maintaining sorted order
    //add your own code
    public static LinkedList<VideoGame> add(VideoGame videoGame, LinkedList<VideoGame> temp) {
        temp.add(videoGame);
        return temp;
    }

    //method to remove a game based on user input
    //add your own code
    public static LinkedList<VideoGame> remove(LinkedList<VideoGame> vG){
        String title = "";
        Scanner uI =  new Scanner(System.in);
        System.out.println("Please enter a index you would like to remove: ");
        title = uI.nextLine();
        for(int i = 0; i < vG.size(); i++){
            if(vG.get(i).getTitle().equals(title)){
                vG.remove(i);
            }
        }
        return vG;
    }

    //method to find the game with latest release date
    //add your own code    
    /*
    find game with latest release date
       simple assumption: only one game has the latest release date.
       need to loop through the collection and find the latest release date                                                        (largest)
            while looping, 
               record and update the current latest release date value 
                   and the corresponding VideoGame object.

       compare dates: isBefore, isAfter, or compareTo
          (see TestDate.java for details)
    */
    public static int lastestRealseDate(LinkedList<VideoGame> vG){
        LocalDate min = vG.get(0).getReleaseDate();
        int index = 0;
        for(int i =0; i < vG.size(); i++){
            if(min.isAfter(vG.get(i).getReleaseDate())){
                continue;
            } else if(min.isBefore(vG.get(i).getReleaseDate())){
                min = vG.get(i).getReleaseDate();
                index = i;
            }
        }
        return index;
    }
    
    
    //OPTIONAL BONUS:
    //  method to add a video game in alphabetical order of game titles
    //add your own code   
    /*    
     add new game in alphabetical order of game titles
        Do not append the new game to the current collection and then sort the entire collection. 
	Instead,
           start with the first game, 
           loop through the collection and 
               find the first game whose title is alphabetically larger than the new game. 
               Then insert the new game at the location, say [j], of this target.
                  As the result of the insertion, this target will be at [j+1].
           If no existing game title is larger than the new game,
               append the new game to the end of game collection list.     
   */  
}
