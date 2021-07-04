package domain;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class ProductSet {
    
    private List<Product> products;

    public ProductSet() {
        this(new ArrayList<>());
    }

    public ProductSet(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ProductSet{products=").append(products);
        sb.append('}');
        return sb.toString();
    }

    public JSONObject toJSON(){
        JSONArray arr = new JSONArray();
        
        products.forEach(product -> {
            arr.put(product.toJSON());
        });
     
        JSONObject json = new JSONObject();
        json.put("products", arr);
        return json;
    }
    
}
