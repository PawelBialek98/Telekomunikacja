import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;

public class Pojedynczy {

    private int H[][]= {{1,1,1,0,1,0,0,0,1,0,0,0},
                        {1,1,0,1,0,1,1,0,0,1,0,0},
                        {1,0,1,1,0,1,0,1,0,0,1,0},
                        {0,1,1,1,1,0,1,1,0,0,0,1}};  //To jeszcze do poprawki ofc

    //private ArrayList<Integer> T = new ArrayList<Integer>();
    private ArrayList<Integer> T = new ArrayList<>(Arrays.asList(1, 0, 1, 1, 0, 1, 1, 1));
    private ArrayList<Integer> E = new ArrayList<>();
    //private int T[] = new int[8];

    private int calculate_C(int r){
        int c = 0;
        for(int i=0;i<T.size();i++){
            c += H[r][i] * T.get(i);
        }
        c %= 2;
        return c;
    }


    public void encrypt(){

        for(int i=0;i<4;i++){
            int C = calculate_C(i);
            T.add(C);
        }

        System.out.println("Zaszyfrowana wiadomosc!: " + T);
        System.out.println("Wysyłam");
        System.out.println();
    }

    private void repair(){
        boolean theSame = false;
        //int pom = 0;

        for(int i=0; i<T.size(); i++){
            for(int j=0; j<E.size(); j++){
                if(H[j][i] == E.get(j)){
                    theSame = true;
                }
                else{
                    theSame = false;
                    break;
                }
            }
            if(theSame){
                System.out.println("Znalazłem bład na pozycji: " + i);
                int bit = T.get(i);
                if(bit == 1) bit = 0;
                else bit = 1;
                T.remove(i);
                T.add(i,bit);
            }
        }
    }

    public void decrypt(){
        System.out.println("Odebrana wiadomosc: " + T);
        boolean blad = false;

        for(int i=0;i<4;i++){
            int c = calculate_C(i);
            E.add(c);
            if(c==1) blad = true;
        }

        if(blad){
            System.out.println("W wiadomości wystąpił błąd!");
            System.out.println("Naprawię go!");
            repair();
        }

        System.out.println("Poprawna wiadomosc: " + T);
    }

    public void changeT(){
        T.remove(3);
        T.add(3,0);
    }







    public void stringToInt(String input){
        int pom = Integer.parseInt(input);
        int pom2 = 11001110;
        for(int i=7; i>=0; i--){
            System.out.println(pom2%10);
            if(pom2%10 == 0) { T.add(0);}
            else { T.add(1);}
            pom2 /= 10;
        }
    }

}
