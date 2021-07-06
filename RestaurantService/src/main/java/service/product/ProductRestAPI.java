package service.product;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import service.product.provider.ProductProvider;

@Path("products")
public class ProductRestAPI {
    
    @GET
    @Path("{idProduct}/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProduct(@PathParam("idProduct") Integer idProduct) {
        String product = ProductProvider.getInstance().getProduct(idProduct);
        return Response.ok(product).build();
    }
    
    @GET
    @Path("picture/{idProduct}/")
    @Produces("image/png")
    public Response getProductPicture(@PathParam("idProduct") Integer idProduct) {
        byte[] picture = ProductProvider.getInstance().getProductPicture(idProduct);
        return Response.ok(picture).build();
    }
    
    @GET
    @Path("all/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProductList() {
        String ps = ProductProvider.getInstance().getProductList();
        return Response.ok(ps).build();
    }
    
    @GET
    @Path("available/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProductAvailableList() {
        String ps = ProductProvider.getInstance().getProductAvailableList();
        return Response.ok(ps).build();
    }
    
    @GET
    @Path("daily/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProductDailyList() {
        String ps = ProductProvider.getInstance().getProductDailyList();
        return Response.ok(ps).build();
    }
    
    @GET
    @Path("available/{parameter}/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProductAvailableListParameter(@PathParam("parameter") String parameter) {
        String ps = ProductProvider.getInstance().getProductAvailableListParameter(parameter);
        return Response.ok(ps).build();
    }
    
    @GET
    @Path("daily/{parameter}/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProductDailyListParameter(@PathParam("parameter") String parameter) {
        String ps = ProductProvider.getInstance().getProductDailyListParameter(parameter);
        return Response.ok(ps).build();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addProduct(@FormParam("product") String productJSON) {
        ProductProvider.getInstance().addProduct(productJSON);
        return Response.ok().build();
    }
}
