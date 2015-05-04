/**
 * Note: This class should NOT be extended -- Dave, 4/5/2009
 */
public class Widget extends Entity {

    int id;

    @Override
    public String getEntityId() {
        return "Widget_" + id;
    }

    @Override
    public String getCacheKey() {
        return "Widget_" + id;
    }

    public String getWidgetId() {
        return "Widget_" + id;
    }

    @Override
    public static int getCacheExpirySeconds() {
        return 60;
    }

    @Override
    public boolean equals() {
        // ...
    }

}
