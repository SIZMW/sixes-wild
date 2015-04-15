package SixesWild.com.mimas.sixeswild.entities;
import java.util.ArrayList;

import junit.framework.TestCase;

public class TestLevel extends TestCase {
	
	public void testLevel() {
		Level level = new Level();
		ArrayList<Double> freqs = new ArrayList<Double>();
		ArrayList<Double> mFreqs = new ArrayList<Double>();
		freqs.add(.10);
		freqs.add(.20);
		freqs.add(.30);
		freqs.add(.30);
		freqs.add(.05);
		freqs.add(.05);
		
		mFreqs.add(.95);
		mFreqs.add(.025);
		mFreqs.add(.025);
		
		
		assertEquals(level.getTileFreq(), freqs);
		assertEquals(level.getMultFreq(), mFreqs);
		
		
	}

}
