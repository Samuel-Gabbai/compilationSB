/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package parser;

import java.util.HashMap;

/**
 *
 * @author ver
 */
public class Environnement {
    private HashMap<String, Symbol> data = new HashMap<String,Symbol>();

    public Environnement(){
    }

    public boolean exists(String name){
        return data.containsKey(name);
    }

    public Symbol getSym(String name){
        if (exists(name)) return data.get(name);
        else return putSym(name);
    }

    public Symbol putSym(String name){
        Symbol v = new Symbol(name);
        data.put(name, v);
        return v;
    }

}
