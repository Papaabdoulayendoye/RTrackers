package victus.rtrackers.controller;

import org.springframework.web.bind.annotation.*;
import victus.rtrackers.model.Trade;
import victus.rtrackers.repository.TradeRepository;
import victus.rtrackers.services.TradeService;

import java.util.List;

@RestController
@RequestMapping("api/trades")
public class TradeController {
    private final TradeRepository tradeRepository;
    private final TradeService tradeService;
    public TradeController(TradeRepository tradeRepository, TradeService tradeService) {
        this.tradeRepository = tradeRepository;
        this.tradeService = tradeService;
    }

    @GetMapping
    public List<Trade> getAll() {
        return tradeService.getAllTrades();
    }
    @PostMapping
    public Trade save(@RequestBody Trade trade) {
        return tradeService.addTrade(trade);
    }
    @DeleteMapping
    public void deleteById(@RequestBody Trade trade) {
        tradeService.deleteTrade(trade);
    }

    @GetMapping("risk/{level}")
    public List<Trade> getByRiskLevel(@PathVariable String level) {
        return tradeService.getTradeByRiskLevel(level);
    }

    @GetMapping("/exposure")
    public double getTotalExposure() {
        return tradeService.getTotalExposure();
    }


}
