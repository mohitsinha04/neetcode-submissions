class TrieNode {
    TrieNode[] child = new TrieNode[26];
    boolean isWord = false;
}

class WordDictionary {
    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (curr.child[idx] == null) {
                curr.child[idx] = new TrieNode();
            }
            curr = curr.child[idx];
        }
        curr.isWord = true;
    }

    public boolean search(String word) {
        return searchHelper(word, 0, root);
    }

    private boolean searchHelper(String word, int index, TrieNode curr) {
        if (curr == null) return false;
        if (index == word.length()) return curr.isWord;

        char c = word.charAt(index);
        
        if (c == '.') {
            // If it's a wildcard, try all non-null children
            for (int i = 0; i < 26; i++) {
                if (curr.child[i] != null && searchHelper(word, index + 1, curr.child[i])) {
                    return true;
                }
            }
            return false;
        } else {
            // Standard character check
            int idx = c - 'a';
            return curr.child[idx] != null && searchHelper(word, index + 1, curr.child[idx]);
        }
    }
}