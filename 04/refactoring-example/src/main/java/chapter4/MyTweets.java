package chapter4;

public class MyTweets {

    private final Tweet myTweet = new TweetBuilder()
            .setId(456789)
            .setText("hello world")
            .setRetweetCount(123)
            .setUser(new User())
            .createTweet();

}
