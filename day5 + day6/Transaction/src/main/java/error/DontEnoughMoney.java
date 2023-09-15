package error;

public class DontEnoughMoney extends RuntimeException {
    public DontEnoughMoney(String e){
        super(e);
    }

//    @Override
//    public String getMessage() {
//        return "Please check your balance" super.getMessage();
//    }
}
