package block3.unit9.task1;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FactsAboutCats {
    private final String id;
    private final String text;
    private final String type;
    private final String user;
    private final Integer upvotes;

    public FactsAboutCats(
        @JsonProperty("id") String id,
        @JsonProperty("text") String text,
        @JsonProperty("type") String type,
        @JsonProperty("user") String user,
        @JsonProperty("upvotes") int upvotes
    ) {
        this.id = id;
        this.text = text;
        this.type = type;
        this.user = user;
        this.upvotes = upvotes;
    }

    public Integer getUpvotes() {
        return upvotes;
    }

    public String getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public String getType() {
        return type;
    }

    public String getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "id - " + id +
                "\n text - " + text +
                "\n type - " + type +
                "\n user - " + user +
                "\n upvotes - " + upvotes;
    }
}
