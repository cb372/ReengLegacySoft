package chapter4.stalecode;

import chapter4.User;

public class DeadCode {

    public void foo(User user) {
int userScore = 0;
if (user.isSpecial()) {
    userScore = 5;
}
// ...
if (userScore < 10) {
    // User score is always less than 10,
    // so this branch will always run
    System.out.println("Not a bad score!");
} else {
    // This branch is dead code
    System.out.println("Wow, amazing score!");
}
    }

}
