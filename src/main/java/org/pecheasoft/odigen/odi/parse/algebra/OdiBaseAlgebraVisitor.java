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
package org.pecheasoft.odigen.odi.parse.algebra;

import java.util.Stack;

import org.pecheasoft.odigen.sql.parse.algebra.BaseAlgebraVisitor;
import org.pecheasoft.odigen.sql.parse.algebra.Expr;
import org.pecheasoft.odigen.sql.parse.algebra.OpType;
import org.pecheasoft.odigen.sql.parse.algebra.RelationList;

public class OdiBaseAlgebraVisitor<CONTEXT, RESULT> extends BaseAlgebraVisitor<CONTEXT, RESULT> implements OdiAlgebraVisitor<CONTEXT, RESULT> {

@Override
    public RESULT visit(CONTEXT ctx, Stack<Expr> stack, Expr expr) {
        preHook(ctx, stack, expr);

        RESULT current;

        if (expr == null) {
            throw new RuntimeException("Object cannot be null!");
        }

        switch ((Object) expr) {
            case LookupJoin lj ->
                current = visitLookupJoin(ctx, stack, lj);
            case CreateProject proj ->
                current = visitCreateProject(ctx, stack, proj);
            case CreateFolder fold ->
                current = visitCreateFolder(ctx, stack, fold);
            case CreateModel model ->
                current = visitCreateModel(ctx, stack, model);
            case CreateSubModel subm ->
                current = visitCreateSubModel(ctx, stack, subm);
            case DropProject proj ->
                current = visitDropProject(ctx, stack, proj);
            case DropFolder fold ->
                current = visitDropFolder(ctx, stack, fold);
            case DropModel model ->
                current = visitDropModel(ctx, stack, model);
            case DropSubModel subm ->
                current = visitDropSubModel(ctx, stack, subm);
            case CreatePackage pkg ->
                current = visitCreatePackage(ctx, stack, pkg);
            case DropPackage pkg ->
                current = visitDropPackage(ctx, stack, pkg);
            case CreateReusableMapping rm ->
                current = visitCreateReusableMapping(ctx, stack, rm);
            case CreateMapping m ->
                current = visitCreateMapping(ctx, stack, m);
            case DropMapping m ->
                current = visitDropMapping(ctx, stack, m);
            case TruncateMapping m ->
                current = visitTruncateMapping(ctx, stack, m);
            case DropReusableMapping rm ->
                current = visitDropReusableMapping(ctx, stack, rm);

            case CreateScenario sc ->
                current = visitCreateScenario(ctx, stack, sc);
            case PhysicalDesign pd ->
                current = visitPhysicalDesign(ctx, stack, pd);
            case KnowledgeModule km ->
                current = visitKnowledgeModule(ctx, stack, km);
            case PhysicalDesignList pdList ->
                current = visitPhysicalDesignList(ctx, stack, pdList);
            case OdiVariable odiVar ->
                current = visitOdiVariable(ctx, stack, odiVar);
            case OdiSequence odiSeq ->
                current = visitOdiSequence(ctx, stack, odiSeq);
            case AlterMapping am ->
                current = visitAlterMapping(ctx, stack, am);

            case DeclareVariablePackageStep pkgStep ->
                current = visitDeclareVariablePackageStep(ctx, stack, pkgStep);
            case RefreshVariablePackageStep pkgStep ->
                current = visitRefreshVariablePackageStep(ctx, stack, pkgStep);
            case SetVariablePackageStep pkgStep ->
                current = visitSetVariablePackageStep(ctx, stack, pkgStep);
            case MappingPackageStep pkgStep ->
                current = visitMappingPackageStep(ctx, stack, pkgStep);
            case ProcedurePackageStep pkgStep ->
                current = visitProcedurePackageStep(ctx, stack, pkgStep);
            case ScenarioAction scAction ->
                current = visitScenarioAction(ctx, stack, scAction);
            default ->
                current = super.visit(ctx, stack, expr);
        }

        // skip postHook against only one relation
        if (expr.getType() == OpType.RelationList) {
            RelationList relationList = (RelationList) expr;
            if (relationList.size() == 1 && relationList.getRelations()[0].getType() == OpType.Relation) {
                return current;
            }
        }

        postHook(ctx, stack, expr, current);
        return current;
    }

    @Override
    public RESULT visitLookupJoin(CONTEXT ctx, Stack<Expr> stack, LookupJoin expr) {
        RESULT result = null;

        stack.push(expr);

        if (expr.getSortExpr() != null) {
            result = visit(ctx, stack, expr.getSortExpr());
        }

        stack.pop();
        return result;
    }

    @Override
    public RESULT visitCreateMapping(CONTEXT ctx, Stack<Expr> stack, CreateMapping expr) {
        stack.push(expr);
        RESULT child = null;

        if (expr.hasStatements()) {
            for (Expr e : expr.getStatements()) {
                child = visit(ctx, stack, e);
            }
        }

        if (!expr.isReusable()) {
            visit(ctx, stack, expr.getPhysicalDesignList());
        }

        stack.pop();
        return child;
    }

    @Override
    public RESULT visitCreateReusableMapping(CONTEXT ctx, Stack<Expr> stack, CreateReusableMapping expr) {
        stack.push(expr);
        RESULT child = null;

        if (expr.hasSubQuery()) {
            child = visit(ctx, stack, expr.getSubQuery());
        }
        stack.pop();
        return child;
    }

    @Override
    public RESULT visitDropMapping(CONTEXT ctx, Stack<Expr> stack, DropMapping expr) {
        return null;
    }

    @Override
    public RESULT visitTruncateMapping(CONTEXT ctx, Stack<Expr> stack, TruncateMapping expr) {
        return null;
    }

    @Override
    public RESULT visitDropReusableMapping(CONTEXT ctx, Stack<Expr> stack, DropReusableMapping expr) {
        return null;
    }

    @Override
    public RESULT visitOdiVariable(CONTEXT ctx, Stack<Expr> stack, OdiVariable expr) {
        return null;
    }

    @Override
    public RESULT visitOdiSequence(CONTEXT ctx, Stack<Expr> stack, OdiSequence expr) {
        return null;
    }

    @Override
    public RESULT visitKnowledgeModule(CONTEXT ctx, Stack<Expr> stack, KnowledgeModule expr) {
        return null;
    }

    @Override
    public RESULT visitPhysicalDesignList(CONTEXT ctx, Stack<Expr> stack, PhysicalDesignList expr) {
        for (PhysicalDesign pd : expr.getPhysicalDesigns()) {
            visit(ctx, stack, pd);
        }
        return null;
    }

    @Override
    public RESULT visitPhysicalDesign(CONTEXT ctx, Stack<Expr> stack, PhysicalDesign expr) {
        stack.push(expr);
        for (KnowledgeModule xkm : expr.getXkms()) {
            visit(ctx, stack, xkm);
        }

        for (KnowledgeModule lkm : expr.getLkms()) {
            visit(ctx, stack, lkm);
        }

        for (KnowledgeModule ikm : expr.getIkms()) {
            visit(ctx, stack, ikm);
        }

        for (KnowledgeModule ckm : expr.getCkms()) {
            visit(ctx, stack, ckm);
        }
        stack.pop();

        return null;
    }

    @Override
    public RESULT visitCreateScenario(CONTEXT ctx, Stack<Expr> stack, CreateScenario createScenario) {
        return null;
    }

    @Override
    public RESULT visitCreateProject(CONTEXT ctx, Stack<Expr> stack, CreateProject expr) {
        return null;
    }

    @Override
    public RESULT visitCreateFolder(CONTEXT ctx, Stack<Expr> stack, CreateFolder expr) {
        return null;
    }

    @Override
    public RESULT visitCreateModel(CONTEXT ctx, Stack<Expr> stack, CreateModel expr) {
        return null;
    }

    @Override
    public RESULT visitCreateSubModel(CONTEXT ctx, Stack<Expr> stack, CreateSubModel expr) {
        return null;
    }

    @Override
    public RESULT visitDropProject(CONTEXT ctx, Stack<Expr> stack, DropProject expr) {
        return null;
    }

    @Override
    public RESULT visitDropFolder(CONTEXT ctx, Stack<Expr> stack, DropFolder expr) {
        return null;
    }

    @Override
    public RESULT visitDropModel(CONTEXT ctx, Stack<Expr> stack, DropModel expr) {
        return null;
    }

    @Override
    public RESULT visitDropSubModel(CONTEXT ctx, Stack<Expr> stack, DropSubModel expr) {
        return null;
    }

    @Override
    public RESULT visitAlterMapping(CONTEXT ctx, Stack<Expr> stack, AlterMapping expr) {
        return null;
    }

    @Override
    public RESULT visitCreatePackage(CONTEXT ctx, Stack<Expr> stack, CreatePackage expr) {
        for (Expr step : expr.getStepsList()) {
            visit(ctx, stack, step);
        }
        return null;
    }

    @Override
    public RESULT visitDropPackage(CONTEXT ctx, Stack<Expr> stack, DropPackage expr) {
        return null;
    }

    @Override
    public RESULT visitScenarioAction(CONTEXT ctx, Stack<Expr> stack, ScenarioAction expr) {
        return null;
    }

    @Override
    public RESULT visitDeclareVariablePackageStep(CONTEXT ctx, Stack<Expr> stack, DeclareVariablePackageStep expr) {
        return null;
    }

    @Override
    public RESULT visitRefreshVariablePackageStep(CONTEXT ctx, Stack<Expr> stack, RefreshVariablePackageStep expr) {
        return null;
    }

    @Override
    public RESULT visitSetVariablePackageStep(CONTEXT ctx, Stack<Expr> stack, SetVariablePackageStep expr) {
        return null;
    }

    @Override
    public RESULT visitMappingPackageStep(CONTEXT ctx, Stack<Expr> stack, MappingPackageStep expr) {
        return null;
    }

    @Override
    public RESULT visitProcedurePackageStep(CONTEXT ctx, Stack<Expr> stack, ProcedurePackageStep expr) {
        return null;
    }

}
