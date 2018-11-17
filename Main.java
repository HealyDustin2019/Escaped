import java.util.Scanner;
public class Main{
    public static int room = 0;
    public static boolean hasLooked = false;
    public static boolean hasMatches = false;
    public static int matches = 30;
    public static void main(String[] args){
        initialize();
        
    }
    public static void initialize(){
        System.out.println("You awaken. Type help for a list of commands.\n");
        seekInput();
    }
    public static void seekInput(){
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        check(input);
    }
    public static void check(String input){
        if(room == 0){
        if(input.equals("help")){
        System.out.println("\nThese are all actions you can take right now:");

        if(hasLooked == false){
            System.out.print("look  |   help\n");
            //look | open\nlight | get
        }
        if((hasLooked == true) && (hasMatches == false)){
            System.out.print("look  |   help\nget");
        }
        if(hasMatches == true){
            System.out.print("look  |   help\nlight");
        }
        System.out.println("\nThese are all the things you can interact with right now:");
        if(hasLooked == false){
            System.out.print("\n");
        }
        if(hasLooked == true){
            System.out.print("matches\n");
        }
        }
        if(input.equals("look")){
            hasLooked = true;
            System.out.print("\nThe brightness of your surroundings causes you great pain. You squint as you attempt to make out where you may be, but find yourself in a place entirely unfamiliar. A vast, empty expanse stretches out before you. A box of matches sits in front of you.\n");
        }
        if(input.equals("look matches")){
            System.out.println("\nA box of matches, with a well worn magnesium strike pad on the side.");
        }
        if(input.equals("get matches")){
            hasMatches = true;
            System.out.println("You pick up the box of matches.");
        }
        if(input.equals("light matches")){
            room = 1;
            matches--;
            System.out.printf("You strike the match, and as it sparks to life, you are transported somewhere new. You have %d matches left.\n",matches);
        }
        seekInput();
        }
        if(room == 1)
        System.out.print("You win!");
    }
}
