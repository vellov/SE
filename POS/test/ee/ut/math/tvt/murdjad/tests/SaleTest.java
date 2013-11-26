package ee.ut.math.tvt.murdjad.tests;


import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import ee.ut.math.tvt.salessystem.domain.data.SoldItem;
import ee.ut.math.tvt.salessystem.domain.data.StockItem;
public class SaleTest {
	private StockItem stock_item1;
	private StockItem stock_item2;
	private SoldItem sold_item1;
	private SoldItem sold_item2;
	private double price1=1.05;
	private double price2=2.50;
	private double total=13.55;//price1+5*price2
	private double total2=1.05;
	
		@Before
	public void setUp(){
		stock_item1=new StockItem(1L,"Bock","Kange jook lahjadele meestele",price1);
		stock_item2=new StockItem(2L,"Magra olu","Soomlastele",price2);
		sold_item1=new SoldItem(stock_item1,1);
		sold_item2=new SoldItem(stock_item2,5);
		ArrayList<SoldItem> sold=new ArrayList<SoldItem>();
		
	}
		@Test
	public void testAddSoldItem(){
		double hind1=sold_item1.getPrice();
		double hind2=sold_item2.getPrice();
		int kogus1=sold_item1.getQuantity();
		int kogus2=sold_item2.getQuantity();
		double summa=hind1*kogus1+hind2*kogus2;
		assertEquals(summa,total,0.001);
		
	}
		@Test
	public void testGetSumWithNoItems(){
		double hind1=sold_item1.getPrice();
		double hind2=sold_item2.getPrice();
		int kogus1=0;
		int kogus2=0;
		double summa=hind1*kogus1+hind2*kogus2;
		assertEquals(summa,0,0.001);
		
		
	}
		@Test
	public void testGetSumWithOneItem(){//meil ajalugu puudu, niiet lahendasime nii
		double hind1=sold_item1.getPrice();
		
		int kogus1=sold_item1.getQuantity();
	
		double summa=hind1*kogus1;
		assertEquals(summa,total2,0.0001);
		
	}
		@Test
	public void testGetSumWithMultipleItems(){
		double hind1=sold_item1.getPrice();
		double hind2=sold_item2.getPrice();
		int kogus1=sold_item1.getQuantity();
		int kogus2=sold_item2.getQuantity();
		double summa=hind1*kogus1+hind2*kogus2;
		assertEquals(summa,total, 0.001);
		
	}

}
