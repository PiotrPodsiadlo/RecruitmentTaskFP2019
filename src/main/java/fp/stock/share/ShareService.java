package fp.stock.share;

import fp.stock.DemoApplication;
import fp.stock.restScheduler.StockFixtures;
import fp.stock.restScheduler.StockItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Transactional
public class ShareService {

    private static final Logger log = LoggerFactory.getLogger(ShareService.class);
    private final ShareRepository shareRepository;

    public ShareService(ShareRepository shareRepository) {
        this.shareRepository = shareRepository;
    }


    @Scheduled(fixedRate = 30000)
    public void updateSharePrice() {
        RestTemplate restTemplate = new RestTemplate();
        StockFixtures stockFixtures = restTemplate.getForObject("http://webtask.future-processing.com:8068/stocks", StockFixtures.class);
        List<StockItem> items = stockFixtures.getItems();
        List<Share> sharesToPriceUpdate = shareRepository.findAll();
        log.info(sharesToPriceUpdate.toString());
        log.info(items.toString());



    }

}
