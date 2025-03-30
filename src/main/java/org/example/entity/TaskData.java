package org.example.entity;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.List;

public class TaskData {
    Set<Task> annsTasks;
    Set<Task> bobsTasks;
    Set<Task> carolsTasks;
    Set<Task> unassignedTasks;

    public TaskData() {
        this.annsTasks = new HashSet<>();
        this.bobsTasks = new HashSet<>();
        this.carolsTasks = new HashSet<>();
        this.unassignedTasks = new HashSet<>();
    }

    public TaskData(Set<Task> taskSet1, Set<Task> taskSet2, Set<Task> taskSet3, HashSet<Object> objects) {
    }

    public Set<Task> getTasks(String employeeName) {
        switch (employeeName) {
            case "ann":
                return annsTasks;
            case "bob":
                return bobsTasks;
            case "carol":
                return carolsTasks;
            case "all":
                Set<Task> allTasks = new HashSet<>();
                allTasks.addAll(annsTasks);
                allTasks.addAll(bobsTasks);
                allTasks.addAll(carolsTasks);
                allTasks.addAll(unassignedTasks);
                return allTasks;
        }
        return Set.of();
    }

   public Set<Task> getUnion(List<Set<Task>> sets){
        HashSet<Task> newSets = new HashSet<>();
        for(Set<Task> taskSet : sets) {
            newSets.addAll(taskSet);
        }
        return newSets;
   }

   public Set<Task> getIntersect(Set<Task> set1, Set<Task> set2) {
        Set<Task> set1Copy = new HashSet<>(set1);
        Set<Task> set2Copy = new HashSet<>(set2);
        set1Copy.retainAll(set2Copy);
        return set1Copy;
   }

    public Set<Task> getDifference(Set<Task> set1, Set<Task> set2) {
        Set<Task> set1Copy = new HashSet<>(set1);
        Set<Task> set2Copy = new HashSet<>(set2);
        set1Copy.removeAll(set2Copy);
        return set1Copy;
    }

}
