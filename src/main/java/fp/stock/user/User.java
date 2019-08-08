package fp.stock.user;

import fp.stock.share.Share;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String password;
    private double financialResources;
    private int quantityFP;
    private int quantityFPL;
    private int quantityFPC;
    private int quantityPGB;
    private int quantityFPA;
    private int quantityDL24;

}
