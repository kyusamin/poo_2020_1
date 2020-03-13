package vetores;

import java.util.ArrayList;

public class Array {
    
    public static void main(String[] args) {
        ArrayList<Integer> vetor = new ArrayList<>();
        vetor.add(0); // adicionar
        vetor.add(1);
        vetor.add(2);
        vetor.add(0,3);
        vetor.add(2,9);
        vetor.add(0);
        vetor.remove(Integer.valueOf(2));
        System.out.println(vetor.contains(9)); // conter
        vetor.set(0, 99); //inserir
        
        //laço indexado
        for(int i = 0; i < vetor.size(); i++){
            System.out.println(vetor.get(i) + " ");
        }
        
        //for range
        for(Integer value : vetor)
            System.out.print(value + " ");
        System.out.println("");
        
            System.out.println(vetor);
    }
}