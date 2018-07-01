package lab.nice.demo.aop.service.impl;

import lab.nice.demo.aop.model.Metrics;
import lab.nice.demo.aop.service.KafkaMonitorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service(value = "kafkaMonitorService")
public class KafkaMonitorServiceImpl implements KafkaMonitorService {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaMonitorServiceImpl.class);

    @Override
    public void save(Metrics metrics) {
        LOGGER.info("Save Kafka {}", metrics);
    }

    @Override
    public Metrics findById(Long id) {
        LOGGER.info("Find Kafka Metrics[id={}]", id);
        return null;
    }
}
