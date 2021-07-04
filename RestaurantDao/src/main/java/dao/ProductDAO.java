package dao;

import domain.Product;
import java.util.List;
import javax.persistence.Query;

public class ProductDAO extends GenericDAO {

    public List<Product> listAll() {
        String cmd = "SELECT p FROM Product p";
        em = getEntityManager();
        Query query = em.createQuery(cmd);
        return query.getResultList();
    }
    
    public List<Product> listAllAvailable() {
        String cmd = "SELECT p FROM Product p WHERE p.available = 1";
        em = getEntityManager();
        Query query = em.createQuery(cmd);
        return query.getResultList();
    }

    public void add(Product product) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(product);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            closeEntityManager();
        }
    }

    public Object retrieve(Product product) {
        em = getEntityManager();
        return em.find(Product.class, product.getIdProduct());
    }

    //product = finded object from DB and modificate.
    public void update(Product product) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(product);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            closeEntityManager();
        }
    }

    public void delete(Product product) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.remove(em.merge(product));
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            closeEntityManager();
        }
    }

}
