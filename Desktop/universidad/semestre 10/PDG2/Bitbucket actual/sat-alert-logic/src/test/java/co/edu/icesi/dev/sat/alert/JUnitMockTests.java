package co.edu.icesi.dev.sat.alert;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import co.edu.icesi.dev.sat.alert.entity.entities.AlertType;
import co.edu.icesi.dev.sat.alert.repository.interfaces.AlertTypeRepo;
import co.edu.icesi.dev.sat.alert.service.implementation.AlertTypeServiceImplementation;

@RunWith(MockitoJUnitRunner.class)
class JUnitMockTests {

	@Nested
	class AlertTypeServiceTest {
		
		@InjectMocks
		private AlertTypeServiceImplementation alrtTypeServImp;
		
		@Mock
		private AlertTypeRepo alrtTypeRep;
		
		@BeforeEach
		public void setUp() {
			MockitoAnnotations.openMocks(this);
		}
		
		@DisplayName("Saving a alertType the correct way")
		@Test
		void aditionTest() {
			AlertType alrtT = new AlertType();
			when(alrtTypeRep.existsById(alrtT.getAlertTypeId())).thenReturn(true);
			when(alrtTypeServImp.findById(alrtT.getAlertTypeId())).thenReturn(alrtT);
			when(alrtTypeServImp.createAlertType(alrtT)).thenReturn(alrtT);			
			alrtT.setAlertTypeName("Riesgo Psicologico");
			alrtT.setPermPermId(1);
			alrtT = alrtTypeServImp.createAlertType(alrtT);
			try {
				assertEquals("Riesgo Psicologico", alrtTypeServImp.findById(alrtT.getAlertTypeId()).getAlertTypeName());
			}catch(Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
		
	}

}
