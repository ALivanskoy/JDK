public class FrontEndDeveloper extends Developer implements FrontEndProgramming {

    @Override
    void drinkCoffee() {
        System.out.println("drinkCoffee");
    }

    @Override
    void smoke() {
        System.out.println("smoke");
    }

    @Override
    public void developGUI() {
        System.out.println("create GUI");
    }


}
