package org.pecheasoft.odigen.catalog;

public class DefaultCatalogService implements CatalogService {

    @Override
    public boolean exists(String name, ObjectType type) {
        return true;
    }

}
