package victus.rtrackers.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        if (!tradeRepository.existsById(id)) {
            return ResponseEntity.notFound().build(); // 404
        }
        tradeService.deleteTrade(id);
        return ResponseEntity.noContent().build();
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
