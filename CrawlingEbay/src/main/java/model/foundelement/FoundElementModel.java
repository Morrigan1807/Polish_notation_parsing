package model.foundelement;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Getter
@Setter
@Log4j2
public class FoundElementModel {

    private String productName;
    private Price price;
    private String priceAsString;
    private String condition;
    private String url;

    public void parseAndSetPrice() {
        if (priceAsString.contains("to")) {
            BoundedPrice boundedPrice = new BoundedPrice();
            boundedPrice.setLowerPrice(Double.parseDouble(priceAsString.substring(priceAsString.indexOf('$') + 1, priceAsString.indexOf(' '))));
            boundedPrice.setUpperPrice(Double.parseDouble(priceAsString.substring(priceAsString.lastIndexOf('$') + 1)));
            price = boundedPrice;
        } else {
            ExactPrice exactPrice = new ExactPrice();
            exactPrice.setExactPrice(Double.parseDouble(priceAsString.substring(1)));
            price = exactPrice;
        }
    }

    public void outToLog() {
        log.info("\n-------------------------------------------");
        log.info("Product name: " + productName + "\n");
        log.info("Price: " + priceAsString + "\n");
        log.info("Condition: " + condition + "\n");
        log.info("URL: " + url);
        log.info("-------------------------------------------\n");
    }
}
