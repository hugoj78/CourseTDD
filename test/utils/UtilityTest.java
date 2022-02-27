package utils;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

class UtilityTest {

	@Test
	void randomIntTest() {
		// GIVEN
		int min = 1;
		int max = 8;
		// WHEN
		int result = Utility.randomInt(min, max);

		// THEN
		assertTrue(min <= result);
		assertTrue(max >= result);

	}

	@Test
	void randomint9999foisTest() {

		for (int i = 0; i < 10000; i++) {
			randomIntTest();
		}

	}

}
