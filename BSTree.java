import java.util.ArrayList;
import java.util.Collections;

public class BSTree {
	

	//TODO 100%
	//TODO check code quality
	//TODO check comments
	public Node root; 
	public String preOrderStr;
	private static ArrayList<String> inOrderList;
	
	/**
	 * Constructor
	 */
	public BSTree(){
		root= new Node();
		preOrderStr="";
		inOrderList = new ArrayList<String>();
	}
	
	public void insert(String item) {
		if(root == null){
		}else{	
		}
		Node adding = new Node();
		adding.setData(item);
		
		if(root == null || root.getData() ==null){ //to be the first node in the BST by getData()!
			root = adding;			
			return;
		}		
		insert(adding, root);
	}

	private void insert(Node adding, Node node){
		if(adding.getData().compareTo((String) node.getData())>0){
			if(node.getRight()!= null){
				insert(adding, node.getRight());
			}
			else{
				node.setRight(adding);
				return;
			}
		}
		else{
			if(node.getLeft() !=null){
				insert(adding, node.getLeft());
			}
			else{
				node.setLeft(adding);
				return;
			}
		}
	}
	
	
	public boolean find(String item) {
		return find(item, root);
	}

	private boolean find(String item, Node node){
		boolean result=false;
		if(node.getData().compareTo(item) == 0){
			result = true;
		}
		else if (node.getData().compareTo(item)>0){
			if(node.getData().compareTo(item)>0&&node.getLeft()!=null){
				result= find(item, node.getLeft()); 
			}
		}
		else if (node.getData().compareTo(item)<0){
			if(node.getData().compareTo(item)<0&&node.getRight()!=null){
				result= find(item, node.getRight()); 
			}
		}
		return result;
	}

	
	public void delete(String item) {
		delete(item, root);
		if(root == null){
			root = new Node();
		}
		
	}

	private void delete(String item, Node node){
		if(node.getData().compareTo(item) == 0){
			if (node == root){
				if(node.getLeft() ==null){
					root = node.getRight();
				}
				else if (node.getRight() == null){
					root = node.getLeft();
				}
				else {
					node.getLeft().setRight(node.getRight());
					node.getRight().setLeft(node.getLeft());
					root = node.getLeft();
				}
			}
			
			if(node.getLeft()!= null && node.getRight()!=null){ //when node has left an right
				node.getLeft().setRight(node.getRight());
				node.getRight().setLeft(node.getLeft());
			}
			else if(node.getLeft() == null &&node.getRight()!=null){ 
				node.getRight().setLeft(null);
			}
			else if(node.getRight() == null && node.getLeft() !=null){
				node.getLeft().setRight(null);
			}
			
		}
		
		
		else if (node.getData().compareTo(item)>0){
			if(node.getData().compareTo(item)>0&&node.getLeft()!=null){
				delete(item, node.getLeft()); 
			}
		}
		else if (node.getData().compareTo(item)<0){
			if(node.getData().compareTo(item)<0&&node.getRight()!=null){
				delete(item, node.getRight()); 
			}
		}
	}
	
	/**
	 *  returns a space-separated copy of the contents stored in the BST in pre-order: 
	 *  the contents of the root node, 
	 *  followed by the contents of the left child and the contents of the right child
	 * @return
	 */
	public String toStringPreOrder() {
		preOrderStr = ""; //in case the visitTree was called before this method
		visitTree(root);
		preOrderStr = preOrderStr.substring(0,preOrderStr.length()-1);
		return preOrderStr;
	}

	
	/**
	 * Multi-function method,
	 * go through the tree in pre-order, but also add elements into in-order list
	 * @param node
	 */
	private void visitTree(Node node){
		if(node == null || node.getData() ==null){
			return;
		}
		
		preOrderStr=preOrderStr.concat(node.getData()+" ");
		inOrderList.add((String)node.getData());
		
		if(node.getLeft()!=null){
			visitTree(node.getLeft());
		}
		if(node.getRight()!=null){
			visitTree(node.getRight());
		}
	}
	
	/**
	 * returns a space-separated copy of the 
	 * contents stored in the BST in (sorted) order
	 * @return
	 */
	public String toStringInOrder() {
		String sortedString="";
		visitTree(root);
		Collections.sort(inOrderList);
		
		for(String curr:inOrderList){
			
			sortedString=sortedString.concat(curr+" ");
		}
		sortedString = sortedString.substring(0, sortedString.length()-1);
		
		return sortedString;
	}

	

}
