package com.sd.his.wrapper;

import com.sd.his.model.Tax;
import com.sd.his.utill.DateTimeUtil;
import com.sd.his.utill.HISConstants;

/**
 * Created by jamal on 7/31/2018.
 */
public class TaxWrapper {
    private long id;
    private String name;
    private String description;
    private double rate;
    private String fromDate;
    private String toDate;
    private boolean active;
    private boolean hasChild;
    private boolean hasParent;

    public TaxWrapper() {
    }


    public TaxWrapper(Tax tax) {
        this.id = tax.getId();
        this.name = tax.getName();
        this.description = tax.getDescription();
        this.rate = tax.getRate();
        this.fromDate = DateTimeUtil.getFormattedDateFromDate(tax.getFromDate(), HISConstants.DATE_FORMATE_THREE);
        this.toDate = DateTimeUtil.getFormattedDateFromDate(tax.getToDate(), HISConstants.DATE_FORMATE_THREE);
        this.active = tax.getActive();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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


    public void setId(long id) {
        this.id = id;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isHasChild() {
        return hasChild;
    }

    public void setHasChild(boolean hasChild) {
        this.hasChild = hasChild;
    }

    public boolean isHasParent() {
        return hasParent;
    }

    public void setHasParent(boolean hasParent) {
        this.hasParent = hasParent;
    }
}