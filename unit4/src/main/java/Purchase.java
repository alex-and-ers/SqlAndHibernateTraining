import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
@Table(name = "Purchaselist")
public class Purchase
{
    @EmbeddedId
    private PurchaseId id;

    private int price;

    @Basic
    @Column(name = "subscription_date")
    private LocalDateTime subscriptionDate;

    public PurchaseId getId() {
        return id;
    }

    public void setId(PurchaseId id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public LocalDateTime getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(LocalDateTime subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }
}
