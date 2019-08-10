package fp.stock.userConcreteShare;

import fp.stock.share.Share;
import fp.stock.user.User;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class UserConcreteShare {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Share share;
    @ManyToOne
    private User user;

}
