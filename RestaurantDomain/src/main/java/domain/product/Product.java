package domain.product;

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
@Table(name = "products")
public class Product implements Serializable {

    @Id
    @Column(name = "id_product")
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Integer idProduct;
    private String title;
    private Double price;
    private Boolean available;
    private Boolean daily;
    private byte[] picture;

    public Product() {
    }

    public Product(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public Product(String title, Double price, Boolean available, Boolean daily, byte[] picture) {
        this.title = title;
        this.price = price;
        this.available = available;
        this.picture = picture;
        this.daily = daily;
    }

    public Product(Integer idProduct, String title, Double price, Boolean available, Boolean daily, byte[] picture) {
        this.idProduct = idProduct;
        this.title = title;
        this.price = price;
        this.available = available;
        this.picture = picture;
        this.daily = daily;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public Boolean getDaily() {
        return daily;
    }

    public void setDaily(Boolean daily) {
        this.daily = daily;
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
        sb.append(", price=").append(price);
        sb.append(", available=").append(available);
        sb.append(", daily=").append(daily);
        sb.append(", picture=").append(picture);
        sb.append('}');
        return sb.toString();
    }

    public JSONObject toJSON() {
        JSONObject productJSON = new JSONObject();
        productJSON.put("idProduct", getIdProduct());
        productJSON.put("title", getTitle());
        productJSON.put("price", getPrice());
        productJSON.put("available", getAvailable());
         productJSON.put("daily", getDaily());
        return productJSON;
    }

    public static Product fromJSON(JSONObject productJSON) {
        Product product = new Product();
        product.setTitle(productJSON.getString("title"));
        product.setPrice(productJSON.getDouble("price"));
        product.setAvailable(productJSON.getBoolean("available"));
        product.setDaily(productJSON.getBoolean("daily"));
        product.setPicture(Base64.getMimeDecoder().decode(productJSON.getString("picture")));
        return product;
    }

}
