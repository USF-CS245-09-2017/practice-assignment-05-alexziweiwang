/**
 * Node.java
 * @author Alex Wang
 *
 */
public class Node {
	public Comparable<String> data;
	public Node left;
	public Node right;
	
	/**
	 * Constructor
	 */
	public Node(){
	}
	
	/**
	 * Getter of data of this node
	 * @return data of this node
	 */
	public Comparable<String> getData(){
		return data;
	}
	
	/**
	 * Getter of left node
	 * @return node in the left
	 */
	public Node getLeft(){
		return left;
	}
	
	/**
	 * Getter of the right node
	 * @return node in the right
	 */
	public Node getRight(){
		return right;
	}
	
	/**
	 * Setter of the data
	 * @param content
	 * 		the given data to be set
	 */
	public void setData(Comparable<String> content){
		data = content;
	}
	
	/**
	 * Setter of the left node
	 * @param givenNode
	 * 		the node given to be set as left node
	 */
	public void setLeft(Node givenNode){
		left = givenNode;
	}
	
	/**
	 * Setter of the right node
	 * @param givenNode
	 * 		the node given to be set as right node
	 */
	public void setRight(Node givenNode){
		right = givenNode;
	}
	
}
