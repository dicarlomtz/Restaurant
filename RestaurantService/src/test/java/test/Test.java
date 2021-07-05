/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dao.product.ProductDAO;
import domain.product.Product;
import domain.product.set.ProductSet;
import java.util.List;

/**
 *
 * @author dicar
 */
public class Test {
    
    public static void main(String[] args) {
        ProductDAO dao = new ProductDAO();
        List<Product> l = dao.listAll();
        ProductSet s = new ProductSet(l);
        System.out.print(s);
    }
    
}
