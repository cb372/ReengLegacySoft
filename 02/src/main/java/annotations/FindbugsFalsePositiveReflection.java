package annotations;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

public class FindbugsFalsePositiveReflection {

    @SuppressFBWarnings(
            value = "UUF_UNUSED_FIELD",
            justification = "This field is accessed using reflection")
    private String foo;

    public void setFoo(String value) {
        try {
            getClass().getDeclaredField("foo").set(this, value);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public String getFoo() {
        try {
            return (String) getClass().getDeclaredField("foo").get(this);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

}
