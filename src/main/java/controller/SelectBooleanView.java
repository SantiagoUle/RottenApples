package controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Santiago
 */
@Named
@RequestScoped
public class SelectBooleanView {

    private boolean value1;
    
    public boolean isValue1() {
        return value1;
    }

    public void setValue1(boolean value1) {
        this.value1 = value1;
    }
}
