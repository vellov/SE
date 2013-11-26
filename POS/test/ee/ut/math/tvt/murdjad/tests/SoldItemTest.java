package ee.ut.math.tvt.murdjad.tests;



import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ee.ut.math.tvt.salessystem.domain.data.SoldItem;
import ee.ut.math.tvt.salessystem.domain.data.StockItem;

public class SoldItemTest {
	private StockItem stock_item;
	private SoldItem sold_item;
	private double price=5;
	
	@Before 
	public void setUp(){
		stock_item=new StockItem(1L,"Viru Valge","Eriti kange",price);

	}
	@Test
	public void testGetSum(){
		sold_item=new SoldItem(stock_item,10);
		assertEquals(sold_item.getSum(), (price*10),0.0001);
	}
	@Test 
	public void testGetSumWithZeroQuantity(){
		sold_item=new SoldItem(stock_item,0);
		assertEquals(sold_item.getSum(),0,0.0001);
	}
	@Test
	(expected = IllegalArgumentException.class)
	public void testGetSumWithQuantityBelowZero(){
		sold_item=new SoldItem(stock_item,-10);
		
	}
}	
