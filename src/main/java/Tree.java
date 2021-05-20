

public class Tree {
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
                        Node currentNode = root;
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



        public static void  main (String[] arg) {
                Tree tree = new Tree();
                tree.insertNewNode(8);
                tree.insertNewNode(5);
                tree.insertNewNode(6);
                tree.insertNewNode(1);
                tree.insertNewNode(2);
                tree.insertNewNode(4);
                tree.insertNewNode(9);
                tree.insertNewNode(10);
                tree.insertNewNode(7);
                tree.insertNewNode(3);

                Node foundValue = tree.findNodeByValue(6);
                foundValue.printNode();

        }

}

