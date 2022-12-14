
public class atmService {

    private bankService bankService;

    public atmService(bankService bankService) {
        this.bankService = bankService;
    }

    //InsertCard
    public User insertCard(String idNr) {
        User user = bankService.getUser(Integer.parseInt(idNr));
        if(isLocked(user)){
            return null;
        }else{
            return user;
        }

    }

    //Display the bank connected to ATM
    public String displayBankName() {
        return bankService.getBankName();
    }

    //Change the bank that should be connected to ATM
    public void changeBankName(String newBankName){
        bankService.setBankName(newBankName);
    }


    //enterPin
    public String enterPin(String pin, String idNr, int option, double _amount){
        User user = bankService.getUser(Integer.parseInt(idNr));
        if(isLocked(user)){
            return "Your card is locked....";
        }else{
            if(pin.equals(user.card.getPin())){
                int ans = option;
                switch (ans){
                    case 1:
                        return (String.valueOf(user.getCard().getBalance()));
                    case 2:
                        double amount = _amount;
                        deposit(amount, user.getCard().getId());
                        return "Deposit succeeded";
                    case 3:
                        double amount2 = _amount;
                        if(withdraw(amount2, user.getCard().getId())){
                            return "Withdraw succeeded";
                        }else{
                            return "Withdraw failed insufficient balance";
                        }
                    case 4:
                        return "Quitting";
                }
            }else{
                user.getCard().setNrOfTries(user.getCard().getNrOfTries() + 1);
                return "Incorrect Pin " + (3 - user.getCard().getNrOfTries()) + ". Attempt left.";
            }
                return null;
        }
    }

    //enterPin only
    public String enterPin(String pin, String idNr){
        User user = bankService.getUser(Integer.parseInt(idNr));
        if(isLocked(user)){
            return "Your card is locked....";
        }else{
            if(pin.equals(user.card.getPin())){
                return "Welcome";
            }else{
                user.getCard().setNrOfTries(user.getCard().getNrOfTries() + 1);
                return "Incorrect Pin. " + user.getCard().getNrOfTries() + " of " + 3 + " tries left";
            }
        }
    }

    //checkCardStatus
    public boolean isLocked(User user){
        if(user.getCard().getNrOfTries() == 3){
            return true;
        }
        return false;
    }

    //checkBalance
    public double checkBalance(String idNr){
        User user = bankService.getUser(Integer.parseInt(idNr));
        return user.getCard().getBalance();
    }


    //Deposit
    public void deposit(double amount, String idNr){
        User user = bankService.getUser(Integer.parseInt(idNr));
        user.getCard().setBalance(user.getCard().getBalance() + amount);
    }



    //Withdraw
    public boolean withdraw(double amount, String idNr){
        User user = bankService.getUser(Integer.parseInt(idNr));
        if(user.getCard().getBalance() > amount){
            user.getCard().setBalance(user.getCard().getBalance() - amount);
            return true;
        }else{
            return false;
        }
    }


}
