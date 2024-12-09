/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.pecheasoft.odigen.sql.parse.algebra;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class PatternMatchPredicate extends BinaryOperator {

    public enum MatchType {LikePredicate, SimilarToPredicate, Regexp}
    private boolean not;
    private boolean caseInsensitive;
    private MatchType matchType;

    public PatternMatchPredicate(MatchType matchType, boolean not, Expr predicand, Expr pattern, boolean caseInsensitive) {
        this.not = not;
        this.caseInsensitive = caseInsensitive;
        this.matchType = matchType;
        
        setLeft(predicand);
        setRight(pattern);
    }

    public PatternMatchPredicate(MatchType matchType, boolean not, Expr predicand, Expr pattern) {
        this(matchType, not, predicand, pattern, false);
    }

    public boolean isNot() {
        return not;
    }

    public Expr getPredicand() {
        return getLeft();
    }

    public Expr getPattern() {
        return getRight();
    }

    public boolean isCaseInsensitive() {
        return this.caseInsensitive;
    }

    public MatchType getMatchType() {
        return matchType;
    }

    public void setMatchType(MatchType matchType) {
        this.matchType = matchType;
    }

    @Override
    public PatternMatchPredicate clone() throws CloneNotSupportedException {
        PatternMatchPredicate patternMatchPredicate = (PatternMatchPredicate) super.clone();
        patternMatchPredicate.not = not;
        patternMatchPredicate.caseInsensitive = caseInsensitive;
        return patternMatchPredicate;
    }
}
