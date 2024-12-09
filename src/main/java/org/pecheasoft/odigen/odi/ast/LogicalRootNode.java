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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)

public class LogicalRootNode extends UnaryNode {
    
  public LogicalRootNode() {
    super(NodeType.ROOT);
  }
  
  public LogicalRootNode(int pid) {
    super(pid, NodeType.ROOT);
  }
  
  @Override
  public String toString() {
    return "Logical Plan Root\n\n" + getChild().toString();
  }
  
}
