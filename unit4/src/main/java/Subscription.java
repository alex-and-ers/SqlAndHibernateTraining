import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
@Table(name = "Subscriptions")
public class Subscription
{
    @EmbeddedId
    private SubscriptionId id;

    @Basic
    @Column(name = "subscription_date")
    private LocalDateTime subscriptionDate;

    public SubscriptionId getId() {
        return id;
    }

    public void setId(SubscriptionId id) {
        this.id = id;
    }

    public LocalDateTime getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(LocalDateTime subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }
}
