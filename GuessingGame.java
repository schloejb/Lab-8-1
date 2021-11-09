import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class GuessingGame implements ActionListener {
  
  int randomNum;
  JTextField userGuess;
  JButton guess;
  JButton PlayAgain;
  JLabel label;
  JLabel label2;
  JLabel label3;
  Random r;
  
  GuessingGame() {
    Random r = new Random();
    int randomNum = r.nextInt(100) +1;

    JFrame frame = new JFrame("Guessing Game");
    frame.setLayout(new FlowLayout());
    frame.setSize(240, 120);

    userGuess = new JTextField(10);
    userGuess.setActionCommand("myTF");

    JButton guess = new JButton("Guess");
    JButton PlayAgain = new JButton("Play Again");

    userGuess.addActionListener(this);
    guess.addActionListener(this);
    PlayAgain.addActionListener(this);

    JLabel label = new JLabel("Enter your guess:");
    JLabel label2 = new JLabel("");
    JLabel label3 = new JLabel("");

    frame.add(label);
    frame.add(userGuess);
    frame.add(guess);
    frame.add(label2);
    frame.add(label3);
    frame.add(PlayAgain);

    frame.setVisible(true);
  }


  
  public void actionPerformed(ActionEvent ae) {
    int guess = Integer.parseInt(userGuess.getText());
    if(ae.getActionCommand().equals("userGuess")){
      label.setText("You enetered: " + guess);  
    }
    if (guess > randomNum){
      label2.setText("Too High!");
    }
    else if (guess < randomNum){
      label2.setText("Too Low!");
    }
    else if (guess == randomNum){
      label2.setText("You got it!");
    }
    else{
      label3.setText("Your last guess was: " + guess);
    }
     
     
    if(ae.getActionCommand().equals("Play Again")){
      int randomNum = r.nextInt(100) +1;

      JLabel label = new JLabel("Enter your guess:");
      JLabel label2 = new JLabel("");
      JLabel label3 = new JLabel("");

      userGuess.setText("");
    }
    else{
      label2.setText("You pressed enter. Please press the guess button");
    }
    
    
  }

  
  
}