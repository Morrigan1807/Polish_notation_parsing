package model;

import lombok.Getter;
import lombok.Setter;
import org.apache.log4j.Logger;

import static util.Constant.*;


@Getter
@Setter
public class FoundElementModel {

    private static final Logger logger = Logger.getLogger(FoundElementModel.class);

    private String productName;
    private Price price;
    private String priceAsString;
    private String condition;
    private String url;

    public void parseAndSetPrice() {
        if (priceAsString.contains(TO)) {
            BoundedPrice boundedPrice = new BoundedPrice();
            boundedPrice.setLowerPrice(Double.parseDouble(priceAsString.substring(priceAsString.indexOf(DOLLAR_SIGN) + 1, priceAsString.indexOf(SPACE))));
            boundedPrice.setUpperPrice(Double.parseDouble(priceAsString.substring(priceAsString.lastIndexOf(DOLLAR_SIGN) + 1)));
            price = boundedPrice;
        } else {
            ExactPrice exactPrice = new ExactPrice();
            exactPrice.setExactPrice(Double.parseDouble(priceAsString.substring(1)));
            price = exactPrice;
        }
    }

    public void outToLog() {
        logger.info(DELIMITER_OUTPUT);
        logger.info(PRODUCT_NAME_OUTPUT + productName);
        logger.info(PRICE_OUTPUT + priceAsString);
        logger.info(CONDITION_OUTPUT + condition);
        logger.info(URL_OUTPUT + url);
        logger.info(DELIMITER_OUTPUT);
    }
}
