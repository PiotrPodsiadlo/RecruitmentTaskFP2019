package fp.stock.user;
import fp.stock.userConcreteShare.UserConcreteShare;
import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.Size;
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
    @OneToMany(cascade =
            CascadeType.ALL)
    @JoinColumn(name="user_id")
    private List<UserConcreteShare> userConcreteShares;
    private int enabled;
}
