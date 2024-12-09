package org.pecheasoft.odigen.odi.util;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.google.common.collect.Lists;

public class ExecutionStatus {
    public enum StatusType {
        OK, WARNING, ERROR;
        
        public StatusType And(StatusType other) {
            if (this == OK) {
                return other;
            } else if (this == WARNING && other == ERROR) {
                return other;
            } else {
                return this;
            }
        }
    };

    private String statement;
    private StatusType status;

    List<String> errorMessages = Lists.newArrayList();
    List<String> warningMessages = Lists.newArrayList();
    List<String> infoMessages = Lists.newArrayList();
    
    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public StatusType getStatus() {
        if (!errorMessages.isEmpty()) {
            status = ExecutionStatus.StatusType.ERROR;
        } else if (!warningMessages.isEmpty()) {
            status = ExecutionStatus.StatusType.WARNING;
        } else {
            status = ExecutionStatus.StatusType.OK;
        }
        return status;
    }

    public void setStatus(StatusType status) {
        this.status = status;
    }

    public void addError(String error) {
        if (!errorMessages.contains(error)) {
            errorMessages.add(error);
        }
    }

    public void addWarning(String error) {
        if (!warningMessages.contains(error)) {
            warningMessages.add(error);
        }
    }

    public void addInfo(String error) {
        if (!infoMessages.contains(error)) {
            infoMessages.add(error);
        }
    }

    public List<String> getErrorMessages() {
        return errorMessages;
    }

    public List<String> getWarningMessages() {
        return warningMessages;
    }

    public List<String> getInfoMessages() {
        return infoMessages;
    }

    public boolean hasErrors() {
        return errorMessages != null && !errorMessages.isEmpty();
    }

    public boolean hasWarnings() {
        return warningMessages != null && !warningMessages.isEmpty();
    }
    
    public boolean hasInfo() {
        return infoMessages != null && !infoMessages.isEmpty();
    }
    
    public String getInfoMessagesText() {
        return StringUtils.join(infoMessages, System.lineSeparator());
    }
    
    public String getWarningMessagesText() {
        return StringUtils.join(warningMessages, System.lineSeparator());
    }    

    public String getErrorMessagesText() {
        return StringUtils.join(errorMessages, System.lineSeparator());
    }   
    
    public static ExecutionStatus OK() {
        ExecutionStatus state = new ExecutionStatus();
        state.setStatus(ExecutionStatus.StatusType.OK);
        return state;
    }
    
    public static ExecutionStatus ERROR() {
        ExecutionStatus state = new ExecutionStatus();
        state.setStatus(ExecutionStatus.StatusType.ERROR);
        return state;
    }  
}
