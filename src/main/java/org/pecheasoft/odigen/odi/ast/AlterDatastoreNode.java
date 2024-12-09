package org.pecheasoft.odigen.odi.ast;

import org.pecheasoft.odigen.sql.parse.algebra.AlterTable.AlterTableOpType;
import org.pecheasoft.odigen.sql.parse.algebra.CreateTable;
import org.pecheasoft.odigen.sql.parse.algebra.ITableConstraint;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 *
 * @author Adi Neagu
 */
@JsonInclude(Include.NON_NULL)
public class AlterDatastoreNode extends LogicalNode {

    private String qualifiedName;
    private String alias;
    private String resourceName;
    private CreateTable.FileDescriptor fileDescriptor;
    private Attribute column;
    private AlterTableOpType alterType;
    private ITableConstraint key;
    private String comment;

    public AlterDatastoreNode() {
        super(NodeType.ALTER_DATASTORE);
    }

    @Override
    public int childNum() {
        return 0;
    }

    @Override
    public LogicalNode getChild(int idx) {
        return null;
    }

    @Override
    public void preOrder(LogicalNodeVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void postOrder(LogicalNodeVisitor visitor) {
        visitor.visit(this);
    }

    public String getQualifiedName() {
        return qualifiedName;
    }

    public void setQualifiedName(String qualifiedName) {
        this.qualifiedName = qualifiedName;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public CreateTable.FileDescriptor getFileDescriptor() {
        return fileDescriptor;
    }

    public void setFileDescriptor(CreateTable.FileDescriptor fileDescriptor) {
        this.fileDescriptor = fileDescriptor;
    }

    public Attribute getColumn() {
        return column;
    }

    public void setColumn(Attribute column) {
        this.column = column;
    }

    public ITableConstraint getKey() {
        return key;
    }

    public void setKey(ITableConstraint key) {
        this.key = key;
    }

    public AlterTableOpType getAlterType() {
        return alterType;
    }

    public void setAlterType(AlterTableOpType alterType) {
        this.alterType = alterType;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}
