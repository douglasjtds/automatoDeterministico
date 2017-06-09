package backEnd;

import com.sun.xml.internal.ws.api.ha.StickyFeature;
import javax.swing.*;
/**
 *
 * @author douglasjtds & yMetsBless
 */
public class sourceCode {
    
    String word;
    int currentState; //variavel para guardar o estado em que o algoritmo se encontra
    char[] alphabet = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'E', '+', '-', '.'};
//    char[] plusLess = {'+', '-'};
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
    
 /*  public void isfinalState(String word, int pos){
        if(word.charAt(pos)){
            
        }
    } */
    
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
        //TODO COLOCAR O BACKEND AQUI:
        //estado inicial + - o número
        boolean verify = true;
        int allowedState[] = {1,2,3,4,5,6,8,9}; //estados existentes no automato
        int wordLenght = word.length();
        int currentPosition = 0;
        currentState = 0; //define q0 como estado inicial
        //Word = jTextField_putWord.getText(); //tá dando erro, tem que ver como
        //que pega o texto que tá em outro pacote
               
        verify = inAlphabet(word);
        if(verify == true){
            while(currentPosition != wordLenght){
                    JOptionPane.showMessageDialog(null, "Sim!  -  Palavra válida.");
                    switch (currentState)  { 
                            case 0: { //caso esteja no estado 0
                                    if (isPlusOrLess(word, currentPosition)) { //veio + ou -
                                            currentState = 1;
                                    } else if (isPoint(word, currentPosition)) { //veio .
                                            currentState = 2;
                                    } else if (isDigit(word, currentPosition)) { //veio algum dígito isDigit
                                            currentState = 3; //que é um estado final 
                                    } else {
                                        currentState = 10;
                                    }

                            }
                            case 1: { //caso esteja no estado 1
                                    if (isPoint(word, currentPosition)) { //veio .
                                            currentState = 2;
                                    } else if (isDigit(word, currentPosition)) { //veio algum dígito
                                            currentState = 3;
                                    } else {
                                        currentState = 10;
                                    }
                            }
                            case 2: { //caso esteja no estado 2
                                    if (isDigit(word, currentPosition)) { //vier algum digito
                                            currentState = 5;
                                    } else {
                                        currentState = 10;
                                    }
                            }
                            case 3: { //caso esteja no estado 3 (que é final)
                                    if (isDigit(word, currentPosition)) { //vier algum dígito
                                            currentState = 3;
                                    } else if (isPoint(word, currentPosition)) { //vier .
                                            currentState = 4;
                                    } else if (isE(word, currentPosition)) { //vier a letra E
                                            currentState = 6;
                                    } else {
                                        currentState = 10;
                                    }
                            }
                            case 4: { //caso esteja no estado 4
                                    if (isDigit(word, currentPosition)) { //vier algum digito
                                            currentState = 5;
                                    } else {
                                        currentState = 10;
                                    }
                            }
                            case 5: { //caso esteja no estado 5 (que é final)
                                    if (isDigit(word, currentPosition)) { //vier algum dígito
                                            currentState = 5;
                                    } else if (isE(word, currentPosition)) { //vier a letra E
                                            currentState = 6;
                                    } else {
                                        currentState = 10;
                                    }
                            }
                            case 6: { //caso esteja no estado 6
                                    if (isPlusOrLess(word, currentPosition)) { //vier + ou -
                                            currentState = 8;				
                                    } else if (isDigit(word, currentPosition)) { //vier algum dígito
                                            currentState = 9;
                                    } else {
                                        currentState = 10;
                                    }
                            }
                            case 8: { //caso esteja no estado 8 (não tem estado 7 no AFD)
                                    if (isDigit(word, currentPosition)) { //vier algum dígito
                                            currentState = 9;
                                    } else {
                                        currentState = 10;
                                    }
                            }
                            case 9: { //caso esteja no estado 9 (que é final)
                                    if (isDigit(word, currentPosition)) { //vier algum dígito
                                            currentState = 9;
                                    } else {
                                        currentState = 10;
                                    }
                            }
                            default: {
                                currentState = 10; //estado de erro
                                JOptionPane.showMessageDialog(null, "O Autômato entrou "
                                        + "num estado inexistente.   ---- ERROR");
                            }
                        }
            }
        } else{
            JOptionPane.showMessageDialog(null, "Não!  -  Palavra invalida. ");
        }
        }
    }  //ERRO NESSA CHAVE CONSERTAR!!! (Douglas diz: que erro?! hahaha)