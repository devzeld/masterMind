import java.util.Random;
import java.util.Scanner;

public class MasterMind{
    private final boolean[] correctNumbers;
    private final int digits;
    private final int tries;
    private final int randNum;

    public MasterMind(int digits,int tries){
        Random ran = new Random();
        this.digits = digits;
        this.tries = tries;
        this.randNum = 1000 + ran.nextInt(9000);
        correctNumbers = new boolean[digits];
    }


    public int getDigits(int num, int index){
        return (num / (int) Math.pow(10, index)) % 10;
    }

    public int getUserNum(int i){
        Scanner sc = new Scanner(System.in);
        System.out.print(i + "- Insert a digit: ");
        return sc.nextInt();
    }

    public int numInRightPos(int userNum){
        int counterRightPos = 0;
        for(int i = 0; i < this.digits; i++) {
            if (getDigits(userNum, i) == getDigits(this.randNum, i)) {
                this.correctNumbers[i] = true;
                counterRightPos++;
            }else {
                this.correctNumbers[i] = false;
            }
        }
        return counterRightPos;
    }



    public int numInWrongPos(int userNum){
        int counterWrongPos = 0;
        for(int i = 0; i < this.digits; i++) {
            if(this.correctNumbers[i]){
                continue;
            }
            for(int j = 0; j <= this.digits; j++){
                if (getDigits(userNum, j) == getDigits(this.randNum, i)) {
                    counterWrongPos++;
                    break;
                }
            }
        }
        return counterWrongPos;
    }


    public void game(){
        int i = 1;
        System.out.println(this.randNum);
        while (i <= this.tries){
            int userNum = getUserNum(i);
            if (userNum >= 1000 && userNum <= 9999) {
                System.out.println(numInRightPos(userNum) == 4 ? "You Won!" : "Right Position: " + numInRightPos(userNum) + "\nWrong Position: " + numInWrongPos(userNum));
                if (numInRightPos(userNum) == 4) {
                    break;
                } else {
                    i++;
                }
            }
        }
        System.out.println(i > 10?"You probably lose!\nThe number was " + this.randNum:"Good, the number was " + this.randNum);
    }

}


