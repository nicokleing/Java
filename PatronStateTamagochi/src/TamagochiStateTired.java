public class TamagochiStateTired implements TamagochiState{
    @Override
    public TamagochiState play() {
        return this;
    }

    @Override
    public TamagochiState getFood() {
        return this;
    }

    @Override
    public TamagochiState goToSleep() {
        return new TamagochiStateHappy();
    }
}
