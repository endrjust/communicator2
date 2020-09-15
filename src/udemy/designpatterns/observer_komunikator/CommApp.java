package udemy.designpatterns.observer_komunikator;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CommApp {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        User user1 = new User("and@o2.pl", "Andrzej");
        User user2 = new User("kas@gmail.com", "Kasia");
        User user3 = new User("paw@o2.pl", "Pawel");

        Channel channel1 = new Channel("ZDJAVApol17", "JAVA", false);
        Channel channel2 = new Channel("tajemne", "JAVA", true);
        Channel channel3 = new Channel("luzneRozmowy", "wszystko", false);
        List<Channel> channels = List.of(channel1, channel2, channel3);
        System.out.println(getPublicChannels(channels));
//        channel1.addUser(user1);
//        channel1.addUser(user2);
//        channel1.addUser(user3);
//        channel1.sendMessage(user1, "To ja");
//        channel1.unregisterUSer(user3);
//        channel1.sendMessage(user2,"I ja");
//        user1.joinToChannel(channel1);
        user1.joinToChannel(channel1);
        user2.joinToChannel(channel1);
        user1.sendMessage("To ja",channel1);
        user1.sendMessage("To ja 2",channel2);
    }


    public static List<Channel> getPublicChannels(List<Channel> channels) {
        List<Channel> publicsCh = new ArrayList<>();
        for (Channel ch : channels) {
            if (!ch.isPrivateChannel()) {
                publicsCh.add(ch);
            }
        }
        return publicsCh;
    }

    public static Channel addChannel() {
        System.out.println("Podaj nazwę");
        String name = scanner.nextLine();
        System.out.println("Podaj tematyke");
        String theme = scanner.nextLine();
        System.out.println("Czy kanał ma być prywatny t/n");
        boolean status = false;
        if (scanner.nextLine().equals("t")) {
            status = true;
        }
        return new Channel(name, theme, status);
    }

}