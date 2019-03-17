import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;


public class Pojedynczy {

    /*private int H[][]= {{1,1,1,0,1,0,0,0,1,0,0,0},
                        {1,1,0,1,0,1,1,0,0,1,0,0},
                        {1,0,1,1,0,1,0,1,0,0,1,0},
                        {0,1,1,1,1,0,1,1,0,0,0,1}};*/  //To jeszcze do poprawki ofc

    /*private int H[][]={ {0,1,1,1,1,1,1,0,   1,0,0,0,0},
                        {1,0,1,1,0,1,0,1,   0,1,0,0,0},
                        {0,1,1,1,1,0,0,1,   0,0,1,0,0},
                        {1,0,1,0,1,0,1,1,   0,0,0,1,0},
                        {0,1,0,0,0,1,1,1,   0,0,0,0,1}};*/

    private int H[][] ={{1,0,0,0,0,0,0,0,  1,0,0,0,0,0,0,0},
                        {1,0,0,0,0,0,0,1,  0,1,0,0,0,0,0,0},
                        {1,1,0,1,1,1,1,0,  0,0,1,0,0,0,0,0},
                        {1,1,1,0,1,1,1,1,  0,0,0,1,0,0,0,0},
                        {0,0,1,1,0,1,1,1,  0,0,0,0,1,0,0,0},
                        {1,1,1,1,1,0,1,1,  0,0,0,0,0,1,0,0},
                        {0,1,1,1,1,1,0,1,  0,0,0,0,0,0,1,0},
                        {0,0,0,0,1,0,1,1,  0,0,0,0,0,0,0,1},};

   /*private int H[][]={  {1, 1, 0, 1, 1, 1, 0, 0,   1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {1, 0, 1, 0, 0, 1, 0, 1,   0, 1, 0, 0, 0, 0, 0, 0, 0},
                        {1, 0, 0, 1, 1, 0, 1, 1,   0, 0, 1, 0, 0, 0, 0, 0, 0},
                        {1, 1, 1, 1, 1, 1, 1, 1,   0, 0, 0, 1, 0, 0, 0, 0, 0},
                        {1, 1, 1, 1, 0, 0, 1, 0,   0, 0, 0, 0, 1, 0, 0, 0, 0},
                        {0, 0, 1, 1, 1, 1, 0, 0,   0, 0, 0, 0, 0, 1, 0, 0, 0},
                        {1, 1, 1, 0, 1, 0, 0, 0,   0, 0, 0, 0, 0, 0, 1, 0, 0},
                        {0, 1, 0, 0, 1, 0, 1, 0,   0, 0, 0, 0, 0, 0, 0, 1, 0},
                        {0, 0, 0, 0, 1, 0, 1, 1,   0, 0, 0, 0, 0, 0, 0, 0, 1}};*/

    private ArrayList<Integer> T = new ArrayList<>();
    private ArrayList<Integer> E = new ArrayList<>();
    private int ArraySize;
    private int kolumny = H[0].length;
    private int wiersze = H.length;

    private int calculate_C(int r,int k){
        int c = 0;
        for(int i=0;i<8;i++){
            c += H[r][i] * T.get(k*kolumny+i);
        }
        c %= 2;
        return c;
    }

    private int calculate_C2(int r,int k){
        int c = 0;
        for(int i=0;i<kolumny;i++){
            c += H[r][i] * T.get(k*8+i);
        }
        c %= 2;
        return c;
    }

    public void encrypt(){
        System.out.println(T);
        for(int k=0;k<ArraySize;k++){
            for(int i=0;i<wiersze;i++){
                int C = calculate_C(i,k);
                T.add((k+1)*8+k*wiersze+i, C);
            }
        }

        System.out.println("Zaszyfrowana wiadomosc!: " + T);
        System.out.println("Wysyłam");
        System.out.println(H.length);
        System.out.println(H[0].length);
        //findColumnsWithErrors();
    }

    private void findColumnsWithErrors(int k){
        ArrayList<Integer> pom = new ArrayList<>();
        for(int i=0; i<kolumny; i++){
            for(int j=i+1; j<kolumny; j++){
                //pom.add(H[j][i]);
                for(int n=0; n<wiersze; n++){
                    pom.add((H[n][i] + H[n][j])%2);
                }
                //System.out.println(pom);
                if(pom.equals(E)){
                    System.out .println("To te same!" + E + "\t" + pom + "Nr kolumn: " + i + " oraz " + j + " K: " + k);
                    changeBit(k,i);
                    changeBit(k,j);
                }
                pom.clear();
            }
        }
    }

    private void changeBit(int k, int i){
        int bit = T.get(k * 8 + i);
        if (bit == 1) bit = 0;
        else bit = 1;
        T.remove(k * 8 + i);
        T.add(k * 8 + i, bit);
    }

    private void repair(int k) {
        boolean theSame = false;
        boolean done = false;
        //int pom = 0;

        for (int i = 0; i < kolumny; i++) {
            for (int j = 0; j < E.size(); j++) {
                if (H[j][i] == E.get(j)) {
                    theSame = true;
                } else {
                    theSame = false;
                    break;
                }
            }
            if (theSame) {
                System.out.println("Znalazłem bład na pozycji: " + (k * 8 + i));
                changeBit(k,i);

                done = true;
            }
        }
        //System.out.println("TheSameFlag: " + theSame);
        //System.out.println("DoneFlag: " + done);
        if (!done) {
            findColumnsWithErrors(k);
        }
        /*for(int i=0;i<E.size();i++){
            System.out.println(k);
            if(E.get(i) == 1){
                System.out.println("K:\t" + k + "\tI:\t" + i);
                int bit = T.get(k*8+i);
                if(bit == 1) bit = 0;
                else bit = 1;
                T.remove(k*8+i);
                T.add(k*8+i,bit);
            }
        }*/

    }

    public void decrypt(){
        System.out.println("Odebrana wiadomosc: " + T);
        boolean blad;

        for(int k=0;k<ArraySize;k++) {
            blad = false;
            for (int i = 0; i < wiersze; i++) {
                int c = calculate_C2(i, k);
                E.add(c);
                if (c == 1) blad = true;
            }

            if (blad) {
                System.out.println(E);
                System.out.println("W wiadomości wystąpił błąd!");
                System.out.println("Naprawię go!");
                repair(k);
            }
            E.clear();

            for (int i = 0; i < wiersze; i++) {
                T.remove((k + 1) * 8);
            }
        }
    }

    public void changeT(){
        T.remove(1);
        T.add(1,1);
        T.remove(7);
        T.add(7,0);

        T.remove(60);
        T.add(60,0);
        //T.remove(5);
        //T.add(5,1);
    }


    public void BytesToVector(byte[] tab){
        //ArrayList<Integer> tmp = new ArrayList<>();
        BitSet bity = BitSet.valueOf(tab);
        for (int i=0; i<bity.size(); i++){
            if(!bity.get(i)) T.add(0);
            else T.add(1);
        }
        ArraySize = tab.length;
    }

    public byte[] VectorToBytes(){
        BitSet bity = new BitSet(T.size());
        for(int i=0;i<T.size();i++){
            if(T.get(i)==1) bity.set(i);
        }
        return bity.toByteArray();
    }

    public ArrayList<Integer> getT(){return T;}
}

