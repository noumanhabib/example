import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RandomGuess extends Thread {
	static Thread myThread;
	static JLabel randomNumberLabel;
	static JButton startButton;
	static JButton exitMe;
	static JButton smallChoose;
	static JButton largeChoose;
	static int myRandom = 0;
	static int pR;
	static int flag = -1;
	static JFrame myViewFrame;
	public static void main(String[] args) {
		myViewFrame = new JFrame("Guess Game");
		myViewFrame.setSize(800, 650);
		myViewFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myViewFrame.getContentPane().setLayout(null);
		
		smallChoose = new JButton("Low");
		smallChoose.setBounds(99, 119, 89, 23);
		smallChoose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				flag++;
				pR = myRandom;
				myThread = new Thread(new RandomGuess());
		        myThread.start();
		        try {
					Thread.sleep(100);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		        if(myRandom <= pR) {
		        	if(flag == 5) {
			        	randomNumberLabel.setText("Successed");
			        	flag = 0;
			    		myRandom = 0;
			    		myViewFrame.remove(smallChoose);
			    		myViewFrame.remove(largeChoose);
			    		startButton.setText("restart");
			    		myViewFrame.getContentPane().add(startButton);
			    		myViewFrame.getContentPane().add(exitMe);
			            myViewFrame.revalidate();
			    		myViewFrame.repaint();
			        }
		        }
		        else {
		        	randomNumberLabel.setText("Failed");
		        	flag = 0;
		    		myRandom = 0;
		    		myViewFrame.remove(smallChoose);
		    		myViewFrame.remove(largeChoose);
		    		startButton.setText("restart");
		    		myViewFrame.getContentPane().add(startButton);
		    		myViewFrame.getContentPane().add(exitMe);
		            myViewFrame.revalidate();
		    		myViewFrame.repaint();
		        }
		        
			}
		});
		
		largeChoose = new JButton("High");
		largeChoose.setBounds(456, 119, 89, 23);
		largeChoose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				flag++;
				pR = myRandom;
				myThread = new Thread(new RandomGuess());
		        myThread.start();
		        try {
					Thread.sleep(100);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		        if(myRandom >= pR) {
		        	if(flag == 5) {
			        	randomNumberLabel.setText("Successed");
			        	flag = 0;
			    		myRandom = 0;
			    		myViewFrame.remove(smallChoose);
			    		myViewFrame.remove(largeChoose);
			    		startButton.setText("restart");
			    		myViewFrame.getContentPane().add(startButton);
			    		myViewFrame.getContentPane().add(exitMe);
			            myViewFrame.revalidate();
			    		myViewFrame.repaint();
			        }
		        }
		        else {
		        	randomNumberLabel.setText("Failed");
		        	flag = 0;
		    		myRandom = 0;
		    		myViewFrame.remove(smallChoose);
		    		myViewFrame.remove(largeChoose);
		    		startButton.setText("restart");
		    		myViewFrame.getContentPane().add(startButton);
		    		myViewFrame.getContentPane().add(exitMe);
		            myViewFrame.revalidate();
		    		myViewFrame.repaint();
		        }
		        
			}
		});
		
		startButton = new JButton("start");
		startButton.setBounds(282, 218, 89, 23);
		myViewFrame.getContentPane().add(startButton);
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myThread = new Thread(new RandomGuess());
		        myThread.start();
		        myViewFrame.getContentPane().add(smallChoose);
		        myViewFrame.getContentPane().add(largeChoose);
		        myViewFrame.remove(startButton);
		        myViewFrame.remove(exitMe);
		        myViewFrame.revalidate();
				myViewFrame.repaint();
			}
		});
		
		exitMe = new JButton("close");
		exitMe.setBounds(282, 254, 89, 23);
		
		exitMe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		myViewFrame.getContentPane().add(smallChoose);
        myViewFrame.getContentPane().add(largeChoose);
        
		randomNumberLabel = new JLabel("");
		randomNumberLabel.setBackground(Color.WHITE);
		randomNumberLabel.setBounds(307, 122, 89, 20);
		myViewFrame.getContentPane().add(randomNumberLabel);
		
		myViewFrame.setVisible(true);

	}
	
	 @Override
    public void run(){
		 myRandom=(int)(Math.random()*100);
		 randomNumberLabel.setText(Integer.toString(myRandom));
    }
	
}
