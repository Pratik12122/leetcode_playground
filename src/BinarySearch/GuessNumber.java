package BinarySearch;

public class GuessNumber {
	public static void main(String[] args) {
		System.out.println(guessNumber(2126753390));
	}
	
	
	
	public static int guessNumber(int n) {
        int left = 1;
        int right = n;
        int guess = n/2;
        int result = guess(guess);

        while(result != 0) {
            if(result == 1) {
                left = guess + 1;
            } else {
                right = guess -1;
            }

            guess = left+(right - left)/2;
            result = guess(guess);
        }
        return guess;
                 
    }



	private static int guess(int guess) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int number = 1702766719;
		if(guess > number) {
			return -1;
		} else if(guess == number) {
			return 0;
		}
		return 1;
	}
	
	
}
