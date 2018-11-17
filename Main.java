import java.util.Scanner;
public class Main {
 public static int room = 0;
 public static boolean hasLooked = false;
 public static boolean hasMatches = false;
 public static int matches = 30;
 public static boolean hasTouchedBooks = false;
 public static boolean hasLookedatDesk = false;
 public static boolean hasTouchedDesk = false;
 public static void main(String[] args) {
  initialize();
 }
 public static void initialize() {
  System.out.println("You awaken. Type help for a list of commands.\n");
  seekInput();
 }
 public static void seekInput() {
  Scanner scan = new Scanner(System.in);
  String input = scan.nextLine();
  check(input);
 }
 public static String check(String input) {
  if (input.equals("debug")) {
   matches = 1000;
  }
  if (room == 0) {
   if (input.equals("help")) {
    System.out.println("\nThese are all actions you can take right now:");
    if (hasLooked == false) {
     System.out.print("look  |   help\n");
    }
    if ((hasLooked == true) && (hasMatches == false)) {
     System.out.print("look  |   help\nget");
    }
    if (hasMatches == true) {
     System.out.print("look  |   help\nlight");
    }
    System.out.println("\nThese are all the things you can interact with right now:");
    if (hasLooked == false) {
     System.out.print("\n");
    }
    if (hasLooked == true) {
     System.out.print("matches\n");
    }
   }
   if (input.equals("look")) {
    hasLooked = true;
    System.out.print("\nThe brightness of your surroundings causes you great pain. You squint as you attempt to make out where you may be, but find yourself in a place entirely unfamiliar. A vast, empty expanse stretches out before you. A box of matches sits in front of you.\n");
   }
   if (input.equals("look matches")) {
    System.out.println("\nA box of matches, with a well worn magnesium strike pad on the side.");
   }
   if (input.equals("get matches")) {
    hasMatches = true;
    System.out.println("You pick up the box of matches.");
   }
   if (input.equals("light matches")) {
    room = 1;
    matches--;
    System.out.printf("You strike the match, and as it sparks to life, you are transported somewhere new. You have %d matches left.\n", matches);
    hasLooked = false;
   }
   seekInput();
  }
  if (room == 1) {
   if (input.equals("help")) {
    System.out.println("\nThese are all actions you can take right now:");
    if (hasLooked == false) {
     System.out.print("look  |   help\n");
    }
    if (hasLooked == true) {
     System.out.print("look  |   help\ntouch");
    }
    System.out.println("\nThese are all the things you can interact with right now:");
    if (hasLooked == false) {
     System.out.print("\n");
    }
    if ((hasLooked == true) && (hasTouchedBooks == true)) {
     System.out.print("desk  |  stair\n");
    }
    if ((hasLooked == true) && (hasTouchedBooks == false)) {
     System.out.print("desk  |  stair\nbooks\n");
    }
   }
   if (input.equals("look")) {
    hasLooked = true;
    System.out.println("You find yourself in total darkness aside from the light emitted from your match, which is already beginning to dwindle. You will have to routinely light them if you want to see anything from here on out.\nAs your eyes begin to adjust to the darkness, you come to the conclusion you are in some sort of study. Piles of books loom menacingly over you, threatening to topple at any moment. An ornate wooden desk sits before you. A set of stairs spirals overhead, peculiarly ending a good ten feet above the floor.\n");
    matchCount();
   }
   if (input.equals("look books")) {
    System.out.println("You examine a column of tomes, noticing only now how truly precarious each books position is. It almost begs you to touch it.\n");
    matchCount();
   }
   if (input.equals("touch books")) {
    System.out.println("You lay a finger upon the spine of a rather weighty book situated in the middle of the stack and apply the slightest pressure. In one great avalance of knowledge, you find yourself knocked on the floor, covered in a mountain of literature and paper cuts. It seems you may have lost a few matches in the whole ordeal.");
    matches -= 7;
    matchCount();
    hasTouchedBooks = true;
   }
   if (input.equals("look desk")) {
    System.out.print("You look at the old desk. Hundreds of pages soaked with ink are messily sprawled across it.");
    if (hasLookedatDesk == false) {
     System.out.println("You notice a few stray matches resting upon a crystal ashtray.");
     matches += 4;
     hasLookedatDesk = true;
     matchCount();
    }
   }
   if (input.equals("touch desk")) {
    System.out.println("You place your hand upon the desk's corner, your fingers lightly touching the intricate designs carved upon its edge. You feel something suprisingly cold on the tip of your index finger.");
    hasTouchedDesk = true;
   }
   if (matches <= 0) {
    System.out.println("You have succumbed to the darkness.");
    return "Fail";
   }
   seekInput();
  }
  return "Fail";
 }
 public static void matchCount() {
  matches--;
  if (matches >= 0)
   System.out.printf("You have %d matches left.\n", matches);
 }
}
