import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;


public class Pojedynczy {

    private int H[][]= {{1,1,1,0,1,0,0,0,1,0,0,0},
                        {1,1,0,1,0,1,1,0,0,1,0,0},
                        {1,0,1,1,0,1,0,1,0,0,1,0},
                        {0,1,1,1,1,0,1,1,0,0,0,1}};  //To jeszcze do poprawki ofc

    //private ArrayList<Integer> T = new ArrayList<Integer>();
    private ArrayList<Integer> T = new ArrayList<>();
    private ArrayList<Integer> E = new ArrayList<>();
    private int ArraySize;
    //private int T[] = new int[8];

    private int calculate_C(int r,int k){
        int c = 0;
        for(int i=0;i<8;i++){
            c += H[r][i] * T.get(k*8+i);
        }
        c %= 2;
        return c;
    }

    private int calculate_C2(int r,int k){
        int c = 0;
        for(int i=0;i<12;i++){
            c += H[r][i] * T.get(k*8+i);
        }
        c %= 2;
        return c;
    }

    public void encrypt(){

        for(int k=0;k<ArraySize;k++){
            for(int i=0;i<4;i++){
                int C = calculate_C(i,k);
                T.add((k+1)*8+k*4+i, C);

            }
            System.out.println(T);
        }

        System.out.println("Zaszyfrowana wiadomosc!: " + T);
        System.out.println("Wysyłam");
        System.out.println();
    }

    private void repair(int k){
        boolean theSame = false;
        //int pom = 0;

        for(int i=0; i<12; i++){
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
                System.out.println("Znalazłem bład na pozycji: " + k*8+i);
                int bit = T.get(k*8+i);
                if(bit == 1) bit = 0;
                else bit = 1;
                T.remove(k*8+i);
                T.add(k*8+i,bit);
            }
        }
    }

    public void decrypt(){
        System.out.println("Odebrana wiadomosc: " + T);
        boolean blad;

        for(int k=0;k<ArraySize;k++) {
            blad = false;
            for (int i = 0; i < 4; i++) {
                int c = calculate_C2(i, k);
                E.add(c);
                System.out.println("C na pozycji " + i + "  " + c);
                if (c == 1) blad = true;
            }

            if (blad) {
                System.out.println("W wiadomości wystąpił błąd!");
                System.out.println("Naprawię go!");
                repair(k);
            }
            System.out.println(E);
            E.clear();

            for (int i = 0; i < 4; i++) {
                T.remove((k + 1) * 8);
            }
        }
        System.out.println(T);
    }

    public void changeT(){
        T.remove(4);
        T.add(4,1);
    }


    public void BytesToVector(byte[] tab){
        //ArrayList<Integer> tmp = new ArrayList<>();
        BitSet bity = BitSet.valueOf(tab);
        for (int i=0; i<bity.size(); i++){
            if(!bity.get(i)) T.add(0);
            else T.add(1);
        }
        ArraySize = tab.length;
        System.out.println(tab.length);
        System.out.println(bity.size());
        System.out.println(T);

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

