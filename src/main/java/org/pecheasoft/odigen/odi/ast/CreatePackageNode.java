/*
 * Copyright 2018 DWH Tools.
 *
 * You may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.odieasy.com/11-licenses/eula
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.pecheasoft.odigen.odi.ast;

import java.util.List;

import org.pecheasoft.odigen.odi.parse.algebra.PackageStepLink;
import org.pecheasoft.odigen.sql.parse.algebra.Expr;
import org.pecheasoft.odigen.sql.util.TUtil;
import org.pecheasoft.odigen.sql.util.graph.SimpleDirectedGraph;

/**
 *
 * @author Adi Neagu
 */
public class CreatePackageNode extends MultiaryNode {

    private final String qualifiedName;
    private final boolean ifNotExist;
    private final boolean replace;
    private final List<Expr> stepsList = TUtil.newList();
    private final SimpleDirectedGraph<Expr, PackageStepLink> graph = new SimpleDirectedGraph<>();

    public CreatePackageNode(String qualifiedName, boolean ifNotExist, boolean replace) {
        super(NodeType.CREATE_PACKAGE);
        this.qualifiedName = qualifiedName;
        this.ifNotExist = ifNotExist;
        this.replace = replace;
    }

    public String getQualifiedName() {
        return qualifiedName;
    }

    public boolean isIfNotExist() {
        return ifNotExist;
    }

    public boolean isReplace() {
        return replace;
    }

    public SimpleDirectedGraph<Expr, PackageStepLink> getGraph() {
        return graph;
    }

    public List<Expr> getStepsList() {
        return stepsList;
    }
}
