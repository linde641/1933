/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hw3;

/**
 *
 * @author paidforbyoptions
 */
public class Purchase 
{
    String assetId;
    double unitPrice;
    int count;
    
    public Purchase(String assetId, int count, double unitPrice)
    {
        this.assetId = assetId;
        this.count = count;
        this.unitPrice = unitPrice;
        
    }
    public Purchase()
    {
        String assetId;
        int count;
        double unitPrice;
    }
}
