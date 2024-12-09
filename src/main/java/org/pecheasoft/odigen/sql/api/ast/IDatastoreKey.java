/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pecheasoft.odigen.sql.api.ast;

import java.util.Collection;

/**
 *
 * @author Adi Neagu
 */
public interface IDatastoreKey extends IDatastoreConstraint {    
    String getKeyType();

    default Collection<String> getKeyColumns() {
        return null;
    }
    
    default Boolean isPrimaryKey() {
        return false;
    }

    default Boolean isAlternateKey() {
        return false;
    }

    default Boolean isReferenceKey() {
        return false;
    }

    default Boolean isUniqueIndex() {
        return false;
    }

    boolean isNonUniqueIndex();
}
