package backEnd;

import javax.swing.JOptionPane;

/**
 *
 * @author douglasjtds & yMetsBless
 */
public class sourceCode {
    
    public void code(String aut){
        //TODO COLOCAR O BACKEND AQUI:
        //estado inicial + - o número
        int allowedState[] = {0,1,2,3,4,5,6,8,9}; //será que é isso?
        if(true != aut.isEmpty()){
            JOptionPane.showMessageDialog(null, "Sim! ");
        } else{
            JOptionPane.showMessageDialog(null, "Não! ");
        }
    }
}
