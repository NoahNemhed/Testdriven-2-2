import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class atmServiceTest {
    private atmService atmService;
    private Database database;
    private bankService bankService;
    private List<User> users;

    @BeforeEach
    public void setup() {
        // create a new atmService and Database object
        database = new Database();
        bankService = new bankService(database, "Handelsbanken");
        atmService = new atmService(bankService);


        // retrieve a list of users from the database
        users = database.getUsers();
    }
    // test the enterPin method with the first user in the list
    @Test
    public void testInsertCard() {
        User user = atmService.insertCard(String.valueOf(users.get(0).getCard().getId()));
        String actual = user.getName();
        String expected = "Alice";
        assertEquals(actual,expected);
    }

    //Tests to enter pin when the user has already entered pin three times should return that card is locked.
    @Test
    public void testEnterPinWhenLocked() {
        User user = users.get(0);
        user.getCard().setNrOfTries(3);
        String result = atmService.enterPin(user.getCard().getPin(), user.getCard().getId());
        assertEquals(result, "Your card is locked....");
    }

    //Tests to enter with pin when card is not locked
    @Test
    public void testEnterPinWhenNotLocked(){
        User user = users.get(0);
        String result = atmService.enterPin(user.getCard().getPin(), user.getCard().getId());
        String expected = "Welcome";
        assertEquals(result,expected);

    }

    //Tests to enter with pin and check balance should return users balance.
    @Test
    public void testEnterPinAndCheckBalance(){
        User user = users.get(0);
        String result = atmService.enterPin(user.getCard().getPin(), user.getCard().getId(), 1, 1);
        assertEquals(result,String.valueOf(user.getCard().getBalance()));

        }

    //Tests to enter with pin and deposit should return deposit succeded.
    @Test
    public void testEnterPinAndDeposit(){
        User user = users.get(0);
        String result = atmService.enterPin(user.getCard().getPin(), user.getCard().getId(), 2, 500);
        assertEquals(result,"Deposit succeeded");
    }

    //Test to enter with pin and withdraw money when balance is sufficent should return Withdraw succeeded
    @Test
    public void testEnterPinAndWithdraw(){
        User user = users.get(0);
        String result = atmService.enterPin(user.getCard().getPin(), user.getCard().getId(), 3, 400);
        assertEquals(result,"Withdraw succeeded");
    }

    //Test to enter with pin and withdraw more money than the user has in balance should return Withdraw failed insufficient balance
    @Test
    public void testEnterPinAndWithdrawTooMutch(){
        User user = users.get(0);
        //Sets users balance to 1000
        user.getCard().setBalance(1000);
        //Withdraws 1001
        String result = atmService.enterPin(user.getCard().getPin(), user.getCard().getId(), 3, 1001);
        assertEquals(result,"Withdraw failed insufficient balance");
    }

    //Test to enter with pin then quit Immediately should return Quitting

    @Test
    public void testEnterPinandQuit(){
        User user = users.get(0);
        String result = atmService.enterPin(user.getCard().getPin(), user.getCard().getId(), 4, 1001);
        assertEquals(result,"Quitting");
    }

    //Test to enter with wrong pin code should return Incorrect pin how many of 3 attempts left
    @Test
    public void testEnterWrongPin(){
        User user = users.get(0);
        String result = atmService.enterPin("32432432432", user.getCard().getId());
        assertEquals(result,"Incorrect Pin. " + user.getCard().getNrOfTries() + " of " + 3 + " tries left");

    }

    //Test to see if the ATM is connected to the right bank should return Handelsbanken
    @Test
    public void isConnectedToRightBank(){
        String result = atmService.displayBankName();
        String expected = "Handelsbanken";
        assertEquals(result, expected);
    }

    //Test to see if the atm can connect to another bank
    @Test
    public void connectToAnotherBank(){
        atmService.changeBankName("Nordea");
        String result = atmService.displayBankName();
        String expected = "Nordea";
        assertEquals(result, expected);
    }

    //Test to see if the user is locked when we know that he isn't
    @Test
    public void testIsLocked_whenUserIsNotLocked(){
        User user = users.get(0);
        assertFalse(atmService.isLocked(user));
    }

    //Test to see if the user is locked when we know that he is locked
    @Test
    public void testIsLocked_whenUserIsLocked(){
        User user = users.get(0);
        user.getCard().setNrOfTries(3);
        assertTrue(atmService.isLocked(user));
    }



}



