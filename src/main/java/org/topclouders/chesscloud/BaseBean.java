package org.topclouders.chesscloud;

import java.io.Serializable;

/**
 * Created by kokeny on 11/11/15.
 */
public abstract class BaseBean implements Cloneable, Serializable {

    public BaseBean() {
    }

    /**
     * @return
     */
    public BaseBean deepCopy() {
        //FIXME must be implement the deepCopy behavior of the BaseBean wihtout using serialization and deserialization!
        return this;
    }

    /**
     * @return
     */
    public BaseBean shallowCopy() {
        try {
            return getClass().cast(clone());
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException("Failed to create shallow copy", e);
        }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
