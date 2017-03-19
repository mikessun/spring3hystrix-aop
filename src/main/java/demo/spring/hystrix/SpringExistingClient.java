package demo.spring.hystrix;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component("springClient")
public class SpringExistingClient {

    @Value("${remoteservice.timeout}")
    private int remoteServiceDelay;

    @HystrixCircuitBreaker
    public String invokeRemoteServiceWithHystrix() throws InterruptedException {
        log.info("in circuit breaker");
        return new RemoteServiceTestSimulator(remoteServiceDelay).execute();
    }

    public String invokeRemoteServiceWithOutHystrix() throws InterruptedException {
        log.info("in non circuit breaker");
        return new RemoteServiceTestSimulator(remoteServiceDelay).execute();
    }
}
