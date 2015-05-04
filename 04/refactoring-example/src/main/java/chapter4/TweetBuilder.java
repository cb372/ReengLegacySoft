package chapter4;

import java.util.Date;
import java.util.List;

public class TweetBuilder {
    private Coordinates coordinates = null;
    private boolean favorited = false;
    private boolean truncated = false;
    private Date createdAt = new Date();
    private Entities entities = new Entities();
    private Long inReplyToUserId = null;
    private List<Contributor> contributors = java.util.Collections.<Contributor>emptyList();
    private String text;
    private int retweetCount = 0;
    private Long inReplyToStatusId = null;
    private long id;
    private Geo geo = null;
    private boolean retweeted = false;
    private boolean possiblySensitive = false;
    private String place = null;
    private User user;
    private String inReplyToScreenName = null;
    private String source = "twitter.com";

    public TweetBuilder setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
        return this;
    }

    public TweetBuilder setFavorited(boolean favorited) {
        this.favorited = favorited;
        return this;
    }

    public TweetBuilder setTruncated(boolean truncated) {
        this.truncated = truncated;
        return this;
    }

    public TweetBuilder setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public TweetBuilder setEntities(Entities entities) {
        this.entities = entities;
        return this;
    }

    public TweetBuilder setInReplyToUserId(Long inReplyToUserId) {
        this.inReplyToUserId = inReplyToUserId;
        return this;
    }

    public TweetBuilder setContributors(List<Contributor> contributors) {
        this.contributors = contributors;
        return this;
    }

    public TweetBuilder setText(String text) {
        this.text = text;
        return this;
    }

    public TweetBuilder setRetweetCount(int retweetCount) {
        this.retweetCount = retweetCount;
        return this;
    }

    public TweetBuilder setInReplyToStatusId(Long inReplyToStatusId) {
        this.inReplyToStatusId = inReplyToStatusId;
        return this;
    }

    public TweetBuilder setId(long id) {
        this.id = id;
        return this;
    }

    public TweetBuilder setGeo(Geo geo) {
        this.geo = geo;
        return this;
    }

    public TweetBuilder setRetweeted(boolean retweeted) {
        this.retweeted = retweeted;
        return this;
    }

    public TweetBuilder setPossiblySensitive(boolean possiblySensitive) {
        this.possiblySensitive = possiblySensitive;
        return this;
    }

    public TweetBuilder setPlace(String place) {
        this.place = place;
        return this;
    }

    public TweetBuilder setUser(User user) {
        this.user = user;
        return this;
    }

    public TweetBuilder setInReplyToScreenName(String inReplyToScreenName) {
        this.inReplyToScreenName = inReplyToScreenName;
        return this;
    }

    public TweetBuilder setSource(String source) {
        this.source = source;
        return this;
    }

    public Tweet createTweet() {
        return new Tweet(coordinates, favorited, truncated, createdAt, entities, inReplyToUserId, contributors, text, retweetCount, inReplyToStatusId, id, geo, retweeted, possiblySensitive, place, user, inReplyToScreenName, source);
    }
}