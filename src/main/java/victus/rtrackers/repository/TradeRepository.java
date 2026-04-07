package victus.rtrackers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import victus.rtrackers.model.Trade;

import java.util.List;

public interface TradeRepository extends JpaRepository<Trade, Long> {
    List<Trade> findByRiskLevel(String riskLevel);
}