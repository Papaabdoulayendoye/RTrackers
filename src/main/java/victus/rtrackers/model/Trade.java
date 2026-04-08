package victus.rtrackers.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "trades")
@Data
@NoArgsConstructor
public class Trade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String symbol; // "AAPL", "EURO/USD"
    private int quantity;
    private double price;
    private String riskLevel; // "LOW" || "MEDIUM" || "HIGH"
    public Trade(String symbol, int quantity, double price) {
        this.symbol = symbol;
        this.quantity = quantity;
        this.price = price;
        this.riskLevel = calculateRiskLevel();
    }
    private String calculateRiskLevel() {
        double exposure = quantity * price;
        if (exposure > 100_000) return "HIGH";
        if (exposure > 10_000) return "MEDIUM";
        return "LOW";
    }
    public String getSymbol() {return symbol;}
    public int getQuantity() { return quantity; }
    public double getPrice() { return price; }
    public String getRiskLevel() { return riskLevel; }
    public double getExposure() { return quantity * price; }
}
