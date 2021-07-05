package service.product.provider;

import dao.product.ProductDAO;
import domain.product.Product;
import domain.product.set.ProductSet;
import org.json.JSONObject;

public class ProductProvider {

    private final ProductDAO dao;
    private static ProductProvider pp = null;

    private ProductProvider() {
        this.dao = new ProductDAO();
    }
    
    public static final ProductProvider getInstance(){
        if(pp == null){
            pp = new ProductProvider();
        }
        
        return pp;
    }

    public String getProduct(Integer idProduct) {
        Product product = new Product(idProduct);
        JSONObject productJSON = ((Product) dao.retrieve(product)).toJSON();
        return productJSON.toString(4);
    }

    public byte[] getProductPicture(Integer idProduct) {
        Product product = new Product(idProduct);
        byte[] picture = ((Product) dao.retrieve(product)).getPicture();
        return picture;
    }

    public String getProductList() {
        ProductSet ps = new ProductSet(dao.listAll());
        JSONObject productsJSON = ps.toJSON();
        return productsJSON.toString(4);
    }

    public String getProductAvailableList() {
        ProductSet ps = new ProductSet(dao.listAllAvailable());
        JSONObject productsJSON = ps.toJSON();
        return productsJSON.toString(4);
    }

    public void addProduct(String productJSON) {
        Product product = Product.fromJSON(new JSONObject(productJSON));
        new ProductDAO().add(product);
    }

}
