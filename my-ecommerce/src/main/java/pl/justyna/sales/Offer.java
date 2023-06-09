package pl.justyna.sales;

import java.math.BigDecimal;

public class Offer {
    BigDecimal total;
    Integer itemsCount;



    public Offer(BigDecimal total, Integer itemsCount){
        this.total = total;
        this.itemsCount = itemsCount;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public Integer getItemsCount() {
        return itemsCount;
    }
}
