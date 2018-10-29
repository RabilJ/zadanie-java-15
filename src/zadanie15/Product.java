package zadanie15;

import java.math.BigDecimal;

public class Product {
    private String name;
    private BigDecimal price;
    private BigDecimal govCut;

    public Product(String name, BigDecimal price, BigDecimal govCut) {
        this.name = name;
        this.price = price;
        this.govCut = govCut;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getGovCut() {
        return govCut;
    }

    public void setGovCut(BigDecimal govCut) {
        this.govCut = govCut;
    }

    @Override
    public String toString() {
        return "Produkt: "+ name+"\n" +"Cena: " +price +"\n" +"Podatek VAT: "+ govCut+"%\n";
    }
}
