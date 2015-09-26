package com.mycorp.timetrack.ui.beans;

import java.util.Date;

public class WorkDay {
    private int employeeId;
    private Date date;
    // work record = tuple of (projectId, hours worked)
    private WorkRecord[] workRecords;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public WorkRecord[] getWorkRecords() {
        return workRecords;
    }

    public void setWorkRecords(WorkRecord[] workRecords) {
        this.workRecords = workRecords;
    }
}

class WorkRecord {}
