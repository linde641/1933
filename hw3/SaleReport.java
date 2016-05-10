/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hw3;

import java.util.Map;

/**
 *
 * @author paidforbyoptions
 */
public class SaleReport 
{
    String id;
    int count;
    double price;
    double taxRate;
    int actualNumberSold;
    double cost;    
    MyDEQueue<Purchase> dequeueOfPurchases;
    
    public SaleReport(String id, int count, double price, double taxRate, MyDEQueue dequeue)
    {
        this.id = id;
        this.count = count;
        this.price = price;
        this.taxRate = taxRate;
        this.dequeueOfPurchases = dequeue;       
        this.actualNumberSold = getActualNumberSoldCalculate();
        this.cost = getCostCalculate();
    }           
    
    public String getAssetID()
    {
        return id;
    }
    
    
    
    private int getActualNumberSoldCalculate()
    {
        if (dequeueOfPurchases == null)
        {
            return 0;
        }
        int shares = 0;
        Purchase entry = new Purchase();
        int size = dequeueOfPurchases.getSize(); 
        for (int i = 0; i < size; i++)
        {
            entry = dequeueOfPurchases.pop();
            shares += entry.count;
            dequeueOfPurchases.pushToBack(entry);
        }
        
        if (shares <= count)
        {
            return shares;
        }
        return count;
    }
    
    public int getActualNumberSold()
    {
        return actualNumberSold;
    }
    
    private double getCostCalculate()
    {
        Purchase purchase = new Purchase();
        double totalPricePaid = 0;
        int shares = 0;        
        int size = dequeueOfPurchases.getSize();
        
        while (shares < actualNumberSold)
        {   
            purchase = dequeueOfPurchases.peek(); 
            if ((shares + purchase.count) <= actualNumberSold)//if I need to wipe out the top purchase order;
            {                
                totalPricePaid += purchase.unitPrice * purchase.count;   
                shares += purchase.count;    
                purchase = dequeueOfPurchases.pop(); 
            }
            else /// if I don't need to sell everything in the top purchase order
            {
                int partialCountShares = actualNumberSold - shares; ///this is the number of shares from this PO im selling
                totalPricePaid += purchase.unitPrice*partialCountShares; //
                shares += partialCountShares;
                purchase.count = purchase.count - partialCountShares;//decreases the number of shares in this PO
            }
            if (shares >= actualNumberSold)
            {
                break;
            }
            
        }
        
        return totalPricePaid;
    }
    
    public double getCost()
    {
        return cost;
    }
    
    public double getPreTaxProfit()
    {        
        return getRevenue() - cost;
    }
    
    public double getProfit()
    {
        return getPreTaxProfit() - getTax();
    }
    
    public int getRequestedNumberSold()
    {
        return count;
    }
    
    public double getRevenue()
    {        
        return price*actualNumberSold;
    }
    
    public double getTax()
    {
        return getPreTaxProfit() * taxRate;
    }
    
    public double getTaxRate()
    {
        return taxRate;
    }
    
}
