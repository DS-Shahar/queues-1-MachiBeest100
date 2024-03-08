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





  //17
	public static Time hefresh(Queue <Time> q) {
		Time first = q.remove();
		Time last = first;
		while(!q.isEmpty()) {
			last = q.remove();
		}
		int secHefresh = last.timeSec() - first.timeSec();
		int HH = secHefresh /(60*60);
		int MH = (secHefresh %(60*60))/60;
		int SH = (secHefresh %(60*60))%60;
		Time timeHefresh = new Time(HH,MH,SH);
		return timeHefresh;
	}
  public class Time {

	private int hour;
	private int minute;
	private int second;

	
	public  Time(int hour, int minute, int second){
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		this.second = second;
	}
	
	public int timeSec() {
		return this.hour * 60 * 60 + this.minute*60 + this.second;
	}

	@Override
	public String toString() {
		return "Time [hour=" + hour + ", minute=" + minute + ", second=" + second + "]";
	}
}




  //Q18

  public static Queue<Ball> fill(String[] a, int n){
		int color;
		int size;
		Queue <Ball> q = new Queue();
		Ball b;
		for(int i = 0; i<n; i++) {
			color = (int)(Math.random() * ((a.length-1) + 1));
			size = (int)(Math.random() * ((1) + 1));
			if(size == 0) {
				b = new Ball(a[color], true);
			}
			else {
				b = new Ball(a[color], false);
			}
			q.insert(b);
		}
		return q;
	}
	
	public static int find(Queue<Ball> q, String letter) {
		int index = 0;
		while(!q.isEmpty()) {
			if(q.remove().toString().equals(letter)) {
				return index;
			}
			index++;
		}
		return index;
	}
	
	public static Scanner reader = new Scanner(System.in);
	public static void main(String[] args) {
		String[] colors = {"Red", "Orange", "Yellow", "Gold", "Blue", "Indigo", "Violet"};
		Queue <Ball> balls = fill(colors, 20);
		System.out.println(balls);
		
		int indexG = find(balls, "G");
				
		boolean correct = false;
		int count = 1;
		int ball;
		while(!correct) {
			System.out.println("whats the index of the first golden ball?");
			ball = reader.nextInt();
			if(indexG == ball) {
				System.out.println("you made it with " + count + " guesses!");
				correct = true;
			}
			count++;
		}
		
		
	}
}
public class Ball {

	private String color;
	private boolean big;
	
	public Ball(String color, boolean big) {
		this.color = color;
		this.big = big;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isBig() {
		return big;
	}

	public void setBig(boolean big) {
		this.big = big;
	}
	
	public String toString() {
		return "" + color.charAt(0);
	}


  //Q19
  public static void timeJobs(Queue<Job> jobs, int t) {
		int sum = jobs.head().getSec();
		while(sum <= t && !jobs.isEmpty()) {
			System.out.println(jobs.remove().toString());
			sum += jobs.head().getSec();
			
		}
		
	}
}

public class Job {
    private String jobCode;
    private int sec; 

    public Job(String jobCode, int sec) { 
        this.jobCode = jobCode;
        this.sec = sec;
    }

    public String getJobCode() {
        return jobCode;
    }

    public int getSec() { 
        return sec;
    }

    @Override
    public String toString() {
        return "Job{" +
                "jobCode='" + jobCode + '\'' +
                ", sec=" + sec + 
                '}';
    }

  //Q20
  public static Queue<Integer> sort(Queue <Integer> q1, Queue <Integer> q2){
		Queue <Integer> q3 = new Queue();
		while(!q1.isEmpty() && !q2.isEmpty()) {
			if(q1.head() >= q2.head()) {
				q3.insert(q2.remove());
			}
			else {
				q3.insert(q1.remove());
			}
		}
		while(!q1.isEmpty()) {
			q3.insert(q1.remove());
		}
		while(!q2.isEmpty()) {
			q3.insert(q2.remove());
		}
		while(!q3.isEmpty()) {
			q1.insert(q3.remove());
		}
		return q1;
	}
}
  
}
