package javeriana.ms.sumador.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javeriana.ms.sumador.business.Adder;
import javeriana.ms.sumador.business.HistoryObtainer;
import javeriana.ms.sumador.entities.SumRecord;

@RestController
public class MySumController {
    
    @Autowired
    Environment environment;
    @Autowired
    Adder adder;
    @Autowired
    HistoryObtainer historyObtainer;

    @GetMapping("/suma")
    public String sum(@RequestParam int a, @RequestParam int b, @RequestParam String user){
        String port = environment.getProperty("local.server.port");
        int result = adder.execute(a, b, user);
        String response = "Resultado: " + result + " -> Microservicio sumador corriendo en el puerto " + port;
        return response;
    }

    @GetMapping("/sumaInt")
    public int integerSum(@RequestParam int a, @RequestParam int b, @RequestParam String user){
        int result = adder.execute(a, b, user);
        return result;
    }

    @GetMapping(value="/historial", produces="application/json")
    public List<SumRecord> history(){
        return historyObtainer.execute();
    }

}
