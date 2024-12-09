package org.pecheasoft.odigen.catalog;



public interface CatalogService {

    public enum ObjectType {
        Model,
        SubModel,
        Datastore, 
        DatastoreAttribute,
        Project,
        ProjectFolder,
        Mapping,
        ReusableMapping,
        Procedure,
        Package,
        Scenario,
        Variable,
        Sequence,
        GlobalSequence,
        GlobalVariable,
        LogicalSchema,
        DataType
    }

    boolean exists(String name, ObjectType type);
}
