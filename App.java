import javax.swing.*;


public class App {
    public static void main(String[] args) {
         DatabaseManager.connect(); 
        int boardWidth = 360;
        int boardHeight = 640;
    
        JFrame frame = new JFrame("Flappy Bird");
        frame.setSize(boardWidth, boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      
        FlappyBird flappyBird = new FlappyBird();
        frame.add(flappyBird);
        frame.pack();
        frame.setVisible(true);

       
    }
}
