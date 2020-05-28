import com.mysql.cj.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main
{
    public static void main(String[] args)
    {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();

        Metadata mData = new MetadataSources(registry).getMetadataBuilder().build();

        SessionFactory sFactory = mData.getSessionFactoryBuilder().build();

        Session session = sFactory.openSession();

        Transaction transaction = session.beginTransaction();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Purchase> query = builder.createQuery(Purchase.class);
        Root<Purchase> root = query.from(Purchase.class);
        query.select(root);
        List<Purchase> purchases = session.createQuery(query).getResultList();

        Map<String, Integer> courses = new HashMap<>();
        session.createQuery("SELECT name, id FROM Course").getResultList().forEach(e -> {
            Object[] g = (Object[]) e;
            courses.put((String) g[0],  (Integer) g[1]);
        });

        Map<String, Integer> students = new HashMap<>();
        session.createQuery("SELECT name, id FROM Student").getResultList().forEach(e -> {
            Object[] g = (Object[]) e;
            students.put((String) g[0],  (Integer) g[1]);
        });
        for (Purchase purchase : purchases) {
            LinkedPurchaseListId id = new LinkedPurchaseListId(
                    students.get(purchase.getId().getStudentName()),
                    courses.get(purchase.getId().getCourseName()));
            LinkedPurchaseList linkedPurchase = new LinkedPurchaseList(id);
            session.save(linkedPurchase);
        }
        transaction.commit();
        sFactory.close();
    }
}
