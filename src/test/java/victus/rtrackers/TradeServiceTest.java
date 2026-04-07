package victus.rtrackers;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import victus.rtrackers.model.Trade;
import victus.rtrackers.repository.TradeRepository;
import victus.rtrackers.services.TradeService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TradeServiceTest {
    private TradeRepository mockRepository = Mockito.mock(TradeRepository.class);
    private RiskCalculator mockRiskCalculator = Mockito.mock(RiskCalculator.class);

    private TradeService service = new TradeService(mockRiskCalculator,mockRepository);

    @Test
    void should_return_high_risk_when_exposure_over_100k() {
        Trade trade = new Trade("AAPL", 1000, 150.0);

        String risk = trade.getRiskLevel();

        assertEquals("HIGH",risk);
    }
    @Test
    void should_return_low_risk_when_exposure_over_100k() {
        Trade trade = new Trade("AAPL", 10, 150.0);
        String risk = trade.getRiskLevel();
        assertEquals("LOW",risk);
    }

    @Test
    void should_calculate_total_exposure() {
        List<Trade> trades = List.of(
                new Trade("AAPL", 100, 50),
                new Trade("USD", 200, 100)
        );
        Mockito.when(mockRepository.findAll()).thenReturn(trades);
        double exposure = service.getTotalExposure();
        assertEquals(25_000, exposure);
    }

}
