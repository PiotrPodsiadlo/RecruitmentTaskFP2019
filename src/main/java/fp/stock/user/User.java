package fp.stock.user;
import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

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
    private int quantityFP;
    private int quantityFPL;
    private int quantityFPC;
    private int quantityPGB;
    private int quantityFPA;
    private int quantityDL24;
    private int enabled;
}
