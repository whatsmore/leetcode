package com.wcm.tools;

import java.util.*;

public class leetcode {

    public static void main(String[] args) {
//        ListNode l11= new ListNode(11);
//        ListNode l10 = new ListNode(10,l11);
//        ListNode l9 = new ListNode(9,l10);
//        ListNode l8 = new ListNode(8,l9);
//        ListNode l7 = new ListNode(7,l8);
//        ListNode l6 = new ListNode(6,l7);
//        ListNode l5 = new ListNode(5,l6);
//        ListNode l4 = new ListNode(4,l5);
//        ListNode l3 = new ListNode(3,l4);
//        ListNode l2 = new ListNode(2,l3);
//        ListNode l1 = new ListNode(1,l2);
//        ListNode l4 = new ListNode(-10);
//        ListNode l3 = new ListNode(-3,l4);
//        ListNode l2 = new ListNode(0,l3);
//        ListNode l1 = new ListNode(5,l2);
//        ListNode l0 = new ListNode(9,l1);
//        TreeNode  a = sortedListToBST(l0);
        TreeNode  a = sortedListToBST(null);
        System.out.println(a);
    }

    /*leetcode 109. 有序链表转换二叉搜索树：给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
                测试用例：
     */
    static TreeNode sortedListToBST(ListNode head) {
        if(head==null){
            return null;
        }
        List<Integer> arr = getArrByListNode(head);
        return getRoot(arr, 0, arr.size() - 1);
    }

    static TreeNode getRoot(List<Integer> arr, int start, int end) {
        TreeNode root = new TreeNode();
        if (end < start) {
            return null;
        }
        int thisIndex = (end+1 - start) / 2 + start;
        root.val = arr.get(thisIndex);
//        if(end>start){
        root.left = getRoot(arr, start, thisIndex - 1);
        root.right = getRoot(arr, thisIndex + 1, end);
//        }
        return root;
    }

    static List<Integer> getArrByListNode(ListNode head) {
        List<Integer> result = new ArrayList<>();
        result.add(head.val);
        while (head.next != null) {
            head = head.next;
            result.add(head.val);
        }
        return result;
    }
    /*leetcode 110. 平衡二叉树：给定一个二叉树，判断它是否是高度平衡的二叉树。
            测试用例：
                System.out.println(isBalanced(TreeNode.getTree(new ArrayList<Integer>() {{ add(3);add(9);add(20);add(null);add(null);add(15);add(7); }})));
                System.out.println(isBalanced(TreeNode.getTree(new ArrayList<Integer>() {{ add(1);add(2);add(2);add(3);add(3);add(null);add(null);add(4);add(4); }})));
                System.out.println(isBalanced(TreeNode.getTree(new ArrayList<Integer>(){{add(1);}})));
                System.out.println(isBalanced(TreeNode.getTree(new ArrayList<Integer>(){{add(3);add(3);add(9);add(20);add(null);add(null);add(15);add(7);}})));

     */

    static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        try {
            return getHeight(root, 0) >= 0;
        } catch (Exception e) {
            return false;
        }
    }

    static int getHeight(TreeNode root, int i) throws Exception {
        if (root == null) {
            return i;
        }
        int leftHeight = getHeight(root.left, i + 1);
        int rightHeight = getHeight(root.right, i + 1);
        if (Math.abs(leftHeight - rightHeight) > 1) {
            throw new Exception();
        }
        return Math.max(leftHeight, rightHeight);
    }

//    static boolean validLeafLength(TreeNode root, int length) {
//        if (root == null) {
//            return true;
//        }
//        if (root.left == null && root.right == null) {
//            if (max == -1) {
//                max = length;
//                min = length;
//            } else if (length > max) {
//                max = length;
//            } else if (length < min) {
//                min = length;
//            }
//            return max - min <= 1;
//        } else {
//            return (validLeafLength(root.left, length + 1) && validLeafLength(root.right, length + 1));
//        }
//    }


    /*leetcode 733. 图像渲染：有一幅以二维整数数组表示的图画，每一个整数表示该图画的像素值大小，数值在 0 到 65535 之间。
                    给你一个坐标 (sr, sc) 表示图像渲染开始的像素值（行 ，列）和一个新的颜色值 newColor，让你重新上色这幅图像。
                    为了完成上色工作，从初始坐标开始，记录初始坐标的上下左右四个方向上像素值与初始坐标相同的相连像素点，接着再记录这四个方向上符合条件的像素点与他们对应四个方向上像素值与初始坐标相同的相连像素点，……，重复该过程。将所有有记录的像素点的颜色值改为新的颜色值。
                    最后返回经过上色渲染后的图像。
                    示例：{1, 2, 3},
                         {2, 2, 3},
                         {1, 2, 3}
                    测试用例：
                        System.out.println(Arrays.deepToString(floodFill(new int[][]{{1, 2, 3}, {2, 2, 3}, {1, 2, 3}}, 1, 1, 3)));
                        System.out.println(Arrays.deepToString(floodFill(new int[][]{{2, 2, 3}, {1, 2, 3}, {1, 2, 3}}, 1, 1, 3)));
                        System.out.println(Arrays.deepToString(floodFill(new int[][]{{2, 1, 3}, {2, 2, 3}, {1, 2, 3}}, 1, 1, 3)));
                        System.out.println(Arrays.deepToString(floodFill(new int[][]{{2, 1, 3}, {1, 2, 3}, {1, 2, 2}}, 1, 1, 3)));
                        System.out.println(Arrays.deepToString(floodFill(new int[][]{{0, 0, 0}, {0, 0, 0}}, 0, 0, 2)));
                        System.out.println(Arrays.deepToString(floodFill(new int[][]{{0, 0, 0}, {0, 1, 1}}, 1, 1, 1)));
     */
    static int[] xs = new int[]{1, -1, 0, 0};
    static int[] ys = new int[]{0, 0, 1, -1};

    static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        if (newColor == oldColor) {
            return image;
        }
        image = floodFill(image, sr, sc, newColor, oldColor);
        return image;
    }

    static int[][] floodFill(int[][] image, int sr, int sc, int newColor, int oldColor) {
        if (!(sr < 0 || sc < 0 || sc > image[0].length - 1 || sr > image.length - 1) && image[sr][sc] == oldColor) {
            image[sr][sc] = newColor;
            for (int i = 0; i < 4; i++) {
                image = floodFill(image, sr + xs[i], sc + ys[i], newColor, oldColor);
            }
        }
        return image;
    }

    /*leetcode 546. 移除盒子：消消乐：给出一些不同颜色的盒子，盒子的颜色由数字表示，即不同的数字表示不同的颜色。
                            你将经过若干轮操作去去掉盒子，直到所有的盒子都去掉为止。每一轮你可以移除具有相同颜色的连续 k 个盒子（k >= 1），
                            这样一轮之后你将得到 k*k 个积分。 当你将所有盒子都去掉之后，求你能获得的最大积分和。
                    测试用例：
                        System.out.println(removeBoxes(new int[]{1}));
                        System.out.println(removeBoxes(new int[]{1, 2}));
                        System.out.println(removeBoxes(new int[]{1, 1}));
                        System.out.println(removeBoxes(new int[]{1, 2, 1}));
                        System.out.println(removeBoxes(new int[]{1, 1, 1}));

                        System.out.println(removeBoxes(new int[]{ 1,2,2,2,1,2,1}));//todo 失败用例！
                        System.out.println(removeBoxes(new int[]{ 1,3,2,3,1}));
                        System.out.println(removeBoxes(new int[]{ 1,3, 2, 2, 3, 4, 3,1}));
                        System.out.println(removeBoxes(new int[]{1, 3, 2, 2, 2, 3, 4, 3, 1}));

                        System.out.println(removeBoxes(new int[]{1, 2, 3, 4, 3, 3, 3}));
                        System.out.println(removeBoxes(new int[]{1, 2, 4, 3, 4, 4, 4, 3, 3, 3}));
                        System.out.println(removeBoxes(new int[]{1, 2, 4, 4, 3, 4, 4, 4, 3, 3, 3}));

               //todo 失败！！
     */
    static int removeBoxes(int[] boxes) {
        return removeBoxesDP(boxes, 0, boxes.length - 1, 0);
    }

    static int removeBoxesDP(int[] boxes, int start, int end, int k) {
        if (start == end) {
            return (1 + k) * (1 + k);
        } else if (end < start) {
            return 0;
        }
        int endV = boxes[end];
        while (end >= 0 && endV == boxes[end]) {
            end--;
            k++;
        }
        int i = findSameV(boxes, start, end, endV);
        if (i == -1) {
            int tmp = removeBoxesDP(boxes, start, end, 0);
            return tmp + k * k;
        } else {
            int tmp = removeBoxesDP(boxes, start, end, 0);
            int a = tmp + k * k;
            int tmp2 = removeBoxesDP(boxes, i + 1, end, 0);
            int tmp3 = removeBoxesDP(boxes, start, i, k);
            int b = tmp2 + tmp3;
            System.out.println("s:" + start + ",e:" + (end + 1));
            System.out.println(a + "|" + b);
            return Math.max(a, b);
        }
    }

    static int findSameV(int[] boxes, int start, int end, int endV) {
        while (end > start) {
            end--;
            if (boxes[end] == endV) {
                return end;
            }
        }
        return -1;
    }

    /*leetcode 43. 字符串相乘：给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
                            num1 和 num2 的长度小于110。
                            num1 和 num2 只包含数字 0-9。
                            num1 和 num2 均不以零开头，除非是数字 0 本身。
                            不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
                测试用例：
                    System.out.println(multiply("2", "3"));//6
                    System.out.println(multiply("3", "3"));//9
                    System.out.println(multiply("2", "0"));//0
                    System.out.println(multiply("0", "0"));//0
                    System.out.println(multiply("22", "55"));//1210
                    System.out.println(multiply("182", "111"));//20202
                    System.out.println(multiply("20000000000", "0"));//0
                    System.out.println(multiply("200000000000000000000", "2"));//400000000000000000000
                    System.out.println(multiply("200000000000000000000", "10000000000000000000000"));//2000000000000000000000000000000000000000000
                    System.out.println(multiply("200000000000000000001", "10000000000000000000000"));//2000000000000000000010000000000000000000000
     */
    static String multiply(String num1, String num2) {
        String result = "";
        if (isZero(num1) || isZero(num2)) {
            return "0";
        }
        if (num1.length() > num2.length()) {
            String tmp = num1;
            num1 = num2;
            num2 = tmp;
        }
        if (num1.length() == 1 && num2.length() == 1) {
            return String.valueOf((num1.toCharArray()[0] - '0') * (num2.toCharArray()[0] - '0'));
        }
        int everyNumLength = num2.length() + 1;
        int[][] tmpResult = new int[num1.length()][everyNumLength];
        char[] numCs1 = num1.toCharArray();
        char[] numCs2 = num2.toCharArray();
        for (int i = numCs1.length - 1; i >= 0; i--) {
            int up = 0;
            for (int j = numCs2.length - 1; j >= 0; j--) {
                int tmpR = (numCs1[i] - '0') * (numCs2[j] - '0');
                tmpR += up;
                up = tmpR / 10;
                tmpR %= 10;
                tmpResult[numCs1.length - 1 - i][j + 1] = tmpR;
            }
            tmpResult[numCs1.length - 1 - i][0] = up;
        }
        int up = 0;

        for (int i = 0; i < tmpResult.length + everyNumLength - 1; i++) {
            int tmpR = 0;
            for (int j = 0; j <= i && j < tmpResult.length; j++) {
                int thisIndex = everyNumLength - 1 - (i - j);
                if (thisIndex < 0) {
                    continue;
                }
                tmpR += tmpResult[j][thisIndex];
            }
            tmpR += up;
            up = tmpR / 10;
            tmpR %= 10;
            result = tmpR + result;
        }
        while (result.startsWith("0") && result.length() > 1) {
            result = result.substring(1);
        }
        return result;
    }

    static boolean isZero(String s) {
        return s.length() == 1 && "0".equals(s);
    }

    /*leetcode 133. 克隆图 :给你无向 连通 图中一个节点的引用，请你返回该图的 深拷贝（克隆）。图中的每个节点都包含它的值 val（int） 和其邻居的列表（list[Node]）。
            [[2,4],[1,3],[2,4],[1,3]]
            测试用例1：
                Node n = new Node(1);
                Node newN = cloneGraph(n);
                System.out.println(newN);
            测试用例2：
                Node n = new Node(1);
                Node n2 = new Node(2,new ArrayList<Node>(){{add(n);}});
                n.neighbors = new ArrayList<Node>(){{add(n2);}};
                Node newN = cloneGraph(n);
                System.out.println(newN);
     */
    static Map<Integer, Node> nodeMap = new HashMap<>();

    static Node cloneGraph(Node node) {//1
        if (node == null) {
            return null;
        }
        return getNewNode(node);
    }

    //    static ArrayList<Node> getNeighbors(Node node) {
//        ArrayList<Node> neighbors = new ArrayList<>();
//        for(Node neighbor:node.neighbors) {
//            if (nodeMap.containsKey(neighbor.val)) {
////                continue;
//                neighbors.add(nodeMap.get(neighbor.val));
//            } else {
//                neighbors.add(getNewNode(neighbor));//2,4
//            }
//        }
//        return neighbors;
//    }
    static Node getNewNode(Node node) {//2
        if (nodeMap.containsKey(node.val)) {
            return nodeMap.get(node.val);
        } else {
            Node newNode = new Node(node.val, new ArrayList<>());//1 //2
            nodeMap.put(node.val, newNode);
            for (Node neighbor : node.neighbors) {
                newNode.neighbors.add(getNewNode(neighbor));
            }
            return newNode;
        }
    }

    /*leetcode 130. 被围绕的区域：给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
        示例1：
        输入：
        [["X","X","X","X"],
         ["X","O","O","X"],
         ["X","X","O","X"],
         ["X","O","X","X"]]
        输出：
        [["X","X","X","X"],
         ["X","X","X","X"],
         ["X","X","X","X"],
         ["X","O","X","X"]]
        测试用例：
            System.out.println(JSONArray.toJSON(solve2(new char[][]{{'X', 'X', 'X'}, {'X', 'O', 'X'}, {'X', 'X', 'X'}})));
            System.out.println(JSONArray.toJSON(solve2(new char[][]{{'X', 'X', 'X'}, {'X', 'O', 'X'}, {'X', 'O', 'X'}, {'X', 'X', 'X'}})));
            System.out.println(JSONArray.toJSON(solve2(new char[][]{{'X', 'X', 'X'}, {'X', 'O', 'X'}, {'X', 'O', 'X'}, {'X', 'O', 'X'}})));
            System.out.println(JSONArray.toJSON(solve2(new char[][]{{'X', 'X', 'X'}, {'X', 'O', 'X'}, {'X', 'X', 'X'}, {'X', 'O', 'X'}})));
            System.out.println(JSONArray.toJSON(solve2(new char[][]{{'X', 'X', 'X'}, {'X', 'O', 'X'}})));
            System.out.println(JSONArray.toJSON(solve2(new char[][]{{'X', 'X'}, {'O', 'X'}, {'X', 'X'}})));
            System.out.println(JSONArray.toJSON(solve2(new char[][]{{'X', 'X', 'X'}, {'X', 'O', 'O'}, {'X', 'X', 'X'}})));
            System.out.println(JSONArray.toJSON(solve2(new char[][]{{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'O'}, {'X', 'X', 'X', 'X'}})));
            System.out.println(JSONArray.toJSON(solve2(new char[][]{{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'X', 'X'}})));
     */
    static char[][] solve2(char[][] board) {
        solve(board);
        return board;
    }

    static void solve(char[][] board) {
        int height = board.length;
        if (height < 3) {
            return;
        }
        int width = board[0].length;
        if (width < 3) {
            return;
        }

        int[][] ways = getWays();
        char[][] newBoard = new char[height][width];
        for (char[] newB : newBoard) {
            Arrays.fill(newB, 'X');
        }
        List<int[]> borders = findBorderAndSetNewBoard(board, newBoard);
        for (int i = 0; i < borders.size(); i++) {
            int[] border = borders.get(i);
            for (int[] way : ways) {
                int y = border[0] + way[0];
                int x = border[1] + way[1];
                if (x >= 0 && y >= 0 && x < width && y < height) {
                    if (board[y][x] == 'O' && newBoard[y][x] != 'O') {
                        newBoard[y][x] = 'O';
                        borders.add(new int[]{y, x});
                    }
                }
            }
        }
        System.arraycopy(newBoard, 0, board, 0, newBoard.length);
    }

    static int[][] getWays() {
        int[][] ways = new int[4][1];
        int[] up = new int[]{-1, 0};
        int[] down = new int[]{1, 0};
        int[] left = new int[]{0, -1};
        int[] right = new int[]{0, 1};
        ways[0] = up;
        ways[1] = down;
        ways[2] = left;
        ways[3] = right;
        return ways;
    }

    static List<int[]> findBorderAndSetNewBoard(char[][] board, char[][] newBoard) {
        return findBorderAndSetNewBoard(board, 'O', newBoard);
    }

    static List<int[]> findBorderAndSetNewBoard(char[][] board, char target, char[][] newBoard) {
        int width = board[0].length;
        List<int[]> border = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            if (i == 0 || i == board.length - 1) {
                for (int j = 0; j < width; j++) {
                    if (board[i][j] == target) {
                        newBoard[i][j] = 'O';
                        border.add(new int[]{i, j});
                    }
                }
            } else {
                if (board[i][0] == target) {
                    newBoard[i][0] = 'O';
                    border.add(new int[]{i, 0});
                }
                if (board[i][width - 1] == target) {
                    newBoard[i][width - 1] = 'O';
                    border.add(new int[]{i, width - 1});
                }
            }

        }
        return border;
    }
    /* leetcode 696. 计数二进制子串
        测试用例：
            System.out.println(countBinarySubstrings("1"));
            System.out.println(countBinarySubstrings("0"));
            System.out.println(countBinarySubstrings(""));
            System.out.println(countBinarySubstrings("10"));
            System.out.println(countBinarySubstrings("101"));
            System.out.println(countBinarySubstrings("011"));
            System.out.println(countBinarySubstrings("0110"));
            System.out.println(countBinarySubstrings("01100"));
            System.out.println(countBinarySubstrings("011001"));
            System.out.println(countBinarySubstrings("0110011"));
     */

    static int countBinarySubstrings(String s) {
        if (s.length() < 2) {
            return 0;
        }
        int result = 0;
        char[] chars = s.toCharArray();
        char current = chars[0];
        int lastCount = 0;
        int currentCount = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] != current) {
                current = chars[i];
                result += Math.min(lastCount, currentCount);
                lastCount = currentCount;
                currentCount = 1;
            } else {
                currentCount++;
            }
        }
        result += Math.min(lastCount, currentCount);
        return result;
    }

    /* leetcode 93. 复原IP地址：给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
                    输入: "25525511135"；输出: ["255.255.11.135", "255.255.111.35"]
                    测试用例：
                        System.out.println((restoreIpAddresses("")));
                        System.out.println((restoreIpAddresses("00")));
                        System.out.println((restoreIpAddresses("0000")));
                        System.out.println((restoreIpAddresses("0100")));
                        System.out.println((restoreIpAddresses("01100")));
                        System.out.println((restoreIpAddresses("012100")));
                        System.out.println((restoreIpAddresses("255012100")));
                        System.out.println((restoreIpAddresses("256012100")));
                        System.out.println((restoreIpAddresses("255255255255")));
                        System.out.println((restoreIpAddresses("2552552552552")));
                        System.out.println((restoreIpAddresses("255255255256")));
     */
    static List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if (s.length() < 4 || s.length() > 12) {
            return result;
        } else {
            return split(s, 3);
        }
    }

    static List<String> split(String s, int leftCount) {
        List<String> result = new ArrayList<>();
        if (leftCount == 0) {
            if (!ipNumber(s)) {
                return result;
            } else {
                result.add(s);
                return result;
            }
        }
        for (int width = 1; width <= Math.min(3, s.length()); width++) {
            String thisNum = s.substring(0, width);
            String left = s.substring(width);
            if (!ipNumber(thisNum) || !rightLeft(left, leftCount)) {
                continue;
            } else {
                List<String> subs = split(left, leftCount - 1);
                for (String sub : subs) {
                    result.add(thisNum + "." + sub);
                }
            }
        }
        return result;
    }

    static boolean rightLeft(String s, int leftCount) {
        return s.length() >= leftCount && s.length() <= leftCount * 3;
    }

    static boolean ipNumber(String s, int startIndex, int endIndex) {
        s = s.substring(startIndex, endIndex);
        return ipNumber(s);
    }

    static boolean ipNumber(String s) {
        if (s.startsWith("0") && s.length() > 1) {
            return false;
        }
        int num = Integer.valueOf(s);
        return ipNumber(num);
    }

    static boolean ipNumber(int num) {
        return num >= 0 && num <= 255;
    }

    /*leetcode 99. 恢复二叉搜索树：二叉搜索树中的两个节点被错误地交换。请在不改变其结构的情况下，恢复这棵树。
                    你能想出一个只使用常数空间的解决方案吗？
                    思路：左边的子都比自己小，右边的子都比自己大
                    测试用例：
                    5
                   / \
                  3   7
                 /\   /\
                1  4 6  8
                  /
                 2
                TreeNode root = new TreeNode(5);
                TreeNode a = new TreeNode(3);
                TreeNode b = new TreeNode(7);
                TreeNode c = new TreeNode(1);
                TreeNode d = new TreeNode(4);
                TreeNode e = new TreeNode(6);
                TreeNode f = new TreeNode(8);
                TreeNode g = new TreeNode(2);
                d.left = g;
                a.left = c;
                a.right = d;
                b.left = e;
                b.right = f;
                root.left = a;
                root.right = b;
                recoverTree(root);
     */
    static void recoverTree(TreeNode root) {
        TreeNode x = null, y = null, pred = null, predecessor = null;

        while (root != null) {
            if (root.left != null) {
                // predecessor 节点就是当前 root 节点向左走一步，然后一直向右走至无法走为止
                predecessor = root.left;
                while (predecessor.right != null && predecessor.right != root) {
                    predecessor = predecessor.right;
                }

                // 让 predecessor 的右指针指向 root，继续遍历左子树
                if (predecessor.right == null) {
                    predecessor.right = root;
                    root = root.left;
                }
                // 说明左子树已经访问完了，我们需要断开链接
                else {
                    if (pred != null && root.val < pred.val) {
                        y = root;
                        if (x == null) {
                            x = pred;
                        }
                    }
                    pred = root;

                    predecessor.right = null;
                    root = root.right;
                }
            }
            // 如果没有左孩子，则直接访问右孩子
            else {
                if (pred != null && root.val < pred.val) {
                    y = root;
                    if (x == null) {
                        x = pred;
                    }
                }
                pred = root;
                root = root.right;
            }
        }
        swap(x, y);
    }

    static void swap(TreeNode x, TreeNode y) {
        int tmp = x.val;
        x.val = y.val;
        y.val = tmp;
    }



    /* leetcode 42. 接雨水
        思路：找到最大值，然后向两边扩
        测试用例：
            System.out.println(trap(new int[]{0}));
            System.out.println(trap(new int[]{0,0}));
            System.out.println(trap(new int[]{1,2,3,4,5,6,0,8,7,5,0,8,6,4,2,4,6,7}));
            System.out.println(trap(new int[]{1,2,3,4,5,6,0,8,7,5,0,8,6,4,2,4,6,17}));
            System.out.println(trap(new int[]{21,2,3,4,5,6,0,8,7,5,0,8,6,4,2,4,6,17}));
            System.out.println(trap(new int[]{21,2,3,4,5,6,0,8,7,5,0,8,6,4,2,4,6,7}));
            System.out.println(trap(new int[]{21,2,3,4,5,6,0,8,7,5,0,8,6,4,2,4,6,7,0,0}));
            System.out.println(trap(new int[]{0,0,21,2,3,4,5,6,0,8,7,5,0,8,6,4,2,4,6,7}));
            System.out.println(trap(new int[]{0,0,21,2,3,4,5,6,0,8,7,5,0,8,6,4,2,4,6,7,0,0}));
     */

    static int trap(int[] height) {
        int result = 0;
        int[] waterHeight = new int[height.length];
        int arrLastIndex = height.length - 1;
        int highestIndex = findHighestIndex(height, 0, arrLastIndex);
        if (highestIndex == -1) {
            return 0;
        }
        int leftIndex, rightIndex = highestIndex;
        if (highestIndex != 0) {
            do {
                leftIndex = findHighestIndex(height, 0, rightIndex - 1);
                if (leftIndex == -1) {
                    break;
                }
                Arrays.fill(waterHeight, leftIndex, rightIndex, height[leftIndex]);//todo 开闭问题
                rightIndex = leftIndex;
            } while (rightIndex != 0);
        }
        leftIndex = highestIndex;
        if (highestIndex != arrLastIndex) {
            do {
                rightIndex = findHighestIndex(height, leftIndex + 1, arrLastIndex, false);
                Arrays.fill(waterHeight, leftIndex, rightIndex, height[rightIndex]);//todo 开闭问题
                leftIndex = rightIndex;
            } while (leftIndex != arrLastIndex);
        }
        for (int i = 1; i < height.length - 1; i++) {
            int gap = waterHeight[i] - height[i];
            result += gap > 0 ? gap : 0;
        }
        return result;
    }

    static int findHighestIndex(int[] arr, int s, int e) {
        return findHighestIndex(arr, s, e, true);
    }

    static int findHighestIndex(int[] arr, int s, int e, boolean l) {
        int result = 0;
        int index = -1;
        for (int i = s; i <= e; i++) {
            if (l) {
                if (arr[i] > result) {
                    result = arr[i];
                    index = i;
                }
            } else {
                if (arr[i] >= result) {
                    result = arr[i];
                    index = i;
                }
            }

        }
        return index;
    }

    /*leetcode 144. 二叉树的前序遍历 (迭代)
        测试用例；
            TreeNode pr = new TreeNode(3);
            TreeNode ql = new TreeNode(4);
            TreeNode qr = new TreeNode(5);
            TreeNode pl = new TreeNode(2,ql,qr);
            TreeNode p = new TreeNode(1, pl, pr);
            System.out.println(preorderTraversal(p));
     */

    static List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        List<Integer> result = new ArrayList<>();
        s.push(root);
        while (!s.isEmpty()) {
            TreeNode thisRoot = s.pop();
            if (thisRoot == null) {
                continue;
            }
            result.add(thisRoot.val);
            s.add(thisRoot.right);
            s.add(thisRoot.left);
        }
        return result;
    }

    /* leetcode 100. 相同的树：判断两棵树是否是完全一致的
        思路：递归
        测试用例：
            TreeNode pl = new TreeNode(2);
            TreeNode pr = new TreeNode(3);
            TreeNode ql = new TreeNode(4);
            TreeNode qr = new TreeNode(5);
            TreeNode p = new TreeNode(1, pl, pr);
            TreeNode q = new TreeNode(1, ql, qr);
            isSame(q, p);//false
     */
    static boolean isSameTree(TreeNode p, TreeNode q) {
        return isSame(p, q);
    }

    static boolean isSame(TreeNode p, TreeNode q) {
        if ((p == null && q != null) || (p != null && q == null)) {
            return false;
        } else if (p == null /*&& q == null*/) {
            return true;
        }
        TreeNode pl = p.left;
        TreeNode pr = p.right;
        TreeNode ql = q.left;
        TreeNode qr = q.right;
        return (p.val == q.val) && isSame(pl, ql) && isSame(pr, qr);
    }

    /*leetcode 336. 回文对：给定一组唯一的单词， 找出所有不同 的索引对(i, j)，使得列表中的两个单词， words[i] + words[j] ，可拼接成回文串。
        //todo fail！！
        测试用例：
           MyTrie t = new MyTrie();
            t.insert("abca", 10);
            t.insert("abcb", 11);
            t.insert("aabcb", 12);
            System.out.println(t.query("abc"));
            System.out.println(t.query("abca"));
            System.out.println(t.query("abcb"));
     */
    static MyTrie trie = new MyTrie();
    static MyTrie invertedTrie = new MyTrie();

    static List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();
        handleData(words);
        for (int i = 0; i < words.length; i++) {
            int invertedWordIndex = invertedTrie.query(words[i]);
            if (invertedTrie.query(words[i]) >= 0) {
                List<Integer> thisResult = new ArrayList<>();
                List<Integer> invertedResult = new ArrayList<>();
                thisResult.add(i, invertedWordIndex);
                invertedResult.add(invertedWordIndex, i);
                result.add(thisResult);
                result.add(invertedResult);
            }
        }
        return null;
    }

    static void handleData(String[] words) {
        for (int i = 0; i < words.length; i++) {
            trie.insert(words[i], i);
            invertedTrie.insert(words[i], i, true);
        }
    }


    static class MyTrie {
        class Node {
            int[] ch = new int[26];
            int flagId;

            public Node() {
                flagId = -1;
            }
        }

        List<Node> tree = new ArrayList<>();

        public MyTrie() {
            tree.add(new Node());
        }


        public void insert(String s, int info) {
            insert(s.toCharArray(), info, false);
        }

        public void insert(char[] chars, int info) {
            insert(chars, info, false);
        }

        public void insert(String s, int info, boolean inverted) {
            insert(s.toCharArray(), info, inverted);
        }

        public void insert(char[] chars, int info, boolean inverted) {
            int len = chars.length, index = 0;//每个index代表在不同的位置的一个字符
            if (inverted) {
                for (int i = len - 1; i >= 0; i--) {
                    index = insertInto(index, chars[i]);
                }
            } else {
                for (char c : chars) {
                    index = insertInto(index, c);
                }
            }
            tree.get(index).flagId = info;
        }

        /**
         * @param index 当前index
         * @param c     需要插入的字符
         *              return 下一个index
         */
        int insertInto(int index, char c) {
            int x = c - 'a';
            if (tree.get(index).ch[x] == 0) {//当前index未插入过该字符
                tree.get(index).ch[x] = tree.size()/*-1+1//用最新的index填充该字符*/;
                tree.add(new Node());
            }
            return tree.get(index).ch[x];
        }

        int query(String s) {
            return query(s.toCharArray());
        }

        int query(char[] chars) {

            int index = 0;
            for (char c : chars) {
                int x = c - 'a';
                if (tree.get(index) == null || tree.get(index).ch[x] == 0) {
                    return -1;
                } else {
                    index = tree.get(index).ch[x];
                }
            }
            return tree.get(index).flagId;
        }
    }
    /*leetcode 103. 二叉树的锯齿形层次遍历：给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
        测试用例1：
            输入：[3,9,20,null,null,15,7],
                    3
                   / \
                  9  20
                    /  \
                   15   7
            输出：[[3],[20,9],[15,7]]
            TreeNode root = new TreeNode(3);
            TreeNode a = new TreeNode(9);
            TreeNode b = new TreeNode(20);
            TreeNode c = new TreeNode(15);
            TreeNode d = new TreeNode(7);
            b.left = c;
            b.right = d;
            root.left = a;
            root.right = b;
            System.out.println(zigzagLevelOrder(root));//[[3],[20,9],[15,7]]

     */

    /**
     * @param root 树的根节点
     * @return 锯齿形层次遍历数组
     */

    static List<List<Integer>> result = new ArrayList<>();

    static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        if (root == null) {
            return result;
        }
        List<Integer> rootValue = new ArrayList<>();
        rootValue.add(root.val);
        result.add(rootValue);
        tmp(s, false);
        return result;
    }

    static void tmp(Stack s, boolean left) {
        List<Integer> thisResult = new ArrayList<>();
        Stack<TreeNode> newS = new Stack<>();
        while (!s.isEmpty()) {
            TreeNode tree = (TreeNode) s.pop();
            if (left) {
                if (tree.left != null) {
                    thisResult.add(tree.left.val);
                    newS.push(tree.left);
                }
                if (tree.right != null) {
                    thisResult.add(tree.right.val);
                    newS.push(tree.right);
                }
            } else {
                if (tree.right != null) {
                    thisResult.add(tree.right.val);
                    newS.push(tree.right);
                }
                if (tree.left != null) {
                    thisResult.add(tree.left.val);
                    newS.push(tree.left);
                }
            }

        }
        if (!thisResult.isEmpty()) {
            result.add(thisResult);

        }
        if (!newS.isEmpty()) {
            tmp(newS, !left);
        }
    }

    /*leetcode 337. 打家劫舍 III：小偷发现了一个可行窃的地区。这个地区只有一个入口，我们称之为“根”。
                    除了“根”之外，每栋房子有且只有一个“父“房子与之相连。小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
                    如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
        测试用例1：
            输入: [3,2,3,null,3,null,1]
                 3
                / \
               2   3
                \   \
                 3   1
                TreeNode root = new TreeNode(3);
                TreeNode a = new TreeNode(2);
                TreeNode b = new TreeNode(3);
                TreeNode c = new TreeNode(3);
                TreeNode d = new TreeNode(1);
                a.right = c;
                b.right = d;
                root.left = a;
                root.right = b;
                System.out.println(rob(root));
            输出：7
        测试用例2：
            输入：[2,1,3,null,4]
                 2
                / \
               1   3
                \
                 4
                TreeNode root = new TreeNode(2);
                TreeNode a = new TreeNode(1);
                TreeNode b = new TreeNode(3);
                TreeNode c = new TreeNode(4);
                a.right = c;
                root.left = a;
                root.right = b;
                System.out.println(rob(root));
            输出：7

     */

    /**
     * @param root 树的根节点
     * @return 最大非间隔权重
     */
    static int rob(TreeNode root) {
        return Math.max(getMaxSelect(root, true), getMaxSelect(root, false));
    }

    static int getMaxSelect(TreeNode root, boolean select) {
        if (root == null) {
            return 0;
        }
        if (select) {
            int left = getMaxSelect(root.left, false);
            int right = getMaxSelect(root.right, false);
            return root.val + left + right;
        } else {
            int left = Math.max(getMaxSelect(root.left, false), getMaxSelect(root.left, true));
            int right = Math.max(getMaxSelect(root.right, false), getMaxSelect(root.right, true));
            return left + right;
        }
    }

    /* leetcode 155. 最小栈：设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
        测试用例：
            MinStack s = new MinStack();
            System.out.println(s.top());//0
            System.out.println(s.getMin());//0
            s.pop();
            System.out.println(s.getMin());//0
            s.push(3);
            System.out.println(s.getMin());//3
            s.push(4);
            System.out.println(s.getMin());//3
            s.push(2);
            System.out.println(s.getMin());//2
            System.out.println(s.top());//2
            s.pop();
            System.out.println(s.getMin());//3
            s.push(1);
            System.out.println(s.getMin());//1
     */

    static class MinStack {

        List<Integer> mini = new ArrayList<>();
        Stack<Integer> s = new Stack<>();

        /**
         * initialize your data structure here.
         */
        public MinStack() {

        }

        public void push(int x) {
            if (s.isEmpty()) {
                mini.add(x);
            } else {
                mini.add(Math.min(mini.get(mini.size() - 1), x));
            }
            s.push(x);
        }

        public void pop() {
            if (s.size() != 0) {
                s.pop();
                mini = mini.subList(0, mini.size() - 1);
            }
        }

        public int top() {
            return s.size() > 0 ? s.peek() : 0;
        }

        public int getMin() {
            return mini.size() > 0 ? mini.get(mini.size() - 1) : 0;
        }
    }

    /*leetcode 207. 课程表：你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。
                           在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]
                           给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？
                    测试用例：
                        System.out.println(canFinish(1, new int[][]{{}}));//true
                        System.out.println(canFinish(2, new int[][]{{0, 1}}));//true
                        System.out.println(canFinish(2, new int[][]{{1, 0}}));//true
                        System.out.println(canFinish(2, new int[][]{{0, 1}, {1, 0}}));//false
                        System.out.println(canFinish(4, new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 1}}));//false
                        System.out.println(canFinish(4, new int[][]{{0, 1}, {1, 2}, {2, 3}, {2, 0}}));//false
                        System.out.println(canFinish(7, new int[][]{{0, 1}, {1, 2}, {2, 3}, {5, 6}}));//true
                        System.out.println(canFinish(7, new int[][]{{0, 1}, {1, 2}, {2, 3}, {5, 6}, {6, 3}, {3, 5}}));//false
                        System.out.println(canFinish(7, new int[][]{{0, 1}, {1, 2}, {2, 3}, {5, 6}, {6, 2}, {3, 5}}));//false
     */

    static boolean canFinish2(int numCourses, int[][] prerequisites) {
        ArrayList[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        for (int[] prerequisite : prerequisites) {
            graph[prerequisite[0]].add(prerequisite[1]);
        }
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 1) {
                return false;
            } else if (visited[i] == 2) {
                continue;
            } else {
                if (!dfs(i, graph, visited)) {
                    return false;
                }
            }

        }
        return true;
    }

    static boolean dfs(int point, ArrayList[] graph, int[] visited) {
        if (visited[point] == 1) {
            return false;
        }
        visited[point] = 1;
        ArrayList<Integer> prerequisites = graph[point];
        for (int prerequisitePoint : prerequisites) {
            if (!dfs(prerequisitePoint, graph, visited)) {
                return false;
            }
        }
        visited[point] = 2;
        return true;
    }

//    static boolean bfs(ArrayList[] graph) {
//        List<Integer> tail = new ArrayList<>();
//        for(int i=0;i<graph.length;i++){
//            if(graph[i].isEmpty()){
//                tail.add(i);
//            }
//        }
//        return true;
//    }

    /**
     * @param numCourses    课程数
     * @param prerequisites 课程依赖组
     * @return 能否完成（存在环形依赖则不可完成）
     */
    static boolean canFinish(int numCourses, int[][] prerequisites) {
        Set<Integer>[] lists = new HashSet[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            if (prerequisites[i].length < 2) {
                return true;
            }
            int course = prerequisites[i][0];
            int preCourse = prerequisites[i][1];
            if (lists[course] == null) {
                Set<Integer> tmp = new HashSet<>();
                tmp.add(preCourse);
                lists[course] = tmp;
            } else {
                lists[course].add(preCourse);
            }
        }

        while (true) {
            List<Integer> canLearns = new ArrayList<>();
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] == null || lists[i].isEmpty()) {
                    canLearns.add(i);
                    lists[i] = new HashSet<Integer>() {{
                        add(-1);
                    }};
                } else {
                    for (int canLearn : canLearns) {
                        lists[i].remove(canLearn);
                    }
                }
            }
            for (int canLearn : canLearns) {
                for (int i = 0; i < canLearn; i++) {
                    lists[i].remove(canLearn);
                }
            }
            if (canLearns.isEmpty()) {
                break;
            }
        }
        for (Set<Integer> list : lists) {
            if (!list.equals(new HashSet<Integer>() {{
                add(-1);
            }}) && !list.isEmpty()) {
                return false;
            }
        }
        return true;
    }
    /*leetcode 71. 简化路径：以 Unix 风格给出一个文件的绝对路径，你需要简化它。或者换句话说，将其转换为规范路径。
        测试用例：
            System.out.println(simplifyPath("/."));// "/"
            System.out.println(simplifyPath("/a//b////c/d//././/.."));// "/a/b/c"
            System.out.println(simplifyPath("/../"));// /
            System.out.println(simplifyPath("/"));// /
            System.out.println(simplifyPath("/a/b/c"));// /a/b/c
            System.out.println(simplifyPath("/abb/bcc/cdd"));// /abb/bcc/cdd
            System.out.println(simplifyPath("/ad/b/css"));// /ad/b/css
            System.out.println(simplifyPath("/a/b/c/"));// /a/b/c
            System.out.println(simplifyPath("/a/b/../c/"));// /a/c
            System.out.println(simplifyPath("/a/b/../c/../"));// /a
            System.out.println(simplifyPath("/a/b/../../../..//c/"));// /c
            System.out.println(simplifyPath("/../a/b/"));// /a/b
            System.out.println(simplifyPath("/a/./b"));// /a/b
            System.out.println(simplifyPath("////a/./b"));// /a/b
            System.out.println(simplifyPath("/a/.//b"));// /a/b
            System.out.println(simplifyPath("/a/b/.a./../../..//c/"));//throw IllegalArgumentException
     */

    /**
     * @param path 需要简化的路径
     * @return 返回被简化的绝对路径，最后一个目录不以斜杆（/）结束
     */
    static String simplifyPath(String path) {
        String result;
        if (!path.endsWith("/")) {
            path += "/";
        }
        while (true) {
            int index = path.indexOf("//");
            if (index == -1) {
                break;
            }
            path = path.substring(0, index) + path.substring(index + 1);
        }
        while (true) {
            int index = path.indexOf("/./");
            if (index == -1) {
                break;
            }
            path = path.substring(0, index) + path.substring(index + 2);
        }
        if (!path.contains("/../")) {
            if (path.endsWith("/") && path.length() != 1) {
                return path.substring(0, path.length() - 1);
            }
            return path;
        } else {
            Stack s = new Stack();
            putEIntoStack(path, s);
            result = getResultByStack(s.toArray());
        }
        return result.isEmpty() ? "/" : result;
    }

    static String getResultByStack(Object[] ss) {
        String result = "";
        for (Object s : ss) {
            if (!"".equals(s)) {
                result = result + "/" + s;
            }
        }
        return result;
    }

    static void putEIntoStack(String p, Stack<String> s) {
        if (p.isEmpty()) {
            return;
        }
        p = p.substring(1);
        if (p.startsWith("../")) {
            if (!s.isEmpty()) {
                s.pop();
            }
            p = p.substring(2);
        } else {
            int i = p.indexOf("/");// a/
            if (i == -1) {
                s.push(p);
                return;
            }
            String e = p.substring(0, i);
            s.push(e);
            if (i + 1 == p.length()) {//以/结束
                return;
            } else {
                p = p.substring(i);
            }
        }
        putEIntoStack(p, s);
    }
    /*leetcode 415. 字符串相加：给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
        测试用例：
            System.out.println(addStrings("1", "1000099"));//1000100
            System.out.println(addStrings("1", "99999"));//100000
            System.out.println(addStrings("1", "11"));//12
            System.out.println(addStrings("0", "1"));//1
            System.out.println(addStrings("1", "-1"));//throw IllegalArgumentException;
            System.out.println(addStrings("001", "1"));//throw IllegalArgumentException;
            System.out.println(addStrings("1", "001"));//throw IllegalArgumentException;
            System.out.println(addStrings("-1", "1"));//throw IllegalArgumentException;
            System.out.println(addStrings("1", ""));//throw IllegalArgumentException;
            System.out.println(addStrings("1", "1"));//throw IllegalArgumentException;
            System.out.println(addStrings("", "1"));//throw IllegalArgumentException;
            System.out.println(addStrings("", ""));//throw IllegalArgumentException;
     */

    /**
     * @param num1 第一个数字的字符串
     * @param num2 第二个数字的字符串
     * @return 返回和的字符串
     */
    static String addStrings(String num1, String num2) {
        validArgs(num1, num2);
        String result = "";
        if (num2.length() > num1.length()) {
            String tmp = num2;
            num2 = num1;
            num1 = tmp;
        }
        char[] numCs1 = num1.toCharArray();
        char[] numCs2 = num2.toCharArray();
        int count = numCs1.length;

        boolean up = false;
        for (int i = 0; i < count; i++) {
            int n1I = numCs1.length - i - 1;
            int n2I = numCs2.length - i - 1;
            int n1 = numCs1[n1I] - '0';
            int n2 = n2I >= 0 ? numCs2[n2I] - '0' : 0;
            if (n2I < 0 && !(up && n1 == 9)) {//n2已经完成的情况下，既没有进位当前n1也不为9，则补完n1前面的字符串
                return num1.substring(0, n1I) + (n1 + (up ? 1 : 0)) + result;
            }
            int thisResult = n1 + n2 + (up ? 1 : 0);
            if (thisResult > 9) {
                thisResult -= 10;
                up = true;
            } else {
                up = false;
            }
            result = thisResult + result;
        }
        if (up) {
            result = 1 + result;
        }
        return result;
    }

    static boolean validArgs(String num1, String num2) {
        if ("".equals(num1) || "".equals(num2)) {
            throw new IllegalArgumentException();
        } else if ((num1.length() > 1 && num1.startsWith("0")) || (num2.length() > 1 && num2.startsWith("0"))) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    /*leetcode 114. 二叉树展开为链表：给定一个二叉树，**原地**将它展开为一个单链表。
        测试用例1：
            TreeNode six = new TreeNode(6, null, null);
            TreeNode five = new TreeNode(2, null, six);
            TreeNode four = new TreeNode(4, null, null);
            TreeNode three = new TreeNode(3, null, null);
            TreeNode two = new TreeNode(2, three, four);
            TreeNode one = new TreeNode(1, two, five);
            flatten(one);
                1
               / \
              2   5
             / \   \
            3   4   6
        测试用例2：
            TreeNode three = new TreeNode(3,null,null);
            TreeNode two = new TreeNode(3,three,null );
            TreeNode one = new TreeNode(1,null,two);
            flatten(one);
                1
                 \
                  3
                 /
                3
     */
    static void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode oldRight = root.right;
        if (root.left != null) {
            flatten(root.left);
            root.right = root.left;
            root.left = null;
        }
        if (oldRight != null) {
            flatten(oldRight);
            TreeNode rightLeaf = root.right;
            if (rightLeaf != oldRight) {
                while (rightLeaf.right != null) {
                    rightLeaf = rightLeaf.right;
                }

                rightLeaf.right = oldRight;
            }

        }
    }

//    static class TreeNode {
//        int val;
//        TreeNode left;
//        TreeNode right;
//
//        TreeNode() {
//        }
//
//        TreeNode(int val) {
//            this.val = val;
//        }
//
//        TreeNode(int val, TreeNode left, TreeNode right) {
//            this.val = val;
//            this.left = left;
//            this.right = right;
//        }
//    }
    /*leetcode 632. 最小区间：你有 k 个升序排列的整数数组。找到一个最小区间，使得 k 个列表中的每个列表至少有一个数包含在其中。
        注意:
            给定的列表可能包含重复元素，所以在这里升序表示 >= 。
            1 <= k <= 3500
            -10^5 <= 元素的值 <= 10^5
        测试用例1：
            String json = "[[-89,1,69,89,90,98],[-43,-36,-24,-14,49,61,66,69],[73,94,94,96],[11,13,76,79,90],[-40,-20,1,9,12,12,14],[-91,-31,0,21,25,26,28,29,29,30],[23,88,89],[31,42,42,57],[-2,6,11,12,12,13,15],[-3,25,34,36,39],[-7,3,29,29,31,32,33],[4,11,14,15,15,18,19],[-34,9,12,19,19,19,19,20],[-26,4,47,53,64,64,64,64,64,65],[-51,-25,36,38,50,54],[17,25,38,38,38,38,40],[-30,12,15,19,19,20,22],[-14,-13,-10,68,69,69,72,74,75],[-39,42,70,70,70,71,72,72,73],[-67,-34,6,26,28,28,28,28,29,30,31]]";
            List array=  JSONArray.parseArray(json,java.util.List.class);
            System.out.println(Arrays.toString(smallestRange(array)));//[13,73]
        测试用例2：
            String json = "[[1,2,3],[1,2,3],[1,2,3]]";
            List array=  JSONArray.parseArray(json,java.util.List.class);
            System.out.println(Arrays.toString(smallestRange(array)));//[1,1]
     */

    /**
     * @param nums
     * @return
     */
    static int[] smallestRange(List<List<Integer>> nums) {
        Map<Integer, Set<Integer>> mapper = new HashMap<>();
        Set<Integer> ns = new TreeSet<>();//所有元素的集合
        for (int i = 0; i < nums.size(); i++) {
            List<Integer> num = nums.get(i);
            for (int n : num) {
                if (mapper.containsKey(n)) {
                    mapper.get(n).add(i);
                } else {
                    Set<Integer> tmp = new HashSet<>();
                    tmp.add(i);
                    mapper.put(n, tmp);
                }
                ns.add(n);
            }
        }
        List<Integer> nsList = new ArrayList<>(ns);
        int smallest = -1;
        int[] result = new int[2];
        for (int i = 0; i < nsList.size(); i++) {
            Set<Integer> hasNums = new HashSet<>();
            for (int j = i; j < nsList.size(); j++) {
                if (smallest != -1 && j - i > smallest) {
                    break;
                }
                int thisNum = nsList.get(j);
                mergeIntoSet(hasNums, mapper.get(thisNum));
                if (nums.size() == hasNums.size()) {
                    int leftNum = nsList.get(i);
                    if (smallest == -1 || thisNum - leftNum < smallest) {
                        smallest = thisNum - leftNum;
                        result = new int[]{leftNum, thisNum};
                    }
                    break;
                }
            }
        }
        return result;
    }

    static void mergeIntoSet(Set<Integer> s1, Set<Integer> s2) {
        s1.addAll(s2);
    }

//    public int lengthOfLongestSubstring(String s) {
//        int result = 0;
//        char[] in = s.toCharArray();
//        int count = 0;
//        HashMap<String, Integer> map = new HashMap<>();
//        for (int i = 0; i < in.length; i++) {
//            String current = String.valueOf(in[i]);
//            if (map.containsKey(current)) {
//                int lastIndex = map.get(current);
//                map = new HashMap<>();
//                count = 0;
//                for (int j = lastIndex + 1; j <= i; j++) {
//                    map.put(String.valueOf(in[j]), j);
//                    count += 1;
//                }
//                result = Math.max(result, count);
//            } else {
//                map.put(current, i);
//                count += 1;
//                result = Math.max(result, count);
//            }
//        }
//        return result;
//    }

    /* leetcode 20. 有效的括号：给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
        有效字符串需满足：
            左括号必须用相同类型的右括号闭合。
            左括号必须以正确的顺序闭合。
            注意空字符串可被认为是有效字符串。
        输入："[]}"；输出：false；
        输入："{[]}"；输出：true；
        输入："{[}]"；输出：false；
        测试用例：
        System.out.println(isValid(""));//true
        System.out.println(isValid("[]}"));//false
        System.out.println(isValid("[{]}"));//false
        System.out.println(isValid("{}[]"));//true
        System.out.println(isValid("{[]}"));//true
        System.out.println(isValid("{[(]}"));//false
        System.out.println(isValid("{[]})"));//false
        System.out.println(isValid("{[]}("));//false
        System.out.println(isValid("{[(]}("));//false
        System.out.println(isValid("{[)]}("));//false
     */

    /**
     * 判断是否是有效的括号
     *
     * @param str 需要被判断的字符串
     * @return 返回是否是有效的
     */
    static boolean isValid(String str) {
        Map<Character, Character> key = new HashMap<>();
        key.put('{', '}');
        key.put('[', ']');
        key.put('(', ')');
        Stack s = new Stack();
        char[] strCs = str.toCharArray();
        for (int i = 0; i < strCs.length; i++) {
            if (s.size() > strCs.length - i) {
                return false;
            }
            char strC = strCs[i];
            if (key.containsKey(strC)) {
                s.push(strC);
            } else {
                if (s.empty() || key.get(s.peek()) != strC) {
                    return false;
                }
                s.pop();
            }
        }
        return s.empty();
    }

    /*leetcode 面试题 08.03. 魔术索引：给定一个有序整数数组，编写一种方法找出魔术索引（在数组A[0...n-1]中，有所谓的魔术索引，满足条件A[i] = i）。
        tag:二分法
        输入：nums = [0, 2, 3, 4, 5]；输出：0
        测试用例：
        System.out.println(findMagicIndex(new int[]{}));//throw IllegalArgumentException
        System.out.println(findMagicIndex(new int[]{1}));//-1
        System.out.println(findMagicIndex(new int[]{1, 2, 3}));//-1
        System.out.println(findMagicIndex(new int[]{0, 0, 0}));//0
        System.out.println(findMagicIndex(new int[]{1, 1, 1}));//1
        System.out.println(findMagicIndex(new int[]{0, 1, 2}));//0
        System.out.println(findMagicIndex(new int[]{0, 2, 3, 4, 5}));//0
        System.out.println(findMagicIndex(new int[]{0, 2, 3, 4, 5}));//0
        System.out.println(findMagicIndex(new int[]{1, 2, 3, 4, 4}));//4
     */

    /**
     * 传入一个数组，找到最小的 magic index 符合 nums[i]=i
     *
     * @param nums 需要查找的数组
     * @return 返回 magic index
     */
    static int findMagicIndex(int[] nums) {
        if (nums.length < 1 || nums.length > 1000000) {
            throw new IllegalArgumentException();
        }
//        else if (isNotSorted(nums)){
//          throw new IllegalArgumentException("输入的数组不是一个已排序的数组");
//        }
        return findMagicIndex(nums, 0, nums.length - 1);
    }

    static int findMagicIndex(int[] nums, int startIndex, int endIndex) {
        if (endIndex < startIndex || endIndex >= nums.length) return -1;
        int middleIndex = startIndex + (endIndex - startIndex) / 2;
        if (middleIndex == nums[middleIndex]) { //{0,1,3}
            //找到了小的，看看还有没有更小的
            int lesserResult = findMagicIndex(nums, startIndex, middleIndex - 1);
            return lesserResult == -1 ? middleIndex : Math.min(lesserResult, middleIndex);
        } else {//{0,0,3} //{1,2,2} //{0,2,2}
            //先找小的
            int tmpResult = findMagicIndex(nums, startIndex, middleIndex - 1);
            if (tmpResult == -1) {
                //找不到小的了，再找大的
                return findMagicIndex(nums, middleIndex + 1, endIndex);
            } else {
                //找到了小的，肯定已经是最小的了
                return tmpResult;
            }
        }
    }

    /*leetcode 343. 整数拆分：给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
                             n 不小于 2 且不大于 58
        tag：动态规划、数学
        输入：2；输出：1（2 = 1 + 1, 1 × 1 = 1）
        输入：10；输出: 36（10 = 3 + 3 + 4, 3 × 3 × 4 = 36）
        测试用例：
        System.out.println(integerBreak(2));//1
        System.out.println(integerBreak(3));//2
        System.out.println(integerBreak(7));//12
        System.out.println(integerBreak(8));//18
        System.out.println(integerBreak(9));//27
        System.out.println(integerBreak(10));//36
        System.out.println(integerBreak(17));//486
        System.out.println(integerBreak(18));//729

     */
    static int integerBreak(int n) {
        if (n / 2 <= 0 || n > 58) {
            throw new IllegalArgumentException("arg must bigger than 2 or lesser than 58。");
        }

        return getMaxBreakTimes(n);
    }

    static int getMaxBreakTimes(int n) {
        if (n == 2) {
            return 1;
        } else if (n == 3) {
            return 2;
        }
        if (n % 3 == 0) {
            return (int) Math.pow(3, n / 3);
        } else if (n % 3 == 1) {
            return (int) Math.pow(3, n / 3 - 1) * 2 * 2;
        } else {
            return (int) Math.pow(3, n / 3) * 2;
        }
    }
    /*leetcode 8. 字符串转换整数 (atoi)
        输入："42"
        输出：42
        测试用例：
        System.out.println(myAtoi("2147483648"));//2147483647
        System.out.println(myAtoi(""));//0
        System.out.println(myAtoi("0"));//0
        System.out.println(myAtoi("+"));//0
        System.out.println(myAtoi("a"));//0
        System.out.println(myAtoi("-0"));//0
        System.out.println(myAtoi("-1"));//-1
        System.out.println(myAtoi("   -42"));//-42
        System.out.println(myAtoi("42"));//42
        System.out.println(myAtoi("4193 with words"));//4193
        System.out.println(myAtoi("words and 987"));//0
        System.out.println(myAtoi("-91283472332"));//-2147483648
     */

    static int myAtoi(String str) {
        int result = 0;
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }
        boolean minus = false;
        if ("+".equals(str.substring(0, 1))) {
            str = str.substring(1, str.length());
        } else if ("-".equals(str.substring(0, 1))) {
            minus = true;
            str = str.substring(1, str.length());
        }
        if (str.length() == 0) {
            return 0;
        }
        char[] strCs = str.toCharArray();
        if ((int) strCs[0] < 48 || (int) strCs[0] > 57) {
            return 0;
        }
        int i = 0;
        for (char strC : strCs) {
            if ((int) strC >= 48 && (int) strC <= 57) {
                int num = (int) strC - (int) ('0');
                result = result * 10 + num;
                if (num != 0 || result != 0) {
                    i++;
                }
                if (result < 0 || (strCs[0] > '2' && i == 10) || i > 10) {
                    return minus ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
            } else {
                break;
            }
        }
        return minus ? -result : result;
    }

    /*leetcode 7. 整数反转
        输入：-120
        输出：-21
        测试用例：
        System.out.println(reverse(123));//321
        System.out.println(reverse(-123));//-321
        System.out.println(reverse(-120));//-21
        System.out.println(reverse(0));//0
        System.out.println(reverse(1));//1
        System.out.println(reverse(1534236469));//0
     */
    static int reverse(int x) {
        int result = x % 10;
        x = x / 10;
        while (x != 0) {
            int tmp = result;
            result = result * 10 + x % 10;
            if ((result - x % 10) / 10 != tmp) {
                return 0;
            }
            x = x / 10;
        }
        return result;
    }

    /*leetcode LCP 13. 寻宝：迷宫是一个二维矩阵，用一个字符串数组表示。它标识了唯一的入口（用 'S' 表示），和唯一的宝藏地点（用 'T' 表示）。
                            但是，宝藏被一些隐蔽的机关保护了起来。在地图上有若干个机关点（用 'M' 表示），只有所有机关均被触发，才可以拿到宝藏。
      输入：["S#O", "M..", "M.T"]
      ->S#O
      ->M..
      ->M.T
      输出：16
     */


    /* leetcode 6. Z 字形变换：将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
       比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
       L   C   I   R
       E T O E S I I G
       E   D   H   N
       之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。请你实现这个将字符串进行指定行数变换的函数。
       测试用例：


    */
    static String convert(String s, int numRows) {
        if (s.length() <= numRows || numRows == 1) {
            return s;
        }
        String result = "";
        for (int numRow = 1; numRow <= numRows; numRow++) {
            if (numRow == 1 || numRow == numRows) {
                result += getNext(numRow - 1, s, numRows);
            } else {
                result += getMiddleAndNext(numRow - 1, s, numRows, numRow);
            }
        }

        return result;
    }

    static String getMiddleAndNext(int index, String s, int numRows, int numRow) {
        String result = s.substring(index, index + 1);
        int nextIndex = index + 2 * (numRows - 1);
        int middleIndex = nextIndex - 2 * (numRow - 1);
        if (middleIndex < s.length()) {
            result += s.substring(middleIndex, middleIndex + 1);
        }
        if (nextIndex < s.length()) {
            result += getMiddleAndNext(nextIndex, s, numRows, numRow);
        }
        return result;
    }

    static String getNext(int index, String s, int numRows) {
        String result = s.substring(index, index + 1);
        int nextIndex = index + 2 * (numRows - 1);
        if (nextIndex < s.length()) {
            result += getNext(nextIndex, s, numRows);
        }
        return result;
    }

    /*leetcode 104.二叉树的最大深度：给定一个二叉树，找出其最大深度。
    输入：二叉树 [3,9,20,null,null,15,7]，输出：3
    测试用例：
        TreeNode root = new TreeNode(3);
        System.out.println(maxDepth(root));
        TreeNode t1 = new TreeNode(9);
        TreeNode t2 = new TreeNode(20);
        TreeNode t3 = new TreeNode(15);
        TreeNode t4 = new TreeNode(7);
        root.setLeft(t1);
        root.setRight(t2);
        t2.setLeft(t3);
        t2.setRight(t4);
        System.out.println(maxDepth(root));
     */
    static int maxDepth(TreeNode root) {
        return root == null ? 0 : 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }


    /*leetcode 5.最长回文子串：给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
    输入: "babad"
    输出: "bab"
    注意: "aba" 也是一个有效答案。
    思路：每个回文串去掉头尾依旧是个回文串，将每个元素的下标数组存到一个map中Map<Character, List<Integer>>，依次遍历元素，然后截取在当前窗口内的最后一个元素形成新的窗口
    测试用例：
//        System.out.println(longestPalindrome(""));//
//        System.out.println(longestPalindrome(""));//
//        System.out.println(longestPalindrome("a"));//a
//        System.out.println(longestPalindrome("aa"));//aa
//        System.out.println(longestPalindrome("aaa"));//aaa
//        System.out.println(longestPalindrome("aaaa"));//aaaa
//        System.out.println(longestPalindrome("aba"));//aba
//        System.out.println(longestPalindrome("abczybdefca"));//acfca
//        System.out.println(longestPalindrome("abczybdefc"));//bcb
//        System.out.println(longestPalindrome("bczybdefca"));//bcb
     */
    static String longestPalindrome(String s) {
        char[] charSs = s.toCharArray();
        Map<Character, List<Integer>> info = getInfo(charSs);
        return getLongestResult(charSs, 0, charSs.length - 1, info);
    }

    static Map<Character, List<Integer>> getInfo(char[] charSs) {
        Map<Character, List<Integer>> result = new HashMap<>();
        for (int i = 0; i < charSs.length; i++) {
            char charS = charSs[i];
            if (result.containsKey(charS)) {
                List<Integer> tmp = result.get(charS);
                tmp.add(i);
                result.put(new Character(charS), tmp);
            } else {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(i);
                result.put(new Character(charS), tmp);
            }
        }
        return result;
    }

    static int findLastIn(List<Integer> info, int s, int e) {
        if (info.size() == 1) {
            return info.get(0);
        } else {
            for (int i = info.size() - 1; info.get(i) > s; i--) {
                if (info.get(i) <= e) {
                    return info.get(i);
                }
            }
        }
        return -1;
    }

    //abczybdefca
    //aaaa
    static String getLongestResult(char[] charSs, int startIndex, int endIndex, Map<
            Character, List<Integer>> infoMap) {
//        if(startIndex==endIndex){
//            return "";
//        }

        String result = "";
        int PL = 0;
        for (int i = startIndex; i <= endIndex; i++) {
            char charS = charSs[i];
            List<Integer> info = infoMap.get(charS);
            int lastIn = findLastIn(info, i, endIndex);
            if (info.get(0) >= lastIn) {
                if (PL == 0) {
                    PL = 1;
                    result = String.valueOf(charS);
                }
            } else {
                String thisResult = charS + getLongestResult(charSs, i + 1, lastIn - 1, infoMap) + charS;
                if (thisResult.length() > PL) {
                    PL = thisResult.length();
                    result = thisResult;
                }
            }
        }
        return result;
    }

    static char[] copy(char[] original, int startIndex, int endIndex) {
        char[] copy = new char[endIndex - startIndex];
        System.arraycopy(original, startIndex, copy, 0,
                Math.min(original.length - startIndex, endIndex - startIndex));
        return copy;
    }

    static int longestIncreasingPath2(int[][] matrix) {
        int result = 0;
        if (matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        int matrixHeight = matrix.length;
        int matrixWidth = matrix[0].length;

        int[][] matrixPV = new int[matrixHeight][matrixWidth];
//        for (int i = 0; i < matrixHeight; i++) {
//            Arrays.fill(matrixPV[i],-1);
//        }

        for (int x = 0; x < matrixWidth; x++) {
            for (int y = 0; y < matrixHeight; y++) {
                if (matrixPV[y][x] == 0) {
                    int pv = getPV(x, y, matrix, matrixPV);
                    matrixPV[y][x] = pv;
                    result = Math.max(result, pv);
                }
            }
        }
        return result;
    }

    static int getPV(int x, int y, int[][] matrix, int[][] matrixPV) {
        if (matrixPV[y][x] != 0) {
            return matrixPV[y][x];
        }
        int result = 1;
        int[][] neighborsLoc = getNeighborsLoc(x, y, matrix);
        for (int[] neighborLoc : neighborsLoc) {
            int thisResult = 1;//
            int value = getValueByLoc(neighborLoc[0], neighborLoc[1], matrix);
            if (getValueByLoc(x, y, matrix) > value) {
                thisResult += getPV(neighborLoc[0], neighborLoc[1], matrix, matrixPV);
            }
            result = Math.max(result, thisResult);

        }
        matrixPV[y][x] = result;
        return result;
    }

    static int longestIncreasingPath(int[][] matrix) {
        int result = 0;
        if (matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
//        if(matrix.length==1&&matrix[0].length==1){
//            return 1;
//        }
        int[][] tails = getTails(matrix);
        for (int[] tail : tails) {
            if (tail[0] == -1) {
                break;
            }
            int thisResult = getResult(tail[0], tail[1], matrix);
            result = Math.max(result, thisResult);
        }
        return result;
    }

    static int getResult(int x, int y, int[][] matrix) {
        int result = 1;
        int[][] neighborsLoc = getNeighborsLoc(x, y, matrix);
        for (int[] neighborLoc : neighborsLoc) {
            int thisResult = 1;
            int value = getValueByLoc(neighborLoc[0], neighborLoc[1], matrix);
            if (getValueByLoc(x, y, matrix) > value) {
                thisResult += getResult(neighborLoc[0], neighborLoc[1], matrix);
            }
            result = Math.max(result, thisResult);

        }
        return result;
    }

    static int[][] getTails(int[][] matrix) {
        int matrixHeight = matrix.length;
        int matrixWidth = matrix[0].length;
        int[][] tail = new int[matrixHeight * matrixWidth][2];
        int i = 0;
        for (int x = 0; x < matrixWidth; x++) {
            for (int y = 0; y < matrixHeight; y++) {
                if (noBigger(x, y, matrix)) {
                    tail[i] = new int[]{x, y};
                    i++;
                }
            }
        }
        if (i < matrixHeight * matrixWidth) {
            tail[i] = new int[]{-1, -1};
        }
        return tail;
    }

    static boolean noBigger(int x, int y, int[][] matrix) {
        return matrix[y][x] >= getNeighborsMaxValue(x, y, matrix);
    }

    static int getNeighborsMaxValue(int x, int y, int[][] matrix) {
        int result = 0;
        int[][] neighborsLoc = getNeighborsLoc(x, y, matrix);
        for (int[] neighborLoc : neighborsLoc) {
            result = Math.max(result, getValueByLoc(neighborLoc[0], neighborLoc[1], matrix));
        }
        return result;
    }

    static int getValueByLoc(int x, int y, int[][] Matrix) {
        return Matrix[y][x];
    }

    static int[][] getNeighborsLoc(int x, int y, int[][] matrix) {
        int[][] result = new int[4][2];
        int matrixHeight = matrix.length;
        int matrixWidth = matrix[0].length;
        int[] up = getUp(x, y);
        int[] down = getDown(x, y);
        int[] left = getLeft(x, y);
        int[] right = getRight(x, y);
        int i = 0, j = 0;
        if (up[1] >= 0) {
            result[i] = up;
            i++;
            j++;
        } else {
            result[i] = new int[]{-1, -1};
            i++;
        }
        if (down[1] < matrixHeight) {
            result[i] = down;
            i++;
            j++;
        } else {
            result[i] = new int[]{-1, -1};
            i++;
        }
        if (left[0] >= 0) {
            result[i] = left;
            i++;
            j++;
        } else {
            result[i] = new int[]{-1, -1};
            i++;
        }
        if (right[0] < matrixWidth) {
            result[i] = right;
            i++;
            j++;
        } else {
            result[i] = new int[]{-1, -1};
            i++;
        }
        int[][] trueResult = new int[j][2];
        for (int[] r : result) {
            if (r[0] == -1) {
                continue;
            }
            trueResult[j - 1] = new int[]{r[0], r[1]};
            j--;
        }
        return trueResult;
    }

    static int[] getUp(int x, int y) {
        return new int[]{x, y - 1};
    }

    static int[] getDown(int x, int y) {
        return new int[]{x, y + 1};
    }

    static int[] getLeft(int x, int y) {
        return new int[]{x - 1, y};
    }

    static int[] getRight(int x, int y) {
        return new int[]{x + 1, y};
    }

    /*leetcode 410 困难
     *分割数组的最大值
     *给定一个非负整数数组和一个整数 m，你需要将这个数组分成 m 个非空的连续子数组。设计一个算法使得这 m 个子数组各自和的最大值最小。
     *解题思路：这个最小的最大值存在一个区间，大于等于最大的元素，小于等于所有的元素和；通过二分的方式来依次判断
     * 测试用例：
     *
//        System.out.println(splitArray2(new int[]{1,2,3},2));//3
//        System.out.println(splitArray2(new int[]{1},1));//1
//        System.out.println(splitArray(new int[]{1,2147483646}, 1));//18
//        System.out.println(splitArray2(new int[]{1},1));//1
//        System.out.println(splitArray2(new int[]{1},1));//1
     */
    static int splitArray(int[] nums, int m) {
        int l = 0, h = 0;
        for (int i = 0; i < nums.length; i++) {
            h += nums[i];
            if (nums[i] > l) {
                l = nums[i];
            }
        }
        while (l < h) {
            int middle = (l + h) / 2;
            if (check2(nums, middle, m)) {
                h = middle;
            } else {
                l = middle + 1;
            }

        }

        return l;
    }

    static boolean check2(int[] nums, int x, int m) {
        int currentSum = 0, thisResultCnt = 1;
        for (int i = 0; i < nums.length; i += 1) {
            if (currentSum + nums[i] > x) {
                currentSum = nums[i];
                thisResultCnt++;
            } else {
                currentSum += nums[i];
            }

        }
        return thisResultCnt <= m;
    }

    static int getMax(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }

    /*leetcode 392 判断子序列 简单
        用例
        System.out.println(isSubsequence("abc","abc"));//true
        System.out.println(isSubsequence("abc","aabc"));//true
        System.out.println(isSubsequence("abc","acbc"));//true
        System.out.println(isSubsequence("abc","ababc"));//true
        System.out.println(isSubsequence("abc","bac"));//false
        System.out.println(isSubsequence("abc",""));//false
        System.out.println(isSubsequence("","abc"));//true
        System.out.println(isSubsequence("",""));//true
     */
    static boolean isSubsequence(String s, String t) {
        if ("".equals(s)) return true;
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        int index = 0;
        for (char _t : tc) {
            if (_t == sc[index]) {
                index += 1;
            }
            if (index == sc.length) {
                return true;
            }
        }

        return false;
    }


    static int lengthOfLongestSubstring2(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }

    /*leetcode 3 无重复字符的最长子串
    给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。


          测试用例
//        System.out.println(lengthOfLongestSubstring2(""));//0
//        System.out.println(lengthOfLongestSubstring2("bbbb"));//1
//        System.out.println(lengthOfLongestSubstring2("abcccdefg"));//5
//        System.out.println(lengthOfLongestSubstring2("abc"));//3
//        System.out.println(lengthOfLongestSubstring2("abcc"));//3
//        System.out.println(lengthOfLongestSubstring2("aabcc"));//3
//        System.out.println(lengthOfLongestSubstring2("aabcdebe"));//5
//        System.out.println(lengthOfLongestSubstring2("abcdefdzzdd"));//6
     */
    static int lengthOfLongestSubstring(String s) {
        int result = 0;
        char[] in = s.toCharArray();
        int count = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            String current = String.valueOf(in[i]);
            if (map.containsKey(current)) {
                int lastIndex = map.get(current);
                map = new HashMap<>();
                count = 0;
                for (int j = lastIndex + 1; j <= i; j++) {
                    map.put(String.valueOf(in[j]), j);
                    count += 1;
                }
                result = Math.max(result, count);
            } else {
                map.put(current, i);
                count += 1;
                result = Math.max(result, count);
            }
        }
        return result;
    }

    static int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) throw new IllegalArgumentException();
        int[] dp = new int[m];
        for (int t = 0; t < n; t++) {
            dp[0] = 1;
            for (int i = 1; i < m; i++) {
                dp[i] += dp[i - 1];
            }
        }
        return dp[m - 1];
    }

    static int minPathSum(int[][] grid) {
        int m, n;
        if ((m = grid.length) == 0) {
            return 0;
        }
        if ((n = grid[0].length) == 0) {
            return 0;
        }
        int[] dp = new int[n];

        // Init
        dp[0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            // 第一行，只能一直向右，即累加
            dp[i] = grid[0][i] + dp[i - 1];
        }

        // dp
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    // 第一列，只能一直向下，即累加
                    dp[j] = dp[j] + grid[i][j];
                } else {
                    // 从上方或左方的两个点中选择较小的，加上当前点
                    dp[j] = Math.min(dp[j], dp[j - 1]) + grid[i][j];
                }
            }
        }

        return dp[n - 1];
    }

    static int getUpValue(int x, int y, int[][] grid) {
        return y == 0 ? 0 : grid[y - 1][x];
    }

    static int getLeftValue(int x, int y, int[][] grid) {
        return x == 0 ? 0 : grid[y][x - 1];
    }

    static void rotate(int[] nums, int k) {
        int trueK = k % nums.length;
        int times = 0;
        for (int i = 0; times < nums.length; i++) {
            int current = i;
            int currentValue = nums[current];
            do {
                int next = (current + trueK) % nums.length;
                int tmp = nums[next];
                nums[next] = currentValue;
                current = next;
                currentValue = tmp;
                times++;
            } while (current == i);
        }
    }


    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i : nums) {
            if (set.contains(i)) {
                set.remove(i);
            } else {
                set.add(i);
            }
        }
        for (int i : set) {
            return i;
        }
        int[] a = {1, 2, 3};
        System.arraycopy(a, 0, a, 0, 1);
        throw new IllegalArgumentException();
    }

    static int findMin(int[] nums) {
        if (nums == null)
            throw new IllegalArgumentException();
        int startIndex = 0;
        int endIndex = nums.length - 1;
        while (startIndex < endIndex) {
            int middle = startIndex + (endIndex - startIndex) / 2;
            if (nums[middle] < nums[endIndex]) {
                endIndex = middle;
            } else if (nums[middle] == nums[endIndex]) {
                // endIndex--;
            } else if (nums[middle] >= nums[endIndex]) {
                startIndex = middle + 1;
            }
        }
        return nums[startIndex];
    }

//    public class TreeNode {
//        int val;
//        TreeNode left;
//        TreeNode right;
//
//        TreeNode(int x) {
//            val = x;
//        }
//
//        TreeNode(int x, TreeNode l, TreeNode r) {
//            val = x;
//            left = l;
//            right = r;
//        }
//
//        public int getVal() {
//            return val;
//        }
//
//        public void setVal(int val) {
//            this.val = val;
//        }
//
//        public TreeNode getLeft() {
//            return left;
//        }
//
//        public void setLeft(TreeNode left) {
//            this.left = left;
//        }
//
//        public TreeNode getRight() {
//            return right;
//        }
//
//        public void setRight(TreeNode right) {
//            this.right = right;
//        }
//
//    }

    static ArrayList<Integer> mergeList(ArrayList<Integer> l1, ArrayList<Integer> l2) {
        ArrayList<Integer> result = new ArrayList<>();
        result.addAll(l1);
        result.addAll(l2);
        return result;
    }
    // static List<Integer> getResult(TreeNode subRoot){
    // ArrayList<Integer> result = new ArrayList<>();
    // if(subRoot.left!=null){
    // result = mergeList(result,getResult(subRoot.left));
    // }
    // result = mergeList(result, (new ArrayList<>(subRoot.val)));
    // if(subRoot.right == null){
    // result = mergeList(result,getResult(subRoot.right));
    // }
    // return result;
    // }

    static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        return null;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode current = head;
        boolean ten = false;
        while (l1 != null || l2 != null || ten == true) {
            int v1 = l1 == null ? 0 : l1.val;
            int v2 = l2 == null ? 0 : l2.val;
            int num = v1 + v2 + (ten ? 1 : 0);
            if (num >= 10) {
                ten = true;
            } else {
                ten = false;
            }
            System.out.println(num);
            current.next = new ListNode(num % 10);
            current = current.next;
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
            l1 = l1 == null ? null : (l1.next == null ? null : l1.next);
            l2 = l2 == null ? null : (l2.next == null ? null : l2.next);
        }
        return head.next;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int zeroCount = 0;
        int sideIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (0 == nums[i]) {
                zeroCount++;
            } else if (0 < nums[i]) {
                sideIndex = i;
                break;
            }
        }
        if (zeroCount >= 3) {
            ArrayList<Integer> e = new ArrayList<Integer>(Arrays.asList(0, 0, 0));
            result.add(e);
        }
        for (int first = 0; first < sideIndex; first++) {
            if (nums[first] >= 0) {
                break;
            }
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            int third = nums.length - 1;
            int target = -(nums[first]);
            for (int second = first + 1; second < nums.length - 1; second++) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> tmp = new ArrayList<Integer>();
                    tmp.add(nums[first]);
                    tmp.add(nums[second]);
                    tmp.add(nums[third]);
                    result.add(tmp);
                }
            }
        }
        return result;
    }

    // static int getSideIndex(int[] nums) {
    // int zeroCount = 0;
    // for (int i = 0; i < nums.length; i++) {
    // if (0 == nums[i]) {
    // zeroCount++;
    // } else if (0 < nums[i]) {
    // return i;
    // }
    // }
    // return -1;
    // }

}
