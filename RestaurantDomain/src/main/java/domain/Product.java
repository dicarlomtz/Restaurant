package domain;

import java.io.Serializable;
import java.util.Base64;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.json.JSONObject;

@Entity
@Table( name = "products" )
public class Product implements Serializable {
    
    @Id
    @Column( name = "id_product" )
    @GeneratedValue( generator = "increment" )
    @GenericGenerator( name = "increment", strategy = "increment" )
    private Integer idProduct;
    private String title;
    private String description;
    private Boolean available;
    private byte[] picture;

    public Product() {
    }

    public Product(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public Product(String title, String description, Boolean available, byte[] picture) {
        this.title = title;
        this.description = description;
        this.available = available;
        this.picture = picture;
    }

    public Product(Integer idProduct, String title, String description, Boolean available, byte[] picture) {
        this.idProduct = idProduct;
        this.title = title;
        this.description = description;
        this.available = available;
        this.picture = picture;
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.idProduct);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Product other = (Product) obj;
        return Objects.equals(this.idProduct, other.idProduct);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Product{idProduct=").append(idProduct);
        sb.append(", title=").append(title);
        sb.append(", description=").append(description);
        sb.append(", available=").append(available);
        sb.append(", picture=").append(picture);
        sb.append('}');
        return sb.toString();
    }
    
    public JSONObject toJSON(){
        JSONObject productJSON = new JSONObject();
        productJSON.put("idProduct", getIdProduct());
        productJSON.put("title", getTitle());
        productJSON.put("description", getDescription());
        productJSON.put("available", getAvailable());
        return productJSON;
    }
    
    public static Product fromJSON(JSONObject productJSON){
        Product product = new Product();
        product.setTitle(productJSON.getString("title"));
        product.setDescription(productJSON.getString("description"));
        product.setAvailable(productJSON.getBoolean("available"));
        product.setPicture(Base64.getMimeDecoder().decode(productJSON.getString("picture")));
        return product;
    }
    
}
