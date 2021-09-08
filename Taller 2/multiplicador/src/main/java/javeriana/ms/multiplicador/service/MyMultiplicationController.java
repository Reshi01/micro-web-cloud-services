package javeriana.ms.multiplicador.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javeriana.ms.multiplicador.business.HistoryObtainer;
import javeriana.ms.multiplicador.business.Multiplier;
import javeriana.ms.multiplicador.entities.MultiplicationRecord;

@RestController
public class MyMultiplicationController {
    
    @Autowired
    Environment environment;
    @Autowired
    Multiplier multiplier;
    @Autowired
    HistoryObtainer historyObtainer;

    @GetMapping("/multip")
    public String sum(@RequestParam int a, @RequestParam int b, @RequestParam String user){
        String port = environment.getProperty("local.server.port");
        int result = multiplier.execute(a, b, user);
        String response = "Resultado: " + result + " -> Microservicio multiplicador corriendo en el puerto " + port;
        return response;
    }

    @GetMapping(value="/historial", produces="application/json")
    public List<MultiplicationRecord> history(){
        return historyObtainer.execute();
    }

}
