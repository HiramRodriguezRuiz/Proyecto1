/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import ON.Barco;
import java.util.List;

/**
 *
 * @author Martha
 */
public interface BarcoDAO {
    Barco find(int id) throws Exception;
    List<Barco> getAll() throws Exception;
    void add(Barco barco) throws Exception;
    void update(Barco barco) throws Exception;
    void delete(int matricula) throws Exception;
}
