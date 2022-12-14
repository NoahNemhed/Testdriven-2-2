import java.util.ArrayList;
import java.util.List;

public class Database {
    private static List<User> users;
    private List<Card> cards;

    public Database() {
        this.users = new ArrayList<>();
        this.cards = new ArrayList<>();

        // Add test users and cards to the database
        users.add(new User("Alice"));
        users.add(new User("Bob"));
        users.add(new User("Charlie"));
        cards.add(new Card("123", "1234", false));
        cards.add(new Card("456", "2345", false));
        cards.add(new Card("789", "3456", false));

        // Connect each user to their card
        users.get(0).setCard(cards.get(0));
        users.get(1).setCard(cards.get(1));
        users.get(2).setCard(cards.get(2));
    }

    public static User getUser(String cardId) {
        // Find the user with the given card ID
        for (User user : users) {
            if (user.getCard().getId().equals(cardId)) {
                return user;
            }
        }
        return null;
    }

    public ArrayList<User> getUsers(){
        return (ArrayList<User>) users;
    }


}
