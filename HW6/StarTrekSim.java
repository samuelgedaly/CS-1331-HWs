//Collaborated with Benjamin Vaisberg

import java.util.Scanner;
import java.util.Random;
//NOTE: YOU ARE NOT ALLOWED TO USE THE ARRAYS CLASS:
import java.util.Arrays;

/**
 * A driver for running the Star Trek simulation
 *
 * @author Chase Lewis and Samuel Gedaly
 * @version 1.0
 */
public class StarTrekSim {
    private static Random randGen = new Random();
    private AstronomicalObject[] detected;
    //YOUR CODE HERE: Add any instance variables that you want
    //(not that you need them... there exists a solution without any)


    /**
     * The only constructor for the StarTrekSim class.
     * DO NOT EDIT
     */
    public StarTrekSim() {
        detected = new AstronomicalObject[]{};
    }

    /**
     * The main method for running the Star Trek game.
     * DO NOT EDIT.
     *
     * @param args The arguments passed in when the file is run from terminal
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StarTrekSim game = new StarTrekSim();

        printStarTrek();
        System.out.println(""
            + "Welcome to Star Trek Explorer. As the captain of the U.S.S \n"
            + "Compiler, it is your mission to explore strange new worlds;\n"
            + "to seek out new life and new civilizations; to boldly go\n"
            + "where no one has gone before.");

        game.newSystem();
        int input = 0;
        while (input != 7) {
            System.out.println("\nWould you like to:");
            System.out.println("1. List all detected objects");
            System.out.println("2. Observe all detected objects");
            System.out.println("3. Warp to a new system");
            System.out.println("4. Attack");
            System.out.println("5. Embark");
            System.out.println("6. Scan");
            System.out.println("7. Quit");
            System.out.println("Please enter one of the options above:");

            input = scan.nextInt();
            while (input < 1 || input > 7) {
                System.out.println("Please enter a number 1-6");
                input = scan.nextInt();
            }

            System.out.println();

            if (input == 1) {
                game.listObjects();
            } else if (input == 2) {
                game.observe();
            } else if (input == 3) {
                game.newSystem();
            } else if (input == 4) {
                game.attack();
            } else if (input == 5) {
                game.embark();
            } else {
                game.scan();
            }
        }
    }

    /**
     * A method for printing out each object in the detected array. Functions
     * by calling each object's toString() method implicitly (hint)
     * DO NOT EDIT!
     */
    private void listObjects() {
        for (AstronomicalObject obj: detected) {
            System.out.println(obj);
        }
    }
    /**
     * Print the result of the observed() method on each
     * object in the detected array.
     */
    private void observe() {
        //YOUR CODE HERE: Print the result of the observed() method on each
        //object in the detected array.
        for (int i = 0; i < detected.length; i++) {
            System.out.println(detected[i].observed());
        }
    }
    /**
     * A method that Randomly selects an Attackable
     * object in the detected array and attacks it.
     */
    private void attack() {
        //YOUR CODE HERE: Randomly select an Attackable object from the detected
        //array and attack it
        int c = 0;
        Random rand = new Random();
        for (int i = 0; i < detected.length; i++) {
            if (detected[i] instanceof Attackable) {
                c++;
            }
        }
        int[] indexes = new int[c];
        for (int j = 0; j < detected.length; j++) {
            if (detected[j] instanceof Attackable) {
                indexes[j] = j;
            }
        }
        int r = rand.nextInt(c);
        int indx = indexes[r];
        System.out.println(((Attackable) detected[indx]).attacked());
    }
    /**
    * A method that Randomly selects an embarkable
    * object in the detected array and boards it.
    */
    private void embark() {
        int c = 0;
        Random rand = new Random();
        for (int i = 0; i < detected.length; i++) {
            if (detected[i] instanceof Embarkable) {
                c++;
            }
        }
        int[] indexes = new int[c];
        for (int j = 0; j < detected.length; j++) {
            if (detected[j] instanceof Embarkable) {
                indexes[j] = j;
            }
        }
        int r = rand.nextInt(c);
        int indx = indexes[r];
        System.out.println(((Embarkable) detected[indx]).boarded());
    }
    /**
    * A method that Randomly selects an scannable
    * object in the detected array and scan it.
    */
    private void scan() {
        //YOUR CODE HERE: Randomly select a Scannable object from the detected
        //array and scan it
        int c = 0;
        Random rand = new Random();
        for (int i = 0; i < detected.length; i++) {
            if (detected[i] instanceof Scannable) {
                c++;
            }
        }
        //System.out.println(c);
        int[] indexes = new int[c];
        int m = 0;
        for (int j = 0; j < detected.length; j++) {
            if (detected[j] instanceof Scannable) {
                indexes[m] = j;
                m++;
            }
        }
        int r = rand.nextInt(c);
        int indx = indexes[r];
        System.out.println(((Scannable) detected[indx]).scanned());
    }

    //NOTE: DON'T CHANGE ANY CODE PAST THIS LINE!!!!!

    /**
     * A method which prints out "Star Trek" in ASCII
     * DO NOT EDIT!
     */
    private static void printStarTrek() {
        System.out.println(""
            + "=================================="
            + "================================\n"
            + "     ______ _______ ______ ______   "
            + " _______ ______  ______ __  __\n"
            + "    / __  //__  __// __  // __  /   "
            + "/__  __// __  / / ____// / / /\n"
            + "   / / /_/   / /  / /_/ // /_/ /     "
            + " / /  / /_/ / / /__  / //'/'\n"
            + "   _\\ \\     / /  / __  //   __/    "
            + "  / /  /   __/ / __ / /  '/'\n"
            + " / /_/ /   / /  / / / // /\\ \\     "
            + "  / /  / /\\ \\  / /___ / /\\ \\\n"
            + "/_____/   /_/  /_/ /_//_/  \\_\\    "
            + " /_/  /_/  \\_\\/_____//_/  \\_\\"
            + "\n================================="
            + "================================\n");
    }

    /**
     * A method for generating a new system. It prints out a status message and
     * randomly generates a new array of objects.
     * DO NOT EDIT!
     */
    private void newSystem() {
        System.out.printf("\nAfter traveling at Warp %.1f ",
            randGen.nextDouble() * 10);
        System.out.printf("for %d days, you arrive at a new system.\n",
            randGen.nextInt(8) + 2);
        System.out.println("Your sensors detect a few objects in the near"
            + " vicinity.");
        System.out.println("What are your orders, Captain?\n");

        detected = new AstronomicalObject[randGen.nextInt(4) + 4];
        for (int i = 4; i < detected.length; i++) {
            int select = randGen.nextInt(4);
            if (select == 0) {
                detected[i] = new Planet();
            } else if (select == 1) {
                detected[i] = new Star();
            } else if (select == 2) {
                detected[i] = new Asteroid();
            } else {
                detected[i] = new Spaceship();
            }
        }
        detected[0] = new Planet();
        detected[1] = new Star();
        detected[2] = new Asteroid();
        detected[3] = new Spaceship();
        //If you are getting an error from this line, make sure you have
        //implemented the Comparable interface!!!
        Arrays.sort(detected);
    }
}
