package zadanie15;

import java.io.*;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Products {
    private static BigDecimal sumBrutto = BigDecimal.valueOf(0);
    private static BigDecimal sumNetto = BigDecimal.valueOf(0);
    private static BigDecimal sumVat = BigDecimal.valueOf(0);
    private static BigDecimal hundred = new BigDecimal("100");
    private static MathContext mc = new MathContext(4);
    private static String line;

    public static void main(String[] args) throws IOException {
        File file = new File("produkty.csv");
        File file2 = new File("podsumowanie.csv");
        BufferedReader bfr = new BufferedReader(new FileReader(file));
        BufferedWriter bfw = new BufferedWriter(new FileWriter(file2));
        List<Product> products = new ArrayList<>();
        while ((line = bfr.readLine()) != null) {
            String[] values = line.split(";");
            String name = values[0];
            String price = values[1];
            String govCut = values[2];
            BigDecimal priceToBD = new BigDecimal(price);
            BigDecimal govCutToBG = new BigDecimal(govCut);
            Product product = new Product(name, priceToBD, govCutToBG);
            products.add(product);
        }
        countAll(products);

        String brutto = "Sprzedaż Brutto: " + sumBrutto.round(mc)+"zł\n";
        System.out.println(brutto);
        bfw.write(brutto);
        String netto = "Sprzedaż Netto: " + sumNetto.round(mc)+"zł\n";
        System.out.println(netto);
        bfw.write(netto);
        String vat = "Suma VATu: "+(hundred.subtract(sumVat.round(mc)))+"%\n";
        System.out.println(vat);
        bfw.write(vat);
        bfw.flush();
        bfw.close();
        bfr.close();

    }
    private static void countAll(List<Product>products){
        for (Product product : products) {
            System.out.println(product);
        }
        for (Product product : products) {
            sumBrutto = sumBrutto.add(product.getPrice());
        }
        for (Product product : products) {
            sumNetto = sumNetto.add(product.getPrice().multiply((hundred.subtract(product.getGovCut()).divide(hundred))));
        }
        sumVat = (sumNetto.multiply(hundred)).divide(sumBrutto, 2, RoundingMode.CEILING);
    }
    private static void printAndWriteAll(){

    }
}
