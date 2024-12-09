/*
 * Copyright 2016 Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.pecheasoft.odigen.odi.ast;

import org.pecheasoft.odigen.odi.parse.algebra.ScenarioAction;

/**
 *
 * @author Adi Neagu
 */


public class ScenarioActionNode extends LogicalNode {

    public ScenarioActionNode(ScenarioAction expr) {
        super(NodeType.SCENARIO_ACTION);
    }
        
    @Override
    public int childNum() {
        return 0;
    }

    @Override
    public LogicalNode getChild(int idx) {
        return null;
    }

    @Override
    public void preOrder(LogicalNodeVisitor visitor) {        
    }

    @Override
    public void postOrder(LogicalNodeVisitor visitor) {        
    }
    
}
