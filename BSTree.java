
/**
 * BSTree.java
 * 
 * @author Alex Wang
 *
 */
public class BSTree {

	public Node root;
	public String preOrderStr;
	public String inOrderStr;

	/**
	 * Constructor
	 */
	public BSTree() {
		root = new Node();
		preOrderStr = "";
		inOrderStr = "";
	}

	/**
	 * Inserts a node into the tree
	 * 
	 * @param content
	 *            content given to be set as data of the new node
	 */
	public void insert(String content) {
		Node adding = new Node();
		adding.setData(content);

		if (root == null || root.getData() == null) {
			/* when the tree is empty */
			/* add as root */
			root = adding;
		} else { /* starts from the root, and finds the place to insert */
			insert(adding, root);
		}
	}

	/**
	 * Inserts a node into the tree
	 * 
	 * @param adding
	 *            node given to be inserted
	 * @param parent
	 *            to compare and insert
	 */
	private void insert(Node adding, Node node) {
		if (adding.getData().compareTo((String) node.getData()) > 0) {
			if (node.getRight() != null) {
				insert(adding, node.getRight());
			} else {
				node.setRight(adding);
				return;
			}
		} else {
			if (node.getLeft() != null) {
				insert(adding, node.getLeft());
			} else {
				node.setLeft(adding);
				return;
			}
		}
	}

	/**
	 * Whether there is such node containing given data
	 * 
	 * @param content
	 *            data given to be searched for
	 * @return boolean that whether it is found or not
	 */
	public boolean find(String content) {
		return find(content, root);
	}

	/**
	 * Find the data through the tree
	 * 
	 * @param content
	 *            given data to be searched for
	 * @param node
	 *            data of this node would be compared to given content
	 * @return boolean that whether the content is found or not
	 */
	private boolean find(String content, Node node) {
		boolean result = false;
		if (node.getData().compareTo(content) == 0) {
			result = true;
		} else if (node.getData().compareTo(content) > 0) {
			if (node.getData().compareTo(content) > 0 && node.getLeft() != null) {
				result = find(content, node.getLeft());
			}
		} else if (node.getData().compareTo(content) < 0) {
			if (node.getData().compareTo(content) < 0 && node.getRight() != null) {
				result = find(content, node.getRight());
			}
		}
		return result;
	}

	/**
	 * Delete a node from the tree
	 * 
	 * @param content
	 *            data of node which is to be deleted
	 */
	public void delete(String content) {
		delete(content, root);
		if (root == null) {
			root = new Node();
		}

	}

	/**
	 * Delete a node from the tree
	 * 
	 * @param content
	 *            data of node which is to be deleted
	 * @param node
	 *            node to be compared or to delete(if found)
	 */
	private void delete(String content, Node node) {
		if (node.getData().compareTo(content) == 0) {
			if (node == root) {
				if (node.getLeft() == null) {
					root = node.getRight();
				} else if (node.getRight() == null) {
					root = node.getLeft();
				} else {
					node.getLeft().setRight(node.getRight());
					node.getRight().setLeft(node.getLeft());
					root = node.getLeft();
				}
			}

			if (node.getLeft() != null && node.getRight() != null) {
				node.getLeft().setRight(node.getRight());
				node.getRight().setLeft(node.getLeft());
			} else if (node.getLeft() == null && node.getRight() != null) {
				node.getRight().setLeft(null);
			} else if (node.getRight() == null && node.getLeft() != null) {
				node.getLeft().setRight(null);
			}

		}

		else if (node.getData().compareTo(content) > 0) {
			if (node.getData().compareTo(content) > 0 && node.getLeft() != null) {
				delete(content, node.getLeft());
			}
		} else if (node.getData().compareTo(content) < 0) {
			if (node.getData().compareTo(content) < 0 && node.getRight() != null) {
				delete(content, node.getRight());
			}
		}
	}

	/**
	 * Returns a space-separated copy of the contents stored in the BST in
	 * pre-order: the contents of the root node, followed by the contents of the
	 * left child and the contents of the right child
	 * 
	 * @return a string of all the contents in pre-order
	 */
	public String toStringPreOrder() {
		/* initialize the string */
		/* in case the visitTree was called before this method */
		preOrderStr = "";

		visitTree(root);

		/* strip the last space */
		preOrderStr = preOrderStr.substring(0, preOrderStr.length() - 1);
		return preOrderStr;
	}

	/**
	 * Returns a space-separated copy of the contents stored in the BST in
	 * (sorted) order
	 * 
	 * @return a string of sorted all contents in the tree
	 */
	public String toStringInOrder() {
		/* initialize the string */
		/* in case the visitTree was called before this method */
		inOrderStr = "";

		visitTree(root);

		/* strip the last space */
		inOrderStr = inOrderStr.substring(0, inOrderStr.length() - 1);
		return inOrderStr;
	}

	/**
	 * Multi-function method, goes through the tree in pre-order, but also add
	 * elements into in-order list
	 * 
	 * @param node
	 *            given node to start visiting of the tree
	 */
	private void visitTree(Node node) {
		if (node == null || node.getData() == null) {
			return;
		}

		preOrderStr = preOrderStr.concat(node.getData() + " ");

		/* recursively goes through all the leaves */
		if (node.getLeft() != null) {
			visitTree(node.getLeft());
		}

		inOrderStr = inOrderStr.concat(node.getData() + " ");
		if (node.getRight() != null) {
			visitTree(node.getRight());
		}
	}

}
