class Main {
  public static <T> boolean Q1(Queue<T> queue, T element) {
        Queue<T> tempQueue = new LinkedList<>(queue); 

        while (!tempQueue.isEmpty()) {
            T current = tempQueue.remove();
            if (current.equals(element)) {
                return true; 
            }
        }

        return false;
    }



  public static <T> boolean Q2(Queue<T> queue, T element) {
        Queue<T> tempQueue = new LinkedList<>(queue); 

        // סריקת התור כל עוד הוא לא ריק
        while (!tempQueue.isEmpty()) {
            T current = tempQueue.remove(); 
            if (current.equals(element)) {
                return true; 
            }
        }

        return false;
    }





   public static <T> boolean Q3(Queue<T> queue, T element) {
        if (queue.isEmpty()) {
            return false; 
        }

        T current = queue.remove();
        if (current.equals(element)) {
            return true; 
        }
     
        return Q3(queue, element);
    }



  public static Queue<Integer> Q6(Queue<Character> inputQueue) {//O(n)
        Queue<Integer> resultQueue = new LinkedList<>();
        int count = 1;

        while (!inputQueue.isEmpty()) {
            char current = inputQueue.remove();

            while (!inputQueue.isEmpty() && inputQueue.peek() == current) {
                inputQueue.remove();
                count++;
            }

            resultQueue.add(count);
            count = 1;
        }

        return resultQueue;
    }




  public static boolean isIn(Queue<String> queue, String str) {
        Queue<String> tempQueue = new LinkedList<>(queue);

        while (!tempQueue.isEmpty()) {
            String current = tempQueue.remove();
            if (current.equals(str)) {
                return true;
            }
        }

        return false;
    }

    public static boolean Q7(Queue<String> queue) { //O(n^2)
        Queue<String> tempQueue = new LinkedList<>(queue);

        while (!tempQueue.isEmpty()) {
            String current = tempQueue.remove();
            if (isIn(tempQueue, current)) {
                return true;
            }
        }

        return false;
    }


   public static void Q8(Queue<Integer> queue) { //O(n^2)
        Queue<Integer> uniqueQueue = new LinkedList<>();

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (!isIn(uniqueQueue, current)) {
                uniqueQueue.add(current);
            }
        }

        queue.clear();
        queue.addAll(uniqueQueue);
    }


public static void Q9(Queue<Integer> queue) {//O(n^2)
        if (queue.isEmpty()) {
            return;
        }

        Queue<Integer> tempQueue1 = new LinkedList<>();
        Queue<Integer> tempQueue2 = new LinkedList<>();

        while (!queue.isEmpty()) {
            int current = queue.poll();

            while (!tempQueue1.isEmpty() && tempQueue1.peek() < current) {
                tempQueue2.add(tempQueue1.poll());
            }
            tempQueue1.add(current);

            Queue<Integer> temp = tempQueue1;
            tempQueue1 = tempQueue2;
            tempQueue2 = temp;
        }

        while (!tempQueue1.isEmpty()) {
            queue.add(tempQueue1.poll());
        }
    }


  

  
}
