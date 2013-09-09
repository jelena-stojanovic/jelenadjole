/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures;

/**
 *
 * @author jelena
 */
public class SuccArray {

    SuccArrayElement first;

    public SuccArray() {
    }
    public SuccArray(int value) {
        first = new SuccArrayElement(value, null, null);
    }
    public SuccArray(SuccArrayElement first) {
        this.first = first;
    }

    public void addFirst(int value) {
        SuccArrayElement currrentFirst=first;
        first=new SuccArrayElement(value, null, currrentFirst);
        if(currrentFirst!=null){
            currrentFirst.setPrevious(first);
        }
    }

    public SuccArrayElement getFirst() {
        return first;
    }
    


    
    public class SuccArrayElement {

        private SuccArrayElement previous;
        private SuccArrayElement next;
        private int value;

        public SuccArrayElement() {
        }

        public SuccArrayElement(int value){
            this.value=value;
        }
                
        public SuccArrayElement(int value, SuccArrayElement previous, SuccArrayElement next) {
            this.value = value;
            this.previous = previous;
            this.next = next;
        }

        /**
         * @return the previous
         */
        public SuccArrayElement getPrevious() {
            return previous;
        }

        /**
         * @param previous the previous to set
         */
        public void setPrevious(SuccArrayElement previous) {
            this.previous = previous;
        }

        /**
         * @return the next
         */
        public SuccArrayElement getNext() {
            return next;
        }

        /**
         * @param next the next to set
         */
        public void setNext(SuccArrayElement next) {
            this.next = next;
        }

        /**
         * @return the value
         */
        public int getValue() {
            return value;
        }

        /**
         * @param value the value to set
         */
        public void setValue(int value) {
            this.value = value;
        }

    }

}
