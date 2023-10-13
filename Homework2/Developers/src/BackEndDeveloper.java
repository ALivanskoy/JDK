public class BackEndDeveloper extends Developer implements BackEndProgramming {

    @Override
    void drinkCoffee() {
        System.out.println("drinkCoffee");
    }

    @Override
    void smoke() {
        System.out.println("smoke");
    }


    @Override
    public void developAPI() {
        System.out.println("developing API hard as we can");
    }
}
