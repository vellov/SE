package ee.ut.math.tvt.murdjad.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import ee.ut.math.tvt.salessystem.ui.model.StockTableModel;


public class StockTableModelTest {
	
	StockTableModel stm;
	
	@Before
	public void setUp() {
		stm = new StockTableModel();
	}
	@Test
	public void createRegular() {
		assertEquals(stm.getColumnName(0), "Id");
	}
	
	
}
