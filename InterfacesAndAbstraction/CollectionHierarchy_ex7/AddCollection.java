package InterfacesAndAbstraction.CollectionHierarchy_ex7;

public class AddCollection extends Collection implements Addable {

    @Override
    public int add(String item) {
        //add item to the end of the collection
        this.getItems().add(item);
        return this.getItems().size() - 1;
    }
}
