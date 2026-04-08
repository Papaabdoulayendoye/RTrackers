package victus.rtrackers;

import org.springframework.stereotype.Component;
import victus.rtrackers.model.Trade;

// @Component = Spring crée automatiquement un bean de ce type
// quand TradeService demande un RiskCalculator, Spring injecte celui-ci
@Component
public class SimpleRiskCalculator implements RiskCalculator {

    @Override
    public double calculate(Trade trade) {
        return trade.getQuantity() * trade.getPrice();
    }
}
