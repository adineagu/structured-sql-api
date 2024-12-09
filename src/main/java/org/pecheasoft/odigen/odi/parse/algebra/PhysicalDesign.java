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
package org.pecheasoft.odigen.odi.parse.algebra;

import java.util.Collection;
import org.pecheasoft.odigen.odi.parse.algebra.KnowledgeModule.KmType;
import org.pecheasoft.odigen.sql.util.TUtil;


/**
 *
 * @author Adi Neagu
 */
public class PhysicalDesign extends OdiExpr {

    private String name;
    private String description;
    private String optimContext;
    private String stagingLocation;
    private MappingCommand beginMappingCommand;
    private MappingCommand endMappingCommand;
    private boolean removeTempObj;
    private boolean useUniqueTempNames;
    private final Collection<KnowledgeModule> xkms = TUtil.newList();
    private final Collection<KnowledgeModule> lkms = TUtil.newList();
    private final Collection<KnowledgeModule> ikms = TUtil.newList();
    private final Collection<KnowledgeModule> ckms = TUtil.newList();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOptimContext() {
        return optimContext;
    }

    public void setOptimContext(String optimContext) {
        this.optimContext = optimContext;
    }

    public String getStagingLocation() {
        return stagingLocation;
    }

    public void setStagingLocation(String stagingLocation) {
        this.stagingLocation = stagingLocation;
    }

    public MappingCommand getBeginMappingCommand() {
        return beginMappingCommand;
    }

    public void setBeginMappingCommand(MappingCommand beginMappingCommand) {
        this.beginMappingCommand = beginMappingCommand;
    }

    public MappingCommand getEndMappingCommand() {
        return endMappingCommand;
    }

    public void setEndMappingCommand(MappingCommand endMappingCommand) {
        this.endMappingCommand = endMappingCommand;
    }

    public boolean isRemoveTempObj() {
        return removeTempObj;
    }

    public void setRemoveTempObj(boolean removeTempObj) {
        this.removeTempObj = removeTempObj;
    }

    public boolean isUseUniqueTempNames() {
        return useUniqueTempNames;
    }

    public void setUseUniqueTempNames(boolean useUniqueTempNames) {
        this.useUniqueTempNames = useUniqueTempNames;
    }

    public boolean addCkm(KnowledgeModule e) {
        return ckms.add(e);
    }

    public boolean addIkm(KnowledgeModule e) {
        return ikms.add(e);
    }

    public boolean addLkm(KnowledgeModule e) {
        return lkms.add(e);
    }

    public boolean addXkm(KnowledgeModule e) {
        return xkms.add(e);
    }

    public Collection<KnowledgeModule> getXkms() {
        return xkms;
    }

    
    public Collection<KnowledgeModule> getLkms() {
        return lkms;
    }

    public Collection<KnowledgeModule> getIkms() {
        return ikms;
    }

    public Collection<KnowledgeModule> getCkms() {
        return ckms;
    }
    
    public Collection<KnowledgeModule> getKmsOfType(KmType kmType) {
        if (null != kmType) switch (kmType) {
            case IKM:
                return getIkms();
            case LKM:
                return getLkms();
            case XKM:
                return getXkms();
            case CKM:
                return getCkms();
            default:
                return null;
        }
        
        return null;
    }
    
    public static class MappingCommand {
        private final String command;
        private final String technology;
        private final String location;

        public MappingCommand(String command, String technology, String location) {
            this.command = command;
            this.technology = technology;
            this.location = location;
        }

        public String getCommand() {
            return command;
        }

        public String getTechnology() {
            return technology;
        }

        public String getLocation() {
            return location;
        }
        
    }

}
