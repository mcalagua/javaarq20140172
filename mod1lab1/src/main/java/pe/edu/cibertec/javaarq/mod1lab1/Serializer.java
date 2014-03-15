/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.javaarq.mod1lab1;

import java.io.InputStream;
import java.io.PrintWriter;

/**
 *
 * @author user
 */
public interface Serializer {

    void marshall(Object ibj, PrintWriter out);

    Object unmarshall(InputStream in);
}
