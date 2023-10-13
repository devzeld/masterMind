import java.util.Random;
import java.util.Scanner;

public class MasterMind{
    public static int getRandomNum(){
        Random ran = new Random();
        return 1000 + ran.nextInt(9000);
    }

    public static int getUserNum(int i){
        Scanner sc = new Scanner(System.in);
        System.out.print(i + "- Insert a digit: ");
        return sc.nextInt();
    }

    public static int numInRightPos(int randomNum, int userNum){
        int counterRightPos = 0;
        for(int i = 1; i <= 4; i++) {
            if (randomNum % 10 == userNum % 10) {
                counterRightPos++;
            }
            randomNum /= 10;
            userNum /= 10;
        }
        return counterRightPos;
    }

    public static boolean verifyNum(int numUserToTry, int randomNum){
        for(int j = 1; j <= 4; j++) {
            if (numUserToTry == randomNum % 10) {
                return true;
            }
            randomNum /= 10;
        }
        return false;
    }


    public static int numInWrongPos(int randomNum, int userNum){
        int counterWrongPos = 0;
        int numUserToTry;
        int randN = randomNum;
        int userN = userNum;
        for(int i = 1; i <= 4; i++) {
            numUserToTry = userNum % 10;
            if (verifyNum(numUserToTry, randomNum)) {
                counterWrongPos++;
            }
            userNum /= 10;
        }
        return counterWrongPos - numInRightPos(randN, userN);
    }

    public static void game(){
        int i = 1;
        int randomNum = getRandomNum();
        while (i <= 10){
            int userNum = getUserNum(i);
            System.out.println(numInRightPos(randomNum, userNum) == 4?"You Won!" : "The number that you guess the position are: " + numInRightPos(randomNum, userNum) + "\nThe number that you guess are: " + numInWrongPos(randomNum, userNum));
            if (numInRightPos(randomNum, userNum) == 4) {
                break;
            } else {
                i++;
            }

        }
        System.out.println(i > 10?"You probably lose!\nThe number was " + randomNum:"Good, the number was " + randomNum);
    }

    }
