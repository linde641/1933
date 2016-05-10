/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hw3;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author paidforbyoptions
 */
public class FinancialAdvisor 
{
    
    public Map<String, MyDEQueue<Purchase>> portfolio = new HashMap();
    
    
    public void buy(String id, int count, double unitPrice)
    {   
        Purchase purchase = new Purchase(id, count, unitPrice);
        
        
        for (String key : portfolio.keySet())
        {
            if (key.equals(id))
            {
                portfolio.get(id).pushToBack(purchase);
                return;
            }
            
        }
        
        MyDEQueue<Purchase> NewStockDequeue = new MyDEQueue<>();
        NewStockDequeue.pushToBack(purchase);
        portfolio.put(id, NewStockDequeue);
        
    }
    
    public SaleReport sell(String id, int count, double price, double taxRate)
    {
        MyDEQueue<Purchase> dequeue = new MyDEQueue<>();
//        System.out.println("the sell method received this id: " + id);
        for (String key : portfolio.keySet())
        {
            if (key.equals(id))
            {
                dequeue = portfolio.get(id);
            }
        }
        
        SaleReport report = new SaleReport(id, count, price, taxRate, dequeue);
        return report;
    }
            
}
