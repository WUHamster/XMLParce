package Home2_1;

/**
 * Created by WUHamster on 31.05.2016.
 */
public class Main {
    public static void main(String[] args) {
        String path = "Trains.xml";

        TrainParser parser = new TrainParser();
        parser.parseTrain(path);

        Loader loader = new Loader();
        loader.loadNewTrain(path);
    }
}
