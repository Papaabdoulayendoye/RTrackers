package victus.rtrackers;
import victus.rtrackers.model.Trade;


public interface RiskCalculator {
    double calculate(Trade trade);
}
