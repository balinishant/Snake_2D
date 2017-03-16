/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake_2d;

import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author Nishant
 */
public class Snake_2D {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        snake2d.Gameplay gameplay = new snake2d.Gameplay(); 
        JFrame obj = new JFrame();
        obj.setBounds(10,10,905,700);
        obj.setBackground(Color.DARK_GRAY);
        obj.setResizable(false);
        obj.setVisible(true);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.add(gameplay);    
    }
    
}
