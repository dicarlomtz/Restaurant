package service;

import dao.ProductDAO;
import domain.Product;
import domain.ProductSet;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.JSONObject;

@Path("products")
public class ProductRestAPI {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{idProduct}/")
    public Response getProduct(@PathParam("idProduct") Integer idProduct) {
        ProductDAO dao = new ProductDAO();
        Product product = new Product(idProduct);
        JSONObject productJSON = ((Product) dao.retrieve(product)).toJSON();
        return Response.ok(productJSON.toString(4)).build();
    }

    @GET
    @Path("picture/{idProduct}/")
    @Produces("image/png")
    public Response getProductPicture(@PathParam("idProduct") Integer idProduct) {
        ProductDAO dao = new ProductDAO();
        Product product = new Product(idProduct);
        byte[] picture = ((Product) dao.retrieve(product)).getPicture();
        return Response.ok(picture).build();
    }

    @GET
    @Path("all/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProductList() {
        ProductDAO dao = new ProductDAO();
        ProductSet ps = new ProductSet(dao.listAll());
        JSONObject json = ps.toJSON();
        return Response.ok(json.toString(4)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("available/")
    public Response getProductAvailableList() {
        ProductDAO dao = new ProductDAO();
        ProductSet ps = new ProductSet(dao.listAllAvailable());
        JSONObject json = ps.toJSON();
        return Response.ok(json.toString(4)).build();
    }

    
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addProduct(@FormParam("product") String productJSON) {
        Product product = Product.fromJSON(new JSONObject(productJSON));
        new ProductDAO().add(product);
        return Response.ok().build();
    }
}
