package com.example.mad_qtend;
import android.util.Log;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.HashMap;

public class DAOEmployee_Attendance {

    private DatabaseReference databaseReference;

    public DAOEmployee_Attendance() {
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        databaseReference = db.getReference(Employee_Attendance.class.getSimpleName());

    }

    public Task<Void> add(Employee_Attendance atd) {
        return databaseReference.push().setValue(atd);
    }

    public Task<Void> update(String key, HashMap<String,Object> hashMap) {
        return databaseReference.child(key).updateChildren(hashMap);
    }

    public Task<Void> remove(String key) {
        return databaseReference.child(key).removeValue();
    }

    public Query get(String key) {
        if (key == null) {
            return databaseReference.orderByKey().limitToFirst(8);
        }
        return databaseReference.orderByKey().startAfter(key).limitToFirst(8);
    }
    public Query get()
    {
        return databaseReference;
    }

}

