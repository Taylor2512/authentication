package com.monodev.authentication.config.dto;

import java.util.List;

public class OperationResultList<T> extends ActionResult {
    private List<T> data;
  
    
    public List<T> getData() {
        return data;
    }
    public void setData(List<T> data) {
        this.data = data;
    }
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
   
    @Override
    public int hashCode() {

        return super.hashCode();
    }
   
    @Override
    public String toString() {
        return super.toString();
    }
   
}
