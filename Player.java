import jm.JMC;
import jm.music.data.Note;
import jm.music.data.Part;
import jm.music.data.Phrase;
import jm.music.data.Score;
import jm.util.Play;
import jm.util.Write;


public class Player {
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
