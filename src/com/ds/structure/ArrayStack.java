package com.ds.structure;

import com.sun.corba.se.impl.ior.OldJIDLObjectKeyTemplate;

import java.util.Arrays;
import java.util.EmptyStackException;

public class ArrayStack{
    private Object[] elementData;
    private int top;
    private int size;

    public ArrayStack(int initialCapacity){
        if (initialCapacity < 0){
            throw new IllegalArgumentException("illegal initial capacity!");
        }
        this.size = initialCapacity;
        this.top = -1;
        this.elementData = new Object[initialCapacity];
    }

    public Object push(Object item){
        isGrow(top+1);
        elementData[++top] = item;
        return item;
    }

    public Object pop(){
        if (top > -1)
            return elementData[top];
        else
            throw new EmptyStackException();
    }

    public boolean isGrow(int minCapacity){
        int oldCapacity = size;
        if (minCapacity > oldCapacity){
            int newCapacity = 0;
            if((oldCapacity<<1)-Integer.MAX_VALUE > 0)
                newCapacity = Integer.MAX_VALUE;
            else
                newCapacity = (oldCapacity<<1);
            this.size = newCapacity;
            Object[] newArray = Arrays.copyOf(elementData, size);
            elementData = newArray;
            return true;
        }
        else
            return false;
    }


}
