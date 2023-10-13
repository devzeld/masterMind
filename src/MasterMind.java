import java.util.Random;

public class MasterMind{
    public static int getRandomNum(){
        Random ran = new Random();
        return 1000 + ran.nextInt(9000);
    }

    public static int numInRightPos(int randomNum, int userNum){
        int counterRightPos = 0;
        int divider = 10;
        for(int i = 1; i <= 4; i++) {
            if (randomNum % divider == userNum % divider) {
                counterRightPos++;
            }
            randomNum /= 10;
            userNum /= 10;
        }
        return counterRightPos;
    }

    public static int numInWrongPos(int randomNum, int userNum){
        return 0;
    }


    }
