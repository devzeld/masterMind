import java.util.Random;
import java.util.Scanner;

public class MasterMind{
    public static int getRandomNum(){
        Random ran = new Random();
        return 1000 + ran.nextInt(9000);
    }

    public static int getUserNum(){
        Scanner sc = new Scanner(System.in);
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
        for(int i = 1; i <= 4; i++) {
            numUserToTry = userNum % 10;
            if (verifyNum(numUserToTry, randomNum)) {
                counterWrongPos++;
            }
            userNum /= 10;
        }
        return counterWrongPos;
    }


    }
