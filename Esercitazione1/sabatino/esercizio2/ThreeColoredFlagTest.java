package sabatino.esercizio2;

import static org.junit.Assert.*;

import org.junit.Test;

public class ThreeColoredFlagTest {

	@Test
	public void testSeparateColors() {
		int[] random ={10,43,66,77,21,54};
		int[] randomExpecteds = {66,54,21,43,10,77};
		ThreeColoredFlag.separateColors(random);
		assertArrayEquals(randomExpecteds, random );
		int[] zeroArray = {0,0,0};
		int[] zeroArrayExpecteds = {0,0,0};
		ThreeColoredFlag.separateColors(zeroArray);
		assertArrayEquals(zeroArrayExpecteds,zeroArray);
	}

}
