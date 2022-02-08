public class Message {

    private String to;
    private String msg;

    public Message(String to, String msg) {
        this.to = to;
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "To : "+this.to+"\nMessage : "+this.msg+"\n";
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    
}
