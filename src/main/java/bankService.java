public class bankService {

    Database database;
    private String bankName;

    public bankService(Database database, String bankName) {
        this.database = database;
        this.bankName = bankName;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public static User getUser(int idNumber) {
        // Retrieve the user with the given ID number from the bank's database.
        User user = Database.getUser(String.valueOf(idNumber));
        return user;
    }



}
