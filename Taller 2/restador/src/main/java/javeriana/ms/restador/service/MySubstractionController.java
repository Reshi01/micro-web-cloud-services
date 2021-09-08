package javeriana.ms.restador.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javeriana.ms.restador.business.HistoryObtainer;
import javeriana.ms.restador.business.Substracter;
import javeriana.ms.restador.entities.SubstractionRecord;

@RestController
public class MySubstractionController {
    
    @Autowired
    Environment environment;
    @Autowired
    Substracter substracter;
    @Autowired
    HistoryObtainer historyObtainer;

    @GetMapping("/resta")
    public String sum(@RequestParam int a, @RequestParam int b, @RequestParam String user){
        String port = environment.getProperty("local.server.port");
        int result = substracter.execute(a, b, user);
        String response = "Resultado: " + result + " -> Microservicio restador corriendo en el puerto " + port;
        return response;
    }

    @GetMapping(value="/historial", produces="application/json")
    public List<SubstractionRecord> history(){
        return historyObtainer.execute();
    }

}
