/*
 * Copyright 2018 Apache Software Foundation.
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
package org.pecheasoft.odigen.odi.parse.algebra;

import java.util.Map;

import org.pecheasoft.odigen.sql.parse.algebra.Expr;

/**
 *
 * @author Adi Neagu
 */
public class AbstractPackageStep extends OdiExpr implements PackageStep {
    private Integer stepId;
    private String label;
    private Integer retriesNumber;
    private Integer waitSeconds;
    private String onSuccessLabel;  
    private Boolean exitOnSuccess = false;
    private String onErrorLabel;
    private Boolean exitOnError = false;

    public DeclareVariablePackageStep createDeclareVariableStep(Expr odiVar) {
        DeclareVariablePackageStep dv = new DeclareVariablePackageStep(odiVar);
        copyGenericProperties(dv);        
        return dv;
    }
    
    public RefreshVariablePackageStep createRefreshVariableStep(Expr odiVar) {
        RefreshVariablePackageStep rv = new RefreshVariablePackageStep(odiVar);
        copyGenericProperties(rv);        
        return rv;
    }
    
    public MappingPackageStep createMappingStep(String mappingName, String physicalDesignName) {
        MappingPackageStep map = new MappingPackageStep(mappingName, physicalDesignName);
        copyGenericProperties(map);
        return map;        
    }
    
    public ProcedurePackageStep createProcedureStep(String mappingName, Map<String, String> options) {
        ProcedurePackageStep proc = new ProcedurePackageStep(mappingName, options);
        copyGenericProperties(proc);
        return proc;        
    }    
    
    private void copyGenericProperties(AbstractPackageStep target) {
        target.setLabel(label);
        target.setOnErrorLabel(onErrorLabel);
        target.setOnSuccessLabel(onSuccessLabel);
        target.setRetriesNumber(retriesNumber);
        target.setWaitSeconds(waitSeconds);
        target.setExitOnError(exitOnError);
        target.setExitOnSuccess(exitOnSuccess);
    }
    
    @Override
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public Integer getRetriesNumber() {
        return retriesNumber;
    }

    public void setRetriesNumber(Integer retriesNumber) {
        this.retriesNumber = retriesNumber;
    }

    @Override
    public Integer getWaitSeconds() {
        return waitSeconds;
    }

    public void setWaitSeconds(Integer waitSeconds) {
        this.waitSeconds = waitSeconds;
    }

    public String getOnSuccessLabel() {
        return onSuccessLabel;
    }

    public void setOnSuccessLabel(String onSuccessLabel) {
        this.onSuccessLabel = onSuccessLabel;
    }

    public String getOnErrorLabel() {
        return onErrorLabel;
    }

    public void setOnErrorLabel(String onErrorLabel) {
        this.onErrorLabel = onErrorLabel;
    }

    @Override
    public Integer getStepId() {
        return stepId;
    }

    @Override
    public void setStepId(Integer stepId) {
        this.stepId = stepId;
    }

    public Boolean getExitOnSuccess() {
        return exitOnSuccess;
    }

    public void setExitOnSuccess(Boolean existOnSuccess) {
        this.exitOnSuccess = existOnSuccess;
    }

    public Boolean getExitOnError() {
        return exitOnError;
    }

    public void setExitOnError(Boolean exitOnError) {
        this.exitOnError = exitOnError;
    }

}
