package web.drh.controller.exception;

public class OwnBean {

    private String status;
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public OwnBean(String message, String status) {
        this.message = message;
        this.status = status;
    }

}
