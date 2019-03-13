import java.util.ArrayList;

public class Pojedynczy {

    private int H[][]= {{1,1,1,1,1,1,1,1,1,0,0,0},
                        {1,1,1,1,1,1,1,1,0,1,0,0},
                        {1,1,1,1,1,1,1,1,0,0,1,0},
                        {1,1,1,1,1,1,1,1,0,0,0,1}};  //To jeszcze do poprawki ofc

    //private ArrayList<int> T = new ArrayList<int>();
    private int T[] = new int[8];

    public String encrypt(String input){

        //int pom = Integer.parseInt(input);
        int pom = Integer.parseInt(input);

        //System.out.println("ELO!");
        stringToInt(input);
        System.out.println(pom);
        for(int i=0; i<8; i++){
            System.out.print(T[i]);
        }

        return input;
    }

    public void stringToInt(String input){
        int pom = Integer.parseInt(input);
        for(int i=7; i>=0; i++){
            System.out.println(pom%10);
            if(pom%10 == 0) { T[i] = 0;}
            else { T[i] = 1;}
            pom /= 10;
        }
    }

}
