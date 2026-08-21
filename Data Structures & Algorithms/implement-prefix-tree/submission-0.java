class PrefixTree {
    class Node{
            Map<Character, Node> nodes;
            boolean isEnd;
            public Node() {
                this.nodes = new HashMap<>();
                this.isEnd = isEnd;
            }
        }
    Node root;
    public PrefixTree() {
        this.root = new Node();
    }

    public void insert(String word) {
        int index = 0;
        Node current = this.root;
        while (index < word.length()) {
            if (current.nodes.containsKey(word.charAt(index))) {
                current = current.nodes.get(word.charAt(index));
            } else {
                Node next = new Node();
                current.nodes.put(word.charAt(index), next);
                current = next;

            }
            index++;
            if (index == word.length()) {
                current.isEnd = true;
            }
        }
    }

    public boolean search(String word) {
        int index = 0;
        Node currentNode = this.root;
        while (index < word.length()) {
            if (currentNode.nodes.containsKey(word.charAt(index))) {
                currentNode = currentNode.nodes.get(word.charAt(index));
                index++;
                if (index == word.length()) {
                    if (currentNode.isEnd) {
                        return true;
                    } else {
                        return false;
                    }
                }
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean startsWith(String prefix) {
        int index = 0;
        Node currentNode = this.root;
        while (index < prefix.length()) {
            if (currentNode.nodes.containsKey(prefix.charAt(index))) {
                currentNode = currentNode.nodes.get(prefix.charAt(index));
                index++;
                if (index == prefix.length()) {
                    return true;
                }
            } else {
                return false;
            }
        }
        return false;
        
    }
}
