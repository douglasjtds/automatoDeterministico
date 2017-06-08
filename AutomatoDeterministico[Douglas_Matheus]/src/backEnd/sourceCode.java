package backEnd;

import javax.swing.*;
/**
 *
 * @author douglasjtds & yMetsBless
 */
public class sourceCode {
    
    String word;
    int currentState; //variavel para guardar o estado em que o algoritmo se encontra
    char[] Alphabet = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'E', '+', '-', '.'};
    char[] PlusLess = {'+', '-'};
    char Dot = '.';

    public sourceCode(String Word) {
        this.word = Word;
    }

    private boolean inAlphabet(String Word){
        int count = 0;
        for(int i=0; i<Word.length(); i++){
            for(int j=0; j<Alphabet.length; j++){
                if(Word.charAt(i) != Alphabet[j]){
                    count++;
                }
            }
            if (count == Alphabet.length){
                    return false;     
            } else{
                count = 0;
            }
        }
        return true;
    }
    
 /*   public void finalState(Character Word){
        if(Character.isDigit(Word) && ) {
            
        }
    } */
    
    
    
    public void calcCode(String word){ //método para calcular a palavra
        //TODO COLOCAR O BACKEND AQUI:
        //estado inicial + - o número
        boolean verify = true;
        int allowedState[] = {1,2,3,4,5,6,8,9}; //estados existentes no automato
        currentState = 0; //define q0 como estado inicial
        //Word = jTextField_putWord.getText(); //tá dando erro, tem que ver como
        //que pega o texto que tá em outro pacote
               
        verify = inAlphabet(word);
        //verificação que o matheus fez
        if(verify == true){
            JOptionPane.showMessageDialog(null, "Sim! ");
        } else{
            JOptionPane.showMessageDialog(null, "Não! ");
        }
    }
}
