public class TamagochiStateHappy implements TamagochiState{

    @Override
    public TamagochiState play() {
        return this;
    }

    @Override
    public TamagochiState getFood() {
        return new TamagochiStateTired();
    }

    @Override
    public TamagochiState goToSleep() {
        return new TamagochiStateHungry();
    }
}
