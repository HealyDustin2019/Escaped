import java.util.Scanner;
public class Main {
 public static int room = 0;
 public static boolean hasLooked = false;
 public static boolean hasMatches = false;
 public static int matches = 30;
 public static boolean hasTouchedBooks = false;
 public static boolean hasLookedatDesk = false;
 public static boolean hasTouchedDesk = false;
 public static boolean hasLookedatDecoration = false;
 public static boolean hasPressedButton = false;
 public static int walk = 0;
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
  if (room == 3)
   return "Success";
  if (input.equals("debug")) {
   matches = 1000;
  }
  if (input.equals("db0")) {
   room = 0;
   hasLooked = false;
   hasMatches = false;
   matches = 30;
   hasTouchedBooks = false;
   hasLookedatDesk = false;
   hasTouchedDesk = false;
   hasLookedatDecoration = false;
   hasPressedButton = false;
   walk = 0;
  }
  if (input.equals("db1")) {
   room = 1;
   hasLooked = false;
   hasMatches = true;
   matches = 30;
   hasTouchedBooks = false;
   hasLookedatDesk = false;
   hasTouchedDesk = false;
   hasLookedatDecoration = false;
   hasPressedButton = false;
   walk = 0;
  }
  if (input.equals("db2")) {
   room = 2;
  }
  if (input.equals("quit")) {
   matches = 0;
  }
  if (room == 0) {
   if (input.equals("help")) {
    System.out.println("\nThese are all actions you can take right now:");
    if (hasLooked == false) {
     System.out.print("look  |   help\n");
    }
    if ((hasLooked == true) && (hasMatches == false)) {
     System.out.println("look  |   help\nget");
    }
    if (hasMatches == true) {
     System.out.println("look  |   help\nlight");
    }
    System.out.println("\nThese are all the things you can interact with right now:");
    if (hasLooked == false) {
     System.out.print("\n");
    }
    if (hasLooked == true) {
     System.out.println("matches\n");
    }
   }
   if (input.equals("look")) {
    if (hasMatches == false) {
     hasLooked = true;
     System.out.println("\nThe brightness of your surroundings causes you great pain. You squint as you attempt to make out where you may be, but find yourself in a place entirely unfamiliar. A vast, empty expanse stretches out before you. A box of matches sits in front of you.\n");
    }
    if (hasMatches == true) {
     hasLooked = true;
     System.out.println("\nThe brightness of your surroundings causes you great pain. You squint as you attempt to make out where you may be, but find yourself in a place entirely unfamiliar. A vast, empty expanse stretches out before you.\n");
    }
   }
   if (input.equals("look matches")) {
    System.out.println("\nA box of matches, with a well worn magnesium strike pad on the side.\n");
   }
   if (input.equals("get matches")) {
    hasMatches = true;
    System.out.println("\nYou pick up the box of matches.\n");
   }
   if (input.equals("light matches")) {
    room = 1;
    matches--;
    System.out.printf("\nYou strike the match, and as it sparks to life, you are transported somewhere new. You have %d matches left.\n\n", matches);
    hasLooked = false;
   }
   if (matches <= 0) {
    System.out.println("\nYou have succumbed to the darkness.\n");
    return "Fail";
   }
   seekInput();
  }
  if (room == 1) {
   if (input.equals("help")) {
    System.out.println("\nThese are all actions you can take right now:");
    if (hasLooked == false) {
     System.out.println("look  |   help");
    }
    if (hasLooked == true && hasLookedatDecoration == false) {
     System.out.println("look  |   help\ntouch");
    }
    if (hasLooked == true && hasLookedatDecoration == true && hasPressedButton == false) {
     System.out.println("look  |   help\ntouch  |  press");
    }
    if (hasLooked == true && hasLookedatDecoration == true && hasPressedButton == true) {
     System.out.println("look  |   help\ntouch  |  press\nclimb");
    }
    System.out.println("\nThese are all the things you can interact with right now:");
    if (hasLooked == false) {
     System.out.print("\n");
    }
    if ((hasLooked == true) && (hasTouchedBooks == true) && hasTouchedDesk == false) {
     System.out.println("desk  |  stair\n");
    }
    if ((hasLooked == true) && (hasTouchedBooks == false) && hasTouchedDesk == false) {
     System.out.println("desk  |  stair\nbooks\n");
    }
    if ((hasLooked == true) && (hasTouchedBooks == false) && hasTouchedDesk == true && hasLookedatDecoration == false) {
     System.out.println("desk  |  stair\nbooks  |  decoration\n");
    }
    if ((hasLooked == true) && (hasTouchedBooks == true) && hasTouchedDesk == true && hasLookedatDecoration == false) {
     System.out.println("desk  |  stair\ndecoration\n");
    }
    if ((hasLooked == true) && (hasTouchedBooks == false) && hasTouchedDesk == true && hasLookedatDecoration == true && hasPressedButton == false) {
     System.out.println("desk  |  stair\nbooks  |  decoration\nbutton\n");
    }
    if ((hasLooked == true) && (hasTouchedBooks == true) && hasTouchedDesk == true && hasLookedatDecoration == true && hasPressedButton == false) {
     System.out.println("desk  |  stair\ndecoration  |  button\n");
    }
    if ((hasLooked == true) && (hasTouchedBooks == false) && hasTouchedDesk == true && hasLookedatDecoration == true && hasPressedButton == true) {
     System.out.println("desk  |  stair\nbooks  |  decoration\nbutton  |  ladder\n");
    }
    if ((hasLooked == true) && (hasTouchedBooks == true) && hasTouchedDesk == true && hasLookedatDecoration == true && hasPressedButton == true) {
     System.out.println("desk  |  stair\ndecoration  |  button\nladder\n");
    }
   }
   if (input.equals("look")) {
    if (hasLooked == true && hasTouchedBooks == false) {
     hasLooked = true;
     System.out.println("\nYou come to the conclusion that you are in some sort of study. Piles of books loom menacingly over you, threatening to topple at any moment. An ornate wooden desk sits before you. A set of stairs spirals overhead, peculiarly ending a good ten feet above the floor.\n");
     matchCount();
    }
    if (hasLooked == false) {
     hasLooked = true;
     System.out.println("\nYou find yourself in total darkness aside from the light emitted from your match, which is already beginning to dwindle. You will have to routinely light them if you want to see anything from here on out. As your eyes begin to adjust to the darkness, you come to the conclusion you are in some sort of study. Piles of books loom menacingly over you, threatening to topple at any moment. An ornate wooden desk sits before you. A set of stairs spirals overhead, peculiarly ending a good ten feet above the floor.\n");
     matchCount();
    }
    if (hasLooked == true && hasTouchedBooks == true) {
     hasLooked = true;
     System.out.println("\nYou come to the conclusion that you are in some sort of study. Hundreds of books are strewn across the floor, almost as if some rude person had just gone ahead and knocked them all over. An ornate wooden desk sits before you. A set of stairs spirals overhead, peculiarly ending a good ten feet above the floor.\n");
     matchCount();
    }
   }
   if (hasTouchedBooks == false) {
    if (input.equals("look books")) {
     System.out.println("\nYou examine a column of tomes, noticing only now how truly precarious each book's position is. It almost begs you to touch it.\n");
     matchCount();
    }
    if (input.equals("touch books")) {
     System.out.println("\nYou lay a finger upon the spine of a rather weighty book situated in the middle of the stack and apply the slightest pressure. In one great avalance of knowledge, you find yourself knocked on the floor, covered in a mountain of literature and paper cuts. It seems you may have lost a few matches in the whole ordeal.\n");
     matches -= 7;
     matchCount();
     hasTouchedBooks = true;
    }
   }
   if (hasLookedatDesk == true) {
    if (input.equals("look desk")) {
     System.out.println("\nYou look at the old desk. Hundreds of pages soaked with ink are messily sprawled across it.\n");
     matchCount();
    }
   }
   if (input.equals("look desk") && hasLookedatDesk == false) {
    System.out.println("\nYou glance at the desk and notice a few stray matches resting upon a crystal ashtray.\n");
    matches += 4;
    hasLookedatDesk = true;
    matchCount();
   }
   if (input.equals("touch desk")) {
    System.out.println("\nYou place your hand upon the desk's corner, lightly running it across the intricate designs carved upon the wooden edge. You are suprised when your fingers fall upon something unusually cold.\n");
    hasTouchedDesk = true;
    matchCount();
   }
   if (input.equals("look stair")) {
    if (hasPressedButton == false) {
     System.out.println("\nThe stairs are grated metal, reminscient of an old fire escape. There appears to be a mechanism at the final step.\n");
     matchCount();
    }
    if (hasPressedButton == true) {
     System.out.println("\nThe stairs are grated metal, reminscient of an old fire escape. A ladder hangs from the final step, just barely touching the ground.\n");
     matchCount();
    }
   }
   if (input.equals("touch stair")) {
    if (hasPressedButton == false) {
     System.out.println("\nYou try your best to to touch the stairs, but they are too far out of reach.\n");
     matchCount();
    }
    if (hasPressedButton == true) {
     System.out.println("\nYou place your hand upon the stair and begin to wonder why you feel such a compulsion to touch everything you come across.\n");
     matchCount();
    }
   }
   if (input.equals("look decoration")) {
    System.out.println("\nUpon closer inspection, you see that there is a small metal button hidden in the woodwork.\n");
    hasLookedatDecoration = true;
    matchCount();
   }
   if (input.equals("touch decoration")) {
    System.out.println("\nYou touch the decoration again. There definitely is something going on there.\n");
    matchCount();
   }
   if (input.equals("press button") || input.equals("touch button")) {
    System.out.println("\nYou press the button and hear a grinding of gears overhead.\n");
    hasPressedButton = true;
    matchCount();
   }
   if (input.equals("look button")) {
    System.out.println("\nYou take a look at the button, unsure of what to do with it. Then, in an astounding revelation, you remember: buttons are meant to be pressed.\n");
   }
   if (input.equals("look ladder")) {
    System.out.println("\nOh look, a ladder. How convenient that this ladder has emerged, now allowing you to go a direction which was previously unavailable to you! This truly is a happy and fortuitous occasion. Congratulations and good luck in all future laddering endeavours.\n");
    matchCount();
   }
   if (input.equals("climb ladder") || input.equals("climb stair")) {
    System.out.println("\nYou clamber up the ladder and onto the stairs. You flinch as the stairs begin to move and you are lifted towards a large balcony.\n");
    room = 2;
    hasLooked = false;
    matchCount();
   }
   if (input.equals("climb desk")) {
    System.out.println("\nA high pitched whine echoes throughout the study, causing you to fall to the floor in pain. Deep down, you know it's because of your strange desire to climb things you have no business climbing. You lose some matches.\n");
    matches -= 3;
    matchCount();
   }
   if (input.equals("climb books")) {
    System.out.println("\nA high pitched whine echoes throughout the study, causing you to fall to the floor in pain. Deep down, you know it's because of your strange desire to climb things you have no business climbing. You lose some matches.\n");
    matches -= 3;
    matchCount();
   }
   if (input.equals("climb decoration")) {
    System.out.println("\nA high pitched whine echoes throughout the study, causing you to fall to the floor in pain. Deep down, you know it's because of your strange desire to climb things you have no business climbing. You lose some matches.\n");
    matches -= 3;
    matchCount();
   }
   if (input.equals("climb button")) {
    System.out.println("\nA high pitched whine echoes throughout the study, causing you to fall to the floor in pain. Deep down, you know it's because of your strange desire to climb things you have no business climbing. You lose some matches.\n");
    matches -= 3;
    matchCount();
   }
   if (input.equals("press stair") || input.equals("press desk") || input.equals("press ladder") || input.equals("press decoration") || input.equals("press books")) {
    System.out.println("\nYou think about pressing it, but realize how dumb you would have to be to just go randomly pressing things. You are better than this.\n");
    matchCount();
   }
   if (matches < 0) {
    System.out.println("\nYou have succumbed to the darkness.\n");
    return "Fail";
   }
   seekInput();
  }
  if (room == 2) {
   if (input.equals("help")) {
    System.out.println("\nThese are all actions you can take right now:");
    if (hasLooked == false && walk < 4) {
     System.out.println("look  |   help");
    }
    if (hasLooked == false && walk >= 4) {
     System.out.println("look  |   help\nwalk");
    }
    if (hasLooked == true) {
     System.out.println("look  |   help\nwalk");
    }
    System.out.println("\nThese are all the things you can interact with right now:");
    if (hasLooked == false || hasLooked == true) {
     System.out.print("\n");
    }
   }
   if (input.equals("look")) {
    if (hasLooked == true && walk == 0) {
     System.out.println("\nA hallway stretches out in front of you, its end obscured by darkness.\n");
     matchCount();
    }
    if (hasLooked == true && walk > 0) {
     System.out.println("\nYou look back, expecting to see the balcony you just left. However, you are dismayed to find that something frightening has occurred; where once there was a balcony, now is just more hallway, going on for as far as you can see. You steel your nerves and prepare to move onward.\n");
     matchCount();
    }
    if (hasLooked == false && walk == 0) {
     hasLooked = true;
     System.out.println("\nAs you step onto the balcony, the stairs recede back to their original position. A hallway stretches out in front of you, its end obscured by darkness.\n");
     matchCount();
    }
    if (hasLooked == false && walk >= 4) {
     System.out.println("\nYou look out upon a beautiful seascape. As you begin to step forward, you quickly realize there is not much to step on. A rocky landing goes about a foor in front of where you stand, quickly dropping off into a sheer cliff face. You recognize the crashing waves below you as the source of the noises you previously heard.\n");
    }
   }
   if (input.equals("walk") && walk == 4) {
    walk++;
    System.out.println("\nYou look back into the dark of the hallway, and then out into the waters below. You decide you are not going back in there. You step beyond the cliff and begin your descent, wind screaming past your ears as you yourself scream towards the ocean. You realize all too late that stepping off of cliffs is usually not a very good decision. You close your eyes and pray to God as you fall to what you are sure will be your demise. Just as you are about to impact, there is silence.\n\n");
    Scanner scan = new Scanner(System.in);
    String end = scan.nextLine();
    System.out.println("You open your eyes and sit up off the ground, once again unsure of what just happened. You look around and for the first time find yourself in a familiar place: your bedroom. From what you can tell, it appears you fell off your bed sometime in the night while having a nightmare. You let out a haggard breath and sit back down onto your bed. You can't believe you had such a bad dream; it all had seemed so real at the time. As you lie down to go back to sleep, you feel something in your pocket. You reach your hand in and pull out a small box. You turn on the light beside your bed to get a better look at it. Your heart pounds as you realize that you are holding the matchbox. Suddenly, the light beside your bed flickers off and you are left in total darkness.\n\nYou have one match left.\n");
    room = 3;
   }
   if (input.equals("walk") && walk == 3) {
    System.out.println("\nYou step into the light, blinded at first by its intensity. Soon, your eyes adjust.\n");
    hasLooked = false;
    walk++;
   }
   if (input.equals("walk") && walk == 2) {
    walk++;
    System.out.println("\nYou see a faint white light ahead of you. It appears you have finally reached the end of the hall! As you begin to run towards the light, you put the matchbox into your pocket, no longer relying on it to see.\n");
    matchCount();
   }
   if (input.equals("walk") && walk == 1) {
    walk++;
    System.out.println("\nYou continue slowly down the hall, the noise ahead crescendoing to a deafening roar. A strong gust of wind travels down the hallway, nearly knocking you off balance.\n");
    matchCount();
   }
   if (input.equals("walk") && walk == 0) {
    walk++;
    if (matches == 4) {
     System.out.println("\nYou take your first step into the hall. You are startled by a strange noise coming from deep within the darkness.\n");
     matchCount();
    }
    if (matches < 4) {
     System.out.println("\nYou take your first step into the hall. You are startled by a strange noise coming from deep within the darkness. You stumble and fall. As you are getting up, you notice some mataches strewn across the ground.\n");
     matches = 4;
     matchCount();
    }
    if (matches > 4) {
     System.out.println("\nYou take your first step into the hall. You are startled by a strange noise coming from deep within the darkness. You stumble and drop some matches.\n");
     matches = 4;
     matchCount();
    }
   }
   if (matches < 0) {
    System.out.println("\nYou have succumbed to the darkness.\n");
    return "Fail";
   }
   seekInput();

   return "Fail";
  }
  return "Fail";
 }
 public static void matchCount() {
  matches--;
  if (matches >= 0)
   System.out.printf("You have %d matches left.\n\n", matches);
 }
}
