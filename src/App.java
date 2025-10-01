/*
 * Created on 2025-09-26
 *
 * Copyright (c) 2025 Nadine von Frankenberg
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        Cat cat1 = createCat();

        // Output the results for cat1
        cat1.printFunnyStory();
        String ageCategoryCat1 = classifyCat(cat1.getAge());
        String articleCat1 = (ageCategoryCat1.equals("Adult")) ? "an" : "a";
        String activityRecommendationCat1 = recommendActivity(cat1.getAge(), cat1.getEnergyLevel());

        System.out.println(cat1.getName() + " is " + articleCat1 + " " + ageCategoryCat1 + ".");
        System.out.println("Recommended activity: " + activityRecommendationCat1 + ".");

        // Please note that there are multiple ways to implement the feed method!
        // If yours looks different but works the same, no need to adapt for LAB05!
        if (cat1.isHungry()) {
            cat1.feed();
        }

        // Output the results for cat2
        Cat cat2 = createCat();
        cat2.printFunnyStory();
        String ageCategoryCat2 = classifyCat(cat2.getAge());
        String activityRecommendationCat2 = recommendActivity(cat2.getAge(), cat2.getEnergyLevel());

        String articleCat2 = (ageCategoryCat2.equals("Adult")) ? "an" : "a";
        System.out.println(cat2.getName() + " is " + articleCat2 + " " + ageCategoryCat2 + ".");
        System.out.println("Recommended activity: " + activityRecommendationCat2 + ".");

        if (cat2.isHungry()) {
            cat2.feed();
        }

        scan.close();
    }

    public static Cat createCat() {
        // TODO LAB05: separate the input reading into separate methods
        // Can be done multiple ways, e.g., by input type (see below) 
        // OR by input (e.g., promptForName(), promptForSound(), promptForAge(), etc.!)
        String name = promptForTextInput("What is your cat's name? ");
        String catSound = promptForTextInput("Your cat says what? ");
        int age = promptForAge(name);
        String funnyStory = promptForTextInput("Tell a funny story about your cat! ");
        int energyLevel  = promptForEnergyLevel(name);
        System.out.println("Meet " + name + ", it says " + catSound + "!\n");
        return new Cat(name, catSound, age, funnyStory, energyLevel);
    }

    private static String promptForTextInput(String questionPrompt) {
        System.out.print(questionPrompt);
        String name = scan.nextLine();
        return name;
    }

    private static int promptForAge(String catName) {
        int age = 0;
        for(int i = 0; i<3; i++){
            try{
                System.out.println("Enter " + catName + "'s age (in years from 0-50): ");
                age = scan.nextInt();
                scan.nextLine();
                if(age<0 || age>50){
                    System.out.println("Enter an age between 0-50.");
                    if(i == 2){
                        System.out.println("Three tries have been used. Default age set at 1.");
                        age = 1;
                    }
                    continue;   
                } 
            }catch(InputMismatchException e){
                System.out.println("Invalid age! Please enter a valid age.");
                scan.nextLine();
                if(i == 2){
                    System.out.println("Three tries have been used. Default age set at 1.");
                    age = 1;
                }
            }
        }
        return age;
    }

    private static int promptForEnergyLevel(String catName) {
        int energyLevel = 0;
        for(int i=0;i<3;i++){
            try{
                System.out.println("On a scale of 1 to 10, how energetic is " + catName + "? ");
                energyLevel = scan.nextInt();
                scan.nextLine();
                if (energyLevel <0 || energyLevel >10){
                    System.out.println("Enter an energy level between 0-10.");
                    if(i==2){
                        System.out.println("Three tries have been used. Default Energy level set at"+energyLevel+".");
                        energyLevel = 1;
                    }
                    continue;
                }
            }catch(InputMismatchException e){
                System.out.println("Invalid energy level! Please enter a valid energy level.");
                scan.nextLine();
                if(i==2){
                    System.out.println("Three tries have been used. Default Energy level set at"+energyLevel+".");
                    energyLevel = 1;
                }
            }
            
        }
        // Validate energy level input
        return energyLevel;
    }

    /***********************************************************/
    /**** NO NEED TO TOUCH or copy the code below here ****/
    /***********************************************************/

    // Please note that there are multiple ways the following two functionalities
    // can be implemented!
    // E.g., inside Cat, accepting a Cat reference, ...
    public static String classifyCat(int age) {
        // Determine age category
        String ageCategory;
        if (age <= 1) {
            ageCategory = "Kitten";
        } else if (age <= 10) {
            ageCategory = "Adult";
        } else {
            ageCategory = "Senior";
        }
        return ageCategory;
    }

    public static String recommendActivity(int age, int energyLevel) {
        // Recommend activity based on energy level
        String activityRecommendation;
        if (age <= 10 && energyLevel >= 7) {
            activityRecommendation = "running or climbing";
        } else if (energyLevel >= 4) {
            activityRecommendation = "chasing toys";
        } else {
            activityRecommendation = "napping";
        }
        return activityRecommendation;
    }
}
