package Testing;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;

import TP.CalculoFlujoMaximo;

public class CalculoFlujoMaximoTest {

	@Test
    public void testSomeMethod() {
        
		CalculoFlujoMaximo mockObject = mock(CalculoFlujoMaximo.class);
		 
		 when(mockObject.getFlujoMaximo()).thenReturn(26.0);
		 
		// Verification
		verify(mockObject).getFlujoMaximo();
	
	}
	
}
