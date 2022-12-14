public class Card {

    String pin,id;
    boolean locked;
    double balance;
    int nrOfTries;

    public Card(String pin, String id, boolean locked) {
        this.pin = pin;
        this.id = id;
        this.locked = locked;
        this.balance = 500;
        this.nrOfTries = 0;
    }

    public int getNrOfTries() {
        return this.nrOfTries;
    }

    public void setNrOfTries(int nrOfTries) {
        this.nrOfTries = nrOfTries;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Card{" +
                "pin='" + pin + '\'' +
                ", id='" + id + '\'' +
                ", locked=" + locked +
                ", balance=" + balance +
                ", nrOfTries=" + nrOfTries +
                '}';
    }
}
