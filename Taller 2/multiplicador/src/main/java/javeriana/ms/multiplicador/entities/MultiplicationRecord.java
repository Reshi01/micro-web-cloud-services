package javeriana.ms.multiplicador.entities;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;

public class MultiplicationRecord {
    @Id
    private String id;
    private LocalDateTime dateTime;
    private String userName;
    private String operation = "MULTIPLICACION";

    public MultiplicationRecord() {
    }

    public MultiplicationRecord(LocalDateTime dateTime, String userName) {
        this.dateTime = dateTime;
        this.userName = userName;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public LocalDateTime getDateTime() {
        return dateTime;
    }
    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
    
}
