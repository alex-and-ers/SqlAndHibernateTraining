import javax.persistence.*;

@Entity
@Table(name = "LinkedPurchaselist")
public class LinkedPurchaseList
{
    @EmbeddedId
    private LinkedPurchaseListId id;

    public LinkedPurchaseList(LinkedPurchaseListId id) {
        this.id = id;
    }

    public LinkedPurchaseListId getId() {
        return id;
    }

    public void setId(LinkedPurchaseListId id) {
        this.id = id;
    }
}
