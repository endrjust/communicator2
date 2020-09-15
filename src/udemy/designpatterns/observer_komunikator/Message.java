package udemy.designpatterns.observer_komunikator;

import java.time.LocalTime;

public class Message {
    private String text;
    private LocalTime timeOfCreate;
    private User messageWriter;

    public Message(final String text, final LocalTime timeOfCreate, final User messageCreator) {
        this.text = text;
        this.timeOfCreate = timeOfCreate;
        this.messageWriter = messageCreator;
    }

    public Message(final String text, final LocalTime timeOfCreate) {
        this.text = text;
        this.timeOfCreate = timeOfCreate;
    }

    public String getMessage() {
        return getMessageWriter() + " " + getTimeOfCreate() + " \n" + getText() + "\n" + "------------------";
    }

    public String getText() {
        return text;
    }

    public void setText(final String text) {
        this.text = text;
    }

    public LocalTime getTimeOfCreate() {
        return timeOfCreate;
    }

    public void setTimeOfCreate(final LocalTime timeOfCreate) {
        this.timeOfCreate = timeOfCreate;
    }

    public User getMessageWriter() {
        return messageWriter;
    }

    public void setMessageWriter(final User messageWriter) {
        this.messageWriter = messageWriter;
    }
}
