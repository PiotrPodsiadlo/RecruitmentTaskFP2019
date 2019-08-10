package fp.stock.share;

import fp.stock.restScheduler.StockFixtures;
import fp.stock.restScheduler.StockItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

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

        for (Share share: sharesToPriceUpdate) {
            Optional<StockItem> matchingObjectitems = items.stream().filter(i -> i.getCode().equals(share.getName())).findFirst();
            StockItem item = matchingObjectitems.get();
            share.setUnitPrice(Double.parseDouble(item.getPrice()));
            shareRepository.save(share);
            Share shareFromDb = shareRepository.getOne(share.getId());
        }


    }

}
