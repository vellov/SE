package ee.ut.math.tvt.murdjad.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import ee.ut.math.tvt.salessystem.domain.data.StockItem;

public class StockItemTest {
	private StockItem item1;
	private int nr_of_items=3;
	private double price=5;
	
	@Before
	public void setUp(){
		item1=new StockItem(1L,"Viru Valge","Eriti kange",price,nr_of_items);
	}
	@Test
	public void testClone(){
		StockItem item2=(StockItem) item1.clone();
		assertEquals(item1.getId(), item2.getId());
        assertEquals(item1.getName(), item2.getName());
        assertEquals(item1.getPrice(), item2.getPrice(), 00.1);
        assertEquals(item1.getQuantity(), item2.getQuantity());
	}
	@Test
	public void testGetColumn(){
		 assertEquals(item1.getColumn(0), 1L);
         assertEquals(item1.getColumn(1), "Viru Valge");
         assertEquals(item1.getColumn(2), price);
         assertEquals(item1.getColumn(3), nr_of_items);       
	}
	@Test
	(expected = IllegalArgumentException.class)
	public void testNegativePrice(){
		//drink1=new StockItem(2L,"Rock","Lahja",-price,nr_of_items);
	}
	
	
}
