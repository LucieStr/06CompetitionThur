/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Strnadkova;

import java.util.Comparator;

/**
 *
 * @author lucka
 */
public class ComparatorZavodnikBySurname implements Comparator<Zavodnik> {

    @Override
    public int compare(Zavodnik o1, Zavodnik o2) {
        return o1.getPrijmeni().compareTo(o2.getPrijmeni());
    }
    
}
