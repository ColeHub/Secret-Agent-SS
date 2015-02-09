package com.afternooncoffeesoftware.sass;

/**
 * Created by cole on 2014-10-14.
 */
public class Dialog {
    public static String textNPC;
    public static String option1;
    public static String option2;
    public static String option3;

    public static void set1() {
        textNPC = "You're going to be late for the meeting, get over there!";
        option1 = "On my way!";
        option2 = "I don't take orders from dirtbags like you.";
        option3 = "...";
    }

    public static void set2() {
        textNPC = "Grab your hat over there before stepping into the room.";
        option1 = "Okay.";
        option2 = "Ja, good idea.";
        option3 = "Sure. Whatever. Say, could you tell me where I am?";
    }

    public static void set3() {
        textNPC = "You better get in to that meeting, you're going to be late!";
        option1 = "";
        option2 = "";
        option3 = "";
    }

    public static void entranceGuard1Set1() {
        textNPC = "We're guarding the entrance to make sure no one gets in!";
        option1 = "You're doing a great job.";
        option2 = "That's so interesting...";
        option3 = "A sundried grapefruit could do a better job than you.";
    }

    public static void entranceGuard1Set2() {
        textNPC = "Thank you so much!";
        option1 = "";
        option2 = "";
        option3 = "";
    }
    public static void entranceGuard1Set3() {
        textNPC = "Shows what you know. Sundried grapefruits don't even have eyes.";
        option1 = "";
        option2 = "";
        option3 = "";
    }

}
