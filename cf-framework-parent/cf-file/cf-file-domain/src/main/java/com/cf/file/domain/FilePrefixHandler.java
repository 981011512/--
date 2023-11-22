package com.cf.file.domain;


import java.io.Serializable;
import java.util.List;

public class FilePrefixHandler implements Serializable {

    private Object source;

    private List sourceList;

    private List<String> sourceFields;

    public Object getSource() {
        return source;
    }

    public void setSource(Object source) {
        this.source = source;
    }

    public List<String> getSourceFields() {
        return sourceFields;
    }

    public void setSourceFields(List<String> sourceFields) {
        this.sourceFields = sourceFields;
    }

    public List getSourceList() {
        return sourceList;
    }

    public void setSourceList(List sourceList) {
        this.sourceList = sourceList;
    }
}
