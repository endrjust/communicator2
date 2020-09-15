package udemy.designpatterns.observer_komunikator;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Channel implements Observerable {

    private String channelName;
    private String theme;
    private List<Observer> userList = new ArrayList<>();
    private List<Message> messages = new ArrayList<>();
    private boolean isPrivateChannel = false;


    public Channel(final String channelName, final String theme, final boolean isPrivateChannel) {
        this.channelName = channelName;
        this.theme = theme;
        this.isPrivateChannel = isPrivateChannel;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(final String channelName) {
        this.channelName = channelName;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(final String theme) {
        this.theme = theme;
    }


    public List<Observer> getUserList() {
        return userList;
    }

    public void setUserList(final List<Observer> userList) {
        this.userList = userList;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(final List<Message> messages) {
        this.messages = messages;
    }

    public boolean isPrivateChannel() {
        return isPrivateChannel;
    }

    public void setPrivateChannel(final boolean privateChannel) {
        isPrivateChannel = privateChannel;
    }

    @Override
    public String toString() {
        return "channelName='" + channelName + '\'' +
                ", theme='" + theme + '\'';
    }

    public void sendMessage(User user, String text) {
        messages.add(new Message(text, LocalTime.now(), user));
        notifyObservers();
    }

    public void addUser(Observer user) {
        if (!userList.contains(user)) {
            userList.add(user);
            System.out.println(user + "has joined to the channel " + getChannelName());
            System.out.println("-----------------");
        }

    }

    @Override
    public void unregisterUSer(final Observer observer) {
        userList.remove(observer);
        System.out.println(observer + "has deleted from the channel " + getChannelName());
        System.out.println("-----------------");
    }

    @Override
    public void notifyObservers() {
        for (Observer observ : userList) {
            observ.handleMessage(this);
        }
    }

    public List<String> downloadAllMessages(){
        List<String> allMessages = new ArrayList<>();
        for (Message msg: messages) {
            allMessages.add(msg.getMessage());
        }
        return allMessages;
    }
}
