package victus.rtrackers.services;

import org.springframework.stereotype.Service;
import victus.rtrackers.RiskCalculator;
import victus.rtrackers.model.Trade;
import victus.rtrackers.repository.TradeRepository;

import java.util.List;

@Service
public class TradeService {
    private final RiskCalculator riskCalculator;
    private final TradeRepository tradeRepository;

    public TradeService(RiskCalculator riskCalculator, TradeRepository tradeRepository) {
        this.riskCalculator = riskCalculator;
        this.tradeRepository = tradeRepository;
    }

    public Trade addTrade(Trade trade) {
        return tradeRepository.save(trade);
    }
    public Trade updateTrade(Trade trade) {
        return tradeRepository.save(trade);
    }
    public void deleteTrade(Long id) {
        if (tradeRepository.existsById(id)) tradeRepository.deleteById(id);
    }
    /*
    public void deleteTrade(Long id) {
        tradeRepository.deleteById(id);
    }
    * */

    public List<Trade> getAllTrades() {
        return tradeRepository.findAll();
    }

    public Trade getTradeById(long id) {
        return tradeRepository.getOne(id);
    }
    public List<Trade> getTradeByRiskLevel(String riskLevel) {
        return tradeRepository.findByRiskLevel(riskLevel);
    }

    public double getTotalExposure() {
        return tradeRepository.findAll()
                .stream()
                .mapToDouble(Trade::getExposure)
                .sum();
    }

}
