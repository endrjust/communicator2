package udemy.designpatterns.observer_komunikator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Optional;

public class User implements Observer {

    private String email;
    private String nickname;
    List<Channel> channels;


    public User(final String email, final String nickname, final List<Channel> channels) {
        this.email = email;
        this.nickname = nickname;
        this.channels = channels;
    }

    public User(final String email, final String nickname) {
        this.email = email;
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(final String nickname) {
        this.nickname = nickname;
    }

    public List<Channel> getChannels() {
        return channels;
    }

    public void setChannels(final List<Channel> channels) {
        this.channels = channels;
    }

    @Override
    public String toString() {
        return this.nickname + "[" + this.email + "]";
    }

    @Override
    public void handleMessage(final Channel channel) {
        System.out.println(this.nickname + " sees the message written by ");
        List<Message> messages = channel.getMessages();
        System.out.println(messages.get(messages.size() - 1).getMessage());
    }

    public void joinToChannel (Channel channel) throws IOException {
        String path = "C:\\Users\\user\\IdeaProjects\\Java_prog\\src\\udemy\\designpatterns\\observer_komunikator\\"+channel.getChannelName()+"_"+getNickname()+".txt";
        Files.write(Paths.get(path),channel.downloadAllMessages(), StandardOpenOption.CREATE);
        channel.addUser(this);
    }

    public void sendMessage(String message, Channel channel) throws IOException {
        if (!channel.getUserList().contains(this)) {
            this.joinToChannel(channel);
        }
        channel.sendMessage(this,message);
    }


}
