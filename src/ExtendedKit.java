import jm.JMC;
import jm.music.data.*;
import jm.util.Play;
import jm.util.Write;
import jm.music.tools.Mod;

/**
 * A short example which generates a drum kit pattern and writes to a MIDI file
 * called ExtendedKit.mid It displays the separation of code into small methods.
 * 
 * @author Andrew Brown
 */
public final class ExtendedKit implements JMC {
	/////////////
	// Attributes
	/////////////
	private Score pattern1 = new Score("JMDemo - Kit");
	// "kick" = title, 0 = instrument (kit), 9 = MIDI channel 10
	private Part drumsBD = new Part("Kick", 0, 9);
	private Part drumsSD = new Part("Snare", 0, 9);
	private Part drumsHHC = new Part("Hats Closed", 0, 9);
	private Part drumsHHO = new Part("Hats Open", 0, 9);
	private Part drumsCY = new Part("Cymbal", 0, 9);
	private Phrase phrBD = new Phrase(0.0);
	private Phrase phrSD = new Phrase(0.0);
	private Phrase phrHHC = new Phrase(0.0);
	private Phrase phrHHO = new Phrase(0.0);
	private Phrase end = new Phrase(64.0);
	// define repeatedly used rests
	private Note restSQ = new Note(REST, SEMI_QUAVER); // quater note rest
	private Note restC = new Note(REST, CROTCHET); // eight note rest

	////////////
	// main
	////////////
	public static void main(String[] args) {
		// create an instance of this class
		ExtendedKit ek = new ExtendedKit();

	}

	//////////////
	// constructor
	//////////////
	public ExtendedKit() {
		// Let us know things have started
		System.out.println("Creating drum patterns . . .");

		// make bass drum
		this.doBassDrum();

		// snare drum
		this.doSnare();

		// make hats
		this.doHiHats();

		// crash at the end
		Note crashSB = new Note(49, SB); // crash
		end.addNote(crashSB);

		// Assemble the score
		this.doScore();

		// write the score to a MIDIfile
		Write.midi(pattern1, "ExtendedKit.mid");
		Play.midi(pattern1);
	}

	////////////
	// Methods
	////////////
	private void doBassDrum() {
		// Create basic kick pattern
		System.out.println("Doing kick drum. . .");
		for (int i = 0; i < 4; i++) {
			Note note = new Note(36, C);
			phrBD.addNote(note);
			phrBD.addNote(restC);
		}
		Mod.repeat(phrBD, 8);
	}

	private void doSnare() {
		// make snare drum
		System.out.println("Doing snare. . .");
		for (int j = 0; j < 16; j++) { // repeat for 16 bars of 4/4
			phrSD.addNote(restC);
			Note snareC = new Note(38, C);
			phrSD.addNote(snareC);
			phrSD.addNote(restC);
			// vary the last crotchet beat each bar
			for (int i = 0; i < 3; i++) {
				int rand = (int) (Math.random() * 3);
				if (rand > 1) {
					Note snareSQ = new Note(38, SEMI_QUAVER);
					phrSD.addNote(snareSQ);
				} else {
					phrSD.addNote(restSQ);
				}
			}
			phrSD.addNote(restSQ);
		}
	}

	private void doHiHats() {
		System.out.println("Doing Hi Hats. . .");
		// repeat for 8 two bar cycles
		for (int j = 0; j < 8; j++) {
			// start with closed hat
			Note note1 = new Note(42, SQ, (int) Math.random() * 80 + 45);
			phrHHC.addNote(note1);
			// add a rest to the other HH part so they align
			phrHHO.addNote(restSQ);
			for (short i = 0; i < 30; i++) {
				int rand = (int) (Math.random() * 16);
				if (rand > 1) { // select occasional open hi hat
					Note note5 = new Note(42, SQ, (int) Math.random() * 80 + 45);
					phrHHO.addNote(note5);
					phrHHC.addNote(restSQ);
				} else {
					Note note2 = new Note(46, SQ, (int) Math.random() * 80 + 45);
					phrHHC.addNote(note2);
					phrHHO.addNote(restSQ);
				}
			}
			// open hi hat at the end of the pattern
			Note note6 = new Note(46, SEMI_QUAVER, 60);
			phrHHO.addNote(note6);
			phrHHC.addNote(restSQ);
		}
	}

	private void doScore() {
		// add phrases to the instrument (part)
		System.out.println("Assembling. . .");
		drumsBD.addPhrase(phrBD);
		drumsSD.addPhrase(phrSD);
		drumsHHC.addPhrase(phrHHC);
		drumsHHO.addPhrase(phrHHO);
		drumsCY.addPhrase(end);

		// add the drum parts to a score.
		pattern1.addPart(drumsBD);
		pattern1.addPart(drumsSD);
		pattern1.addPart(drumsHHC);
		pattern1.addPart(drumsHHO);
		pattern1.addPart(drumsCY);
	}
}