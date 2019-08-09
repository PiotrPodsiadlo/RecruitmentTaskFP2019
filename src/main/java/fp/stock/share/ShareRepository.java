package fp.stock.share;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShareRepository  extends JpaRepository<Share, Long> {
}
