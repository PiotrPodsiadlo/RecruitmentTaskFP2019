package fp.stock.user;
import fp.stock.share.Share;
import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    @Size(min = 2)
    private String name;
    @Column(nullable = false)
    @Size(min = 2)
    private String password;
    private double financialResources;
    @ManyToMany
    private List<Share> Shares = new ArrayList<>();
    private int enabled;


    public User addShares(Share share) {
        Shares.add(share);
        return this;
    }
}
