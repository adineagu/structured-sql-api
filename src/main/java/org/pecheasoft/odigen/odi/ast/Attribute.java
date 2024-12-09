/* 
 * Copyright 2017 DWH Tools.
 *
 * You may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://odieasy.com/11-licenses/eula
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.pecheasoft.odigen.odi.ast;

import java.util.Collection;

import org.pecheasoft.odigen.sql.util.annotation.Annotated;
import org.pecheasoft.odigen.sql.util.annotation.Annotation;
import org.pecheasoft.odigen.sql.util.annotation.impl.AnnotatedObject;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)

/**
 *
 * @author Adi Neagu
 */
public abstract class Attribute implements Annotated {

    private String name;
    private Integer position;
    private String alias;
    private AttributeType attrType;
    private Annotated annotated = new AnnotatedObject();

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public AttributeType getAttrType() {
        return attrType;
    }

    public void setAttrType(AttributeType attrType) {
        this.attrType = attrType;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Collection<Annotation> getAnnotations() {
        return this.annotated.getAnnotations();
    }

    @Override
    public void setAnnotations(Collection<Annotation> annotations) {
        this.annotated.setAnnotations(annotations);
    }

    public boolean isReusable(String annotationName) {
        return isAnnotatedWith("reusable");
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((position == null) ? 0 : position.hashCode());
        result = prime * result + ((alias == null) ? 0 : alias.hashCode());
        result = prime * result + ((attrType == null) ? 0 : attrType.hashCode());
        result = prime * result + ((annotated == null) ? 0 : annotated.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }

        Attribute other = (Attribute) obj;
        
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        if (position == null) {
            if (other.position != null) {
                return false;
            }
        } else if (!position.equals(other.position)) {
            return false;
        }
        if (alias == null) {
            if (other.alias != null) {
                return false;
            }
        } else if (!alias.equals(other.alias)) {
            return false;
        }
        if (attrType != other.attrType) {
            return false;
        }
        if (annotated == null) {
            if (other.annotated != null) {
                return false;
            }
        } else if (!annotated.equals(other.annotated)) {
            return false;
        }
        return true;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Attribute newAttribute = (Attribute) super.clone();
        newAttribute.name = name;
        newAttribute.position = position;
        newAttribute.alias = alias;
        newAttribute.attrType = attrType;
        newAttribute.annotated = (AnnotatedObject) annotated.clone();
        return newAttribute;
    }

}
