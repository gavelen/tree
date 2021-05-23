

public class Tree {
        private Node root;

        public Tree() {
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

        public void insertNewNode(int value) {
                Node newNode = new Node();
                newNode.setValue(value);
                if (root == null) {
                        root = newNode;
                } else {
                        Node currentNode = root;
                        Node parentNode;
                        while (true) {
                                parentNode = currentNode;
                                if (currentNode.getValue() == value) {
                                        return;
                                } else if (value < currentNode.getValue()) {
                                        currentNode = currentNode.getLeftChild();
                                        if (currentNode == null) {
                                                parentNode.setLeftChild(newNode);
                                                return;
                                        }
                                } else {
                                        currentNode = currentNode.getRightChild();
                                        if (currentNode == null) {
                                                parentNode.setRightChild(newNode);
                                                return;
                                        }
                                }
                        }
                }
        }

        public boolean deleteNode(int value) {
                Node currentNode = root;
                Node parentNode = root;
                boolean isLeftChild = true;
                while (currentNode.getValue() != value) {
                        parentNode = currentNode;
                        if (value < currentNode.getValue()) {
                                isLeftChild = true;
                                currentNode = currentNode.getLeftChild();
                        } else {
                                isLeftChild = false;
                                currentNode = currentNode.getRightChild();
                        }
                        if (currentNode == null) {
                                return false;
                        }
                }
                if (currentNode.getLeftChild() == null && currentNode.getRightChild() == null) {
                        if (currentNode == root) {
                                root = null;
                        } else if (isLeftChild) {
                                parentNode.setLeftChild(currentNode.getLeftChild());
                        } else {
                                parentNode.setRightChild(currentNode.getRightChild());
                        }
                } else if (currentNode.getLeftChild() == null) {
                        if (currentNode == root) {
                                root = currentNode.getRightChild();
                        } else if (isLeftChild) {
                                parentNode.setLeftChild(currentNode.getLeftChild());
                        } else {
                                parentNode.setRightChild(currentNode.getRightChild());
                        }
                } else {
                        Node futureNode = futureNode(currentNode);
                        if (currentNode == root) {
                                root = futureNode;
                        } else if (isLeftChild) {
                                parentNode.setLeftChild(futureNode);
                        }
                        else{
                                parentNode.setRightChild(futureNode);
                        }
                }

                        return true;
        }
        private Node futureNode (Node node){
                Node parent = node;
                Node futureNode = node;
                Node current = node.getRightChild();
                while (current != null)
                {
                        parent = futureNode;
                        futureNode = current;
                        current = current.getLeftChild();
                }
                if (futureNode != node.getRightChild())
                {
                        parent.setLeftChild(futureNode.getRightChild());
                        futureNode.setRightChild(node.getRightChild());
                }

                return futureNode;
        }

        public static void main(String[] arg) {
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

