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

/**
 *
 * @author Adi Neagu
 */
public class PackageStepLink {

    private final Boolean isOnError;
    private final Boolean isOnSuccess;

    private PackageStepLink(Boolean isOnError, Boolean isOnSuccess) {
        this.isOnError = isOnError;
        this.isOnSuccess = isOnSuccess;
    }

    public static PackageStepLink createOnSuccessLink() {
        return new PackageStepLink(Boolean.FALSE, Boolean.TRUE);
    }

    public static PackageStepLink createOnErrorLink() {
        return new PackageStepLink(Boolean.TRUE, Boolean.FALSE);
    }

    /**
     * Create an edge which represents both On success and on error
     *
     * @return
     */
    public static PackageStepLink createOnAnyCaseLink() {
        return new PackageStepLink(Boolean.TRUE, Boolean.TRUE);
    }

    public static PackageStepLink createDefaultLink() {
        return new PackageStepLink(Boolean.FALSE, Boolean.TRUE);
    }

    public Boolean isOnError() {
        return isOnError;
    }

    public Boolean isOnSuccess() {
        return isOnSuccess;
    }

}
