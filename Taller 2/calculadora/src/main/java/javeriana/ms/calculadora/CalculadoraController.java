package javeriana.ms.calculadora;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CalculadoraController {

  @Autowired
  RestTemplate restTemplate;

  @Bean
  @LoadBalanced
  RestTemplate restTemplate(){
    return new RestTemplate();
  }

  @GetMapping("/calculadora/suma")
  public String calcularSuma(@RequestParam int a,@RequestParam int b,@RequestParam String user){
    String response=restTemplate.getForObject("http://sumador/suma?a={a}&b={b}&user={user}", String.class, a,b,user);
    return response;
  }

  @GetMapping("/calculadora/resta")
  public String calcularResta(@RequestParam int a,@RequestParam int b,@RequestParam String user){
    String response=restTemplate.getForObject("http://restador/resta?a={a}&b={b}&user={user}", String.class, a,b,user);
    return response;
  }

  @GetMapping("/calculadora/multip")
  public String calcularMultiplicar(@RequestParam int a,@RequestParam int b,@RequestParam String user){
    String response=restTemplate.getForObject("http://multiplicador/multip?a={a}&b={b}&user={user}", String.class, a,b,user);
    return response;
  }

  @GetMapping("/calculadora/div")
  public String calcularDividir(@RequestParam int a,@RequestParam int b,@RequestParam String user){
    String response=restTemplate.getForObject("http://divisor/div?a={a}&b={b}&user={user}", String.class, a,b,user);
    return response;
  }

  @GetMapping(value="/historial",produces="application/json")
  public List<Record> historial(){
    List<Record> result= new ArrayList<>();
    List<Record> sumRecords = restTemplate.getForObject("http://sumador/historial", List.class);
    result.addAll(sumRecords);
    List<Record> substractionRecords =restTemplate.getForObject("http://restador/historial", List.class);
    result.addAll(substractionRecords);
    List<Record> multiplicationRecords= restTemplate.getForObject("http://multiplicador/historial", List.class);
    result.addAll(multiplicationRecords);
    List<Record> divisionRecords= restTemplate.getForObject("http://divisor/historial", List.class);
    result.addAll(divisionRecords);
    return result;
  }
  
}
