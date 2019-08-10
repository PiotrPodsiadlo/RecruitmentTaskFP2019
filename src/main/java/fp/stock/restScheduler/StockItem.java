package fp.stock.restScheduler;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class StockItem {

    private String name;
    private String code;
    private String unit;
    private String price;

}
