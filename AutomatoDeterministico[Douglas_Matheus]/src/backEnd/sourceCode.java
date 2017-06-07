package backEnd;

import Interface.mainScreen;
import javax.swing.JOptionPane;

/**
 *
 * @author douglasjtds & yMetsBless
 */
public class sourceCode {
    
    String Word;
    int currentState; //variavel para guardar o estado em que o algoritmo se encontra
    char letter;
    public void calcCode(String aut){ //método para calcular a palavra
        //TODO COLOCAR O BACKEND AQUI:
        //estado inicial + - o número
        boolean inOnAlphabet = true;
        int allowedState[] = {1,2,3,4,5,6,8,9}; //estados existentes no automato
        currentState = 0; //define q0 como estado inicial
        //Word = jTextField_putWord.getText(); //tá dando erro, tem que ver como
        //que pega o texto que tá em outro pacote
        
        
        
        //verificação que o matheus fez
        if(true != aut.isEmpty()){
            JOptionPane.showMessageDialog(null, "Sim! ");
        } else{
            JOptionPane.showMessageDialog(null, "Não! ");
        }
    }
}
