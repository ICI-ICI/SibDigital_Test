package com.task.Sorting.models;

import jakarta.persistence.*;

@Entity
@Table(name = "sorted1")
public class Tabl {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "val")
    private float val;
    @Column(name = "sort_id")
    private long sort_id;

    public Tabl() {
    }
    public Tabl(float val, long sort_id) {
        this.val = val;
        this.sort_id = sort_id;
    }

}
