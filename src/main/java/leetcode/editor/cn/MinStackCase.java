////设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
////
////
//// push(x) -- 将元素 x 推入栈中。
//// pop() -- 删除栈顶的元素。
//// top() -- 获取栈顶元素。
//// getMin() -- 检索栈中的最小元素。
////
////
//// 示例:
////
//// MinStack minStack = new MinStack();
////minStack.push(-2);
////minStack.push(0);
////minStack.push(-3);
////minStack.getMin();   --> 返回 -3.
////minStack.pop();
////minStack.top();      --> 返回 0.
////minStack.getMin();   --> 返回 -2.
////
//// Related Topics 栈 设计
//
//
//package leetcode.editor.cn;
//
//import java.util.Stack;
//
//public class MinStackCase {
//    public static void main(String[] args) {
//
//    }
//
//
//    //leetcode submit region begin(Prohibit modification and deletion)
//    class MinStack {
//
//        private Stack<Integer> data;
//
//        private Stack<Integer> min;
//
//        /**
//         * initialize your data structure here.
//         */
//        public MinStack() {
//            data = new Stack<>();
//            min = new Stack<>();
//        }
//
//        public void push(int x) {
//            data.add(x;
//            if (min.isEmpty() || min.peek() >= x) {
//                min.push(x);
//            } else {
//                min.add(min.peek());
//            }
//
//        }
//
//        public void pop() {
//            if (!data.isEmpty()) {
//                min.pop();
//                min.pop();
//            }
//        }
//
//        public int top() {
//            if(!data.isEmpty()){
//                return data.peek();
//            }
//            return 0;
//        }
//
//        public int getMin() {
//            if(!min.isEmpty()){
//                return min.peek();
//            }
//            return 0;
//        }
//    }
//
///**
// * Your MinStack object will be instantiated and called as such:
// * MinStack obj = new MinStack();
// * obj.push(x);
// * obj.pop();
// * int param_3 = obj.top();
// * int param_4 = obj.getMin();
// */
////leetcode submit region end(Prohibit modification and deletion)
//
//}