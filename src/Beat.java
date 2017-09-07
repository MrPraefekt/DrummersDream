
import javax.swing.JButton;
import jm.JMC;
import jm.music.data.Note;
import jm.music.data.Part;
import jm.music.data.Phrase;
import jm.music.data.Score;
import jm.util.Play;
import jm.util.Write;
import jm.JMC;
import jm.music.data.Note;
import jm.music.data.Part;
import jm.music.data.Phrase;
import jm.music.data.Score;
import jm.util.*;

public class Beat extends JButton {

	private static final long serialVersionUID = 1L;

	// Attributes of a Beat object
	int playInfo;
	int instrument;

	// Default constructor
	public Beat() {
		playInfo = 0;
		instrument = 0;
	}

	// Set methods
	public void setPlayInfo(int a) {
		playInfo = a;
	}

	public void setInstrument(int a) {
		playInfo = a;
	}

	// Get methods

	public int getPlayInfo() {
		return playInfo;
	}

	public int getInstrument() {
		return instrument;
	}

	// Play Note
	// 1 Crash
	// 2 Ride
	// 3 Hi-hat
	// 4 Tom1
	// 5 Snare
	// 6 Tom2
	// 7 Tom3
	// 8 Base
	public void play(int a) {
		Score score = new Score("JMDemo - Random Rhythm");
		Part inst = new Part("Snare", 0, 9);
		Phrase phr = new Phrase(0.0);
		Note note = new Note(JMC.D2, 1.0);
		phr.addNote(note);
		
		Phrase phr2 = new Phrase(0.0);
		Note note2 = new Note(JMC.C4, 1.0);
		phr2.addNote(note2);

		// add the phrase to an instrument and that to a score
		
		inst.addPhrase(phr);
		inst.addPhrase(phr2);
		score.addPart(inst);

		// create a MIDI file of the score
		Write.midi(score, "randomRhythm.mid");
		Play.midi(score);
	}
}
