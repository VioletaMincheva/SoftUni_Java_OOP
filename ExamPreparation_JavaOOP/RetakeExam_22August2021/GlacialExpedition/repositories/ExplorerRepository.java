package glacialExpedition.repositories;

import glacialExpedition.models.explorers.Explorer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ExplorerRepository implements Repository<Explorer> {
    private final Collection<Explorer> explorers;

    public ExplorerRepository() {
        this.explorers = new ArrayList<>();
    }

    @Override
    public Collection<Explorer> getCollection() {
        return Collections.unmodifiableCollection(this.explorers);
    }

    @Override
    public void add(Explorer entity) {
        if (this.explorers.stream().noneMatch(e -> e.getName().equals(entity.getName()))) {
            this.explorers.add(entity);
        }else {
            System.out.print("There is Explorer with the same name");
        }
    }

    @Override
    public boolean remove(Explorer entity) {
        return this.explorers.remove(entity);
    }


    @Override
    public Explorer byName(String name) {
        return this.explorers.stream().filter(e -> e.getName().equals(name)).findFirst().orElse(null);
    }
}
