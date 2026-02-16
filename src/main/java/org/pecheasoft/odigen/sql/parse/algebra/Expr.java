/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with this
 * work for additional information regarding copyright ownership. The ASF
 * licenses this file to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.pecheasoft.odigen.sql.parse.algebra;

import java.util.Collection;

import org.pecheasoft.odigen.sql.util.annotation.Annotated;
import org.pecheasoft.odigen.sql.util.annotation.Annotation;
import org.pecheasoft.odigen.sql.util.annotation.impl.AnnotatedObject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonInclude(Include.NON_NULL)
public abstract class Expr implements JsonSerializable, Cloneable, Annotated {

    private String text;
    private Annotated annotated = new AnnotatedObject();

    @Override
    public Collection<Annotation> getAnnotations() {
        return this.annotated.getAnnotations();
    }

    @Override
    public void setAnnotations(Collection<Annotation> annotations) {
        this.annotated.setAnnotations(annotations);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Expr newExpr = (Expr) super.clone();
        newExpr.annotated = (Annotated) annotated.clone();
        return newExpr;
    }

    @Override
    public String toString() {
        return toJson();
    }

    /**
     * This method provides a visiting way in the post order.
     * @param visitor
     */
    public void accept(ExprVisitor visitor) {
        if (this instanceof UnaryOperator unary) {
            unary.getChild().accept(visitor);
        } else if (this instanceof BinaryOperator bin) {
            bin.getLeft().accept(visitor);
            bin.getRight().accept(visitor);
        }

        visitor.visit(this);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
    public String getClassName() {
        return getClass().getSimpleName();
    }
    
    @JsonIgnore
    @Override
    public String toJson() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(this);
        } catch (JsonProcessingException ex) {
            throw new RuntimeException(ex);
        }
    }
}
