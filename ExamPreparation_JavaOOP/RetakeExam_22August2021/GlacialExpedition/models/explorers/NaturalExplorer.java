package glacialExpedition.models.explorers;

public class NaturalExplorer extends BaseExplorer {

    private static double ENERGY = 60;

    public NaturalExplorer(String name) {
        super(name, ENERGY);
    }

    @Override
    public void search() {
        double decreaseUnitsNaturalExplorer = 7;
        if (ENERGY >= decreaseUnitsNaturalExplorer) {
            ENERGY -= decreaseUnitsNaturalExplorer;
        } else {
            ENERGY = 0;
        }
    }
}
