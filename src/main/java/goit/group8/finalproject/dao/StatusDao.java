package goit.group8.finalproject.dao;

import goit.group8.finalproject.model.Status;

import java.util.List;

public interface StatusDao {

    List<Status> showAll();

   /* Status findByName(String name);*/

    Status findById(int id);
}
