package org.pecheasoft.odigen.odi.parse.algebra;

import org.pecheasoft.odigen.sql.parse.algebra.Join;


public class OdiJoin extends Join {

    private LookupJoin lookup;

    public OdiJoin(JoinType joinType) {
        super(joinType);
    }

    public LookupJoin getLookup() {
        return lookup;
    }

    public void setLookup(LookupJoin lookup) {
        this.lookup = lookup;
    }

}
