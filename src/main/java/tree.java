

public class tree {
        private Node root;
        public Tree () {
        root = null;
        }
        public Node findNodeByValue(int value) {
                Node currentNode = root;
                while (currentNode.getValue() != value) {
                        if (value < currentNode.getValue()) {
                                currentNode = currentNode.getLeftChild();
                        } else {
                                currentNode = currentNode.getRightChild();
                        }
                        if (currentNode == null) {
                                return null;
                        }
                }
                return currentNode;
        }
        public void insertNewNode (int value) {
                Node newNode = new Node();
                newNode.setValue(value);
                if (root == null){
                        root = newNode;
                }
                else {
                        Node currentNode = new Node();
                        Node parentNode;
                        while (true){
                                parentNode = currentNode;
                                if (currentNode.getValue() == value) {
                                        return;
                                }
                                else if (value < currentNode.getValue()){
                                        currentNode = currentNode.getLeftChild();
                                        if (currentNode == null) {
                                                parentNode.setLeftChild(newNode);
                                                return;
                                        }
                                }
                                else {
                                        currentNode = currentNode.getRightChild();
                                        if (currentNode == null){
                                                parentNode.setRightChild(newNode);
                                                return;
                                        }
                                }
                        }
                }
        }
        public void deleteNode (int value){
                Node currentNode = root;
                Node parentNode = root;
                
        }

}

