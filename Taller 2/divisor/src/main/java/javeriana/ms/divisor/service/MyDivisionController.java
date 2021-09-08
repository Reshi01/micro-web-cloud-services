package javeriana.ms.divisor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javeriana.ms.divisor.business.Divider;
import javeriana.ms.divisor.business.HistoryObtainer;
import javeriana.ms.divisor.entities.DivisionRecord;

@RestController
public class MyDivisionController {
    
    @Autowired
    Environment environment;
    @Autowired
    Divider adder;
    @Autowired
    HistoryObtainer historyObtainer;

    @GetMapping("/div")
    public String sum(@RequestParam int a, @RequestParam int b, @RequestParam String user){
        String port = environment.getProperty("local.server.port");
        float result;
        String response;
        try {
            result = adder.execute(a, b, user);
            response = "Resultado: " + result + " -> Microservicio divisor corriendo en el puerto " + port;
        }
        catch(ArithmeticException e) {
            response = "Error: División entre cero -> Microservicio divisor corriendo en el puerto " + port;
        }
        return response;
    }

    @GetMapping(value="/historial", produces="application/json")
    public List<DivisionRecord> history(){
        return historyObtainer.execute();
    }

}
