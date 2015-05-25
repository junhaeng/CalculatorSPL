package spl.feature.function;

import java.util.ArrayList;

import javax.swing.JTextArea;

public class Controller implements ControlI{
    private double result;
    private boolean exist_result;
    private BaseFunction function;
    
    private double temp_opd;
    private int current_op;
    private int valid_check;
    
    
    public Controller(BaseFunction f){
        this.function = f;
        exist_result = false;
        current_op = 0;
        valid_check = 0;
    }

    public int passOperand(double opd){
        if(valid_check == 1) return -1;
        if( current_op == 0 ){  // input operand value "opd" after "=" or in initial state
            result = opd;       // set opd to result
            exist_result = true;
            valid_check = 1;
        }else if( current_op > 0 ){ // input operand value "opd" after "+".....
            switch(current_op){
            case 1:
                result = function.add(result, opd);
                exist_result = true;
                break;
            case 2:
                result = function.sub(result, opd);
                exist_result = true;
                break;
            case 3:
                result = function.mul(result, opd);
                exist_result = true;
                break;
            case 4:
                result = function.div(result, opd);
                exist_result = true;
                break;
            case 5:
                result = function.mod(result, opd);
                exist_result = true;
                break;
            case 6:
                result = function.qout(result, opd);
                exist_result = true;
                break;
            }
            valid_check = 1;
        }
        return 0;
    }

    @Override
    public int passOpreation(String ops) {
        if(ops == "add"){
            current_op = 1;
        }else if(ops == "result"){
            current_op = 0;
        }else if(ops == "sub"){
            current_op = 2;
        }else if(ops =="mul"){
            current_op = 3;
        }else if(ops == "div"){
            current_op = 4;
        }else if(ops == "mod"){
            current_op = 5;
        }else if(ops == "qout"){
            current_op = 6;
        }
        // about unary operation
        //.........
        if(valid_check == 2) return -1;
        else{
            valid_check = 2;
            return 0;
        }
    }

    @Override
    public double getResult() throws Exception {
        // TODO Auto-generated method stub
        if(exist_result){
            return result;
        }else{
            throw new Exception("result error!!");
        }
    }

    @Override
    public void flush() {
        // TODO Auto-generated method stub
        exist_result = false;
        current_op = 0;
    }
    
    public class UnvalidCalcInput extends Exception{
        
    }
    
    /**
     * for parentalize 
     * @author user
     *
     */
    class ComputeTree{
        private Node root;
        ComputeTree(){
            root = null;
        }
        double computeTree(){
            return 0;
        }
        void InitalTree(double opd1, int op, double opd2){
            
        }
        void addOprationAndOperand(int op, double opd2){
            if(root == null){
                /**
                 * error
                 */
            }
        }
        boolean isEmpty(){
            if(this.root == null)
                return true;
            else
                return false;
        }
    }
    class Node{
        private Node parent, left, right;
        private double value;
        private String operation;
        private boolean isOperation;
        
        Node(String operation){
            this.operation = operation;
            isOperation = true;
        }
        Node(double value){
            this.value = value;
            isOperation = false;
        }

        public Node getParent() {
            return parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
        
    }
}
