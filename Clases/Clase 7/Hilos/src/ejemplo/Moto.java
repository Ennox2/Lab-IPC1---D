package ejemplo;

import java.awt.Image;
import static java.lang.Thread.sleep;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;

public class Moto extends Thread {

    Game game; 
    int posx, posy; 
    Gas gas; 
    private volatile boolean running = true;

    
    public Moto(Game game, Gas gas) {
        
        this.gas = gas; 
        this.game = game; 
        posx = this.game.lbl11.getX();
        posy = this.game.lbl11.getY();
        this.game.moto = this.game.lbl11.getBounds();
        
    }
    
    public void run(){
        try{
            while(running){
                sleep(150);
                
                if (this.gas.posx > posx){
                    posx += 8; 
                }else if (this.gas.posx  < posx){
                    posx -= 8;
                } 
                
                if (this.gas.posy + 50  > posy + 150 ){
                    posy += 8; 
                }else if (this.gas.posy + 50  < posy + 150){
                    posy -= 8;
                } 
                
                
                this.game.lbl11.setLocation(posx, posy);
                this.game.moto = this.game.lbl11.getBounds();
                
                if (this.game.moto.intersects(this.game.item)){
                    sleep(250);
                    this.game.lbl1.setBounds(this.gas.posx - 25, this.gas.posy - 25, 100, 100);
                    ImageIcon img = new ImageIcon(getClass().getResource("../imgs/eat.gif"));
                    Image nuevo = img.getImage().getScaledInstance(this.game.lbl1.getWidth(), this.game.lbl1.getHeight(), Image.SCALE_DEFAULT);
                    ImageIcon render = new ImageIcon(nuevo);
                    this.game.lbl1.setIcon(render);
                    this.game.repaint();
                    sleep(800);
                    SwingUtilities.invokeLater(() -> {
                        // Código relacionado con la interfaz de usuario
                        this.game.remove(this.game.lbl1);
                        this.game.repaint();
                        this.game.btn1.setEnabled(true);
                    });
                    this.gas.stopThread();
                    stopThread();
                    
                }
            this.game.repaint();
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
    
    }
    
    public void stopThread() {
        running = false;
    }
    
}
