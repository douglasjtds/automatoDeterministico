package backEnd;
import javax.swing.*;

/**
 *
 * @author douglasjtds & yMetsBless
 */
public class sourceCode {
    
    String word;
    int currentState; //variavel para guardar o estado em que o algoritmo se encontra
    char[] alphabet = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'E', '+', '-', '.'};
    char dot = '.';

    public sourceCode(String word) {
        this.word = word;
    }

    private boolean inAlphabet(String word){
        if(word.isEmpty())
            return false;
        
        int count = 0;
        for(int i=0; i<word.length(); i++){
            for(int j=0; j<alphabet.length; j++){
                if(word.charAt(i) != alphabet[j]){
                    count++;
                }
            }
            if (count == alphabet.length){
                    return false;     
            } else{
                count = 0;
            }
        }
        return true;
    }
    
    public boolean isfinalState(int currentState){
        if(currentState == 3 || currentState == 5 || currentState == 9){
            return true;   
        } else
            return false;
    } 
    
    public boolean isPoint(String word, int pos){
        if(word.charAt(pos) == dot){
            return true;
        } else
            return false;
    }

    
    public boolean isPlusOrLess(String word, int pos){
        if(word.charAt(pos) == '+' || word.charAt(pos) == '-'){
            return true;
        } else
            return false;
    }
    
    public boolean isDigit(String word, int pos){
        if(Character.isDigit(word.charAt(pos))){
            return true;
        } else
            return false;
    }
    
    public boolean isE(String word, int pos){
        if(word.charAt(pos) == 'E') {
            return true;
        } else
            return false;
    }
    
    
    public void calcCode(String word){ //método para calcular a palavra
        boolean verify = true;  //Variavel que irá verificar se a palavra bate com o alfabeto
        int wordLenght = word.length();
        int currentPosition = 0;
        currentState = 0; //define q0 como estado inicial
               
        verify = inAlphabet(word);  //Verifica se a palavra pertence ao alfabeto
        if(verify == true){
            while(currentPosition != wordLenght){
                    switch (currentState)  { 
                            case 0: { //quando está no estado inicial
                                    if (isPlusOrLess(word, currentPosition)) { //veio + ou -
                                            currentState = 1;
                                            currentPosition++;
                                    } else if (isPoint(word, currentPosition)) { //veio .
                                            currentState = 2;
                                            currentPosition++;
                                    } else if (isDigit(word, currentPosition)) { //veio algum dígito isDigit
                                            currentState = 3; //que é um estado final 
                                            currentPosition++;
                                    } else {
                                        currentState = 10;
                                    }
                                    break;
                            }
                            case 1: { //caso esteja no estado 1
                                    if (isPoint(word, currentPosition)) { //veio .
                                            currentState = 2;
                                            currentPosition++;
                                    } else if (isDigit(word, currentPosition)) { //veio algum dígito
                                            currentState = 3;
                                            currentPosition++;
                                    } else {
                                        currentState = 10;
                                    }
                                break;   
                            }
                            case 2: { //caso esteja no estado 2
                                    if (isDigit(word, currentPosition)) { //vier algum digito
                                            currentState = 5;
                                            currentPosition++;
                                    } else {
                                        currentState = 10;
                                    }
                                break;
                            }
                            case 3: { //caso esteja no estado 3 (que é final)
                                    if (isDigit(word, currentPosition)) { //vier algum dígito
                                            currentState = 3;
                                            currentPosition++;
                                    } else if (isPoint(word, currentPosition)) { //vier .
                                            currentState = 4;
                                            currentPosition++;
                                    } else if (isE(word, currentPosition)) { //vier a letra E
                                            currentState = 6;
                                            currentPosition++;
                                    } else {
                                        currentState = 10;
                                    }
                                break;
                            }
                            case 4: { //caso esteja no estado 4
                                    if (isDigit(word, currentPosition)) { //vier algum digito
                                            currentState = 5;
                                            currentPosition++;
                                    } else {
                                        currentState = 10;
                                    }
                                break;
                            }
                            case 5: { //caso esteja no estado 5 (que é final)
                                    if (isDigit(word, currentPosition)) { //vier algum dígito
                                            currentState = 5;
                                            currentPosition++;
                                    } else if (isE(word, currentPosition)) { //vier a letra E
                                            currentState = 6;
                                            currentPosition++;
                                    } else {
                                        currentState = 10;
                                    }
                                break;
                            }
                            case 6: { //caso esteja no estado 6
                                    if (isPlusOrLess(word, currentPosition)) { //vier + ou -
                                            currentState = 8;
                                            currentPosition++;
                                    } else if (isDigit(word, currentPosition)) { //vier algum dígito
                                            currentState = 9;
                                            currentPosition++;
                                    } else {
                                        currentState = 10;
                                    }
                                break;
                            }
                            case 8: { //caso esteja no estado 8 (não tem estado 7 no AFD)
                                    if (isDigit(word, currentPosition)) { //vier algum dígito
                                            currentState = 9;
                                            currentPosition++;
                                    } else {
                                        currentState = 10;
                                    }
                                break;
                            }
                            case 9: { //caso esteja no estado 9 (que é final)
                                    if (isDigit(word, currentPosition)) { //vier algum dígito
                                            currentState = 9;
                                            currentPosition++;
                                    } else {
                                        currentState = 10;
                                    }
                                break;
                            }
                            default: {
                                JOptionPane.showMessageDialog(null, "Não!  -  Palavra invalida. ");
                                JOptionPane.showMessageDialog(null, "O Autômato entrou "
                                        + "num estado inexistente.   ---- ERROR\n\n"
                                        + "fechando aplicação..."); //deixa isso ou não?!
                                System.exit(0);
                            }
                        }
            }
            
                if(wordLenght == currentPosition && isfinalState(currentState)){
                    JOptionPane.showMessageDialog(null, "Sim!  -  Palavra válida.");
                } else
                    JOptionPane.showMessageDialog(null, "Não!  -  Palavra invalida. ");
            } else
                JOptionPane.showMessageDialog(null, "Não!  -  Palavra invalida. ");
        }
}