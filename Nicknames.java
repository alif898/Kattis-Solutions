/**
 * @author Alif Naufal Farrashady A0218302U
 */

import java.io.*;
import java.util.HashMap;

public class Nicknames {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(
                new OutputStreamWriter(System.out)));

        /**
         * First HashMap will store nicknames already processed to prevent redundant queries
         * Second HashMap stores AVL trees by first letter to manage max height
         */
        HashMap<String, Integer> duplicates = new HashMap<String, Integer>();
        HashMap<Character, AVL> trees = new HashMap<Character, AVL>();

        /**
         * Reads names and inserts into corresponding AVL trees
         */
        int a = Integer.parseInt(br.readLine());
        for (int i = 0; i < a; i++) {
            String nextName = br.readLine();
            char firstLetter = nextName.charAt(0);
            if (trees.containsKey(firstLetter)) {
                trees.get(firstLetter).insert(nextName);
            } else {
                AVL tree = new AVL();
                tree.insert(nextName);
                trees.put(firstLetter, tree);
            }
        }

        /**
         * Reads nicknames and query them through the corresponding AVL trees
         */
        int b = Integer.parseInt(br.readLine());
        for (int j = 0; j < b; j++) {
            String nextNickname = br.readLine();
            int matches;
            if (duplicates.containsKey(nextNickname)) {
                matches = duplicates.get(nextNickname);
            } else {
                char firstLetter = nextNickname.charAt(0);
                if (trees.containsKey(firstLetter)) {
                    matches = trees.get(firstLetter).checkValid(nextNickname);
                } else {
                    matches = 0;
                }
                duplicates.put(nextNickname, matches);
            }
            pw.write(matches + "\n");
        }
        pw.close();
    }
}

/**
 * Vertex object containing String as key
 */
class Vertex {
    Vertex parent;
    Vertex left;
    Vertex right;
    String key;
    int height;
    int size;

    /**
     * Constructor for Vertex, default height is 0, default size is 1
     * @param v, String contained in the Vertex
     */
    Vertex(String v) {
        this.key = v;
        this.parent = null;
        this.left = null;
        this.right = null;
        this.height = 0;
        this.size = 1;
    }
}

/**
 * AVL tree, will store Strings in lexicographical order
 */
class AVL {
    Vertex root;

    /**
     * Constructor for empty AVL tree
     */
    AVL() {
        this.root = null;
    }

    /**
     * Helper method for debugging, prints out keys by inorder traversal
     */
    void inorder() {
        inorder(this.root);
    }

    /**
     * Recursive method for inorder traversal
     * @param T Current Vertex
     */
    void inorder(Vertex T) {
        if (T != null) {
            inorder(T.left);
            System.out.println(T.key + " ");
            inorder(T.right);
        }
    }

    /**
     * Method to insert new String into AVL tree
     * @param v String to be inserted
     */
    void insert(String v) {
        this.root = insert(this.root, v);
    }

    /**
     * Finds insertion point recursively, then updates size & height
     * Will also check if any rotations are required to rebalance the tree
     * @param T Current Vertex
     * @param v String to be inserted
     * @return new Vertex containing v
     */
    Vertex insert(Vertex T, String v) {
        if (T == null) {
            return new Vertex(v);
        }
        if (v.compareTo(T.key) < 0) {
            T.left = insert(T.left, v);
            T.left.parent = T;
        } else {
            T.right = insert(T.right, v);
            T.right.parent = T;
        }
        updateSize(T);
        updateHeight(T);
        return checkRotation(T);
    }

    /**
     * Getter to check height of current Vertex
     * @param T Current Vertex
     * @return Height of T if it is not null
     */
    int height(Vertex T) {
        return T == null ? -1 : T.height;
    }

    /**
     * Getter to check balance factor of current Vertex
     * @param T Current Vertex
     * @return Balance factor of T if it is not null
     */
    int balanceFactor(Vertex T) {
        return T == null ? 0 : height(T.left) - height(T.right);
    }

    /**
     * Setter to update new height of current Vertex
     * @param T Current Vertex
     */
    void updateHeight(Vertex T) {
        if (T != null) {
            T.height = Math.max(height(T.left), height(T.right)) + 1;
        }
    }

    /**
     * Getter to check size of current Vertex
     * @param T Current Vertex
     * @return Size of T if it is not null
     */
    int size(Vertex T) {
        return T == null ? 0: T.size;
    }

    /**
     * Setter to update new size of current Vertex
     * @param T Current Vertex
     */
    void updateSize(Vertex T) {
        if (T != null) {
            T.size = size(T.left) + size(T.right) + 1;
        }
    }

    /**
     * Conducts left rotation about current Vertex and updates size/height of T and rotated Vertex
     * @param T Current Vertex
     * @return T if no rotations done, else returns T.right
     */
    Vertex rotateLeft(Vertex T) {
        if (T.right != null) {
            Vertex w = T.right;
            T.right = w.left;
            if (w.left != null) {
                w.left.parent = T;
            }
            w.parent = T.parent;
            if (T.parent == null) {
                this.root = w;
            } else if (T == T.parent.left) {
                T.parent.left = w;
            } else {
                T.parent.right = w;
            }
            w.left = T;
            T.parent = w;

            w.size = T.size;
            updateSize(T);
            updateHeight(T);
            updateHeight(w);
            return w;
        }
        return T;
    }

    /**
     * Conducts right rotation about current Vertex and updates size/height of T and rotated Vertex
     * @param T Current Vertex
     * @return T if no rotations done, else returns T.left
     */
    Vertex rotateRight(Vertex T) {
        if (T.left != null) {
            Vertex w = T.left;
            T.left = w.right;
            if (w.right != null) {
                w.right.parent = T;
            }
            w.parent = T.parent;
            if (T.parent == null) {
                this.root = w;
            } else if (T == T.parent.right) {
                T.parent.right = w;
            } else {
                T.parent.left = w;
            }
            w.right = T;
            T.parent = w;

            w.size = T.size;
            updateSize(T);
            updateHeight(T);
            updateHeight(w);
            return w;
        }
        return T;
    }

    /**
     * Checks if any rotations are needed about T based on its balance factor
     * @param T Current Vertex
     * @return Vertex in old position of T
     */
    Vertex checkRotation(Vertex T) {
        if (balanceFactor(T) < -1) {
            if (balanceFactor(T.right) > 0) {
                T.right = rotateRight(T.right);
            }
            T = rotateLeft(T);
        } else if (balanceFactor(T) > 1) {
            if (balanceFactor(T.left) < 0) {
                T.left = rotateLeft(T.left);
            }
            T = rotateRight(T);
        }
        return T;
    }

    /**
     * Main method that will handle the process of finding valid nicknames
     * First find the highest Vertex that is valid, meaning its ancestors are all invalid
     * Then find lower bound and upper bound that are valid
     * All Vertex in this range will be valid
     * Size attribute can be used to prevent redundant traversal
     * @param query Nickname
     * @return Number of matches
     */
    int checkValid(String query) {
        Vertex highestValid = findHighestValid(this.root, query);
        if (highestValid == null) {
            return 0;
        }
        return 1 + checkLeft(highestValid.left, query) + checkRight(highestValid.right, query);
    }

    /**
     * Finds the highest valid Vertex recursively
     * @param T Current Vertex
     * @param query Nickname
     * @return Highest valid Vertex, its ancestors are invalid
     */
    Vertex findHighestValid(Vertex T, String query) {
        if (T == null) {
            return null;
        }
        String current = T.key;
        if (current.indexOf(query) == 0) {
            return T;
        }
        int compare = query.compareTo(current);
        if (compare < 0) {
            return findHighestValid(T.left, query);
        } else {
            return findHighestValid(T.right, query);
        }
    }

    /**
     * Method to find lower bound Vertex recursively
     * Whenever we traverse further left, add size of T.right, as they are guaranteed to be valid
     * Else check right
     * @param T Current Vertex
     * @param query Nickname
     * @return Number of matches from highestValid to lower bound
     */
    int checkLeft(Vertex T, String query) {
        if (T == null) {
            return 0;
        }
        String current = T.key;
        if (current.indexOf(query) == 0) {
            return 1 + checkLeft(T.left, query) + size(T.right);
        } else {
            return checkLeft(T.right, query);
        }
    }

    /**
     * Method to find upper bound Vertex recursively
     * Whenever we traverse further right, add size of T.left, as they are guaranteed to be valid
     * Else check left
     * @param T Current Vertex
     * @param query Nickname
     * @return Number of matches from highestValid to upper bound
     */
    int checkRight(Vertex T, String query) {
        if (T == null) {
            return 0;
        }
        String current = T.key;
        if (current.indexOf(query) == 0) {
            return 1 + checkRight(T.right, query) + size(T.left);
        } else {
            return checkRight(T.left, query);
        }
    }
}