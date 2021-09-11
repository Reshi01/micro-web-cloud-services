package javeriana.ms.calculadora;

import java.time.LocalDateTime;

public class Record {
  private String id;
    private LocalDateTime dateTime;
    private String userName;
    private String operation;

    public Record() {
    }

    public Record(String id, LocalDateTime dateTime, String userName, String operation) {
        this.id=id;
        this.dateTime = dateTime;
        this.userName = userName;
        this.operation=operation;
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
