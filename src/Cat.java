/*
 * Created on 2025-09-26
 *
 * Copyright (c) 2025 Nadine von Frankenberg
 */

public class Cat {
    private String name;
    private String meowSound;
    private String funnyStory;
    private int age;
    private int energyLevel;
    private boolean isHungry = true; // All cats are hungry by default
    ;

    // Constructors
    public Cat(String name, String sound, int age, String funnyStory, int energyLevel) {
        this.name = name;
        this.meowSound = sound;
        this.age = age;
        this.funnyStory = funnyStory;
        this.energyLevel = energyLevel;
    }

    // Getters
    public String getName() {
        return this.name;
    }

    public String getMeowSound() {
        return this.meowSound;
    }

    public String getFunnyStory() {
        return this.funnyStory;
    }

    public boolean isHungry() {
        return this.isHungry;
    }

    public int getAge() {
        return this.age;
    }

    public int getEnergyLevel() {
        return this.energyLevel;
    }

    // Cat behavior
    public void meow() {
        System.out.println(this.name + " says: " + this.meowSound + "!");
    }

    public void printFunnyStory() {
        System.out.println("Here is a funny story about " + this.name + ":\n" + this.funnyStory);
    }

    public void feed() {
        if (this.isHungry) {
            System.out.println(this.name + " was hungry and was fed.");
        } else {
            System.out.println(this.name + " is not hungry at the moment.");
        }
        this.isHungry = !this.isHungry;
    }
}
