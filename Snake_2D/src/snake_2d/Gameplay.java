/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake2d;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Nishant
 */
public class Gameplay extends JPanel implements KeyListener, ActionListener{
    private ImageIcon titleImage;
    
    private int[] snakeXlength = new int[750];
    private int[] snakeYlength = new int[750];
    
    private int lengthofsnake = 3;
    private int moves=0;
    private int score=0;
    
    private int[] eneXpos={25,50,75,100,125,150,175,200,225,250,275,300,325,350,375,400,425,450,475,500,
    525,550,575,600,625,650,675,700,725,750,775,800,825};
    private int[] eneYpos={75,100,125,150,175,200,225,250,275,300,325,350,375,400,425,450,475,500,
    525,550,575};
    
    private boolean left = false;
    private boolean right = false;
    private boolean up = false;
    private boolean down = false;
    
    private ImageIcon rightmouth;
    private ImageIcon leftmouth; 
    private ImageIcon upmouth;
    private ImageIcon downmouth;
    private ImageIcon snakeimage;
    private ImageIcon enemyimage;

private Random random=new Random();
private int Xpos = random.nextInt(34);
private int Ypos = random.nextInt(23);


    private Timer timer;
    private int delay = 100;
    
    public Gameplay(){
    addKeyListener(this);
    setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay, this);
        timer.start();
    }
    // built in method paint to draw everything on panel using graphics
    @Override
    public void paint(Graphics g){
        
         if(moves==0)
    {
        snakeXlength[2]=50;
        snakeXlength[1]=75;
        snakeXlength[0]=100;
        
        snakeYlength[2]=100;
        snakeYlength[1]=100;
        snakeYlength[0]=100;
    }
        
    //draw title
    g.setColor(Color.white);
    g.drawRect(24,10,851,55);// (x-axis,y-axis,width,height)
    
    //draw title image
    titleImage = new ImageIcon("C:\\Users\\Nishant\\Documents\\NetBeansProjects\\Snake2D\\src\\snaketitle.jpg");
    titleImage.paintIcon(this,g,25,11);
    
    // draw border for gameplay
    g.setColor(Color.white);
    g.drawRect(24,74,851,577);
    
    //draw background for gameplay
    g.setColor(Color.black);
    g.fillRect(25,75,850,575);//width and height is multiple of 25
    
    g.setColor(Color.white);
    g.setFont(new Font("arial",Font.PLAIN,14));
    g.drawString("Score:"+score,780,30);
    
    g.setColor(Color.white);
    g.setFont(new Font("arial",Font.PLAIN,14));
    g.drawString("Score:"+lengthofsnake,780,50);
    
    
    rightmouth = new ImageIcon("C:\\Users\\Nishant\\Documents\\NetBeansProjects\\Snake2D\\src\\rightmouth.png");
    rightmouth.paintIcon(this,g,snakeXlength[0],snakeYlength[0]);
    
    for(int a=0;a<lengthofsnake;a++)
    {
   
    if(a==0 && left)
    {
    leftmouth = new ImageIcon("C:\\Users\\Nishant\\Documents\\NetBeansProjects\\Snake2D\\src\\leftmouth.png");
    leftmouth.paintIcon(this,g,snakeXlength[a],snakeYlength[a]);
    }
    
    if(a==0 && left)
    {
    leftmouth = new ImageIcon("C:\\Users\\Nishant\\Documents\\NetBeansProjects\\Snake2D\\src\\leftmouth.png");
    leftmouth.paintIcon(this,g,snakeXlength[a],snakeYlength[a]);
    }
    
    if(a==0 && right)
    {
    rightmouth = new ImageIcon("C:\\Users\\Nishant\\Documents\\NetBeansProjects\\Snake2D\\src\\righttmouth.png");
    rightmouth.paintIcon(this,g,snakeXlength[a],snakeYlength[a]);
    }
    
    if(a==0 && up)
    {
    upmouth = new ImageIcon("C:\\Users\\Nishant\\Documents\\NetBeansProjects\\Snake2D\\src\\upmouth.png");
    upmouth.paintIcon(this,g,snakeXlength[a],snakeYlength[a]);
    }
    
    if(a==0 && down)
    {
    downmouth = new ImageIcon("C:\\Users\\Nishant\\Documents\\NetBeansProjects\\Snake2D\\src\\downmouth.png");
    downmouth.paintIcon(this,g,snakeXlength[a],snakeYlength[a]);
    }
    
    if(a!=0)
    {
    snakeimage = new ImageIcon("C:\\Users\\Nishant\\Documents\\NetBeansProjects\\Snake2D\\src\\snakeimage.png");
    snakeimage.paintIcon(this,g,snakeXlength[a],snakeYlength[a]);
    }
    
    }
    
    enemyimage = new ImageIcon("C:\\Users\\Nishant\\Documents\\NetBeansProjects\\Snake2D\\src\\enemy.png");
    
    if(eneXpos[Xpos]==snakeXlength[0] && eneYpos[Ypos]==snakeYlength[0])
    {
        score++;    
        lengthofsnake++;
        Xpos=random.nextInt(34);
        Ypos=random.nextInt(23);
    }
    enemyimage.paintIcon(this,g,eneXpos[Xpos],eneYpos[Ypos]);
    
    for(int b=1;b<lengthofsnake;b++)
    {
    if(snakeXlength[b]==snakeXlength[0] && snakeYlength[b]==snakeYlength[0])
    {
        right = false;
        up = false;
        down = false;
        left = false;
        
        g.setColor(Color.white);
        g.setFont(new Font("arial",Font.BOLD,50));
        g.drawString("GAME OVER",300,300);
        
        g.setFont(new Font("arial",Font.BOLD,20));
        g.drawString("hit SPACE to Restart",350,340);
    }
    }
    
    
    g.dispose();
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   if(e.getKeyCode()==KeyEvent.VK_SPACE)
   {
       score=0;
       moves=0;
       lengthofsnake=3;
       repaint();
   }
       
       if((e.getKeyCode() == KeyEvent.VK_RIGHT) && (!left))
   {
       moves++;
       right=true;
       up = false;
       down = false;
   }
    if((e.getKeyCode() == KeyEvent.VK_LEFT) && (!right))
   {
       moves++;
       left=true;
       up = false;
       down = false;
   }
     if((e.getKeyCode() == KeyEvent.VK_UP) && (!down))
   {
       moves++;
       up=true;
       left = false;
       right = false;
   }
      if((e.getKeyCode() == KeyEvent.VK_DOWN) && (!up))
   {
       moves++;
       down=true;
       left = false;
       right = false;
   }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    timer.start();
    if(right)
    {
        for(int r=lengthofsnake-1; r>=0; r--)
        {
            snakeYlength[r+1]=snakeYlength[r];
        }
        for(int r =lengthofsnake;r>=0;r--)
        {
            if(r==0)
            {
                snakeXlength[r]=snakeXlength[r]+25;
            }
            else
            {
                snakeXlength[r]=snakeXlength[r-1];
            }
            if(snakeXlength[r]>850)
            {
                snakeXlength[r]=25;
            }
        }
        repaint();
    }
    if(left)
    {
        for(int r=lengthofsnake-1; r>=0; r--)
        {
            snakeYlength[r+1]=snakeYlength[r];
        }
        for(int r =lengthofsnake;r>=0;r--)
        {
            if(r==0)
            {
                snakeXlength[r]=snakeXlength[r]-25;
            }
            else
            {
                snakeXlength[r]=snakeXlength[r-1];
            }
            if(snakeXlength[r]<25)
            {
                snakeXlength[r]=850;
            }
        }
        repaint();
    }
    if(up)
    {
         for(int r=lengthofsnake-1; r>=0; r--)
        {
            snakeXlength[r+1]=snakeXlength[r];
        }
        for(int r =lengthofsnake;r>=0;r--)
        {
            if(r==0)
            {
                snakeYlength[r]=snakeYlength[r]-25;
            }
            else
            {
                snakeYlength[r]=snakeYlength[r-1];
            }
            if(snakeYlength[r]<75)
            {
                snakeYlength[r]=625;
            }
        }
        repaint();
    }
    if(down)
    {
        for(int r=lengthofsnake-1; r>=0; r--)
        {
            snakeXlength[r+1]=snakeXlength[r];
        }
        for(int r =lengthofsnake;r>=0;r--)
        {
            if(r==0)
            {
                snakeYlength[r]=snakeYlength[r]+25;
            }
            else
            {
                snakeYlength[r]=snakeYlength[r-1];
            }
            if(snakeYlength[r]>625)
            {
                snakeYlength[r]=75;
            }
        }
        repaint();
    }
    }
    
}
