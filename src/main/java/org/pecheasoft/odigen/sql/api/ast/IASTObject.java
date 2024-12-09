/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pecheasoft.odigen.sql.api.ast;

import java.io.Serializable;

import org.pecheasoft.odigen.sql.util.annotation.Annotated;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *
 * @author Adi Neagu
 */
@JsonInclude(Include.NON_NULL)
public interface IASTObject extends Annotated, Serializable {

    String getName();

    default String getClassName() {
        return getClass().getSimpleName();
    }
    
    @JsonIgnore
    default String toJson() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(this);
        } catch (JsonProcessingException ex) {
            throw new RuntimeException(ex);
        }
    }
}
