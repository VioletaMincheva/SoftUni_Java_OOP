package viceCity.repositories.interfaces;

import viceCity.models.guns.Gun;

import java.util.Collection;
import java.util.Collections;

public class GunRepository implements Repository {
    private Collection<Gun> models;

    @Override
    public Collection<Gun> getModels() {
        return Collections.unmodifiableCollection(this.models);
    }

    @Override
    public void add(Object model) {

    }

    @Override
    public boolean remove(Object model) {
        return false;
    }

    @Override
    public Object find(String name) {
        return null;
    }
}
