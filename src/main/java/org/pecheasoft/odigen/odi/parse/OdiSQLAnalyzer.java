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

package org.pecheasoft.odigen.odi.parse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import org.pecheasoft.odigen.odi.parse.OdiConstants.OdiObjectType;
import org.pecheasoft.odigen.odi.parse.algebra.AbstractPackageStep;
import org.pecheasoft.odigen.odi.parse.algebra.AlterMapping;
import org.pecheasoft.odigen.odi.parse.algebra.CreateFolder;
import org.pecheasoft.odigen.odi.parse.algebra.CreateMapping;
import org.pecheasoft.odigen.odi.parse.algebra.CreateModel;
import org.pecheasoft.odigen.odi.parse.algebra.CreatePackage;
import org.pecheasoft.odigen.odi.parse.algebra.CreateProject;
import org.pecheasoft.odigen.odi.parse.algebra.CreateScenario;
import org.pecheasoft.odigen.odi.parse.algebra.CreateSubModel;
import org.pecheasoft.odigen.odi.parse.algebra.DropFolder;
import org.pecheasoft.odigen.odi.parse.algebra.DropMapping;
import org.pecheasoft.odigen.odi.parse.algebra.DropModel;
import org.pecheasoft.odigen.odi.parse.algebra.DropPackage;
import org.pecheasoft.odigen.odi.parse.algebra.DropProject;
import org.pecheasoft.odigen.odi.parse.algebra.DropReusableMapping;
import org.pecheasoft.odigen.odi.parse.algebra.DropSubModel;
import org.pecheasoft.odigen.odi.parse.algebra.KnowledgeModule;
import org.pecheasoft.odigen.odi.parse.algebra.LookupJoin;
import org.pecheasoft.odigen.odi.parse.algebra.MappingPackageStep;
import org.pecheasoft.odigen.odi.parse.algebra.OdiJoin;
import org.pecheasoft.odigen.odi.parse.algebra.OdiScenarioStartVariable;
import org.pecheasoft.odigen.odi.parse.algebra.OdiSequence;
import org.pecheasoft.odigen.odi.parse.algebra.OdiVariable;
import org.pecheasoft.odigen.odi.parse.algebra.PackageStep;
import org.pecheasoft.odigen.odi.parse.algebra.PhysicalDesign;
import org.pecheasoft.odigen.odi.parse.algebra.PhysicalDesignList;
import org.pecheasoft.odigen.odi.parse.algebra.ScenarioAction;
import org.pecheasoft.odigen.odi.parse.algebra.TruncateMapping;
import org.pecheasoft.odigen.sql.parse.SQLAnalyzer;
import org.pecheasoft.odigen.sql.parse.algebra.ColumnReferenceExpr;
import org.pecheasoft.odigen.sql.parse.algebra.Expr;
import org.pecheasoft.odigen.sql.parse.algebra.Insert;
import org.pecheasoft.odigen.sql.parse.algebra.Join;
import org.pecheasoft.odigen.sql.parse.algebra.Join.JoinType;
import org.pecheasoft.odigen.sql.parse.algebra.LiteralValue.LiteralType;
import org.pecheasoft.odigen.sql.parse.algebra.Sort;
import org.pecheasoft.odigen.sql.parser.SQLParser;
import org.pecheasoft.odigen.sql.parser.SQLParser.Alter_mapping_statementContext;
import org.pecheasoft.odigen.sql.parser.SQLParser.Create_complex_mappingContext;
import org.pecheasoft.odigen.sql.parser.SQLParser.Create_folder_statementContext;
import org.pecheasoft.odigen.sql.parser.SQLParser.Create_model_statementContext;
import org.pecheasoft.odigen.sql.parser.SQLParser.Create_package_statementContext;
import org.pecheasoft.odigen.sql.parser.SQLParser.Create_project_statementContext;
import org.pecheasoft.odigen.sql.parser.SQLParser.Create_scenario_statementContext;
import org.pecheasoft.odigen.sql.parser.SQLParser.Create_simple_mappingContext;
import org.pecheasoft.odigen.sql.parser.SQLParser.Create_submodel_statementContext;
import org.pecheasoft.odigen.sql.parser.SQLParser.Drop_folder_statementContext;
import org.pecheasoft.odigen.sql.parser.SQLParser.Drop_model_statementContext;
import org.pecheasoft.odigen.sql.parser.SQLParser.Drop_package_statementContext;
import org.pecheasoft.odigen.sql.parser.SQLParser.Drop_project_statementContext;
import org.pecheasoft.odigen.sql.parser.SQLParser.Drop_reusable_mapping_statementContext;
import org.pecheasoft.odigen.sql.parser.SQLParser.Drop_scenario_statementContext;
import org.pecheasoft.odigen.sql.parser.SQLParser.Drop_submodel_statementContext;
import org.pecheasoft.odigen.sql.parser.SQLParser.Export_scenario_statementContext;
import org.pecheasoft.odigen.sql.parser.SQLParser.Generic_package_statementContext;
import org.pecheasoft.odigen.sql.parser.SQLParser.Import_scenario_statementContext;
import org.pecheasoft.odigen.sql.parser.SQLParser.Km_target_itemContext;
import org.pecheasoft.odigen.sql.parser.SQLParser.Lookup_specificationContext;
import org.pecheasoft.odigen.sql.parser.SQLParser.Mapping_commandContext;
import org.pecheasoft.odigen.sql.parser.SQLParser.Odi_sequenceContext;
import org.pecheasoft.odigen.sql.parser.SQLParser.Odi_variable_literalContext;
import org.pecheasoft.odigen.sql.parser.SQLParser.Outer_join_type_part2Context;
import org.pecheasoft.odigen.sql.parser.SQLParser.Phys_designContext;
import org.pecheasoft.odigen.sql.parser.SQLParser.Phys_design_clauseContext;
import org.pecheasoft.odigen.sql.parser.SQLParser.Procedure_statementContext;
import org.pecheasoft.odigen.sql.parser.SQLParser.Regenerate_scenario_statementContext;
import org.pecheasoft.odigen.sql.parser.SQLParser.Scenario_variableContext;
import org.pecheasoft.odigen.sql.parser.SQLParser.Truncate_mapping_statementContext;
import org.pecheasoft.odigen.sql.parser.SQLParser.Truncate_reusable_mapping_statementContext;
import org.pecheasoft.odigen.sql.parser.SQLParser.Xkm_clauseContext;
import org.pecheasoft.odigen.sql.util.CatalogConstants;
import org.pecheasoft.odigen.sql.util.CatalogUtil;

public class OdiSQLAnalyzer extends SQLAnalyzer {

    public OdiSQLAnalyzer() {
    }

    @Override
    public Join visitJoined_table_primary(SQLParser.Joined_table_primaryContext ctx) {
        OdiJoin join;
        if (ctx.CROSS() != null) {
            join = new OdiJoin(JoinType.CROSS);
        } else if (ctx.UNION() != null) {
            join = new OdiJoin(JoinType.UNION);
        } else { // qualified join or natural
            if (ctx.join_type() != null && ctx.join_type().outer_join_type() != null) {
                Outer_join_type_part2Context outer_join_typeContext = ctx.join_type().outer_join_type()
                        .outer_join_type_part2();
                if (outer_join_typeContext.FULL() != null) {
                    join = new OdiJoin(JoinType.FULL_OUTER);
                } else if (outer_join_typeContext.LEFT() != null) {
                    join = new OdiJoin(JoinType.LEFT_OUTER);
                } else {
                    join = new OdiJoin(JoinType.RIGHT_OUTER);
                }
            } else {
                join = new OdiJoin(JoinType.INNER);
            }

            if (ctx.NATURAL() != null) {
                join.setNatural();
            }

            if (ctx.join_specification() != null) { // only for qualified join
                if (ctx.join_specification().join_condition() != null) {
                    Expr searchCondition = visitSearch_condition(ctx.join_specification().
                            join_condition().search_condition());
                    join.setQual(searchCondition);
                    join.setText(getRuleText(ctx.join_specification().join_condition().search_condition()));
                } else if (ctx.join_specification().named_columns_join() != null) {
                    ColumnReferenceExpr[] columns = buildColumnReferenceList(ctx.join_specification().
                            named_columns_join().column_reference_list());
                    join.setJoinColumns(columns);
                    join.setText(getRuleText(ctx.join_specification().
                            named_columns_join().column_reference_list()));
                }
                
                if (ctx.join_specification().lookup_specification() != null) {
                    LookupJoin lkpJoin = new LookupJoin();
                    Lookup_specificationContext lkpCtx = ctx.join_specification().lookup_specification();
                    
                    if (checkIfExist(lkpCtx.orderby_clause())) {
                        Sort sort = visitOrderby_clause(lkpCtx.orderby_clause());
                        lkpJoin.setSortExpr(sort);
                    }
                    
                    if (lkpCtx.first_row() != null) {
                        lkpJoin.setMatchRowRule(LookupJoin.LookupMatchRowRule.FIRST_ROW);
                    } else if (lkpCtx.all_rows() != null) {
                        lkpJoin.setMatchRowRule(LookupJoin.LookupMatchRowRule.ALL_ROWS);
                    } else if (lkpCtx.last_row() != null) {
                        lkpJoin.setMatchRowRule(LookupJoin.LookupMatchRowRule.LAST_ROW);
                    }
                    
                    join.setLookup(lkpJoin);
                }
            }                        

        }

        //join.setRight(visitTable_primary(ctx.right));
        join.setRight(visitJoined_table(ctx.right));
        return join;
    }


    @Override
    public Expr visitCreate_model_statement(Create_model_statementContext ctx) {
        CreateModel model;
        if (checkIfExist(ctx.name)) {
            model = new CreateModel(ctx.code.getText(), ctx.name.getText(), ctx.schema.getText(), ctx.context.getText());
        } else {
            model = new CreateModel(ctx.code.getText(), ctx.schema.getText(), ctx.context.getText());
        }
        model.setIfNotExists(checkIfExist(ctx.if_not_exists()));
        return model;
    }

    @Override
    public Expr visitCreate_project_statement(Create_project_statementContext ctx) {
        CreateProject project;
        if (checkIfExist(ctx.name)) {
            project = new CreateProject(ctx.code.getText(), ctx.name.getText());
        } else {
            project = new CreateProject(ctx.code.getText());
        }
        project.setIfNotExists(checkIfExist(ctx.if_not_exists()));
        return project;
    }

    @Override
    public Expr visitDrop_model_statement(Drop_model_statementContext ctx) {
        DropModel model = new DropModel(ctx.code.getText());
        model.setIfExists(checkIfExist(ctx.if_exists()));
        model.setCascade(checkIfExist(ctx.CASCADE()));
            
        return model;
    }
    
    @Override
    public Expr visitDrop_project_statement(Drop_project_statementContext ctx) {
        DropProject project = new DropProject(ctx.code.getText());
        project.setIfExists(checkIfExist(ctx.if_exists()));
        project.setCascade(checkIfExist(ctx.CASCADE()));
        
        return project;
    }

    @Override
    public Expr visitCreate_folder_statement(Create_folder_statementContext ctx) {
        CreateFolder createFolder = new CreateFolder(ctx.folder_name().getText());
        createFolder.setIfNotExists(checkIfExist(ctx.if_not_exists()));
        
        return createFolder;
    }

    @Override
    public Expr visitDrop_folder_statement(Drop_folder_statementContext ctx) {
        return new DropFolder(ctx.folder_name().getText(), checkIfExist(ctx.if_exists()), checkIfExist(ctx.CASCADE()));
    }

    @Override
    public Expr visitCreate_submodel_statement(Create_submodel_statementContext ctx) {
        CreateSubModel createSubModel;
        
        if (checkIfExist(ctx.name)) {
            createSubModel = new CreateSubModel(ctx.folder_name().getText(), ctx.name.getText());
        } else {
            createSubModel = new CreateSubModel(ctx.folder_name().getText());
        }
        
        createSubModel.setIfNotExists(checkIfExist(ctx.if_not_exists()));
        return createSubModel;
    }
        
    @Override
    public Expr visitDrop_submodel_statement(Drop_submodel_statementContext ctx) {
        return new DropSubModel(ctx.folder_name().getText(), checkIfExist(ctx.if_exists()), checkIfExist(ctx.CASCADE()));
    }
    

    @Override
    public Expr visitAlter_mapping_statement(Alter_mapping_statementContext ctx) {
        String mappingName = ctx.mapping_name().getText();
        AlterMapping alterMapping = new AlterMapping(mappingName, checkIfExist(ctx.if_exists()));
        if (checkIfExist(ctx.phys_design_clause())) {
            PhysicalDesignList physDesigns = (PhysicalDesignList) visitPhys_design_clause(ctx.phys_design_clause());
            alterMapping.setPhysicalDesignList(physDesigns);
        }   
        
        if (checkIfExist(ctx.comm)) {
            alterMapping.setComment(stripQuote(ctx.comm.getText()));
        }
        
        alterMapping.setReusable(checkIfExist(ctx.REUSABLE()));

        return alterMapping;
    }
    
    @Override
    public Expr visitCreate_mapping_statement(SQLParser.Create_mapping_statementContext ctx) {

        if (checkIfExist(ctx.create_simple_mapping())) {
            return visitCreate_simple_mapping(ctx.create_simple_mapping());
        } else if (checkIfExist(ctx.create_complex_mapping())) {
            return visitCreate_complex_mapping(ctx.create_complex_mapping());
        } else {
            return null;
        }
    }

    @Override
    public Expr visitCreate_simple_mapping(Create_simple_mappingContext ctx) {
        String mappingName = ctx.mapping_name().getText();
        CreateMapping createMapping = new CreateMapping(mappingName, checkIfExist(ctx.or_replace()), checkIfExist(ctx.if_not_exists()));

        if (checkIfExist(ctx.insert_statement())) {
            Expr insert = this.visitInsert_statement(ctx.insert_statement());

            if (checkIfExist(ctx.REUSABLE())) {
               createMapping.setReusable(true);
               ((Insert) insert).setReusableMappingSignature(true);
            }
       
            createMapping.addStatement(insert);
        } else if (checkIfExist(ctx.multi_insert_statement())) {
            Expr insert = this.visitMulti_insert_statement(ctx.multi_insert_statement());
            createMapping.addStatement(insert);
        }

        if (ctx.param_clause() != null) {
            Map<String, String> params = escapeTableMeta(getParams(ctx.param_clause()));
            createMapping.setParams(params);
        }
        
        if (checkIfExist(ctx.staging_location())) {
            createMapping.setStagingLocation(ctx.staging_location().name.getText());
        }

        if (checkIfExist(ctx.phys_design_clause())) {
            PhysicalDesignList physDesigns = (PhysicalDesignList) visitPhys_design_clause(ctx.phys_design_clause());
            createMapping.setPhysicalDesignList(physDesigns);
        }
         
        return createMapping;
    }

    @Override
    public Expr visitCreate_complex_mapping(Create_complex_mappingContext ctx) {
        String mappingName = ctx.mapping_name().getText();
        CreateMapping createMapping = new CreateMapping(mappingName, checkIfExist(ctx.or_replace()), checkIfExist(ctx.if_not_exists()));

        if (checkIfExist(ctx.mapping_statements_block()) && checkIfExist(ctx.mapping_statements_block().insert_statement())) {
            ctx.mapping_statements_block().insert_statement().forEach(is -> {
                Expr insert = this.visitInsert_statement(is);
                createMapping.addStatement(insert);
            });
        }

        if (checkIfExist(ctx.mapping_statements_block()) && checkIfExist(ctx.mapping_statements_block().multi_insert_statement())) {
            ctx.mapping_statements_block().multi_insert_statement().forEach(is -> {
                Expr insert = this.visitMulti_insert_statement(is);
                createMapping.addStatement(insert);
            });
        }

        if (ctx.param_clause() != null) {
            Map<String, String> params = escapeTableMeta(getParams(ctx.param_clause()));
            createMapping.setParams(params);
        }

        if (checkIfExist(ctx.staging_location())) {
            createMapping.setStagingLocation(ctx.staging_location().name.getText());
        }
        
        if (checkIfExist(ctx.phys_design_clause())) {
            PhysicalDesignList physDesigns = (PhysicalDesignList) visitPhys_design_clause(ctx.phys_design_clause());
            createMapping.setPhysicalDesignList(physDesigns);
        }

        return createMapping;
    }


    @Override
    public Expr visitCreate_scenario_statement(Create_scenario_statementContext ctx) {
        CreateScenario scen = new CreateScenario();
        String scenarioName = ctx.scenario_name().getText();
        scen.setName(scenarioName);

        if (checkIfExist(ctx.scenario_version())) {
            scen.setVersion(ctx.scenario_version().getText());
        }

        scen.setSrcObjType(ctx.scenario_source_type().getText().toUpperCase());
        scen.setSrcObjectName(ctx.mapping_name().getText());
        
        if (checkIfExist(ctx.phys_design_name())) {
            scen.setPhysDesignName(ctx.phys_design_name().getText());
        }
        
        if (checkIfExist(ctx.or_replace())) {
            scen.setRegenerate(true);
        }
        
        if (checkIfExist(ctx.scenario_variables())) {
            scen.setStartVariables(ctx.scenario_variables().scenario_variable().stream()
                    .map(this::buildScenStartVariable)
                    .collect(Collectors.toList()));
        }

        return scen;
    }
    
    private OdiScenarioStartVariable buildScenStartVariable(Scenario_variableContext ctx) {                
        String variableName = org.apache.commons.lang.StringUtils.remove(ctx.Odi_Variable().getText(), CatalogConstants.IDENTIFIER_ODIVAR_PREFIX);        
        String[] tokens = org.apache.commons.lang.StringUtils.split(variableName, CatalogConstants.IDENTIFIER_DELIMITER);
        
        assert tokens.length == 2 : "ODI variable name must have the form GLOBAL | PROJECT NAME . VARIABLE NAME";
        
        OdiVariable odiVar = new OdiVariable(tokens[0], tokens[1]);
        
        String defaultValue = null;
        
        if (checkIfExist(ctx.value)) {
            defaultValue = stripQuote(ctx.value.getText());
        }
        return new OdiScenarioStartVariable(odiVar, defaultValue, null);
    }

    @Override
    public Expr visitRegenerate_scenario_statement(Regenerate_scenario_statementContext ctx) {
        ScenarioAction scenAction = new ScenarioAction();
        
        scenAction.setName(ctx.scenario_name().getText());
        scenAction.setVersion(ctx.scenario_version().getText());        
        scenAction.setIfExists(checkIfExist(ctx.if_exists()));
        scenAction.setActionType(OdiConstants.ScenarioActionType.REGENERATE);
        
        return scenAction;
    }

    @Override
    public Expr visitDrop_scenario_statement(Drop_scenario_statementContext ctx) {
        ScenarioAction scenAction = new ScenarioAction();
        
        scenAction.setName(ctx.scenario_name().getText());
        scenAction.setVersion(ctx.scenario_version().getText());        
        scenAction.setIfExists(checkIfExist(ctx.if_exists()));
        scenAction.setActionType(OdiConstants.ScenarioActionType.DROP);
        
        return scenAction;
    }

    @Override
    public Expr visitImport_scenario_statement(Import_scenario_statementContext ctx) {
        ScenarioAction scenAction = new ScenarioAction();
                
        scenAction.setImportObjectType(OdiObjectType.valueOf(ctx.odi_object_type().getText().toUpperCase()));
        if (checkIfExist(ctx.import_object())) {
            scenAction.setName(ctx.import_object().odi_object_name().getText());
            
            if (checkIfExist(ctx.import_object().scenario_version())) {
                scenAction.setVersion(ctx.import_object().scenario_version().getText());
            }
        }        
        scenAction.setXmlFileName(ctx.path.getText());
        scenAction.setActionType(OdiConstants.ScenarioActionType.IMPORT);        
        scenAction.setImportType(OdiConstants.ImportType.valueOf(ctx.import_mode().Quoted_Identifier().getText().toUpperCase()));
        
        if (checkIfExist(ctx.import_parent_object())) {
            scenAction.setParentObjectType(OdiObjectType.valueOf(ctx.import_parent_object().odi_parent_object_type().getText().toUpperCase()));
            scenAction.setParentObjectName(ctx.import_parent_object().odi_object_name().getText());
        }
        
        if (checkIfExist(ctx.if_not_exists())) {
            scenAction.setIfNotExists(true);
        }
        
        return scenAction;
    }

    @Override
    public Expr visitExport_scenario_statement(Export_scenario_statementContext ctx) {
        ScenarioAction scenAction = new ScenarioAction();
        
        scenAction.setName(ctx.scenario_name().getText());
        scenAction.setVersion(ctx.scenario_version().getText());        
        scenAction.setIfExists(checkIfExist(ctx.if_exists()));
        scenAction.setXmlFileName(ctx.path.getText());
        scenAction.setActionType(OdiConstants.ScenarioActionType.EXPORT);        
        
        return scenAction;
    }
    

    @Override
    public Expr visitDrop_mapping_statement(SQLParser.Drop_mapping_statementContext ctx) {
        return new DropMapping(ctx.mapping_name().getText(), checkIfExist(ctx.if_exists()), checkIfExist(ctx.CASCADE()));
    }

    @Override
    public Expr visitTruncate_mapping_statement(Truncate_mapping_statementContext ctx) {
        return new TruncateMapping(ctx.mapping_name().getText(), checkIfExist(ctx.if_exists()));
    }

    @Override
    public Expr visitTruncate_reusable_mapping_statement(Truncate_reusable_mapping_statementContext ctx) {
        return new TruncateMapping(ctx.mapping_name().getText(), checkIfExist(ctx.if_exists()), true);
    }  
        
    @Override
    public Expr visitDrop_package_statement(Drop_package_statementContext ctx) {
        return new DropPackage(ctx.mapping_name().getText(), checkIfExist(ctx.if_exists()));
    }
    
    @Override
    public Expr visitDrop_reusable_mapping_statement(Drop_reusable_mapping_statementContext ctx) {
        return new DropReusableMapping(ctx.mapping_name().getText(), checkIfExist(ctx.if_exists()), checkIfExist(ctx.CASCADE()));
    }

    @Override
    public Expr visitCreate_package_statement(Create_package_statementContext ctx) {
        String qualifiedPackageName = ctx.mapping_name().getText();
        
        CreatePackage crPck = new CreatePackage(qualifiedPackageName, checkIfExist(ctx.or_replace()), checkIfExist(ctx.if_not_exists()));
        
        ctx.statement_block().generic_package_statement().stream()
                .map(this::getPackageStep)
                .filter(Objects::nonNull)
                .forEachOrdered((step) -> crPck.getStepsList().add((Expr)step));
        
        return crPck;
    }
    
    private PackageStep getPackageStep(Generic_package_statementContext ctx) {
        int retries;
        int waitTime;
        String label;
        String onSuccessStepLabel;
        String onErrorStepLabel;
        AbstractPackageStep step = new AbstractPackageStep();
        
        // default behavior
        step.setExitOnError(Boolean.TRUE);
        step.setExitOnSuccess(Boolean.FALSE);
        
        if (checkIfExist(ctx.label())) {
            label = ctx.label().identifier().getText();
            step.setLabel(label);  
        }
        
        if (checkIfExist(ctx.error_clause())) {
            if (checkIfExist(ctx.error_clause().times)) {
                retries = Integer.parseInt(ctx.error_clause().times.getText());
                step.setRetriesNumber(retries);
            }
            if (checkIfExist(ctx.error_clause().wait_time)) {
                waitTime = Integer.parseInt(ctx.error_clause().wait_time.getText());
                step.setWaitSeconds(waitTime);
            }
            if (checkIfExist(ctx.error_clause().label())) {
                onErrorStepLabel = ctx.error_clause().label().identifier().getText();
                step.setOnErrorLabel(onErrorStepLabel);
            }
            if (checkIfExist(ctx.error_clause().CONTINUE())) {
                step.setExitOnError(Boolean.FALSE);
            }            
            if (checkIfExist(ctx.error_clause().EXIT())) {
                step.setExitOnError(Boolean.TRUE);
            }
        }   
        
        if (checkIfExist(ctx.success_clause())) {
            if (checkIfExist(ctx.success_clause().EXIT())) {
                step.setExitOnSuccess(Boolean.TRUE);
            }
            if (checkIfExist(ctx.success_clause().label())) {
                onSuccessStepLabel = ctx.success_clause().label().identifier().getText();
                step.setOnSuccessLabel(onSuccessStepLabel);
            }            
        }         
        
        if (checkIfExist(ctx.package_statement().declare_odivar_statement())) {
            Expr odiVar = visitOdi_variable(ctx.package_statement().declare_odivar_statement().odi_variable());
            return step.createDeclareVariableStep(odiVar);
        } else if (checkIfExist(ctx.package_statement().refresh_odivar_statement())) {
            Expr odiVar = visitOdi_variable(ctx.package_statement().refresh_odivar_statement().odi_variable());
            return step.createRefreshVariableStep(odiVar);            
        } else if (checkIfExist(ctx.package_statement().mapping_statement())) {
            MappingPackageStep mapping;
                    
            String mappingName = ctx.package_statement().mapping_statement().mapping_name().getText();            
            
            if (checkIfExist(ctx.package_statement().mapping_statement().phys_design_name())) {
                String physDesName = ctx.package_statement().mapping_statement().phys_design_name().Quoted_Identifier().getText();
                mapping = step.createMappingStep(mappingName, physDesName);
            } else {
                mapping = step.createMappingStep(mappingName, null);
            }
                        
            return mapping;
        } else if (checkIfExist(ctx.package_statement().procedure_statement())) {
            Procedure_statementContext procCtx = ctx.package_statement().procedure_statement();
            String procedureName = procCtx.mapping_name().getText();
            Map<String, String> options = null;
            
            if (checkIfExist(procCtx.procedure_options())) {
                options = escapeTableMeta(getProcParams(procCtx.procedure_options()));                
            }
            
            return step.createProcedureStep(procedureName, options);
        }
                    
        return step;
    }    

    @Override
    public OdiVariable visitOdi_variable(SQLParser.Odi_variableContext ctx) {
        String projectName = null;
        String name = null;
        LiteralType type = null;

        if (checkIfExist(ctx.Odi_Variable())) {
            String variableName = ctx.Odi_Variable().getText().substring(1);
            projectName = CatalogUtil.extractQualifier(variableName);
            name = CatalogUtil.extractSimpleName(variableName);
            type = LiteralType.String;
        }

        OdiVariable odivar = new OdiVariable(projectName, name);
        odivar.setValueType(type);

        return odivar;
    }

    @Override
    public Expr visitOdi_sequence(Odi_sequenceContext ctx) {
        OdiSequence odivar = null;

        if (checkIfExist(ctx.Odi_Sequence())) {           
            boolean isBindVariable = ":".equals(ctx.Odi_Sequence().getText().substring(0,1));
            
            boolean isNextVal = org.apache.commons.lang.StringUtils.endsWithIgnoreCase(ctx.Odi_Sequence().getText(), "_NEXTVAL");            
            
            String sequenceName;
            
            if (isNextVal) {
                sequenceName = org.apache.commons.lang.StringUtils.replace(ctx.Odi_Sequence().getText(), "_NEXTVAL", "");
            } else {
                sequenceName = org.apache.commons.lang.StringUtils.replace(ctx.Odi_Sequence().getText(), "_CURRVAL", "");
            }            
            
            String variableName = sequenceName.substring(1);
            String projectName = CatalogUtil.extractQualifier(variableName);
            String name = CatalogUtil.extractSimpleName(variableName);
            
            odivar = new OdiSequence(projectName, name);
            odivar.setBindVariable(isBindVariable);
            odivar.setNextVal(isNextVal);
        }

        return odivar;
    }

    @Override
    public Expr visitOdi_variable_literal(Odi_variable_literalContext ctx) {
        String projectName = null;
        String name = null;

        String tokens[] = stripQuote(ctx.getText()).split("\\.");

        switch (tokens.length) {
            case 1 -> name = tokens[0].substring(1);
            case 2 -> {
                projectName = tokens[0].substring(1);
                name = tokens[1];
            }
            default -> {
                assert (false);
            }
        }

        OdiVariable odivar = new OdiVariable(projectName, name);
        odivar.setValueType(LiteralType.String);
        return odivar;
    }

    @Override
    public Expr visitPhys_design_clause(Phys_design_clauseContext ctx) {
        PhysicalDesignList physDesignList = new PhysicalDesignList();

        ArrayList<PhysicalDesign> phyDesigns = new ArrayList<>();

        ctx.phys_design().stream()
                .map((c) -> (PhysicalDesign) visitPhys_design(c)).forEachOrdered(phyDesigns::add);

        physDesignList.setPhysicalDesigns(phyDesigns);
        return physDesignList;
    }

    @Override
    public Expr visitPhys_design(Phys_designContext ctx) {
        PhysicalDesign physDesign = new PhysicalDesign();
        
        if (checkIfExist(ctx.phys_design_name())) {
            physDesign.setName(ctx.phys_design_name().getText());
        }

        if (checkIfExist(ctx.phys_design_desc())) {
            physDesign.setDescription(ctx.phys_design_desc().Quoted_Identifier().getText());
        }

        if (checkIfExist(ctx.staging_location())) {
            physDesign.setStagingLocation(ctx.staging_location().name.getText());
        }
        
        if (checkIfExist(ctx.optimization_context())) {
            physDesign.setOptimContext(ctx.optimization_context().identifier().getText());
        }

        if (checkIfExist(ctx.REMOVE_TEMPORARY_OBJECTS_ON_ERROR())) {
            physDesign.setRemoveTempObj(Boolean.TRUE);
        } else {
            physDesign.setRemoveTempObj(Boolean.FALSE);
        }

        if (checkIfExist(ctx.UNIQUE_TEMPORARY_OBJECT_NAMES())) {
            physDesign.setUseUniqueTempNames(Boolean.TRUE);
        } else {
            physDesign.setUseUniqueTempNames(Boolean.FALSE);
        }
        
        if (checkIfExist(ctx.on_begin_mapping_cmd())) {
            PhysicalDesign.MappingCommand beginMapCmd = getMappingCommand(ctx.on_begin_mapping_cmd().mapping_command());
            physDesign.setBeginMappingCommand(beginMapCmd);
        }
        
        if (checkIfExist(ctx.on_end_mapping_cmd())) {
            PhysicalDesign.MappingCommand endMapCmd = getMappingCommand(ctx.on_end_mapping_cmd().mapping_command());
            physDesign.setEndMappingCommand(endMapCmd);
        }
        
        if (checkIfExist(ctx.km_list())) {
            ctx.km_list().xkm_clause().stream().map(this::visitXkm_clause).forEachOrdered(physDesign::addXkm);
            ctx.km_list().lkm_clause().stream().map(this::visitLkm_clause).forEachOrdered(physDesign::addLkm);
            ctx.km_list().ikm_clause().stream().map(this::visitIkm_clause).forEachOrdered(physDesign::addIkm);
            ctx.km_list().ckm_clause().stream().map(this::visitCkm_clause).forEachOrdered(physDesign::addCkm);
        }
        return physDesign;
    }
    
    private PhysicalDesign.MappingCommand getMappingCommand(Mapping_commandContext ctx) {
        String command = null;
        String technology = null;
        String location = null;

        if (checkIfExist(ctx.command)) {
            command = ctx.command.getText();
        }

        if (checkIfExist(ctx.technology)) {
            technology = ctx.technology.getText();
        }

        if (checkIfExist(ctx.location)) {
            location = ctx.location.getText();
        }
        
        return new PhysicalDesign.MappingCommand(command, technology, location);
    }

    @Override
    public KnowledgeModule visitXkm_clause(Xkm_clauseContext ctx) {
        KnowledgeModule xkm;
        String name = ctx.km_name().getText();
        Map<String, String> options;

        xkm = new KnowledgeModule(name, KnowledgeModule.KmType.XKM);

        if (checkIfExist(ctx.km_technology())) {
            xkm.setTechnology(ctx.km_technology().Quoted_Identifier().getText());
        }
        
        if (checkIfExist(ctx.km_target())) {
            
            String[] tables = new String[ctx.km_target().km_target_list().km_target_item().size()];
            
            for (int i = 0;  i < ctx.km_target().km_target_list().km_target_item().size(); i++) {  
                Km_target_itemContext target = ctx.km_target().km_target_list().km_target_item().get(i);
                if (target.table_name() != null) {
                    tables[i] = target.table_name().getText();
                } else if (target.Regular_Identifier() != null) {
                    tables[i] = target.Regular_Identifier().getText();
                }
          
                xkm.setTargetTableQualifiedNames(Arrays.asList(tables));
            } 
        }
        
        if (checkIfExist(ctx.km_params())) {
            options = escapeTableMeta(getKMParams(ctx.km_params()));
            xkm.setOptions(options);
        }

        return xkm;
    }

    
    @Override
    public KnowledgeModule visitIkm_clause(SQLParser.Ikm_clauseContext ctx) {
        KnowledgeModule ikm;
        String name = ctx.km_name().getText();
        Map<String, String> options;

        ikm = new KnowledgeModule(name, KnowledgeModule.KmType.IKM);

        if (checkIfExist(ctx.km_technology())) {
            ikm.setTechnology(ctx.km_technology().Quoted_Identifier().getText());
        }
        
        if (checkIfExist(ctx.km_target())) {
            
            String[] tables = new String[ctx.km_target().km_target_list().km_target_item().size()];
            
            for (int i = 0;  i < ctx.km_target().km_target_list().km_target_item().size(); i++) {  
                Km_target_itemContext target = ctx.km_target().km_target_list().km_target_item().get(i);
                if (target.table_name() != null) {
                    tables[i] = target.table_name().getText();
                } else if (target.Regular_Identifier() != null) {
                    tables[i] = target.Regular_Identifier().getText();
                }
          
                ikm.setTargetTableQualifiedNames(Arrays.asList(tables));
            } 
        }        

        if (checkIfExist(ctx.km_params())) {
            options = escapeTableMeta(getKMParams(ctx.km_params()));
            ikm.setOptions(options);
        }

        return ikm;
    }

    @Override
    public KnowledgeModule visitLkm_clause(SQLParser.Lkm_clauseContext ctx) {
        KnowledgeModule lkm;
        String name = ctx.km_name().getText();
        Map<String, String> options;

        lkm = new KnowledgeModule(name, KnowledgeModule.KmType.LKM);

        if (checkIfExist(ctx.km_technology())) {
            lkm.setTechnology(ctx.km_technology().Quoted_Identifier().getText());
        }

        if (checkIfExist(ctx.km_params())) {
            options = escapeTableMeta(getKMParams(ctx.km_params()));
            lkm.setOptions(options);
        }

        return lkm;
    }

    @Override
    public KnowledgeModule visitCkm_clause(SQLParser.Ckm_clauseContext ctx) {
        KnowledgeModule ckm;
        String name = ctx.km_name().getText();
        Map<String, String> options;

        ckm = new KnowledgeModule(name, KnowledgeModule.KmType.CKM);

        if (checkIfExist(ctx.km_technology())) {
            ckm.setTechnology(ctx.km_technology().Quoted_Identifier().getText());
        }
        
        if (checkIfExist(ctx.km_params())) {
            options = escapeTableMeta(getKMParams(ctx.km_params()));
            ckm.setOptions(options);
        }

        return ckm;
    }
    private Map<String, String> getKMParams(SQLParser.Km_paramsContext ctx) {
        Map<String, String> params = new HashMap<>();
        for (int i = 0; i < ctx.km_param().size(); i++) {
            params.put(stripQuote(ctx.km_param(i).key.getText()), stripQuote(ctx.km_param(i).value.getText()));
        }

        return params;
    }
    
    private Map<String, String> getProcParams(SQLParser.Procedure_optionsContext ctx) {
        Map<String, String> params = new HashMap<>();
        for (int i = 0; i < ctx.km_param().size(); i++) {
            params.put(stripQuote(ctx.km_param(i).key.getText()), stripQuote(ctx.km_param(i).value.getText()));
        }

        return params;
    }    

}
