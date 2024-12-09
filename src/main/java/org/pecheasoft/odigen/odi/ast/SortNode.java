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

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang.StringUtils;
import org.pecheasoft.odigen.sql.util.TUtil;

/**
 *
 * @author Adi Neagu
 */
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)

public class SortNode extends UnaryNode implements MappingComponent {

    private List<SortSpec> attributes = TUtil.newList();
    private static final Logger LOG = Logger.getLogger(SortNode.class.getName());

    public SortNode() {
        super(NodeType.SORT);
    }

    public List<SortSpec> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<SortSpec> attributes) {
        this.attributes = attributes;
    }

    @Override
    public String toString() {
        return StringUtils.join(attributes, ",");
    }

    @JsonInclude(Include.NON_NULL)
    public static class SortSpec {

        private Attribute attr;
        private boolean asc;
        private boolean nullsFirst;

        public Attribute getAttr() {
            return attr;
        }

        public void setAttr(Attribute attr) {
            this.attr = attr;
        }

        public boolean isAsc() {
            return asc;
        }

        public void setAsc(boolean asc) {
            this.asc = asc;
        }

        public boolean isNullsFirst() {
            return nullsFirst;
        }

        public void setNullsFirst(boolean nullsFirst) {
            this.nullsFirst = nullsFirst;
        }

        @Override
        public String toString() {
            return StringUtils.join(new String[]{getAttributeExpression(attr), (isAsc() ? " ASC" : " DESC"), (isNullsFirst() ? " NULLS FIRST" : " NULLS LAST")});
        }

        private String getAttributeExpression(Attribute attr) {
            
            if (attr instanceof ColumnAttribute columnAttribute) {
                return columnAttribute.getQualifiedName();
            } else if (attr instanceof ExpressionAttribute expressionAttribute) {
                return expressionAttribute.getExpression();
            } else {
                LOG.log(Level.SEVERE, "Invalid attribute type for Sorter component");
                return null;
            }
        }

    }

}
