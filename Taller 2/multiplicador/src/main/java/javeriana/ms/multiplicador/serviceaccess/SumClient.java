package javeriana.ms.multiplicador.serviceaccess;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SumClient {
    
    @Autowired
    RestTemplate restTemplate;

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public int execute(int a, int b, String user){
        int response = Integer.valueOf(restTemplate.getForObject("http://sumador/sumaInt?a={a}&b={b}&user={user}", String.class, a, b, user));
        return response;
    } 
}
