package org.pecheasoft.odigen.odi.parse.algebra;

import java.util.Stack;

import org.pecheasoft.odigen.sql.parse.algebra.AlgebraVisitor;
import org.pecheasoft.odigen.sql.parse.algebra.Expr;

public interface OdiAlgebraVisitor<CONTEXT, RESULT> extends AlgebraVisitor<CONTEXT, RESULT> {

  RESULT visitAlterMapping(CONTEXT ctx, Stack<Expr> stack, AlterMapping expr);
  RESULT visitCreateMapping(CONTEXT ctx, Stack<Expr> stack, CreateMapping expr);
  RESULT visitDropMapping(CONTEXT ctx, Stack<Expr> stack, DropMapping expr);
  RESULT visitTruncateMapping(CONTEXT ctx, Stack<Expr> stack, TruncateMapping expr);
  RESULT visitDropReusableMapping(CONTEXT ctx, Stack<Expr> stack, DropReusableMapping expr);
  RESULT visitDropPackage(CONTEXT ctx, Stack<Expr> stack, DropPackage expr);
  RESULT visitCreateReusableMapping(CONTEXT ctx, Stack<Expr> stack, CreateReusableMapping expr);
  RESULT visitCreateScenario(CONTEXT ctx, Stack<Expr> stack, CreateScenario expr);
  RESULT visitPhysicalDesignList(CONTEXT ctx, Stack<Expr> stack, PhysicalDesignList expr);
  RESULT visitPhysicalDesign(CONTEXT ctx, Stack<Expr> stack, PhysicalDesign expr);
  RESULT visitKnowledgeModule(CONTEXT ctx, Stack<Expr> stack, KnowledgeModule expr);
  RESULT visitOdiVariable(CONTEXT ctx, Stack<Expr> stack, OdiVariable expr);
  RESULT visitOdiSequence(CONTEXT ctx, Stack<Expr> stack, OdiSequence expr);
  RESULT visitCreateProject(CONTEXT ctx, Stack<Expr> stack, CreateProject expr);
  RESULT visitCreateFolder(CONTEXT ctx, Stack<Expr> stack, CreateFolder expr);
  RESULT visitCreateModel(CONTEXT ctx, Stack<Expr> stack, CreateModel expr);
  RESULT visitCreateSubModel(CONTEXT ctx, Stack<Expr> stack, CreateSubModel expr);
  RESULT visitDropProject(CONTEXT ctx, Stack<Expr> stack, DropProject expr);
  RESULT visitDropFolder(CONTEXT ctx, Stack<Expr> stack, DropFolder expr);
  RESULT visitDropModel(CONTEXT ctx, Stack<Expr> stack, DropModel expr);
  RESULT visitDropSubModel(CONTEXT ctx, Stack<Expr> stack, DropSubModel expr);  
  RESULT visitCreatePackage(CONTEXT ctx, Stack<Expr> stack, CreatePackage expr);
  RESULT visitDeclareVariablePackageStep(CONTEXT ctx, Stack<Expr> stack, DeclareVariablePackageStep expr);
  RESULT visitRefreshVariablePackageStep(CONTEXT ctx, Stack<Expr> stack, RefreshVariablePackageStep expr);
  RESULT visitSetVariablePackageStep(CONTEXT ctx, Stack<Expr> stack, SetVariablePackageStep expr);  
  RESULT visitMappingPackageStep(CONTEXT ctx, Stack<Expr> stack, MappingPackageStep expr);  
  RESULT visitProcedurePackageStep(CONTEXT ctx, Stack<Expr> stack, ProcedurePackageStep expr);  
  RESULT visitScenarioAction(CONTEXT ctx, Stack<Expr> stack, ScenarioAction expr); 
  RESULT visitLookupJoin(CONTEXT ctx, Stack<Expr> stack, LookupJoin expr); 
  
}
