package fp.stock.userWallet;

import fp.stock.share.Share;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class UserWallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany
    private List<Share> userShares;
}
