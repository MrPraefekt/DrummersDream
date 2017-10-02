import javax.swing.*;

import jm.JMC;
import jm.music.data.Note;
import jm.music.data.Part;
import jm.music.data.Phrase;
import jm.music.data.Score;
import jm.music.tools.Mod;
import jm.util.Play;
import jm.util.Write;

public final class Pattern implements JMC {

	public static void main(String[] args) {
		JFrame meinFrame = new JFrame("PatternFrame");
		// Phrase phrHHO = new Phrase(0.0);
		// Beat crash[] = new Beat[65];
		// Beat ride[] = new Beat[65];
		Beat hihat[] = new Beat[65];
		// Beat tom1[] = new Beat[65];
		Beat snare[] = new Beat[65];
		// Beat tom2[] = new Beat[65];
		// Beat tom3[] = new Beat[65];
		Beat base[] = new Beat[65];

		// INSTRUMENT HiHat:
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

		// INSTRUMENT Snare:
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

		// INSTRUMENT Base:
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

		meinFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		meinFrame.setSize(1200, 700);
		meinFrame.setLocationRelativeTo(null);
		meinFrame.setLayout(null);
		meinFrame.setVisible(true);
		meinFrame.setResizable(false);

		// DEFAULT BEAT
		// HiHat,Base,Snare
		for (int i = 13; i < 65; i = i + 2) {
			hihat[i].note.setPitch(42);
		}
		for (int i = 13; i < 65; i = i + 8) {
			base[i].note.setPitch(36);
		}
		for (int i = 13 + 4; i < 65; i = i + 8) {
			snare[i].note.setPitch(38);
		}
		Score pattern1 = new Score("PatternScore");
		// "kick" = title, 0 = instrument (kit), 9 = MIDI channel 10
		Part drumsBD = new Part("Kick", 0, 9);
		Part drumsSD = new Part("Snare", 0, 9);
		Part drumsHHC = new Part("Hats Closed", 0, 9);
		// Part drumsHHO = new Part("Hats Open", 0, 9);
		// Part drumsCY = new Part("Cymbal", 0, 9);
		Phrase phrBD = new Phrase(0.0);
		Phrase phrSD = new Phrase(0.0);
		Phrase phrHHC = new Phrase(0.0);

		for (int i = 1; i < 65; i++) {
			phrHHC.addNote(hihat[i].getNote());
		}
		for (int i = 1; i < 65; i++) {
			phrSD.addNote(base[i].getNote());
		}
		for (int i = 1; i < 65; i++) {
			phrBD.addNote(snare[i].getNote());
		}
		drumsHHC.addPhrase(phrHHC);
		drumsSD.addPhrase(phrSD);
		drumsBD.addPhrase(phrBD);

		pattern1.addPart(drumsBD);
		pattern1.addPart(drumsSD);
		pattern1.addPart(drumsHHC);
		Write.midi(pattern1, "Drum.mid");
		Play.midi(pattern1);
	}
}