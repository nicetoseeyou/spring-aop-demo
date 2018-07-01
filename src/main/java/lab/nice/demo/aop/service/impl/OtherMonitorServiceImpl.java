package lab.nice.demo.aop.service.impl;

import lab.nice.demo.aop.service.OtherMonitorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service(value = "otherMonitorService")
public class OtherMonitorServiceImpl implements OtherMonitorService {
    private static final Logger LOGGER = LoggerFactory.getLogger(OtherMonitorServiceImpl.class);

    @Override
    public void save(Long entity) {
        LOGGER.info(" Save Other metrics {}", entity);
    }

    @Override
    public Long findById(Long id) {
        LOGGER.info("Find other metrics by id={}", id);
        return id;
    }
}
