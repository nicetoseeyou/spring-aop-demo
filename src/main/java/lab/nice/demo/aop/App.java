package lab.nice.demo.aop;

import lab.nice.demo.aop.model.Metrics;
import lab.nice.demo.aop.service.KafkaMonitorService;
import lab.nice.demo.aop.service.OtherMonitorService;
import lab.nice.demo.aop.service.OtherService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Timestamp;
import java.time.Instant;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:application.xml");
        KafkaMonitorService kafkaMonitorService = (KafkaMonitorService) context.getBean("kafkaMonitorService");
        Metrics metrics = new Metrics(0L, 10L, 20L, new Timestamp(Instant.now().toEpochMilli()));
        kafkaMonitorService.save(metrics);
        kafkaMonitorService.findById(0L);
        OtherService otherService = (OtherService) context.getBean("otherService");
        otherService.save(10L);
        otherService.findById(10L);
        OtherMonitorService otherMonitorService = (OtherMonitorService) context.getBean("otherMonitorService");
        otherMonitorService.save(10L);
        otherMonitorService.findById(10L);
    }
}
