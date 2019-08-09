package fp.stock.user;
import fp.stock.role.Role;
import lombok.Data;
import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false)
    private String password;
    private double financialResources;
    private int quantityFP;
    private int quantityFPL;
    private int quantityFPC;
    private int quantityPGB;
    private int quantityFPA;
    private int quantityDL24;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;
    private int enabled;
}
