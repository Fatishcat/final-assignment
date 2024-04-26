
public class MorseTree extends TreeNode <Character> {
	private TreeNode<Character> root;
	
	public MorseTree() {
		super('_');
		this.root = this;
		root.setLeft(null);
		root.setRight(null);
	}
	
	public TreeNode<Character> getRoot() {
		return root;
	}

	public void setRoot(TreeNode<Character> root) {
		this.root = root;
	}

	public String preOrder() {
		return this.preorder();
	}
	
	public String postOrder() {
		return this.postorder();
	}
	
	public String encode(String s) {
		String encoded  = "";
		s = s.toLowerCase();
		for(int i = 0; i < s.length(); i++) {
			//returns to the top of the tree
			this.root = this;
			while(root.isIn(s.charAt(i))) {
				//while there the letter isIn() this node but is not this node continues traveling down
				//when it hits the node with the character it breaks
				if(root.getLeft().isIn(s.charAt(i))) {
					encoded += " o";
					root = root.getLeft();
					if(root.getElement() == s.charAt(i)) {
						break;
					}
				}
				else if(root.getRight().isIn(s.charAt(i))) {
					encoded += " -";
					root = root.getRight();
					if(root.getElement() == s.charAt(i)) {
						break;
					}
				}
			}
			if(s.charAt(i) != ' ') {
				encoded += " |";
			}
		}
		root = this;
		return encoded;
	}
	
	public String decode(String s) {
		root = this;
		String decoded = "";
		s = s.toLowerCase();
		
		for(int i = 0; i < s.length(); i++){
			if(s.charAt(i) == '|') {
				decoded += root.getElement();
				root = this;
			}
			else if(s.charAt(i) == 'o') {
				root = root.getLeft();
			}
			else if(s.charAt(i) == '-') {
				root = root.getRight();
			}
		}
		return decoded;
	}
}
