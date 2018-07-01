package lab.nice.demo.aop.service.impl;

import lab.nice.demo.aop.service.OtherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service(value = "otherService")
public class OtherServiceImpl implements OtherService {
    private static final Logger LOGGER = LoggerFactory.getLogger(OtherServiceImpl.class);

    @Override
    public void save(Long other) {
        LOGGER.info("Save Other {}", other);
    }

    @Override
    public Long findById(Long id) {
        LOGGER.info("Find Other[id={}]", id);
        return id;
    }
}
