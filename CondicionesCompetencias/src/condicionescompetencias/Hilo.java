
package condicionescompetencias;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JTextArea;
public class Hilo extends Thread{
    private JTextArea area;
    private RCompartido rc;
    private boolean pausa,terminar;
    Hilo(JTextArea area,RCompartido rc ){
        this.area=area;
        this.rc=rc;
        pausa=false;
        terminar=false;
    }
     synchronized void pausarhilo(){
         pausa=true;
        try {
            wait(1000);
            pausa=false;
        } catch (InterruptedException ex) {
            Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
     }
     public void setTerminar (boolean terminar){
        this.terminar=terminar;
    }
     
    public void run(){
        while(!terminar){
            try{
                rc.setDatocompartido(this.getName());
               area.append(rc.getDatocompartido()+"\n");
               sleep(1500);
            }catch(Exception e){e.printStackTrace();}
        }
    }
}
