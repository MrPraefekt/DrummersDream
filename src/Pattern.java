
import javax.swing.*;


public class Pattern {
	public static void main(String[] args) {
		JFrame meinFrame = new JFrame("Pattern");

//		Beat crash[] = new Beat[65];
//		Beat ride[] = new Beat[65];
		Beat hihat[] = new Beat[65];
//		Beat tom1[] = new Beat[65];
		Beat snare[] = new Beat[65];
//		Beat tom2[] = new Beat[65];
//		Beat tom3[] = new Beat[65];
		Beat base[] = new Beat[65];


		//INSTRUMENT HiHat:
		for (int i = 1; i < hihat.length; i++) {
			hihat[i] = new Beat();
			hihat[i].addActionListener(null);
		}
		for (int i = 1; i < hihat.length; i++) {
			hihat[i].setBounds(i * 11 + 50, 45, 10, 15);
			meinFrame.add(hihat[i]);
		}
		JLabel labelHihat = new JLabel("HiHat:");
		labelHihat.setBounds(10, 45, 50, 15);
		meinFrame.add(labelHihat);
		
		//INSTRUMENT Snare:
		for (int i = 1; i < snare.length; i++) {
			snare[i] = new Beat();
			snare[i].addActionListener(null);
		}
		for (int i = 1; i < snare.length; i++) {
			snare[i].setBounds(i * 11 + 50, 65, 10, 15);
			meinFrame.add(snare[i]);
		}
		JLabel labelSnare = new JLabel("Snare:");
		labelSnare.setBounds(10, 65, 50, 15);
		meinFrame.add(labelSnare);

		//INSTRUMENT Base:
		for (int i = 1; i < base.length; i++) {
			base[i] = new Beat();
			base[i].addActionListener(null);
		}
		for (int i = 1; i < snare.length; i++) {
			base[i].setBounds(i * 11 + 50, 85, 10, 15);
			meinFrame.add(base[i]);
		}
		JLabel labelBase = new JLabel("Base:");
		labelBase.setBounds(10, 85, 50, 15);
		meinFrame.add(labelBase);		
		
		Beat sn = new Beat();
		sn.play(1);
		
		meinFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		meinFrame.setSize(1200, 700);
		meinFrame.setLocationRelativeTo(null);
		meinFrame.setLayout(null);
		meinFrame.setVisible(true);
		meinFrame.setResizable(false);
	}
}